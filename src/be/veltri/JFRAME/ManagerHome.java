package be.veltri.JFRAME;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Manager;
import be.veltri.POJO.Walk;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class ManagerHome extends JFrame {

	private static final long serialVersionUID = 1961339568732155669L;
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
	public ManagerHome(Manager manager) {
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
				setVisible(false);
				Account acc = new Account(manager);
				acc.setVisible(true);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/user_logo.jpg")).getImage();
		btn_account.setIcon(new ImageIcon(img));
		btn_account.setBounds(550, 24, 50, 50);
		contentPane.add(btn_account);

		JScrollPane walkList = new JScrollPane();
		walkList.setBounds(41, 112, 305, 274);
		contentPane.add(walkList);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N°", "Walk category", "Walk date", "Walk departure" }));

		Walk w = new Walk();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int i = 1;
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		LocalDateTime now = LocalDateTime.now();
		for (Walk walk : w.getAll()) {
			if (simpleDateFormat.format(now).compareTo(simpleDateFormat.format(walk.getDateDeparture())) > 0) {
				Object[] row = new Object[] { i++, walk.getCategory_walk(), simpleDateFormat.format(walk.getDateDeparture()),
						walk.getPlaceDeparture() };
				model.addRow(row);
			}
		}
		walkList.setViewportView(table);

		JButton btn_forfeit = new JButton("Forfeit");
		btn_forfeit.addActionListener(new ActionListener() {
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
					Date walk_date = null;
					try {
						walk_date = new SimpleDateFormat("dd-MM-yyyy").parse(walk_date_tmp);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					Walk walk_to_pass = new Walk(walk_dep, walk_date, "", walk_cat, 0);
					
					setVisible(false);
					ForfeitManager fm = new ForfeitManager(walk_to_pass);
					fm.setVisible(true);
			}
		}});
		btn_forfeit.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_forfeit.setBounds(420, 215, 205, 32);
		contentPane.add(btn_forfeit);

		JButton btn_addWalk = new JButton("Add a walk");
		btn_addWalk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddWalk addw = new AddWalk();
				addw.setVisible(true);
			}
		});
		btn_addWalk.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_addWalk.setBounds(420, 258, 205, 32);
		contentPane.add(btn_addWalk);

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
		
		JLabel lblNewLabel = new JLabel("Manager view");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 24, 129, 40);
		contentPane.add(lblNewLabel);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
