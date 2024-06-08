package skiLEarnHUB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class Category {
	
	protected AdminDB dbconn;
	
	public Category() {
		dbconn = new AdminDB();
	}
	
	public boolean insertCategory(String name) {
		String sql = "INSERT INTO job_categories(category) VALUES (?)";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			statement.setString(1, name);
			
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Category cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(!name.matches("[a-zA-Z\\s]+$")) {
				JOptionPane.showMessageDialog(null, "Category name must only contain letters", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				int rowInserted =  statement.executeUpdate();
				
				if(rowInserted >= 1) {
					return true;
				}
				else {
					return false;
				}
				
			}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to add categories" + e.getMessage());
			return false;
		}
	}
	
	public boolean updateCategory(String id, String name) {
		String sql = "UPDATE job_categories SET category = (?) WHERE id = (?)";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, id);
			
			if(id.isEmpty() || name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fields cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(!id.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "ID must be numeric", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				int rowInserted =  statement.executeUpdate();
				
				if(rowInserted >= 1) {
					return true;
				}
				else {
					return false;
				}
			}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to update categories" + e.getMessage());
			return false;
		}
		
	}
	
	public boolean deleteCategory(String id) {
		String sql = "DELETE FROM job_categories WHERE id = (?)";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			statement.setString(1, id);
			
			if(id.isEmpty()) {
				JOptionPane.showMessageDialog(null, "ID cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(!id.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "ID must be numeric", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else {
				int rowInserted =  statement.executeUpdate();
				
				if(rowInserted >= 1) {
					return true;
				}
				else {
					return false;
				}
			}
			
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to delete categories" + e.getMessage());
			return false;
		}
		
		
		
	}
	
	public ResultSet getCategoryById(String id) {
		String sql = "SELECT id, category FROM job_categories WHERE id = (?)";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			statement.setString(1, id);
			return statement.executeQuery();
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Faild to retrieve categories" + e.getMessage());
			return null;
		}
	}
	
	public ResultSet getAllCategories() {
		String sql = "SELECT * FROM job_categories";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			return statement.executeQuery();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Faild to retrieve categories" + e.getMessage());
			return null;
		}
		
	}
	

}
