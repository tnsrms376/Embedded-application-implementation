package project.apt.foryou;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	// subscription 테이블에서 찾는 회원 가져오기
	public SubscriptionVO getSubMember(String memId) {
		String select = "SELECT * FROM subscription WHERE mem_id = ?";
		SubscriptionVO sub = null;

		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String subNum = rs.getString("sub_num");
				String id = rs.getString("mem_id");
				String date = rs.getString("sub_date");
				int deposit = rs.getInt("sub_deposit");
				int count = rs.getInt("sub_count");
				
				sub = new SubscriptionVO(subNum, id, date, deposit, count);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sub;
	}

	
	// 청약 테이블 업데이트
	public void updateSubInfo(SubscriptionVO sub) {
		String Update = "UPDATE subscription SET  sub_num =?, sub_date=?, sub_deposit=?, sub_count=?  WHERE mem_id=?";
		
		try {
			con = new DBConnection().getConnection();
		
			pstmt = con.prepareStatement(Update);
			pstmt.setString(1, sub.getSubNum());
			pstmt.setString(2, sub.getSubDate());
			pstmt.setInt(3, sub.getSubDeposit());
			pstmt.setInt(4, sub.getSubCount());
			pstmt.setString(5, sub.getMemId());
			pstmt.executeUpdate();
			
			con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	
	//-------------  진경 ---------------------------------------------------------------------
	
	
	
	
	
	
	
	//수민 201224 21:17
	public List<SubscriptionVO> getAllsub() {//청약 테이블 전체 조회 
		SubscriptionVO subsp = null;
		String select = "SELECT * FROM subscription";
		List<SubscriptionVO> list = new ArrayList<SubscriptionVO>();
		
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String subNum = rs.getString("sub_num");
				String memId = rs.getString("mem_id");
				String subDate = rs.getString("sub_date");
				int subDeposit = rs.getInt("sub_deposit");
				int subCount = rs.getInt("sub_count");
				subsp = new SubscriptionVO(subNum, memId, subDate, subDeposit, subCount);
				list.add(subsp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public List<SubscriptionVO> getHasub(int num) {//신청자 아파트ID로 청약테이블 조회
		SubscriptionVO subsp = null;
		String select = "SELECT mem_id, sub_deposit, sub_count\r\n" + 
				"FROM subscription\r\n" + 
				"WHERE mem_id IN (SELECT mem_id FROM application WHERE apt_id = ?)";
		List<SubscriptionVO> list = new ArrayList<SubscriptionVO>();
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				int subDeposit = rs.getInt("sub_deposit");
				int subCount = rs.getInt("sub_count");
				subsp = new SubscriptionVO(memId, subDeposit, subCount);
				list.add(subsp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//-------------  수민 ---------------------------------------------------------------------
	
	
}