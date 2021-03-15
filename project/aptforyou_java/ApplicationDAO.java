package project.apt.foryou;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ApplicationDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

//=====================================================================진경 

	// application 테이블에서 찾는 회원 정보 가져오기
	public ApplicationVO getAppMember(String memId) {
		ApplicationVO app = null;
		String select = "SELECT * FROM application WHERE mem_id = ?";

		try {
			con = new DBConnection().getConnection();
			PreparedStatement pstmt = con.prepareStatement(select);
			pstmt.setString(1, memId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("mem_id");
				String name = rs.getString("mem_name");

				app = new ApplicationVO(id, name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return app;
	}

	
	
	// 신청테이블의 행 전체 갯수 가져오기
	public int countNum() {
		String select = "SELECT count(*) FROM application";
		int count = 0;

		try {
			con = new DBConnection().getConnection();

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(select);
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return count;
	}

	
//아파트 분양신청 
	public void apply(ApplicationVO app) {
		String insert = "INSERT INTO application (app_num, mem_name, apt_name, apt_id, mem_id) VALUES (?,?,?,?,?)";

		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(insert);

			pstmt.setInt(1, app.getAppNum());
			pstmt.setString(2, app.getMemName());
			pstmt.setString(3, app.getAptName());
			pstmt.setInt(4, app.getAptId());
			pstmt.setString(5, app.getMemId());
			pstmt.executeQuery();
			System.out.println("신청 성공 ! ");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	
	
	
	
	
//=====================================================================수민
	
	//****수민 수정 201227
		public List<ApplicationVO> getSelapp(int num) { //-- 아파트 아이디로 조회
			String select = "SELECT * FROM application WHERE apt_id = ";
			ApplicationVO app = null;
			List<ApplicationVO> list = new ArrayList<ApplicationVO>();
			try {
				con = new DBConnection().getConnection();
				PreparedStatement pstmt = con.prepareStatement(select + num);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next() ) {
					int appNum = rs.getInt("app_num");
					int aptId = rs.getInt("apt_id");
					String memId = rs.getString("mem_id");
					String memName = rs.getString("mem_name");
					String aptName = rs.getString("apt_name");
					int score = rs.getInt("score");
					app = new ApplicationVO(appNum, aptId, memId, memName, aptName, score);
					list.add(app);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	
	public List<ApplicationVO> getAllapp() { //--신청자 전체조회
		String select = "SELECT * FROM application";
		ApplicationVO app = null;
		List<ApplicationVO> list = new ArrayList<ApplicationVO>();
		try {
			con = new DBConnection().getConnection();
			PreparedStatement pstmt = con.prepareStatement(select);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next() ) {
				int appNum = rs.getInt("app_num");
				String memName = rs.getString("mem_name");
				int aptId = rs.getInt("apt_id");
				String aptName = rs.getString("apt_name");
				String memId = rs.getString("mem_id");
				app = new ApplicationVO (appNum, memName, aptId, aptName, memId);
				list.add(app);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void UpdateAddscore() { //-- 아파트 점수 칼럼추가
		String select = "SELECT score FROM application";
		String addScore = "ALTER TABLE application ADD score NUMBER";
		PreparedStatement pstmt = null;
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(addScore);
			ResultSet rs = pstmt.executeQuery();
			String num = "UPDATE application SET score = '0'";
			pstmt = con.prepareStatement(num);
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateScore(String mem, int num){ //해당 아이디 점수 업데이트
		String select = "UPDATE application SET score = ? WHERE mem_id = ? ";
//		ApplicationVO appScore = null;
		PreparedStatement pstmt;
		
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, num);
			pstmt.setString(2, mem);
			ResultSet rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dropScore() {//스코어 칼럼 삭제   =============== 추가 201227 
		String select = "ALTER TABLE application DROP COLUMN score";
		PreparedStatement pstmt;
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
