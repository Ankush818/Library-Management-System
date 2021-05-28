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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
		lblNewLabel.setBounds(481, 16, 228, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(251, 142, 117, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(251, 237, 154, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Issue Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(251, 327, 154, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Due Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(249, 413, 137, 20);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 235, 205));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(472, 124, 325, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 228, 181));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setBounds(472, 224, 325, 47);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 228, 196));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(472, 314, 325, 47);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 228, 196));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(472, 400, 325, 47);
		contentPane.add(textField_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String BookId=textField.getText();
				String StudentId=textField_1.getText();
				try
				{
					Connection con=ConnectionProvider.getcon();
					Statement st=con.createStatement();		
					ResultSet set=st.executeQuery("select * from Issue where BookID='"+BookId+"' AND StudentID='"+StudentId+"'");
					
					if(set.next())
					{
						textField_2.setText(set.getString(3));
						textField_3.setText(set.getString(4));
						
						textField.setEditable(false);
						textField_1.setEditable(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Book is not issued to this student");
						setVisible(false);
						new ReturnBook().setVisible(true);
					}
				}					
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
			}
		});
		btnSearch.setBackground(new Color(173, 255, 47));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Ninja-icon.png"));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(862, 224, 161, 42);
		contentPane.add(btnSearch);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String BookId=textField.getText();
				String StudentId=textField_1.getText();
				try
				{
					Connection con=ConnectionProvider.getcon();
					Statement st=con.createStatement();		
					st.executeUpdate("Update Issue set ReturnBook='YES' where BookID='"+BookId+"' AND StudentID='"+StudentId+"'");
					JOptionPane.showMessageDialog(null, "Book Successfully Returned");
			}
				
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnReturn.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Returnbooks-icon (1).png"));
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnReturn.setBounds(232, 522, 154, 40);
		contentPane.add(btnReturn);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBackground(new Color(173, 255, 47));
		btnClose.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBounds(636, 522, 142, 37);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBackground(new Color(173, 255, 47));
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\blurr Library.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1090, 666);
		contentPane.add(lblNewLabel_5);
	}
}
