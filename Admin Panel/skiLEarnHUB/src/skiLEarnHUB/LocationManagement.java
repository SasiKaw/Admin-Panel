package skiLEarnHUB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class LocationManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField JTextLocId;
	private JTextField JTextLocName;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnUpdate_1;
	private JLabel lblLocationManagement;
	private JButton btnSearch;
	private JTable JLocationTable;
	private JButton btnViewAll;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationManagement frame = new LocationManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LocationManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(70, 10, 836, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblLocationManagement = new JLabel("Location Management");
		lblLocationManagement.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLocationManagement.setBounds(297, 28, 292, 33);
		panel.add(lblLocationManagement);
		
		panel_1 = new JPanel();
		panel_1.setBounds(21, 120, 517, 191);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Location Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 28, 132, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblCategoryName = new JLabel("Location Name");
		lblCategoryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoryName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCategoryName.setBounds(23, 104, 151, 32);
		panel_1.add(lblCategoryName);
		
		JTextLocId = new JTextField();
		JTextLocId.setBounds(184, 28, 272, 28);
		panel_1.add(JTextLocId);
		JTextLocId.setColumns(10);
		
		JTextLocName = new JTextField();
		JTextLocName.setColumns(10);
		JTextLocName.setBounds(184, 104, 272, 28);
		panel_1.add(JTextLocName);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(42, 333, 132, 68);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JTextLocName.getText();
				Location cat = new Location();
				boolean result = cat.insertLocation(name);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Location insert sucessful");
					JTextLocName.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to insert location");
					JTextLocName.setText("");
					
				}
			}
		});
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(386, 333, 132, 68);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JTextLocId.getText();
				
				Location cat = new Location();
				boolean result = cat.deleteLocation(id);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Location deleted sucessful");
					JTextLocId.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to delete location");
					JTextLocId.setText("");
					
				}
			}
		});
		contentPane.add(btnNewButton_2);
		
		btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JTextLocId.getText();
				String name = JTextLocName.getText();
				
				Location loc = new Location();
				boolean result = loc.updateLocation(id, name);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Location update sucessful");
					JTextLocId.setText("");
					JTextLocName.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to update location");
					JTextLocId.setText("");
					JTextLocName.setText("");
					
				}
			}
		});
		btnUpdate_1.setBounds(212, 333, 132, 68);
		btnUpdate_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnUpdate_1);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JTextLocId.getText();
				
				DefaultTableModel model = (DefaultTableModel) JLocationTable.getModel();
				model.setRowCount(0);
				
				Location loc = new Location();
				
				ResultSet rs = loc.getLocationById(id);
				
				try {
					if(rs != null && rs.next()) {
						model.addRow(new Object[] {rs.getInt("id"), rs.getString("location")});
						JTextLocId.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "No location found with Id: " + id, "Search Result", JOptionPane.INFORMATION_MESSAGE);
						JTextLocId.setText("");
					}
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSearch.setBounds(212, 416, 132, 68);
		contentPane.add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(572, 116, 436, 285);
		contentPane.add(scrollPane);
		
		JLocationTable = new JTable();
		scrollPane.setViewportView(JLocationTable);
		JLocationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Location Id", "Location Name"
			}
		));
		JLocationTable.getColumnModel().getColumn(0).setPreferredWidth(81);
		JLocationTable.getColumnModel().getColumn(1).setPreferredWidth(97);
		
		btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) JLocationTable.getModel();
				model.setRowCount(0);
				Location loc = new Location();
				ResultSet rs = loc.getAllLocations();
				
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getInt("id"), rs.getString("location")});
					}
					
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnViewAll.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewAll.setBounds(876, 416, 132, 68);
		contentPane.add(btnViewAll);
	}
}
