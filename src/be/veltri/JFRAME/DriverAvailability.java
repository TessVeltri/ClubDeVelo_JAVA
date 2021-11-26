package be.veltri.JFRAME;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Member;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DriverAvailability extends JFrame {

	private static final long serialVersionUID = 6430147029916977881L;
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
	public DriverAvailability(Walk walk, Member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int idW = walk.findId();

		JLabel lbl_title = new JLabel("Drivers availability");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(123, 24, 440, 58);
		contentPane.add(lbl_title);

		JLabel lbl_where = new JLabel("Where ?");
		lbl_where.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_where.setBounds(21, 113, 109, 27);
		contentPane.add(lbl_where);

		JLabel lbl_when = new JLabel("When ?");
		lbl_when.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_when.setBounds(288, 113, 109, 27);
		contentPane.add(lbl_when);

		JLabel lbl_description = new JLabel("Description :");
		lbl_description.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_description.setBounds(21, 151, 109, 27);
		contentPane.add(lbl_description);

		JScrollPane tab_participants = new JScrollPane();
		tab_participants.setBounds(34, 208, 617, 119);
		contentPane.add(tab_participants);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Drivers", "Place for passenger in the car", "Place for bikes in the car" }));

		Registration r = new Registration();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<String> lst = new ArrayList<String>();
		lst = r.getDriver(idW);
		if (lst.size() != 0) {
			Object[] row = new Object[] { lst.get(1) + " " + lst.get(2), lst.get(3), lst.get(4) };
			model.addRow(row);
		} else {
			JOptionPane.showMessageDialog(null, "There are no driver here!");
		}

		tab_participants.setViewportView(table);

		JLabel lbl_walk = new JLabel("Walk n\u00B0 ");
		lbl_walk.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lbl_walk.setBounds(21, 75, 109, 27);
		contentPane.add(lbl_walk);

		JLabel lbl_whereValue = new JLabel("");
		lbl_whereValue.setText(walk.getPlaceDeparture());
		lbl_whereValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_whereValue.setBounds(109, 113, 109, 27);
		contentPane.add(lbl_whereValue);

		JLabel lbl_whenValue = new JLabel("");
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		lbl_whenValue.setText(simpleDateFormat.format(walk.getDateDeparture()).toString());
		lbl_whenValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_whenValue.setBounds(371, 113, 109, 27);
		contentPane.add(lbl_whenValue);

		JLabel lbl_descriptionValue = new JLabel("");
		lbl_descriptionValue.setText(walk.getDescription_walk());
		lbl_descriptionValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_descriptionValue.setBounds(142, 151, 109, 27);
		contentPane.add(lbl_descriptionValue);

		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberHome mh = new MemberHome(member);
				mh.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(21, 420, 205, 32);
		contentPane.add(btn_back);

		JLabel lbl_walkValue = new JLabel("");
		lbl_walkValue.setText("" + idW);
		lbl_walkValue.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lbl_walkValue.setBounds(96, 75, 109, 27);
		contentPane.add(lbl_walkValue);

		JLabel lbl_passCount = new JLabel("Passengers for this walk : ");
		lbl_passCount.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_passCount.setBounds(21, 338, 230, 27);
		contentPane.add(lbl_passCount);

		JLabel lbl_passCountValue = new JLabel("");
		int count = r.getPassengerCount(idW);
		lbl_passCountValue.setText("" + count);
		lbl_passCountValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_passCountValue.setBounds(239, 338, 59, 27);
		contentPane.add(lbl_passCountValue);

		JLabel lbl_bikeCount = new JLabel("Bikes for this walk : ");
		lbl_bikeCount.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_bikeCount.setBounds(374, 338, 230, 27);
		contentPane.add(lbl_bikeCount);

		JLabel lbl_bikeCountValue = new JLabel("");
		int count2 = r.getBikeCount(idW);
		lbl_bikeCountValue.setText("" + count2);
		lbl_bikeCountValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_bikeCountValue.setBounds(545, 338, 59, 27);
		contentPane.add(lbl_bikeCountValue);

		JLabel lbl_passNeed = new JLabel("Place for passengers needed : ");
		lbl_passNeed.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_passNeed.setBounds(21, 376, 248, 27);
		contentPane.add(lbl_passNeed);

		JLabel lbl_passNeedValue = new JLabel("0");
		lbl_passNeedValue.setForeground(Color.RED);
		int nbr_place_pass = 0;
		if (lst.size() != 0) {
			nbr_place_pass = Integer.parseInt(lst.get(3));
		}
		int nbr_pass = Integer.parseInt(lbl_passCountValue.getText());
		if ((nbr_pass - nbr_place_pass) < 0) {
			lbl_passNeedValue.setForeground(Color.BLACK);
			lbl_passNeedValue.setText("0");
		} else {
			lbl_passNeedValue.setText("" + (nbr_pass - nbr_place_pass));
		}
		lbl_passNeedValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_passNeedValue.setBounds(264, 376, 59, 27);
		contentPane.add(lbl_passNeedValue);

		JLabel lbl_bikeNeed = new JLabel("Place for bikes needed : ");
		lbl_bikeNeed.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_bikeNeed.setBounds(371, 376, 230, 27);
		contentPane.add(lbl_bikeNeed);

		JLabel lbl_bikeNeedValue = new JLabel("0");
		lbl_bikeNeedValue.setForeground(Color.RED);
		int nbr_place_bike = 0;
		if (lst.size() != 0) {
			nbr_place_bike = Integer.parseInt(lst.get(4));
		}
		int nbr_bike = Integer.parseInt(lbl_bikeCountValue.getText());
		if ((nbr_bike - nbr_place_bike) < 0) {
			lbl_bikeNeedValue.setForeground(Color.BLACK);
			lbl_bikeNeedValue.setText("0");
		} else {
			lbl_bikeNeedValue.setText("" + (nbr_bike - nbr_place_bike));
		}
		lbl_bikeNeedValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_bikeNeedValue.setBounds(574, 376, 59, 27);
		contentPane.add(lbl_bikeNeedValue);
		
		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
