package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCar extends JFrame {

	private static final long serialVersionUID = 5303879358888777949L;
	private JPanel contentPane;
	private JTextField txtcarName;
	private JTextField txtNbrPassenger;
	private JTextField txtNbrBike;
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
	public AddCar(Person person) {
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_title = new JLabel("Add a new car");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(123, 37, 440, 58);
		contentPane.add(lbl_title);

		txtcarName = new JTextField();
		txtcarName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtcarName.getText().trim().equals("Car name")) {
					txtcarName.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtcarName.getText().trim().equals("")) {
					txtcarName.setText("Car name");
				}
			}
		});
		txtcarName.setText("Car name");
		txtcarName.setFont(new Font("Serif", Font.PLAIN, 20));
		txtcarName.setColumns(10);
		txtcarName.setBounds(43, 153, 250, 40);
		contentPane.add(txtcarName);

		txtNbrPassenger = new JTextField();
		txtNbrPassenger.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNbrPassenger.getText().trim().equals("Number of passenger place")) {
					txtNbrPassenger.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNbrPassenger.getText().trim().equals("")) {
					txtNbrPassenger.setText("Number of passenger place");
				}
			}
		});
		txtNbrPassenger.setText("Number of passenger place");
		txtNbrPassenger.setFont(new Font("Serif", Font.PLAIN, 20));
		txtNbrPassenger.setColumns(10);
		txtNbrPassenger.setBounds(43, 223, 250, 40);
		contentPane.add(txtNbrPassenger);

		txtNbrBike = new JTextField();
		txtNbrBike.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNbrBike.getText().trim().equals("Number of bike place")) {
					txtNbrBike.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNbrBike.getText().trim().equals("")) {
					txtNbrBike.setText("Number of bike place");
				}
			}
		});
		txtNbrBike.setText("Number of bike place");
		txtNbrBike.setFont(new Font("Serif", Font.PLAIN, 20));
		txtNbrBike.setColumns(10);
		txtNbrBike.setBounds(360, 223, 250, 40);
		contentPane.add(txtNbrBike);

		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountCarBike ac = new AccountCarBike(person);
				ac.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(43, 380, 205, 32);
		contentPane.add(btn_back);

		JButton btn_validate = new JButton("Validate");
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_name = txtcarName.getText().trim();
				int nbr_bike = 0;
				int nbr_passenger = 0;
				
				boolean verif = false;
				
				try {
					nbr_bike = Integer.parseInt(txtNbrBike.getText().trim());
					nbr_passenger = Integer.parseInt(txtNbrPassenger.getText().trim());
					verif = true;
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "You cannot insert a letter in the number of place");
					verif = false;
				}

				Car car = new Car(car_name, nbr_bike, nbr_passenger, person);
				if (car_name.equals("") || car_name.equals("Car name") || nbr_bike < 0 || nbr_passenger <= 0) {
					JOptionPane.showMessageDialog(null, "Please, complete all fields");
					verif = false;
				} else {
					verif = true;
				}
				if (verif) {
					boolean create = car.create();
					if (create) {
						JOptionPane.showMessageDialog(null, "Congratulation, you add a new car!");
						dispose();
						AccountCarBike ac = new AccountCarBike(person);
						ac.setVisible(true);
					}
				}
			}
		});
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(408, 380, 205, 32);
		contentPane.add(btn_validate);

		image = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
