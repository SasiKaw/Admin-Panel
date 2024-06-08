package skiLEarnHUB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField JTextPassword;
	private JTextField JTextUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle(" Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(10, 10, 580, 385);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(49, 130, 72, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setBounds(49, 191, 72, 21);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(131, 305, 107, 45);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextUsername.setText("");
				JTextPassword.setText("");
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(326, 305, 113, 45);
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = JTextUsername.getText();
				String password = new String(JTextPassword.getPassword());
				
				if(userName.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Username & Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if(userName.equals("Admin")  && password.equals("Admin1234") ){
					JOptionPane.showMessageDialog(null, "Login Sucessful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
					
					new AdminCrud().setVisible(true);
					AdminLogin.this.setVisible(false);	
				}
				else {
					JOptionPane.showMessageDialog(null, "Ïncorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
					JTextUsername.setText("");
					JTextPassword.setText("");
				}
				
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(114, 10, 355, 53);
		panel_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login ");
		lblNewLabel_2.setBackground(SystemColor.activeCaptionText);
		lblNewLabel_2.setForeground(SystemColor.activeCaptionText);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JCheckBox JCheckPassword = new JCheckBox("Show Password");
		JCheckPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JCheckPassword.isSelected()){
					JTextPassword.setEchoChar((char) 0);
				}
				else {
					JTextPassword.setEchoChar('•');
				}
			}
		});
		JCheckPassword.setForeground(new Color(192, 192, 192));
		JCheckPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		JCheckPassword.setBounds(394, 232, 148, 34);
		JCheckPassword.setBackground(new Color(64, 128, 128));
		panel.add(JCheckPassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(64, 128, 128));
		panel_2.setBounds(34, 89, 512, 192);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPassword = new JPasswordField();
		JTextPassword.setBounds(97, 95, 393, 43);
		panel_2.add(JTextPassword);
		
		JTextUsername = new JTextField();
		JTextUsername.setBounds(97, 33, 393, 43);
		panel_2.add(JTextUsername);
		JTextUsername.setColumns(10);
	}
}
