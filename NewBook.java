package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
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
	public NewBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(245, 106, 125, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(246, 181, 104, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Publisher");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		lblNewLabel_2.setBounds(245, 266, 125, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		lblNewLabel_3.setBounds(245, 345, 91, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Publisher Year");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		lblNewLabel_4.setBounds(245, 420, 172, 40);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField.setBounds(535, 102, 350, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_1.setColumns(10);
		textField_1.setBounds(535, 174, 350, 41);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_2.setColumns(10);
		textField_2.setBounds(535, 259, 350, 41);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_3.setColumns(10);
		textField_3.setBounds(535, 338, 350, 41);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_4.setColumns(10);
		textField_4.setBounds(535, 420, 350, 41);
		contentPane.add(textField_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String BookID=textField.getText();
				String Name=textField_1.getText();
				String Publisher=textField_2.getText();
				String Price=textField_3.getText();
				String PublisherYear=textField_4.getText();
				
				try
				{
					Connection con=ConnectionProvider.getcon();
					Statement st=con.createStatement();				
					st.executeUpdate("insert into NewBook Values('"+BookID+"','"+Name+"','"+Publisher+"','"+Price+"','"+PublisherYear+"')");
					JOptionPane.showMessageDialog(null, "Succesfully Saved");
					dispose();
					//setVisible(false);
					//new NewBook().setVisible(true);
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"BookID already exist" );
					setVisible(false);
					new NewBook().setVisible(true);
				}
				
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Books-icon.png"));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(373, 535, 115, 29);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Pictures\\Saved Pictures\\Button-Close-icon.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBounds(671, 535, 115, 29);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_6 = new JLabel("New Book");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_6.setBounds(447, 0, 164, 41);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\patilpatil.ankush\\Downloads\\Return book.jpg"));
		lblNewLabel_5.setBounds(0, 0, 956, 677);
		contentPane.add(lblNewLabel_5);
	}
}
