package project.apt.foryou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	//--------------------------------------------------------------------01. 소정 
	
	public void memberJoin(MemberVO mvo) { // 회원가입
		PreparedStatement pstm = null;
		
			try {
			con = new DBConnection().getConnection();
			String sqlInsert = "INSERT INTO member(Mem_Id, Mem_pw, Mem_Name, Mem_Regnum, Mem_Address, Mem_Mobile) VALUES (?, ?, ?, ?, ?, ?)";
			pstm = con.prepareStatement(sqlInsert);
			System.out.println("========================================================================");
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();

			pstm.setString(1, mvo.getMemId());
			pstm.setString(2, mvo.getMemPw());
			pstm.setString(3, mvo.getMemName());
			pstm.setString(4, mvo.getMemRegnum());
			pstm.setString(5, mvo.getMemAddress());
			pstm.setString(6, mvo.getMemMobile());

			pstm.executeUpdate();
			list.add(mvo);

		} catch (SQLException e) {
			System.out.println("####### 가입 실패 ######");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("******* 성공적으로 회원가입 되셨습니다 *******");
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

	}// memberJoin end
	
	
	public MemberVO Login(String id) { // 로그인창
		MemberVO member = getlogMember(id);
		return member;
	}
	
	
    public MemberVO getlogMember(String logid) {
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        MemberVO mem = null;
      
        try {
           String select = "SELECT * FROM member WHERE mem_id = ?";
           con = new DBConnection().getConnection();
           pstm = con.prepareStatement(select);
           pstm.setString(1, logid);
           rs = pstm.executeQuery();
 
           while (rs.next()) {    
              String logpw = rs.getString("mem_pw");
           
              mem = new MemberVO(logid, logpw);
           }
                 
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return mem;
    }
	
	
	
	
	void partnerAdd() { // 신혼부부 추가

		try {
			String sqlInsert = "INSERT INTO partner(mem_Id, par_name, par_Regnum, par_sex, par_regdate) VALUES (?, ?, ?, ?, ?, ?)";
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(sqlInsert);

			ArrayList<PartnerVO> plist = new ArrayList<PartnerVO>();
			PartnerVO parlist = new PartnerVO();

			pstmt.setString(1, parlist.getMemId());
			pstmt.setString(2, parlist.getParName());
			pstmt.setString(3, parlist.getParRegnum());
			pstmt.setString(4, parlist.getParSex());
			pstmt.setString(5, parlist.getParRegdate());

			pstmt.executeUpdate(); 
			plist.add(parlist);

		} catch (SQLException e) {
			System.out.println("####### 추가 실패 #######");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("******* 성공적으로 추가하였습니다 *******");
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

	}// partneradd end
	
	void familyAdd() { // 부양가족 추가


		try {
			String sqlInsert = "INSERT INTO family(Mem_Id, fam_Name, fam_Regnum, fam_sex, fam_relation) VALUES (?, ?, ?, ?, ?)";
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(sqlInsert);

			ArrayList<FamilyVO> flist = new ArrayList<FamilyVO>();
			FamilyVO famlist = new FamilyVO();

			pstmt.setString(1, famlist.getMemId());
			pstmt.setString(2, famlist.getFamName());
			pstmt.setString(3, famlist.getFamRegnum());
			pstmt.setString(4, famlist.getFamSex());
			pstmt.setString(5, famlist.getFamRelation());
			
			pstmt.executeUpdate();
			flist.add(famlist);

		} catch (SQLException e) {
			System.out.println("####### 추가 실패 #######");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("******* 성공적으로 추가하였습니다 *******");
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

	}// familyadd end
	
	void houseAdd() { // 유주택자

		try {
			String sqlInsert = "INSERT INTO house(Mem_Id, hou_pdate, hou_location) VALUES (?, ?, ?)";
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(sqlInsert);
			//rs = pstm.executeQuery();

			ArrayList<HouseVO> hlist = new ArrayList<HouseVO>();
			HouseVO houlist = new HouseVO();

			pstmt.setString(1, houlist.getMemId());
			pstmt.setString(2, houlist.getHouPdate());
			pstmt.setString(3, houlist.getHouLocation());
			
			pstmt.executeUpdate();
			hlist.add(houlist);


		} catch (SQLException e) {
			System.out.println("####### 추가 실패 #######");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("******* 성공적으로 추가하였습니다 *******");
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

	}// HouseAdd end
	
	
	
	
	
	
	
//--------------------------------------------------------------------02.진경
	
	
	
	// member테이블에서 찾는 회원 정보 가져오기
	public MemberVO getMember(String memId) {
		MemberVO member = null;
		String select = "SELECT * FROM member WHERE mem_id = ?";
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("mem_id");
				String pw = rs.getString("mem_pw");
				String name = rs.getString("mem_name");
				String addr = rs.getString("mem_address");
				String mobile = rs.getString("mem_mobile");
				member = new MemberVO(id, pw, name, addr, mobile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	
	// 내 정보 수정하기
	public void updateMyinfo(MemberVO member, ApplicationVO app) {
		PreparedStatement pstmt2 = null;
		String updateMem = "UPDATE member SET mem_name=?, mem_address=?, mem_mobile=? WHERE mem_id=?";
		String updateApp = "UPDATE application SET mem_name =? WHERE mem_id = ?"; // for cascade

		try {
			con = new DBConnection().getConnection();

			pstmt = con.prepareStatement(updateMem); // update 멤버테이블 쿼리문 pstmt 변수에 저장 후 실행
			pstmt.setString(1, member.getMemName());
			pstmt.setString(2, member.getMemAddress());
			pstmt.setString(3, member.getMemMobile());
			pstmt.setString(4, member.getMemId());
			pstmt.executeUpdate(); // member 테이블 업데이트

			pstmt2 = con.prepareStatement(updateApp);
			pstmt2.setString(1, app.getMemName());
			pstmt2.setString(2, app.getMemId());
			pstmt2.executeUpdate(); // application 테이블 cascade 업데이트

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//회원탈퇴
	public void remove(String id) {
		String delete = "DELETE FROM member WHERE mem_id= ? ";
		
		try {
			con = new DBConnection().getConnection();
			
			pstmt = con.prepareStatement(delete); 
			pstmt.setString(1,id);
			pstmt.executeQuery();
			
		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//--------------------------------------------------------------------04. 수민 
	public List<MemberVO> getAllmember() { //--회원 전체 조회
		String select = "SELECT * FROM member";
		MemberVO member = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next() ) {
				String id = rs.getString("mem_id");
				String name = rs.getString("mem_name");
				String addr = rs.getString("mem_address");
				String mobile = rs.getString("mem_mobile");
				member = new MemberVO(id, name, addr, mobile);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<MemberVO> getlocation(String loc) {//지역검색으로 회원 조회
		String select = "SELECT * FROM member WHERE mem_address LIKE '%";
		MemberVO member = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select + loc + "%'");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("mem_id");
				String name = rs.getString("mem_name");
				String addr = rs.getString("mem_address");
				String mobile = rs.getString("mem_mobile");
				member = new MemberVO(id, name, addr, mobile);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
}
