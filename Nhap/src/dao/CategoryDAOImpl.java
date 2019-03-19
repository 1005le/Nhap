package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public void addCategory(Category category) {
		Connection con = DBConnect.getConnection();
		String sql = "insert into category value(?,?,?)";
		PreparedStatement ps; 
		try {
			
			//ps = con.prepareStatement(sql);
			ps = con.prepareCall(sql);
			ps.setInt(1, category.getMa_the_loai());
			ps.setString(2, category.getTen_the_loai());
			ps.setString(3, category.getMo_ta());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void deleteCategory(int ma_the_loai) {
		Connection con = DBConnect.getConnection(); 
		PreparedStatement ps;
		String sql = "delete from category where ma_the_loai ='"+ ma_the_loai+"'";
			try {
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();	
			}
	}

	@Override
	public List<Category> getList(){
		Connection con;
		String sql ="select * from category";
		List<Category> list = new ArrayList<Category>();
		try {
			con = DBConnect.getConnection();
			list = new ArrayList<Category>();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_the_loai = rs.getString("ten_the_loai");
				String mo_ta = rs.getString("mo_ta");
				list.add(new Category(ma_the_loai, ten_the_loai,mo_ta));
			}
			con.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return list;
	}

	@Override
	public Category getCategory(int id) {
		Connection con ;
		PreparedStatement ps;
		String sql = "select * from category where ma_the_loai ='"+ id +"'";
		Category c = new Category();	
		try {
			con = DBConnect.getConnection();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_the_loai = rs.getString("ten_the_loai");
				String mo_ta = rs.getString("mo_ta");
				c= new Category(ma_the_loai, ten_the_loai, mo_ta);
			
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void updateCategory(Category c) {
		Connection con ;
		String sql ="update category set ten_the_loai =?, mo_ta =? where ma_the_loai=?";
		PreparedStatement ps;
		
			con = DBConnect.getConnection();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, c.getTen_the_loai());
				ps.setString(2, c.getMo_ta());
				ps.setInt(3, c.getMa_the_loai());
				
				ps.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			 
				
	}
	public static void main(String[] args) {
		CategoryDAOImpl dao = new CategoryDAOImpl();
		Category c = new Category(1, "Samsung", "DT");
		 dao.addCategory(c);
		 System.out.println("Hello1:"+dao.getList());
		// dao.delCategory(10);
		//dao.updateCategory(c);
		 System.out.println("Hello2"+c.getTen_the_loai());
	}
	
	
}
