package be.veltri.JFRAME;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Calendar;
import be.veltri.POJO.Category;
import be.veltri.POJO.Cyclo;
import be.veltri.POJO.Descent;
import be.veltri.POJO.Hiker;
import be.veltri.POJO.Manager;
import be.veltri.POJO.Trialist;
import be.veltri.POJO.Walk;

import javax.swing.JLabel;
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

		Calendar calendar = new Calendar();
		ArrayList<String> cat_list = new ArrayList<String>(
				Arrays.asList("All", "VTT_Trialist", "VTT_Descent", "VTT_Hiker", "Cyclo"));
		Object[] lst = cat_list.toArray();

		JComboBox cb_categories = new JComboBox(lst);
		cb_categories.setBounds(41, 119, 129, 22);
		contentPane.add(cb_categories);

		JScrollPane walkList = new JScrollPane();
		walkList.setBounds(41, 157, 305, 274);
		contentPane.add(walkList);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N°", "Walk category", "Walk date", "Walk departure" }));

		Walk w = new Walk();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		walkList.setViewportView(table);

		JButton btn_go = new JButton("GO");
		btn_go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String category_name = cb_categories.getSelectedItem().toString();
				Category category = new Trialist();

				Walk w = new Walk();

				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int modelCount = model.getRowCount();
				for (int i = 0; i < modelCount; i++)
					model.removeRow(0);

				String pattern = "dd-MM-yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				Date now = new Date();

				if (category_name.equals("VTT_Trialist")) {
					category = new Trialist();
				} else if (category_name.equals("VTT_Descent")) {
					category = new Descent();
				} else if (category_name.equals("VTT_Hiker")) {
					category = new Hiker();
				} else if (category_name.equals("Cyclo")) {
					category = new Cyclo();
				} else {
					category = null;
				}
				for (Walk walk : calendar.getListWalk(category, null)) {
					if (now.after(walk.getDateDeparture()) == false) {
						Object[] row = new Object[] { walk.findId(), walk.getCategory_walk(),
								simpleDateFormat.format(walk.getDateDeparture()), walk.getPlaceDeparture(),
								walk.getDescription_walk() };
						model.addRow(row);
					}
				}

			}
		});
		btn_go.setBounds(180, 119, 61, 23);
		contentPane.add(btn_go);

		JButton btn_forfeit = new JButton("Members forfeit");
		btn_forfeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ForfeitManager fm = new ForfeitManager(manager);
				fm.setVisible(true);
			}
		});
		btn_forfeit.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_forfeit.setBounds(420, 215, 205, 32);
		contentPane.add(btn_forfeit);

		JButton btn_addWalk = new JButton("Add a walk");
		btn_addWalk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddWalk addw = new AddWalk(manager);
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
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
