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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Treasurer;
import be.veltri.POJO.Walk;

public class TreasurerHome extends JFrame {

	private static final long serialVersionUID = 2692128668014189842L;
	private JPanel contentPane;
	private JTable table;
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
	public TreasurerHome(Treasurer treasurer) {
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

		JScrollPane walkList = new JScrollPane();
		walkList.setBounds(41, 112, 305, 274);
		contentPane.add(walkList);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N°", "Walk category", "Walk date", "Walk departure", "Walk description" }));

		Walk w = new Walk();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date now = new Date();
		for (Walk walk : w.getAll()) {
			if (simpleDateFormat.format(now).toString().compareTo(simpleDateFormat.format(walk.getDateDeparture())) > 0) {
				Object[] row = new Object[] { walk.findId(), walk.getCategory_walk(), simpleDateFormat.format(walk.getDateDeparture()),
						walk.getPlaceDeparture(), walk.getDescription_walk() };
				model.addRow(row);
			}
		}
		walkList.setViewportView(table);

		JButton btn_refundDriver = new JButton("Refund drivers");
		btn_refundDriver.addActionListener(new ActionListener() {
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
				RefundDriver da = new RefundDriver(treasurer, walk_to_pass);
				da.setVisible(true);
			}
		}});
		btn_refundDriver.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_refundDriver.setBounds(421, 248, 205, 32);
		contentPane.add(btn_refundDriver);

		JButton btn_aSub = new JButton("Annual subscription");
		btn_aSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AnnualSubscription rw = new AnnualSubscription();
				rw.setVisible(true);
			}
		});
		btn_aSub.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_aSub.setBounds(421, 291, 205, 32);
		contentPane.add(btn_aSub);

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
		
		JButton btn_paymentPassenger = new JButton("Passengers payments");
		btn_paymentPassenger.addActionListener(new ActionListener() {
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
					java.sql.Date w_date = new java.sql.Date(walk_date.getTime());
					Walk walk_to_pass = new Walk(walk_dep, w_date, "", walk_cat, 0);
					
					setVisible(false);
					PassengerPayment rw = new PassengerPayment(walk_to_pass);
					rw.setVisible(true);
				}
			}
		});
		btn_paymentPassenger.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_paymentPassenger.setBounds(421, 205, 205, 32);
		contentPane.add(btn_paymentPassenger);
		
		JButton btn_globalForfeit = new JButton("Global forfeit");
		btn_globalForfeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GlobalForfeitTreasurer rw = new GlobalForfeitTreasurer();
				rw.setVisible(true);
			}
		});
		btn_globalForfeit.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_globalForfeit.setBounds(421, 162, 205, 32);
		contentPane.add(btn_globalForfeit);
		
		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}

}
