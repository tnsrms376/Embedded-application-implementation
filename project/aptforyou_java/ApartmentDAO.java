package project.apt.foryou;

import java.sql.*;
import java.util.ArrayList;

public class ApartmentDAO {
	ArrayList<ApartmentVO> list = new ArrayList<ApartmentVO>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

//--------------------------------------------------------------------------01.소정

//--------------------------------------------------------------------------02.진경
	// 아파트 전체 조회
	public ArrayList<ApartmentVO> getAllApt() {
		String select = "SELECT * FROM apartment";

		try {
			con = new DBConnection().getConnection();

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(select);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int count = rs.getInt(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String inDate = rs.getString(7);
				String comName = rs.getString(8);

				list.add(new ApartmentVO(id, name, addr, count, size, price, inDate, comName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 아파트 지역별 검색
	public ArrayList<ApartmentVO> searchByArea(String area) {
		String selectAddress = "SELECT * FROM apartment WHERE apt_address LIKE ";
		try {

			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(selectAddress + "'%" + area + "%'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int count = rs.getInt(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String inDate = rs.getString(7);
				String comName = rs.getString(8);

				list.add(new ApartmentVO(id, name, addr, count, size, price, inDate, comName));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 아파트 입주년도별 검색
	public ArrayList<ApartmentVO> searchByDate(String year) {

		String select = "SELECT * FROM apartment WHERE TO_CHAR(apt_indate,'YYYY')= ";

		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select + year);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int count = rs.getInt(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String inDate = rs.getString(7);
				String comName = rs.getString(8);

				list.add(new ApartmentVO(id, name, addr, count, size, price, inDate, comName));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//-------------------------------------------------------------------------- 03.순근 
	public void CreateAptInfo(ApartmentVO avo) {
		try {
			con = new DBConnection().getConnection();
			String insertSql = "INSERT INTO Apartment (Apt_id, Apt_name, Apt_address, Apt_count, Apt_size, Apt_price, Apt_indate, Com_name) "
					+ " VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(insertSql);

			pstmt.setInt(1, avo.getAptId()); 
			pstmt.setString(2, avo.getAptName());
			pstmt.setString(3, avo.getAptAddr());
			pstmt.setInt(4, avo.getAptCount());
			pstmt.setString(5, avo.getAptSize()+"평");
			pstmt.setInt(6, avo.getAptPrice());
			pstmt.setString(7, avo.getAptIndate());
			pstmt.setString(8, avo.getComName());

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int countaptid() {
		String select = "SELECT count(*) FROM Apartment";
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

	// apt 테이블에서 찾는 아파트 가져오기
	public ApartmentVO getAptId(int findAptNum) {
		ApartmentVO avo = null;
		String select = ("SELECT * FROM Apartment WHERE Apt_id = ");

		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select + findAptNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int AptId = rs.getInt("Apt_id");
				String AptName = rs.getString("Apt_name");
				String AptAddr = rs.getString("Apt_address");
				int AptCount = rs.getInt("Apt_count");
				String AptSize = rs.getString("Apt_size");
				int AptPrice = rs.getInt("Apt_price");
				String AptIndate = rs.getString("Apt_indate");
				String ComName = rs.getString("Com_name");

				avo = new ApartmentVO(AptId, AptName, AptAddr, AptCount, AptSize, AptPrice, AptIndate, ComName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avo;
	}

	// 수정된 아파트정보 업데이트
	public void updateAptInfo(ApartmentVO avo) {
		String Update = "UPDATE apartment SET apt_name=?, apt_address=?, apt_count=?, apt_size=?, apt_price=?, apt_indate=?, com_name=? WHERE apt_id=?";

		try {
			con = new DBConnection().getConnection();

			pstmt = con.prepareStatement(Update);

			pstmt.setString(1, avo.getAptName());
			pstmt.setString(2, avo.getAptAddr());
			pstmt.setInt(3, avo.getAptCount());
	        pstmt.setString(4, avo.getAptSize()+"평");
			pstmt.setInt(5, avo.getAptPrice());
			pstmt.setString(6, avo.getAptIndate());
			pstmt.setString(7, avo.getComName());
			pstmt.setInt(8, avo.getAptId());
			pstmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DeleteAptInfo(ApartmentVO avo) {

		try {
			con = new DBConnection().getConnection();
//					where절 수정
			String delsql = "DELETE FROM Apartment WHERE Apt_id=?";
			PreparedStatement pstmt = con.prepareStatement(delsql);

			pstmt.setInt(1, avo.AptId);
			pstmt.executeQuery();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//--------------------------수민 x 

}
