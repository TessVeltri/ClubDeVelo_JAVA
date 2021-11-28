package be.veltri.JFRAME;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Car;
import be.veltri.POJO.Member;
import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountWalks extends JFrame {

	private static final long serialVersionUID = -4883597102667113496L;
	private JPanel contentPane;
	private JLabel image;
	private JTable table;

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
	public AccountWalks(Person person) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_title = new JLabel("Your walks");
		lbl_title.setBounds(123, 34, 440, 58);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		contentPane.add(lbl_title);

		JButton btn_back = new JButton("Back");
		btn_back.setBounds(28, 396, 205, 32);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberHome mh = new MemberHome((Member)person);
				mh.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(btn_back);

		JButton btn_walks = new JButton("Your walks");
		btn_walks.setBounds(28, 166, 205, 32);
		btn_walks.setEnabled(false);
		btn_walks.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(btn_walks);

		JButton btn_car = new JButton("Your car and bike");
		btn_car.setBounds(28, 227, 205, 32);
		btn_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountCarBike ac = new AccountCarBike(person);
				ac.setVisible(true);
			}
		});
		btn_car.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(btn_car);

		JButton btn_data = new JButton("Your data");
		btn_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountData ad = new AccountData(person);
				ad.setVisible(true);
			}
		});
		btn_data.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_data.setBounds(28, 293, 205, 32);
		contentPane.add(btn_data);

		JScrollPane walkList = new JScrollPane();
		walkList.setEnabled(false);
		walkList.setBounds(329, 103, 282, 250);
		contentPane.add(walkList);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N°", "Walk category", "Walk date", "Walk departure", "Description" }));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date now = new Date();
		Walk w = new Walk();
		int id = person.findId();
		for (Walk walk : w.getAllById(id)) {
			if (simpleDateFormat.format(now).toString()
					.compareTo(simpleDateFormat.format(walk.getDateDeparture())) > 0) {

				Object[] row = new Object[] { walk.findId(), walk.getCategory_walk(),
						simpleDateFormat.format(walk.getDateDeparture()), walk.getPlaceDeparture(),
						walk.getDescription_walk() };
				model.addRow(row);
			}
		}
		walkList.setViewportView(table);

		JButton btn_wantDriver = new JButton("I want to be driver");
		btn_wantDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					String id_w = model.getValueAt(index, 0).toString();
					int id_walk = Integer.parseInt(id_w);
					int id_person = person.findId();
					Registration rg = new Registration(true, false, false, id_person, id_walk);
					Car car = new Car();
					car = car.find(person.findId());
					
					if(car==null) {
						JOptionPane.showMessageDialog(null, "You can't be driver, you don't have a car");
					} else  {
						boolean update = rg.update(rg);
						if (update) {
							JOptionPane.showMessageDialog(null, "Great, you have just registered as a driver for this walk");
						}
					}	
				}
			}
		});
		btn_wantDriver.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_wantDriver.setBounds(374, 396, 205, 32);
		contentPane.add(btn_wantDriver);
		
		image = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
		
	}
}
