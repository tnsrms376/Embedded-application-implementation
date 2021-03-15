package project.apt.foryou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public CompanyVO getAptId(int findAptNum) {
		CompanyVO cvo = null;
		String select = ("SELECT * FROM Company WHERE Apt_id = ");

		try {
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(select + findAptNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int AptId = rs.getInt("Apt_id");
				String ComName = rs.getString("Com_name");
				String AptName = rs.getString("Apt_name");

				

				cvo = new CompanyVO(AptId, ComName,  AptName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cvo;
	}



	
	public void updateAptInfo(CompanyVO cvo) {
		String Update = "UPDATE Company SET apt_name=?, com_name=?, WHERE apt_id=?";
		
		try {
			con = new DBConnection().getConnection();

			pstmt = con.prepareStatement(Update);

			
			pstmt.setString(1, cvo.getAptName());
			pstmt.setString(2, cvo.getComName());
			pstmt.setInt(3, cvo.getAptId());

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}

