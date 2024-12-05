package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExe {
	public static void main(String[] args) {
		delete(210);
		select();
		System.out.println("end of prog.");
	}


	// 연결.
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드.
			// Connection 객체.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println("연결 중 에러.");
			e.printStackTrace();
		}
		return conn; // connection 객체 반환.
	}
	
	// 삭제 기능.
	public static void delete(int empId) {
		Connection conn = getConn();
		String query = "delete employees where employee_id = "+ empId +"";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 수정 기능.
	public static void update(String fname, String pno, int sal, int empId) {
		Connection conn = getConn();
//		String query = "update employees"
//				+ "     set first_name = '"+ fname + "' "
//				+ "         ,phone_number = '" + pno + "' "
//				+ "         ,salary = " + sal + " "
//				+ "        where employee_id = " + empId + " ";
		String query2 = "update employees set first_name = '"+ fname +"', phone_number = '" + pno +"', salary = " + sal +" where employee_id = "+empId+"";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query2);
			System.out.println(r + "건 처리됨.");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 입력 기능.
	public static void insert(String lastName, String email, String hdate, String job ) {
		Connection conn = getConn();
		String query = "insert into employees (employee_id, last_name, email, hire_date, job_id) "
				+ "values(employees_seq.nextval" // empId
				+ ", '" + lastName + "'" // last_name
						+ ", '"+ email +"'" // email
								+ ", '"+ hdate +"'" // hire_date
								+ ", '"+ job +"')"; // job_id
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 조회 기능.
	public static void select() {
		Connection conn = getConn();
		
		// sql 작성. Statement 객체.
		Statement stmt;
		try {
			stmt = conn.createStatement();
			// 조회.
			ResultSet rs = stmt.executeQuery("select * from employees order by employee_id desc"); // 조회.
			// 결과출력.
			while (rs.next()) {
				System.out.println(rs.getInt("employee_id") + ", " //
						+ rs.getString("first_name") + ", " //
						+ rs.getString("email"));
			}
			conn.close(); // 연결 해제.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" == end of data == ");
	}
} // end of class.
