package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	
	public void addCategory(Category category);
	public void deleteCategory(int ma_the_loai);
	
	public List<Category> getList();
	public Category getCategory(int ma_the_loai);
	public void updateCategory(Category c);
	
	
}
