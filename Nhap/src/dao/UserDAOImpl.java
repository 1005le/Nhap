package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean checkUser(String username) {
		Connection con = DBConnect.getConnection();
		String sql ="select * from [user] where username='"+ username+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		Connection con  = DBConnect.getConnection();
		String sql="select * from [user] where username ='"+ username+"' and password='"+password+"' ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				con.close();
				return true;
			}			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateUser(User u) {
		Connection con = DBConnect.getConnection();
		String sql="update [user] set user_id=?, password=?, ngaysinh=?, gioitinh=?,email=?, sdt=?,diachi=?,role=?"
				+ "where username=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,u.getUser_id());
			ps.setString(2, u.getPassword());
			ps.setDate(3, u.getNgaysinh());
			ps.setString(4, u.getGioitinh());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getSdt());
			ps.setString(7, u.getDiachi());
			ps.setString(8, u.getRole());
			ps.setString(9, u.getUsername());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(String name) {
	Connection con = DBConnect.getConnection();
	String sql = "select * from [user] where username='"+name+"'";
	User u = new User();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int user_id = rs.getInt("user_id");
			String username= rs.getString("username");
			String password = rs.getString("password");
			Date ngaysinh = rs.getDate("ngaysinh");
			String gioitinh = rs.getString("gioitinh");
			String email = rs.getString("email");
			String sdt = rs.getString("sdt");
			String diachi = rs.getString("diachi");
			String role = rs.getString("role");
			u = new User(user_id, username, password,ngaysinh,gioitinh,email,sdt,diachi,role);
		}
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return u;
	}

	@Override
	public void addUser(User u) {
		Connection con = DBConnect.getConnection();
		String sql = "insert into [user] values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setDate(4, u.getNgaysinh());
			ps.setString(5, u.getGioitinh());
			ps.setString(6, u.getEmail());
			ps.setString(7, u.getSdt());
			ps.setString(8, u.getDiachi());
			ps.setString(9, u.getRole());
			
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
		String txt1 ="1997-10-10";		       
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		      try {
				java.sql.Date effect_from = new java.sql.Date(formatter.parse(txt1).getTime());
				dao.addUser(new User(4,"long","12345",effect_from,"Nữ","long@gmail.com", "077654123","Ha Noi", "2"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}  
		
		System.out.println(dao.checkUser("lien"));
		System.out.println(dao.login("lien", "12345"));
	}

}
