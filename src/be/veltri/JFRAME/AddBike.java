package be.veltri.JFRAME;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;
import be.veltri.POJO.Person;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddBike extends JFrame {

	private static final long serialVersionUID = -1581074237176718389L;
	private JPanel contentPane;
	private JTextField txtBikeType;
	private JTextField txtWeight;
	private JTextField txtLenght;
	private JLabel image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection frame = new Connection();
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
	public AddBike(Person person) {
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Add a new bike");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(123, 50, 440, 58);
		contentPane.add(lbl_title);
		
		txtBikeType = new JTextField();
		txtBikeType.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtBikeType.getText().trim().equals("Bike type")) {
					txtBikeType.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtBikeType.getText().trim().equals("")) {
					txtBikeType.setText("Bike type");
				}
			}
		});
		txtBikeType.setText("Bike type");
		txtBikeType.setFont(new Font("Serif", Font.PLAIN, 20));
		txtBikeType.setColumns(10);
		txtBikeType.setBounds(45, 142, 250, 40);
		contentPane.add(txtBikeType);
		
		txtWeight = new JTextField();
		txtWeight.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtWeight.getText().trim().equals("Weight")) {
					txtWeight.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtWeight.getText().trim().equals("")) {
					txtWeight.setText("Weight");
				}
			}
		});
		txtWeight.setText("Weight");
		txtWeight.setFont(new Font("Serif", Font.PLAIN, 20));
		txtWeight.setColumns(10);
		txtWeight.setBounds(45, 212, 250, 40);
		contentPane.add(txtWeight);
		
		txtLenght = new JTextField();
		txtLenght.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtLenght.getText().trim().equals("Lenght")) {
					txtLenght.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtLenght.getText().trim().equals("")) {
					txtLenght.setText("Lenght");
				}
			}
		});
		txtLenght.setText("Lenght");
		txtLenght.setFont(new Font("Serif", Font.PLAIN, 20));
		txtLenght.setColumns(10);
		txtLenght.setBounds(362, 212, 250, 40);
		contentPane.add(txtLenght);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountCarBike ac = new AccountCarBike(person);
				ac.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(42, 381, 205, 32);
		contentPane.add(btn_back);
		
		JButton btn_validate = new JButton("Validate");
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = txtBikeType.getText().trim();
				int lenght = 0;
				int weight = 0;
				
				boolean verif = false;
				try {
					lenght = Integer.parseInt(txtLenght.getText().trim());
					weight = Integer.parseInt(txtWeight.getText().trim());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "You cannot insert a letter in the number of place");
					verif = false;
				}
				
				Bike bike = new Bike(weight, type, lenght, person);
				if (type.equals("") || type.equals("Bike type") || lenght <= 0 || weight <= 0) {
					JOptionPane.showMessageDialog(null, "Please, complete all fields");
					verif = false;
				} else {
					verif = true;
				}
				if (verif) {
					boolean create = bike.create();
					if (create) {
						JOptionPane.showMessageDialog(null, "Congratulation, you add a new bike!");
						dispose();
						AccountCarBike ac = new AccountCarBike(person);
						ac.setVisible(true);
					}
				}
			}
		});
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(407, 381, 205, 32);
		contentPane.add(btn_validate);
		
		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(0, 0, 700, 500);
		getContentPane().add(image);
	}
}
