package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product p) {
		
		Connection con = DBConnect.getConnection();
		String sql = "insert into product values(?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, p.getMa_san_pham());
			ps.setInt(2, p.getMa_the_loai());
			ps.setString(3, p.getTen_san_pham());
			ps.setString(4, p.getHinh_anh());
			ps.setDouble(5, p.getGia_ban());
			ps.setString(6, p.getHang_san_xuat());
			ps.setString(7, p.getThong_tin());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getList() {
		Connection con = DBConnect.getConnection();
		String sql = "select * from product";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham, hinh_anh, gia_ban, hang_san_xuat, thong_tin));
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}

	@Override
	public List<Product> getListByCategory(int id) {
		Connection con = DBConnect.getConnection();
		
		String sql = "select * from product where ma_the_loai ='"+id+"'";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				
				list.add(new Product(ma_san_pham, ma_the_loai, ten_san_pham, hinh_anh, gia_ban, hang_san_xuat, thong_tin));
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProduct(int id) {
		Connection con = DBConnect.getConnection();
		String sql = "select * from product where ma_san_pham ='"+ id +"'";
		Product p = new Product();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ma_san_pham = rs.getInt("ma_san_pham");
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_san_pham = rs.getString("ten_san_pham");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				p = new Product(ma_san_pham, ma_the_loai, ten_san_pham, hinh_anh, gia_ban, hang_san_xuat, thong_tin);		
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return p;
	}
	public static void main(String[] args) {
//		Product p = new Product(0, 1, "S6", "da", 500000.0 ,"","");
//		ProductDAOImpl productDAO = new ProductDAOImpl();
//		// productDAO.addProduct(p);
//		// System.out.println(productDAO.getList());
//		System.out.println(productDAO.getListByCategory(1));
	
	ProductDAOImpl productDAO = new ProductDAOImpl();
	System.out.println(productDAO.getList().get(1).getTen_san_pham());
	System.out.println(productDAO.getListByCategory(1).get(1).getTen_san_pham());
}
	@Override
	public List<Product> searchList(String ten_san_pham, String ten_the_loai) {
		Connection con = DBConnect.getConnection();
		
		String sql = null;
		
		return null;
	}

}
