package project.apt.foryou; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FamilyDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
//	------------------------------------------------------소정 	
	
	void familyAdd(FamilyVO fvo) { // 부양가족 추가
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sqlInsert = "INSERT INTO family(Mem_Id, fam_Name, fam_Regnum, fam_sex, fam_relation) VALUES (?, ?, ?, ?, ?)";
			con = new DBConnection().getConnection();
			pstm = con.prepareStatement(sqlInsert);
			System.out.println("========================================================================");

			ArrayList<FamilyVO> flist = new ArrayList<FamilyVO>();

			pstm.setString(1, fvo.getMemId());
			pstm.setString(2, fvo.getFamName());
			pstm.setString(3, fvo.getFamRegnum());
			pstm.setString(4, fvo.getFamSex());
			pstm.setString(5, fvo.getFamRelation());
			
			pstm.executeUpdate();
			flist.add(fvo);

		} catch (SQLException e) {
			System.out.println("실패!");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("가족추가 완료!");
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}

	}// familyadd end

	
	
	
	
	
	
//	------------------------------------------------------진경 

// 찾는 회원 정보 가져오기 
	public FamilyVO getMember(String memId, String famName) {
		FamilyVO family = null;
		
		String select = "SELECT * FROM family WHERE mem_id = ? AND fam_name = ?";
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, memId);
			pstmt.setString(2, famName);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("mem_id")); // 찾는 아이디가 맞는지 확인
				String id = rs.getString("mem_id");
				String name = rs.getString("fam_name");
				String sex = rs.getString("fam_sex");
				String relation = rs.getString("fam_relation");
					
				family = new FamilyVO(id, name, sex, relation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return family;
	}

	
	
	
	//family테이블 업데이트 
	public void updateFamilyinfo(FamilyVO family) {
		String strUpdate = "UPDATE family SET fam_name=?, fam_sex=?, fam_relation=? WHERE mem_id=? AND fam_name = ?";
		
		try {
			con = new DBConnection().getConnection();
			
			pstmt = con.prepareStatement(strUpdate);
			pstmt.setString(1, family.getnewName());
			pstmt.setString(2, family.getFamSex());
			pstmt.setString(3, family.getFamRelation());
			pstmt.setString(4, family.getMemId());
			pstmt.setString(5, family.getFamName());
			
			pstmt.executeUpdate();		//family 테이블 업데이트 
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	
//	------------------------------------------------------------------- 수민 
	public List<FamilyVO> getAllfam() { //가족 전체 조회
		String select = "SELECT * FROM family";
		FamilyVO family = null;
		List<FamilyVO> list = new ArrayList<FamilyVO>();
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String famName = rs.getString("mem_name");
				String famRegnum = rs.getString("fam_regnum");
				String famSex = rs.getString("fam_sex");
				String famRelation = rs.getString("fam_relation");
				
				family = new FamilyVO(memId, famName, famRegnum, famSex, famRelation);
				list.add(family);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List <FamilyVO> getCountfam(int num) { //가족 Count숫자 조회
		String select = "SELECT mem_id, COUNT(fam_name) famCount \r\n" + 
				"FROM family\r\n" + 
				"WHERE mem_id IN (SELECT mem_id FROM application WHERE apt_id = ?)\r\n" + 
				"GROUP BY mem_id";
		FamilyVO family = null;
		List<FamilyVO> list = new ArrayList<FamilyVO>();
		
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				int famCount = rs.getInt("famCount");
				family = new FamilyVO(memId, famCount);
				list.add(family);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
