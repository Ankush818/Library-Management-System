package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Project.ConnectionProvider;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 33));
		lblNewLabel.setBounds(418, 0, 174, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BookID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(61, 117, 105, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(61, 202, 117, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Issue Date");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(61, 298, 117, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Due Date");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(61, 385, 105, 39);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 235, 205));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(309, 110, 351, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 239, 213));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(309, 195, 351, 45);
		contentPane.add(textField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 22));
		dateChooser.setForeground(new Color(0, 0, 0));
		dateChooser.setBounds(309, 282, 351, 45);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		dateChooser_1.setBounds(309, 385, 351, 45);
		contentPane.add(dateChooser_1);
		
		JButton btnIssue = new JButton("Issue ");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat dFormate=new SimpleDateFormat("dd-MM-YYYY");
				String BookId=textField.getText();
				String StudentId=textField_1.getText();
				String IssueDate=dFormate.format(dateChooser.getDate());
				String DueDate=dFormate.format(dateChooser_1.getDate());
				String ReturnDate="NO";
				
				try
				{
					Connection con=ConnectionProvider.getcon();
					Statement st=con.createStatement();		
					ResultSet set=st.executeQuery("select * from NewBook where BookID='"+BookId+"'");
					
					if(set.next())
					{
						ResultSet set1=st.executeQuery("select * from Student where StudentID='"+StudentId+"'");
						if(set1.next())
						{
							ResultSet set2=st.executeQuery("select * from Issue where BookID='"+BookId+"' AND StudentID='"+StudentId+"'");
							if(set2.next())
							{
								JOptionPane.showMessageDialog(null, "Already Book Issued");
							}
							else{
								st.executeUpdate("insert into Issue values('"+BookId+"','"+StudentId+"','"+IssueDate+"','"+DueDate+"','"+ReturnDate+"')");
							JOptionPane.showMessageDialog(null, "Book Successfully Issued");
							}
							
						}
						else
							JOptionPane.showMessageDialog(null, "Incorrect StudentID");
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect BookID");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnIssue.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Books-icon.png"));
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIssue.setBounds(151, 498, 131, 29);
		contentPane.add(btnIssue);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBounds(480, 498, 115, 29);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\book.jpg"));
		lblNewLabel_5.setBounds(0, 0, 971, 667);
		contentPane.add(lblNewLabel_5);
	}
}
