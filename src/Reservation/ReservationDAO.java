package Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReservationDAO {

	public void create(ReservationVO vo) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector connection");

		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB connecttion");

		String sql = "insert into reservation values(null,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, vo.getId());
		ps.setString(2, vo.getSubject());
		ps.setString(3, vo.getRegion());
		ps.setString(4, vo.getDate());
		ps.setString(5, vo.getRoom_num());
		ps.setString(6, vo.getTime());
		ps.setString(7, vo.getSeat_num());

		System.out.println("3. sql creation");

		ps.executeUpdate();
		System.out.println("4. sql transmission");

	}

	public ReservationVO num(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector connection");

		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB connecttion");

		String sql = "select max(reserv_num) from reservation where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		System.out.println("3. sql creation");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. sql transmission");

		ReservationVO bag_num = new ReservationVO();

		if (rs.next() == true) {
			System.out.println("검색결과 있음.");

			int reserv_num = rs.getInt(1);

			bag_num.setReserv_num(reserv_num);

		} else {
			System.out.println("검색결과 없음.");
		}
		return bag_num;
	}

	public ReservationVO one(int reserv_num) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector connection");

		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB connecttion");

		String sql = "select * from reservation where reserv_num = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, reserv_num);
		System.out.println("3. sql creation");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. sql transmission");

		ReservationVO bag = new ReservationVO();

		if (rs.next() == true) {
			System.out.println("검색결과 있음.");

			String id2 = rs.getString("id");
			String subject = rs.getString("subject");
			int reserv_num1 = rs.getInt("reserv_num");
			String region = rs.getString("region");
			String date = rs.getString("date");
			String room_num = rs.getString("room_num");
			String time = rs.getString("time");
			String seat_num = rs.getString("seat_num");

			bag.setId(id2);
			bag.setReserv_num(reserv_num1);
			bag.setSubject(subject);
			bag.setRegion(region);
			bag.setDate(date);
			bag.setRoom_num(room_num);
			bag.setTime(time);
			bag.setSeat_num(seat_num);
		} else {
			System.out.println("검색결과 없음.");
		}
		return bag;
	}

	public ArrayList<ReservationVO> call(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector connection");

		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB connecttion");

		String sql = "select * from reservation where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		System.out.println("3. sql creation");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. sql transmission");

		ArrayList<ReservationVO> list = new ArrayList<>();

		while (rs.next()) {
			ReservationVO bag = new ReservationVO();
			System.out.println("검색결과 있음.");

			String id2 = rs.getString("id");
			String subject = rs.getString("subject");
			int reserv_num1 = rs.getInt("reserv_num");
			String region = rs.getString("region");
			String date = rs.getString("date");
			String room_num = rs.getString("room_num");
			String time = rs.getString("time");
			String seat_num = rs.getString("seat_num");

			bag.setId(id2);
			bag.setReserv_num(reserv_num1);
			bag.setSubject(subject);
			bag.setRegion(region);
			bag.setDate(date);
			bag.setRoom_num(room_num);
			bag.setTime(time);
			bag.setSeat_num(seat_num);
			list.add(bag);
		}
		return list;
	}

	public void delete(ReservationVO vo) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector connection");

		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB connecttion");

		String sql = "delete from reservation where reserv_num = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getReserv_num());
		System.out.println("3. sql creation");

		ps.executeUpdate();
		System.out.println("4. sql transmission");

	}

}