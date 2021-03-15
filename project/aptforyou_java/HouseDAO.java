package project.apt.foryou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class HouseDAO { //수민 201224 20:40
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//-------------------------------------------------------------소정 
	
	void houseAdd(HouseVO hvo) { // 유주택자
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;


		try {
			String sqlInsert = "INSERT INTO house(Mem_Id, hou_pdate, hou_location) VALUES (?, ?, ?)";
			con = new DBConnection().getConnection();
			pstm = con.prepareStatement(sqlInsert);
			System.out.println("========================================================================");

			ArrayList<HouseVO> hlist = new ArrayList<HouseVO>();
			

			pstm.setString(1, hvo.getMemId());
			pstm.setString(2, hvo.getHouPdate());
			pstm.setString(3, hvo.getHouLocation());
			
			pstm.executeUpdate();
			hlist.add(hvo);


		} catch (SQLException e) {
			System.out.println("집추가 실패!");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("집정보 추가완료!");
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

	}// HouseAdd end
	
	
		
//-------------------------------------------------------------수민 	
	
	
	public List<HouseVO> getAllhouse() {//주택 테이블 전체 조회
		HouseVO house = null;
		String select = "SELECT * FROM house";
		List<HouseVO> list = new ArrayList<HouseVO>();
		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String houPdate = rs.getString("Hou_Pdate");
				String houLocation = rs.getString("hou_location");
				house = new HouseVO(memId, houPdate, houLocation);
				list.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
