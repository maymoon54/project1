package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MembershipDAO {

	/*
	 * create() 메소드 정의 :
	 * 회원가입------------------------------------------------------------
	 */

	public void create(MembershipVO bag) throws Exception {
		// 1.conector 설정
		Class.forName("com.mysql.jdbc.Driver");

		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문 작성
		String sql = "insert into membership values (?,?,?,?,?)";

		// 4.sql문 전송
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bag.getId());
		ps.setString(2, bag.getPw());
		ps.setString(3, bag.getName());
		ps.setString(4, bag.getEmail());
		ps.setString(5, bag.getPhone());

		ps.executeUpdate();
	}

	/*
	 * id중복체크를 위한 메소드 정의-----------------------------------------------------------
	 */

	public boolean read(String id) throws Exception {
		// 1.conector 설정
		Class.forName("com.mysql.jdbc.Driver");

		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문 작성
		String sql = "select * from membership where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4.sql문 전송
		ResultSet rs = ps.executeQuery();

		// id가 중복되지 않는 경우
		boolean result = false;

		if (rs.next()) {
			result = true; // id가 중복되는 경우
		} else {

		}
		return result;
	}

	/* id로 회원정보 검색----------------------------------------------------------- */
	public MembershipVO one(String id) throws Exception {
		// 1.connector설정
		Class.forName("com.mysql.jdbc.Driver");

		// 2.db연결
		// String url = "연결하는 방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문을 만든다.(create)

		String sql = "select * from membership where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4.sql문을 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많을 수도 있음.
		ResultSet rs = ps.executeQuery();

		MembershipVO bag = new MembershipVO();

		if (rs.next() == true) { // 결과가 있는지 없는지 체크해주는 메서드
			// if(rs.next())와 동일함.
			// if문은 rs.next()가 true때만 실행되므로!

			String id2 = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			// 가방에 넣기
			bag.setId(id2);
			bag.setPw(pw);
			bag.setName(name);
			bag.setPhone(phone);
			bag.setEmail(email);

		} else {
			System.out.println("검색결과가 없어요");
		}
		return bag;
		// bag은 참조형 변수, 주소를 전달!
	}

	/*
	 * update()메소드 정의 : 회원정보 수정
	 * -----------------------------------------------------------
	 */

	public void update(String pw, String name, String email, String phone, String id) throws Exception {

		// 1.connector설정
		Class.forName("com.mysql.jdbc.Driver");

		// 2.db연결
		// String url = "연결하는 방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 3.sql문을 만든다.(create)

		String sql = "update membership set pw=?, name=?, email=?, phone=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		// id,pw,name,email.phone
		ps.setString(1, pw);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, phone);
		ps.setString(5, id);

		// 4.sql문을 전송
		ps.executeUpdate();

	}

	/* 로그인을 위한 메소드 정의 ----------------------------------------------------------- */

	public boolean read(String id, String pw) throws Exception {
//1.connector설정
		Class.forName("com.mysql.jdbc.Driver");

//2.db연결
//String url = "연결하는 방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/movie?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

//3.sql문을 만든다.(create)

		String sql = "select * from membership where id = ? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);

//4.sql문을 전송
//select의 결과는 검색결과가 담긴 테이블(항목+내용)
//내용에는 없을 수도 있고, 많을 수도 있음.
		ResultSet rs = ps.executeQuery();

		boolean result = false; // 로그인이 안되는 상태(초기값)
		// 있다 없다 기 때문에 boolean으로 넘겨도 됨(용량면에서 더 효율적)

		if (rs.next() == true) { // 결과가 있는지 없는지 체크해주는 메서드
//if(rs.next())와 동일함.
//if문은 rs.next()가 true때만 실행되므로!

			System.out.println("로그인 ok");
			result = true;// 있음

		} else {
			System.out.println("로그인 not");
		}
		return result;
//false 넘어가면, 로그인not.
//true 넘어가면, 로그인ok.
	}

}