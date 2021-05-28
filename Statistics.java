package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable tableIssue;
	private JTable table_3;
	private JTable table_4;
	private JTable tableReturn;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Statistics");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(500, 0, 275, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Issue Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(15, 51, 190, 31);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(15, 244, 1085, -101);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(128, 208, 1041, -48);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setColumnSelectionAllowed(true);
		table_2.setBounds(67, 144, 1, 1);
		contentPane.add(table_2);
		
		JLabel lblNewLabel_2 = new JLabel("Return Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(15, 364, 197, 38);
		contentPane.add(lblNewLabel_2);
		
		table_3 = new JTable();
		table_3.setBounds(51, 436, 1, 1);
		contentPane.add(table_3);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBackground(new Color(255, 250, 205));
		btnClose.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnClose.setBounds(1142, 373, 115, 29);
		contentPane.add(btnClose);
		
		JButton btnFetch = new JButton("Fetch Data");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connection con=ConnectionProvider.getcon();
					Statement st=con.createStatement();	
					ResultSet rs=st.executeQuery("Select Issue.StudentID,Student.Name,Issue.BookID,NewBook.Name,Issue.IssueDate,Issue.DueDate FROM Issue inner join NewBook ON  NewBook.BookID=Issue.BookID inner join Student ON Student.StudentID=Issue.StudentID where Issue.ReturnBook='NO'");
					//ResultSet rs=st.executeQuery("Select Issue.StudentID,Student.Name,Issue.BookID,NewBook.Name,Issue.IssueDate,Issue.DueDate from Student inner join NewBook inner join Issue where NewBook.BookID=Issue.BookID and Student.StudentID=Issue.StudentID and Issue.ReturnBook='NO'");
					tableIssue.setModel(DbUtils.resultSetToTableModel(rs));
					
					ResultSet rs1=st.executeQuery("Select Issue.StudentID,Student.Name,Issue.BookID,NewBook.Name,Issue.IssueDate,Issue.DueDate FROM Issue inner join NewBook ON  NewBook.BookID=Issue.BookID inner join Student ON Student.StudentID=Issue.StudentID where Issue.ReturnBook='YES'");
					//ResultSet rs1=st.executeQuery("Select Issue.StudentID,Student.Name,Issue.BookID,NewBook.Name,Issue.IssueDate,Issue.DueDate from Student inner join NewBook inner join Issue where NewBook.BookID=Issue.BookID and Student.StudentID=Issue.StudentID and Issue.ReturnBook='YES'");
					tableReturn.setModel(DbUtils.resultSetToTableModel(rs1));
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnFetch.setBackground(new Color(230, 230, 250));
		btnFetch.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Books-icon.png"));
		btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnFetch.setBounds(1085, 38, 190, 47);
		contentPane.add(btnFetch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 99, 1275, 214);
		contentPane.add(scrollPane);
		
		tableIssue = new JTable();
		tableIssue.setFont(new Font("Tahoma", Font.BOLD, 30));
		scrollPane.setViewportView(tableIssue);
		tableIssue.setCellSelectionEnabled(true);
		tableIssue.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tableIssue.setFillsViewportHeight(true);
		tableIssue.setColumnSelectionAllowed(true);
		
		table_4 = new JTable();
		table_4.setBounds(36, 522, 370, -85);
		contentPane.add(table_4);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		scrollPane_1.setSize(new Dimension(5, 5));
		scrollPane_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		scrollPane_1.setBounds(0, 418, 1275, 221);
		contentPane.add(scrollPane_1);
		
		tableReturn = new JTable();
		scrollPane_1.setViewportView(tableReturn);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\blurr Library.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1300, 639);
		contentPane.add(lblNewLabel_3);
	}
}
