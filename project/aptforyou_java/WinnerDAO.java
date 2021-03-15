package project.apt.foryou;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class WinnerDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	void winnerView() { // 당첨자 조회


		try {
			String sql = "SELECT * FROM winner";
			con = new DBConnection().getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("당첨자 조회");
			System.out.println("========================================================================");
//			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			ArrayList<WinnerVO> wlist = new ArrayList<WinnerVO>();

			while (rs.next()) {
//				MemberVO userlist = new MemberVO();
				WinnerVO winnerlist = new WinnerVO();

				winnerlist.setAppNum(rs.getInt(1));
				winnerlist.setMemId(rs.getString(2));
				winnerlist.setMemName(rs.getString(3));
				winnerlist.setAptName(rs.getString(4));

				wlist.add(winnerlist);
			}

			System.out.println();
			Iterator<WinnerVO> itr = wlist.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}

		} catch (SQLException e) {
			System.out.println("Select문에서 예외 발생");
			e.printStackTrace();
		} finally {
			try {
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

	} // winnerView end
	
	//=====수민 전체보기
		public List<WinnerVO> getAllwinner() { // 당첨자 전체 조회
			String select = "SELECT * FROM winner";
			WinnerVO winner = null;
			List<WinnerVO> list = new ArrayList<WinnerVO>();
			try {
				con = new DBConnection().getConnection();
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int AppNum = rs.getInt("app_num");
					String MemId = rs.getString("mem_id");
					String MemName = rs.getString("mem_name");
					String AptName = rs.getString("apt_name");
					winner = new WinnerVO(AppNum, MemId, MemName, AptName);
					list.add(winner);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//=================수민 추가 201227
		public void insertWiner(ApplicationVO mvo) { // 당첨자 업데이트
			String select = "INSERT INTO winner VALUE (app_num, mem_id, mem_name, apt_name) "
					+ "VALUES (?, ?, ?, ?)";
			
			try {
				con = new DBConnection().getConnection();
				pstmt = con.prepareStatement(select);
				pstmt.setInt(1, mvo.getAppNum());
				pstmt.setString(2, mvo.getMemId());
				pstmt.setString(3, mvo.getMemName());
				pstmt.setString(4, mvo.getAptName());
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
}
