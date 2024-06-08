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

public class CategoryManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField JTextCatId;
	private JTextField JTextCatName;
	private JButton btnNewButton;
	private JButton btnSearch;
	private JButton btnNewButton_2;
	private JButton btnUpdate_1;
	private JLabel lblCategoryManagement;
	private JTable JCategoryTable;
	private JButton btnViewAll;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryManagement frame = new CategoryManagement();
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
	public CategoryManagement() {
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
		
		lblCategoryManagement = new JLabel("Category Management");
		lblCategoryManagement.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCategoryManagement.setBounds(277, 27, 302, 33);
		panel.add(lblCategoryManagement);
		
		panel_1 = new JPanel();
		panel_1.setBounds(21, 120, 517, 191);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 28, 132, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoryName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCategoryName.setBounds(23, 104, 151, 32);
		panel_1.add(lblCategoryName);
		
		JTextCatId = new JTextField();
		JTextCatId.setBounds(184, 28, 272, 28);
		panel_1.add(JTextCatId);
		JTextCatId.setColumns(10);
		
		JTextCatName = new JTextField();
		JTextCatName.setColumns(10);
		JTextCatName.setBounds(184, 104, 272, 28);
		panel_1.add(JTextCatName);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(42, 333, 132, 68);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JTextCatName.getText();
				Category cat = new Category();
				boolean result = cat.insertCategory(name);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Category insert sucessful");
					JTextCatName.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to insert category");
					JTextCatName.setText("");
					
				}
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(212, 416, 132, 68);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JTextCatId.getText();
				
				DefaultTableModel model = (DefaultTableModel) JCategoryTable.getModel();
				model.setRowCount(0);
				
				Category cat = new Category();
				
				ResultSet rs = cat.getCategoryById(id);
				
				try {
					if(rs != null && rs.next()) {
						model.addRow(new Object[] {rs.getInt("id"), rs.getString("category")});
						JTextCatId.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "No category found with Id: " + id, "Search Result", JOptionPane.INFORMATION_MESSAGE);
						JTextCatId.setText("");
					}
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		contentPane.add(btnSearch);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(386, 333, 132, 68);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JTextCatId.getText();
				
				Category cat = new Category();
				boolean result = cat.deleteCategory(id);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Category deleted sucessful");
					JTextCatId.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to delete category");
					JTextCatId.setText("");
					
				}
				
			}
		});
		contentPane.add(btnNewButton_2);
		
		btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JTextCatId.getText();
				String name = JTextCatName.getText();
				
				Category cat = new Category();
				boolean result = cat.updateCategory(id, name);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Category update sucessful");
					JTextCatId.setText("");
					JTextCatName.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to update category");
					JTextCatId.setText("");
					JTextCatName.setText("");
					
				}
				
				
			}
		});
		btnUpdate_1.setBounds(212, 333, 132, 68);
		btnUpdate_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnUpdate_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(572, 116, 436, 285);
		contentPane.add(scrollPane);
		
		JCategoryTable = new JTable();
		scrollPane.setViewportView(JCategoryTable);
		JCategoryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category Id", "Category Name"
			}
		)
		{	
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}		
			
		);
		JCategoryTable.getColumnModel().getColumn(1).setPreferredWidth(86);
		
		btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) JCategoryTable.getModel();
				model.setRowCount(0);
				Category cat = new Category();
				ResultSet rs = cat.getAllCategories();
				
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getInt("id"), rs.getString("category")});
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
