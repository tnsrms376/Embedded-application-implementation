package project.apt.foryou;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PartnerDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
// -------------------------------------------------------------------------소정 	
	void partnerAdd(PartnerVO pvo) { // 신혼부부 추가
		try {			
			String Insert = "INSERT INTO partner(mem_Id, par_name, par_Regnum, par_sex, par_regdate) VALUES (?, ?, ?, ?, ?)";
			con = new DBConnection().getConnection();
			PreparedStatement pstmt = con.prepareStatement(Insert);

			ArrayList<PartnerVO> plist = new ArrayList<PartnerVO>();
			

			pstmt.setString(1, pvo.getMemId());
			pstmt.setString(2, pvo.getParName());
			pstmt.setString(3, pvo.getParRegnum());
			pstmt.setString(4, pvo.getParSex());
			pstmt.setString(5, pvo.getParRegdate());

			pstmt.executeUpdate(); 
			plist.add(pvo);

		} catch (SQLException e) {
			System.out.println("추가 실패!");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("배우자 추가완료!");
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}

	} // partneradd end

	
	
	
//------------------------------------------------진경-----------------------------------------------
	
	//partner 테이블에서 찾는 회원 가져오기 
	public PartnerVO getMember(String id) {
		PartnerVO partner = null;
		String select = "SELECT * FROM partner WHERE mem_id = ?";
		
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			//	System.out.println(rs.getString("mem_id")); // 찾는 아이디가 맞는지 확인
			
				String name = rs.getString("par_name");
				String sex = rs.getString("par_sex");
				String regdate = rs.getString("par_regdate");

				partner = new PartnerVO(id, name, sex, regdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partner;
	}
	
	
	
	
	//파트너 정보 수정 
	public void updatePartnerinfo(PartnerVO partner) {
		String Update = "UPDATE partner SET par_name=?, par_sex=?, par_regdate=? WHERE mem_id=?";

		try {
			con = new DBConnection().getConnection();

			pstmt = con.prepareStatement(Update);
			pstmt.setString(1, partner.getParName());
			pstmt.setString(2, partner.getParSex());
			pstmt.setString(3, partner.getParRegdate());
			pstmt.setString(4, partner.getMemId());
			pstmt.executeUpdate();
			System.out.println("변경되었습니다.");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
//------------------------------------------------수민----------------------------------------------	
	
	
	public List<PartnerVO> getAllpar() { //배우자 전체 조회
		String select = "SELECT * FROM partner";
		PartnerVO par = null;
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		try {
			con = new DBConnection().getConnection();
			PreparedStatement pstmt = con.prepareStatement(select);
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String parName = rs.getString("par_name");
				String parRegnum = rs.getString("par_regnum");
				String parSex = rs.getString("par_sex");
				String parRegdate = rs.getString("par_regdate");
				
				par = new PartnerVO (memId, parName, parRegnum, parSex, parRegdate);
				list.add(par);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//================수민 
    public List<PartnerVO> getApppar(int num) { // 아파트ID로 주택청약 배우자 전체 조회
          String select = "SELECT mem_id, par_regdate\r\n" + 
                "FROM partner\r\n" + 
                "WHERE mem_id IN (SELECT mem_id FROM application WHERE apt_id = ?)";
          PartnerVO par = null;
          List<PartnerVO> list = new ArrayList<PartnerVO>();
          try {
             con = new DBConnection().getConnection();
             PreparedStatement pstmt = con.prepareStatement(select);
             pstmt.setInt(1, num);
             ResultSet rs = pstmt.executeQuery();   
             
             while(rs.next()) {
                String memId = rs.getString("mem_id");
                String parRegDate = rs.getString("par_regdate");
                par = new PartnerVO (memId, parRegDate);
                list.add(par);
             }
          } catch (SQLException e) {
             e.printStackTrace();
          }
          return list;
       }// --------------12/26                14:26 수정 
}




