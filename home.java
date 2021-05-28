package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					home frame = new home();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1322, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewStudent = new JButton("New Student");
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				new NewStudent().setVisible(true);
				
				
			}
		});
		btnNewStudent.setBackground(new Color(255, 222, 173));
		btnNewStudent.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\new student Icon.png"));
		btnNewStudent.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnNewStudent.setBounds(81, 174, 242, 57);
		contentPane.add(btnNewStudent);
		
		JButton btnNewBook = new JButton("NewBook");
		btnNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				new NewBook().setVisible(true);
			}
		});
		btnNewBook.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Books-icon.png"));
		btnNewBook.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnNewBook.setBackground(new Color(255, 228, 181));
		btnNewBook.setBounds(567, 174, 220, 57);
		contentPane.add(btnNewBook);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Statistics st=new Statistics();
				st.setVisible(true);
				
				//new home().setVisible(true);
			}
		});
		btnStatistics.setBackground(new Color(255, 222, 173));
		btnStatistics.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Statistics-icon.png"));
		btnStatistics.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnStatistics.setBounds(983, 176, 203, 53);
		contentPane.add(btnStatistics);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				IssueBook is=new IssueBook();
				is.setVisible(true);
				
			}
		});
		btnIssueBook.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Issuebook-icon (1).png"));
		btnIssueBook.setBackground(new Color(255, 222, 173));
		btnIssueBook.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnIssueBook.setBounds(204, 321, 213, 53);
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				ReturnBook rb= new ReturnBook();
				rb.setVisible(true);
			}
		});
		btnReturnBook.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Returnbooks-icon (1).png"));
		btnReturnBook.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnReturnBook.setBackground(new Color(255, 222, 173));
		btnReturnBook.setBounds(750, 321, 236, 53);
		contentPane.add(btnReturnBook);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
		      Login log=new Login();
		      log.setVisible(true);
		 
					
				
											
			}
		});
		btnLogout.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Logout-icon.png"));
		btnLogout.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnLogout.setBackground(new Color(255, 218, 185));
		btnLogout.setBounds(467, 441, 220, 57);
		contentPane.add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setBounds(605, 16, 69, 20);
		contentPane.add(label);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setOpaque(true);
		lblHomePage.setBackground(new Color(210, 105, 30));
		lblHomePage.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblHomePage.setBounds(499, 30, 213, 57);
		contentPane.add(lblHomePage);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Library.jpg"));
		lblNewLabel.setBounds(0, 0, 1285, 656);
		contentPane.add(lblNewLabel);
	}
}
