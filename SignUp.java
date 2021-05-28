package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Point;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 735);
		contentPane = new JPanel();
		contentPane.setLocation(new Point(325, 125));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(378, 16, 262, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblUsername.setBounds(199, 140, 154, 36);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Create Password");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(195, 243, 244, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(195, 348, 244, 36);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(537, 138, 380, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setBounds(537, 231, 380, 45);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textField.getText();
				String password=textField_1.getText();
				String Cpassword=passwordField_2.getText();
				
				if(password.equals(Cpassword)){
                try{
				Connection con=ConnectionProvider.getcon();
				Statement st=con.createStatement();				
				st.executeUpdate("insert into SignUp values('"+username+"','"+password+"','"+Cpassword+"')");
				JOptionPane.showMessageDialog(null, "Registered Sucessfully");
				setVisible(false);
				new Login().setVisible(true);
                }
                
                catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
					setVisible(false);
					new NewStudent().setVisible(true);
				}
			}
			
			else
				JOptionPane.showMessageDialog(null,"Passwords Does not match");
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\ok-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(428, 481, 154, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(709, 481, 115, 45);
		contentPane.add(btnNewButton_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField_2.setBounds(537, 346, 380, 45);
		contentPane.add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(564, 422, -486, 26);
		contentPane.add(passwordField_3);
		
		JButton btnNewButton_2 = new JButton("Log In");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Login l=new Login();
				setVisible(false);
				//l.setVisible(true);
				new Login().setVisible();
			}
		});
		btnNewButton_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton_2.setBounds(144, 486, 133, 36);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\Mountain.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1046, 738);
		contentPane.add(lblNewLabel_3);
	}
}
