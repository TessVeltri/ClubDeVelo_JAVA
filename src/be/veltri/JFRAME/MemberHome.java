package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import be.veltri.POJO.Category;
import be.veltri.POJO.Member;
import be.veltri.POJO.Trialist;
import be.veltri.POJO.Walk;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MemberHome extends JFrame {

	private static final long serialVersionUID = 4255365256306606039L;
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
	public MemberHome(Member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_title = new JLabel("Welcome");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(219, 24, 254, 58);
		contentPane.add(lbl_title);

		JButton btn_account = new JButton("");
		btn_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Account acc = new Account(member);
				acc.setVisible(true);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/user_logo.jpg")).getImage();
		btn_account.setIcon(new ImageIcon(img));
		btn_account.setBounds(550, 24, 50, 50);
		contentPane.add(btn_account);

		JScrollPane walkList = new JScrollPane();
		walkList.setBounds(41, 112, 387, 290);
		contentPane.add(walkList);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N°", "Walk category", "Walk date", "Walk departure", "Description" }));

		Category c = new Trialist();
		ArrayList<Category> lst_cat = c.getAllById(member.findId());
		ArrayList<String> list_cat_str = new ArrayList<String>();
		for (Category str : lst_cat) {
			list_cat_str.add(str.getCategoryName());
		}
		
		Walk w = new Walk();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		java.sql.Date now = new java.sql.Date (System.currentTimeMillis());
		for (Walk walk : w.getAll()) {
			if (now.compareTo(walk.getDateDeparture()) < 0) {
				Object[] row = new Object[] { walk.findId(), walk.getCategory_walk(), simpleDateFormat.format(walk.getDateDeparture()),
						walk.getPlaceDeparture(), walk.getDescription_walk() };
				model.addRow(row);
			}
		}
		walkList.setViewportView(table);

		JButton btn_driverA = new JButton("Drivers available");
		btn_driverA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String number = model.getValueAt(index, 0).toString();
					String walk_cat = model.getValueAt(index, 1).toString();
					String walk_date_tmp = model.getValueAt(index, 2).toString();
					String walk_dep = model.getValueAt(index, 3).toString();
					String walk_desc = model.getValueAt(index, 4).toString();
					Date walk_date = null;
					try {
						walk_date = new SimpleDateFormat("dd-MM-yyyy").parse(walk_date_tmp);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					java.sql.Date w_date = new java.sql.Date(walk_date.getTime());
					Walk walk_to_pass = new Walk(walk_dep, w_date, walk_desc, walk_cat, 0);
					
				setVisible(false);
				DriverAvailability da = new DriverAvailability(walk_to_pass, member);
				da.setVisible(true);
			}
		}});
		btn_driverA.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_driverA.setBounds(456, 170, 205, 32);
		contentPane.add(btn_driverA);

		JButton btn_signWalk = new JButton("Sign up for a walk");
		btn_signWalk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String number = model.getValueAt(index, 0).toString();
					String walk_cat = model.getValueAt(index, 1).toString();
					String walk_date_tmp = model.getValueAt(index, 2).toString();
					String walk_dep = model.getValueAt(index, 3).toString();
					String walk_desc = model.getValueAt(index, 4).toString();
					Date walk_date = null;
					try {
						walk_date = new SimpleDateFormat("dd-MM-yyyy").parse(walk_date_tmp);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					java.sql.Date w_date = new java.sql.Date(walk_date.getTime());
					Walk walk_to_pass = new Walk(walk_dep, w_date, walk_desc, walk_cat, 0);
					
					setVisible(false);
					RegistrationToWalk rw = new RegistrationToWalk(walk_to_pass, member);
					rw.setVisible(true);
				}
			}
		});
		btn_signWalk.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_signWalk.setBounds(456, 232, 205, 32);
		contentPane.add(btn_signWalk);

		JButton btn_logOut = new JButton("");
		btn_logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Connection conn = new Connection();
				conn.setVisible(true);
				dispose();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/logOut_logo.png")).getImage();
		btn_logOut.setIcon(new ImageIcon(img2));
		btn_logOut.setBounds(611, 24, 50, 50);
		contentPane.add(btn_logOut);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
