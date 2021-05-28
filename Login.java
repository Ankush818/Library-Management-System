package library;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Project.ConnectionProvider;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.Point;
public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel LoginPage;
	//setExtendedState(JFrame.MAXIMIZED_BOTH);
	
	protected JLabel Label_1;

	/**Lo
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//JFrame jf=new JFrame();
		//jf.setSize(1650,1080);
		frame.setLocationRelativeTo(null);
	}

	

	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocation(new Point(325, 125));
		frame.setBounds(100, 100, 1001, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setOpaque(true);
		lblUsername.setBackground(new Color(255, 255, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(132, 121, 155, 50);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setLabelFor(frame);
		lblPassword.setBackground(new Color(255, 255, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(132, 241, 155, 43);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
					});
		txtUsername.addFocusListener(new FocusAdapter() {
			
		});
		txtUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtUsername.setBounds(466, 123, 420, 53);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			
		});
		txtPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		txtPassword.addFocusListener(new FocusAdapter() {
			
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtPassword.setBounds(466, 236, 420, 59);
		frame.getContentPane().add(txtPassword);
		
		JLabel LabelMs = new JLabel("");
		LabelMs.setForeground(Color.RED);
		LabelMs.setFont(new Font("Algerian", Font.PLAIN, 20));
		LabelMs.setBounds(466, 401, 420, 50);
		frame.getContentPane().add(LabelMs);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=txtUsername.getText();
				String password=txtPassword.getText();
				try{
					Connection con=ConnectionProvider.getcon();
					
					//String query="Select Username,Password from SignUp";
					String query=("Select * from SignUp where Username='"+username+"' AND Password='"+password+"'");
					Statement st=con.createStatement();
					ResultSet set=st.executeQuery(query);
					
					if(set.next())
					{
                        home me=new home();
                       
						me.setVisible(true);
						dispose();
						//me.sleep(100000);
					}
					
					else						
						JOptionPane.showMessageDialog(null,"Incorrect password or username");
				
				
				
								
				
				}		
					
				catch( Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);	
					 
				}
				
					
				
				
			}
		

			private void dispose() {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\ok-icon.png"));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(224, 516, 143, 50);
		frame.getContentPane().add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnClose.setBounds(619, 516, 143, 50);
		frame.getContentPane().add(btnClose);
		
		JLabel lblLoginPage = new JLabel("");
		lblLoginPage.setForeground(new Color(0, 0, 0));
		lblLoginPage.setBackground(new Color(210, 105, 30));
		lblLoginPage.setBounds(423, 67, 116, 20);
		frame.getContentPane().add(lblLoginPage);
		
		LoginPage = new JLabel("Login Page");
		LoginPage.setOpaque(true);
		LoginPage.setForeground(new Color(0, 0, 0));
		LoginPage.setBackground(Color.RED);
		LoginPage.setFont(new Font("Times New Roman", Font.BOLD, 40));
		LoginPage.setBounds(373, -8, 236, 59);
		frame.getContentPane().add(LoginPage);
		
		JLabel Label_1 = new JLabel("");
		Label_1.setBounds(466, 321, 358, 45);
		frame.getContentPane().add(Label_1);
		
		//JPasswordField txtPassword=new JPasswordField();
		JCheckBox chCheckBox = new JCheckBox("Show Password");
		chCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chCheckBox.isSelected())
				{
					txtPassword.setEchoChar((char)0);
				}
				else{
					txtPassword.setEchoChar('*');
				}
			}
		});
		chCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chCheckBox.setBounds(466, 337, 180, 29);
		frame.getContentPane().add(chCheckBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\blurr Library.jpg"));
		lblNewLabel.setBounds(0, 0, 979, 674);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
    



	
}
