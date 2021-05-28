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
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent frame = new NewStudent();
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
	public NewStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1316, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccount = new JLabel("Create Student Account");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAccount.setBounds(407, 16, 376, 51);
		contentPane.add(lblAccount);
		
		JLabel lblStudentID = new JLabel("Student ID");
		lblStudentID.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblStudentID.setBounds(292, 119, 170, 40);
		contentPane.add(lblStudentID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblName.setBounds(302, 190, 122, 40);
		contentPane.add(lblName);
		
		JLabel lblFather = new JLabel("Father Name");
		lblFather.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblFather.setBounds(292, 251, 206, 51);
		contentPane.add(lblFather);
		
		JLabel lblCourse = new JLabel("Course Name");
		lblCourse.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblCourse.setBounds(292, 318, 206, 40);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch Name");
		lblBranch.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBranch.setBounds(292, 374, 206, 40);
		contentPane.add(lblBranch);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBackground(new Color(255, 250, 205));
		textField.setBounds(622, 121, 335, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setBounds(622, 192, 335, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setBackground(new Color(255, 250, 205));
		textField_2.setBounds(622, 257, 335, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"B.Tech"}));
		comboBox.setBackground(new Color(255, 250, 205));
		comboBox.setBounds(622, 318, 335, 43);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CSE", "Mechanical", "EEE", "ECE"}));
		comboBox_1.setBackground(new Color(255, 250, 205));
		comboBox_1.setBounds(622, 389, 335, 41);
		contentPane.add(comboBox_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String StudentID=textField.getText();
				String Name=textField_1.getText();
				String FatherName=textField_2.getText();
				String CourseName=(String) comboBox.getSelectedItem();
				String BranchName=(String) comboBox_1.getSelectedItem();
				
				try
				{
					Connection con=ConnectionProvider.getcon();
					Statement st=con.createStatement();				
					st.executeUpdate("insert into Student values('"+StudentID+"','"+Name+"','"+FatherName+"','"+CourseName+"','"+BranchName+"')");
					JOptionPane.showMessageDialog(null, "Succesfully Saved");
					dispose();
					//setVisible(false);
					//new NewStudent().setVisible(true);
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Student already exist");
					setVisible(false);
					new NewStudent().setVisible(true);
				}
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Returnbooks-icon (1).png"));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(312, 487, 115, 29);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(644, 487, 115, 29);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\BlurrTree.jpg"));
		lblNewLabel.setBounds(0, 0, 1279, 646);
		contentPane.add(lblNewLabel);
	}
}
