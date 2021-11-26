package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Member;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class RegistrationToWalk extends JFrame {

	private static final long serialVersionUID = 5808341258584506208L;
	private JPanel contentPane;
	private JLabel image;
	private final ButtonGroup driver_group = new ButtonGroup();
	private final ButtonGroup passenger_group = new ButtonGroup();
	private final ButtonGroup bike_group = new ButtonGroup();

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
	public RegistrationToWalk(Walk walk, Member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int idW = walk.findId();
		int idP = member.findId();

		JLabel lbl_title = new JLabel("Sign up to walk n\u00B0 ");
		lbl_title.setText("Sign up to walk n\u00B0 " + idW);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(98, 24, 489, 58);
		contentPane.add(lbl_title);

		JLabel lbl_where = new JLabel("Where ?");
		lbl_where.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_where.setBounds(37, 151, 109, 27);
		contentPane.add(lbl_where);

		JLabel lbl_whereValue = new JLabel((String) null);
		lbl_whereValue.setText(walk.getPlaceDeparture());
		lbl_whereValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_whereValue.setBounds(125, 151, 109, 27);
		contentPane.add(lbl_whereValue);

		JLabel lbl_when = new JLabel("When ?");
		lbl_when.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_when.setBounds(37, 189, 109, 27);
		contentPane.add(lbl_when);

		JLabel lbl_whenValue = new JLabel("<dynamic>");
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		lbl_whenValue.setText(simpleDateFormat.format(walk.getDateDeparture()).toString());
		lbl_whenValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_whenValue.setBounds(120, 189, 109, 27);
		contentPane.add(lbl_whenValue);

		JLabel lbl_description = new JLabel("Description :");
		lbl_description.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_description.setBounds(37, 227, 109, 27);
		contentPane.add(lbl_description);

		JLabel lbl_descriptionValue = new JLabel((String) null);
		lbl_descriptionValue.setText(walk.getDescription_walk());
		lbl_descriptionValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_descriptionValue.setBounds(158, 227, 109, 27);
		contentPane.add(lbl_descriptionValue);

		JLabel lbl_type = new JLabel("Type :");
		lbl_type.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_type.setBounds(37, 265, 109, 27);
		contentPane.add(lbl_type);

		JLabel lbl_typeValue = new JLabel((String) null);
		lbl_typeValue.setText(walk.getCategory_walk());
		lbl_typeValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_typeValue.setBounds(158, 265, 109, 27);
		contentPane.add(lbl_typeValue);

		JLabel lbl_driver = new JLabel("Be driver ?");
		lbl_driver.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_driver.setBounds(329, 151, 109, 27);
		contentPane.add(lbl_driver);

		JRadioButton rdbtnY_driver = new JRadioButton("Y");
		driver_group.add(rdbtnY_driver);
		rdbtnY_driver.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnY_driver.setBounds(465, 151, 44, 29);
		contentPane.add(rdbtnY_driver);

		JRadioButton rdbtnN_driver = new JRadioButton("N");
		rdbtnN_driver.setSelected(true);
		driver_group.add(rdbtnN_driver);
		rdbtnN_driver.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnN_driver.setBounds(509, 151, 44, 29);
		contentPane.add(rdbtnN_driver);

		JLabel lbl_pass = new JLabel("Be passenger?");
		lbl_pass.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_pass.setBounds(329, 189, 130, 27);
		contentPane.add(lbl_pass);

		JRadioButton rdbtnY_pass = new JRadioButton("Y");
		passenger_group.add(rdbtnY_pass);
		rdbtnY_pass.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnY_pass.setBounds(465, 189, 44, 29);
		contentPane.add(rdbtnY_pass);

		JRadioButton rdbtnN_pass = new JRadioButton("N");
		rdbtnN_pass.setSelected(true);
		passenger_group.add(rdbtnN_pass);
		rdbtnN_pass.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnN_pass.setBounds(509, 189, 44, 29);
		contentPane.add(rdbtnN_pass);

		JLabel lbl_bike = new JLabel("Place for bike ?");
		lbl_bike.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_bike.setBounds(329, 227, 130, 27);
		contentPane.add(lbl_bike);

		JRadioButton rdbtnY_bike = new JRadioButton("Y");
		bike_group.add(rdbtnY_bike);
		rdbtnY_bike.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnY_bike.setBounds(465, 227, 44, 29);
		contentPane.add(rdbtnY_bike);

		JRadioButton rdbtnN_bike = new JRadioButton("N");
		rdbtnN_bike.setSelected(true);
		bike_group.add(rdbtnN_bike);
		rdbtnN_bike.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnN_bike.setBounds(509, 227, 44, 29);
		contentPane.add(rdbtnN_bike);

		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberHome mh = new MemberHome(member);
				mh.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(51, 388, 205, 32);
		contentPane.add(btn_back);

		JButton btn_validate = new JButton("Validate");
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean driver = false;
				boolean passenger = false;
				boolean bike = false;
				Enumeration<AbstractButton> dg = driver_group.getElements();
				while (dg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) dg.nextElement();
					if (jrd.isSelected()) {
						if (jrd.getText().equals("N")) {
							driver = false;
						} else {
							driver = true;
						}
					}
				}
				Enumeration<AbstractButton> pg = passenger_group.getElements();
				while (pg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) pg.nextElement();
					if (jrd.isSelected()) {
						if (jrd.getText().equals("N")) {
							passenger = false;
						} else {
							passenger = true;
						}
					}
				}
				Enumeration<AbstractButton> bg = bike_group.getElements();
				while (bg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if (jrd.isSelected()) {
						if (jrd.getText().equals("N")) {
							bike = false;
						} else {
							bike = true;
						}
					}
				}
				
				boolean verif = false;
				Registration rg = new Registration(driver, passenger, bike, idP, idW);
				if (driver==true && passenger ==true){
					JOptionPane.showMessageDialog(null, "You can't be driver and passenger at the same time");
					verif = false;
				} else {
					verif = true;
				}
				
				if (verif) {
					boolean create = rg.create();
					Registration check = rg.find();
					if (create && check == null) {
						JOptionPane.showMessageDialog(null, "Great ! Your sign up at the walk is done ");
						MemberHome mh = new MemberHome (member);
						mh.setVisible(true);
						dispose();
					} else if (check != null) {
						JOptionPane.showMessageDialog(null, "You are already sign up at this walk");
						MemberHome mh = new MemberHome (member);
						mh.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "An error has occurred, try again");
					}
				}
				
			}
		});
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(425, 388, 205, 32);
		contentPane.add(btn_validate);
		
		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
