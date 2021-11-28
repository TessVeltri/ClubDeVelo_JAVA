package be.veltri.JFRAME;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;
import be.veltri.POJO.Member;
import be.veltri.POJO.Person;

public class AccountCarBike extends JFrame {

	private static final long serialVersionUID = 1224965392499452783L;
	private JPanel contentPane;
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
	public AccountCarBike(Person person) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Your car and your bike");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(123, 34, 440, 58);
		contentPane.add(lbl_title);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberHome mh = new MemberHome((Member)person);
				mh.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(28, 396, 205, 32);
		contentPane.add(btn_back);
		
		JButton btn_walks = new JButton("Your walks");
		btn_walks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountWalks aw = new AccountWalks(person);
				aw.setVisible(true);
			}
		});
		btn_walks.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_walks.setBounds(28, 166, 205, 32);
		contentPane.add(btn_walks);
		
		JButton btn_car = new JButton("Your car and bike");
		btn_car.setEnabled(false);
		btn_car.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_car.setBounds(28, 227, 205, 32);
		contentPane.add(btn_car);
		
		JButton btn_data = new JButton("Your data");
		btn_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountData ad = new AccountData (person);
				ad.setVisible(true);
			}
		});
		btn_data.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_data.setBounds(28, 290, 205, 32);
		contentPane.add(btn_data);
		
		JButton btn_addCar = new JButton("Add a car");
		btn_addCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddCar ad = new AddCar(person);
				ad.setVisible(true);
			}
		});
		btn_addCar.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_addCar.setBounds(341, 215, 205, 32);
		contentPane.add(btn_addCar);
		
		JLabel lbl_carValue = new JLabel("Car name : ");
		lbl_carValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_carValue.setBounds(316, 166, 247, 48);
		contentPane.add(lbl_carValue);
		
		Car car = new Car();
		car = car.find(person.findId());
		if ( car != null ) {
			btn_addCar.setEnabled(false);
			lbl_carValue.setText("Car name : " + car.getCarName());
		} else {
			btn_addCar.setEnabled(true);
		}
		
		JButton btn_delete_car = new JButton("");
		btn_delete_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car car = new Car();
				car = car.find(person.findId());
				if(car != null) {
					car.delete();
					JOptionPane.showMessageDialog(null, "Your car has been deleted");
					lbl_carValue.setText("Car name : ");
					btn_addCar.setEnabled(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "No car found");
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/delete_logo.jpg")).getImage();
		btn_delete_car.setIcon(new ImageIcon(img));
		btn_delete_car.setBounds(585, 166, 50, 50);
		contentPane.add(btn_delete_car);
		
		JButton btn_addBike = new JButton("Add a bike");
		btn_addBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddBike ab = new AddBike(person);
				ab.setVisible(true);
			}
		});
		btn_addBike.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_addBike.setBounds(341, 339, 205, 32);
		contentPane.add(btn_addBike);
		
		JLabel lbl_bikeValue = new JLabel("Bike : ");
		lbl_bikeValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_bikeValue.setBounds(316, 290, 247, 48);
		contentPane.add(lbl_bikeValue);
		
		Bike bike = new Bike();
		bike = bike.find(person.findId());
		if ( bike != null ) {
			btn_addBike.setEnabled(false);
			lbl_bikeValue.setText("Bike : " + bike.getType());
		} else {
			btn_addBike.setEnabled(true);
		}
		
		JButton btn_delete_bike = new JButton("");
		btn_delete_bike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bike bike = new Bike();
				bike = bike.find(person.findId());
				if(bike != null) {
					bike.delete();
					JOptionPane.showMessageDialog(null, "Your bike has been deleted");
					lbl_bikeValue.setText("Bike : ");
					btn_addBike.setEnabled(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "No bike found");
				}
			}
		});
		btn_delete_bike.setBounds(585, 290, 50, 50);
		btn_delete_bike.setIcon(new ImageIcon(img));
		contentPane.add(btn_delete_bike);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
