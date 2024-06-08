package skiLEarnHUB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AdminCrud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCrud frame = new AdminCrud();
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
	public AdminCrud() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Option");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(213, 46, 198, 63);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Category");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CategoryManagement().setVisible(true);
				AdminCrud.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(213, 119, 190, 63);
		contentPane.add(btnNewButton);
		
		JButton btnLocation = new JButton("Location");
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LocationManagement().setVisible(true);
				AdminCrud.this.setVisible(false);
			}
		});
		btnLocation.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnLocation.setBounds(213, 218, 190, 63);
		contentPane.add(btnLocation);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(116, 35, 398, 327);
		contentPane.add(panel);
	}
}
