package skiLEarnHUB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class Location {
protected AdminDB dbconn;
	
	public Location() {
		dbconn = new AdminDB();
	}
	
	public boolean insertLocation(String name) {
		String sql = "INSERT INTO locations(location) VALUES (?)";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			statement.setString(1, name);
			
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Location cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(!name.matches("[a-zA-Z\\s]+$")) {
				JOptionPane.showMessageDialog(null, "Location name must only contain letters", "Validation Error", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Failed to add Locations" + e.getMessage());
			return false;
		}
	}
	
	public boolean updateLocation(String id, String name) {
		String sql = "UPDATE locations SET location = (?) WHERE id = (?)";
		
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
			JOptionPane.showMessageDialog(null, "Failed to update Locations" + e.getMessage());
			return false;
		}
		
	}
	
	public boolean deleteLocation(String id) {
		String sql = "DELETE FROM locations WHERE id = (?)";
		
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
			JOptionPane.showMessageDialog(null, "Failed to delete Locations" + e.getMessage());
			return false;
		}
		
		
		
	}
	
	public ResultSet getLocationById(String id) {
		String sql = "SELECT id, location FROM locations WHERE id = (?)";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			statement.setString(1, id);
			return statement.executeQuery();
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Faild to retrieve locations" + e.getMessage());
			return null;
		}
	}
	
	public ResultSet getAllLocations() {
		String sql = "SELECT * FROM locations";
		
		try {
			PreparedStatement statement = dbconn.connectDB().prepareStatement(sql);
			return statement.executeQuery();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Faild to retrieve locations" + e.getMessage());
			return null;
		}
		
	}
}
