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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Person;
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
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(btn_back);

		JButton btn_walks = new JButton("Your walks");
		btn_walks.setBounds(28, 166, 205, 32);
		btn_walks.setEnabled(false);
		btn_walks.setFont(new Font("Serif", Font.PLAIN, 20));
		contentPane.add(btn_walks);

		JButton btn_car = new JButton("Your car");
		btn_car.setBounds(28, 227, 205, 32);
		btn_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountCar ac = new AccountCar(person);
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
		walkList.setBounds(329, 144, 282, 250);
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

		image = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
