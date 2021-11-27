package be.veltri.JFRAME;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Manager;
import be.veltri.POJO.Walk;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JCalendar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

public class AddWalk extends JFrame {

	private static final long serialVersionUID = 970375690002334733L;
	private JPanel contentPane;
	private JTextField txtDeparturePlace;
	private final ButtonGroup descGroup = new ButtonGroup();
	private JTextField dateField;
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
	public AddWalk(Manager manager) {
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Add a new walk");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(175, 24, 335, 58);
		contentPane.add(lbl_title);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerHome mh = new ManagerHome(manager);
				mh.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(49, 391, 205, 32);
		contentPane.add(btn_back);
		
		txtDeparturePlace = new JTextField();
		txtDeparturePlace.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (txtDeparturePlace.getText().trim().equals("Departure place")) {
					txtDeparturePlace.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (txtDeparturePlace.getText().trim().equals("")) {
					txtDeparturePlace.setText("Departure place");
				}
			}
		});
		txtDeparturePlace.setText("Departure place");
		txtDeparturePlace.setFont(new Font("Serif", Font.PLAIN, 20));
		txtDeparturePlace.setColumns(10);
		txtDeparturePlace.setBounds(49, 139, 250, 40);
		contentPane.add(txtDeparturePlace);
		
		JRadioButton rdbtnAm = new JRadioButton("AM");
		rdbtnAm.setSelected(true);
		descGroup.add(rdbtnAm);
		rdbtnAm.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnAm.setBounds(49, 198, 73, 40);
		contentPane.add(rdbtnAm);
		
		JRadioButton rdbtnPm = new JRadioButton("PM");
		descGroup.add(rdbtnPm);
		rdbtnPm.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnPm.setBounds(124, 198, 73, 40);
		contentPane.add(rdbtnPm);
		
		JComboBox cb_category = new JComboBox(new Object[]{});
		cb_category.setModel(new DefaultComboBoxModel(new String[] {"Select a category", "VTT_Trialist", "VTT_Descent", "VTT_Hiker", "Cyclo"}));
		cb_category.setFont(new Font("Serif", Font.PLAIN, 20));
		cb_category.setBounds(49, 252, 250, 40);
		contentPane.add(cb_category);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(397, 165, 205, 153);
		contentPane.add(calendar);
		
		class MyDateListener implements PropertyChangeListener {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("calendar")) {
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			        dateField.setText(simpleDateFormat.format(calendar.getDate()));
				}
			}
		}

		MyDateListener listener = new MyDateListener();
		calendar.addPropertyChangeListener(listener);
		
		JButton btn_validate = new JButton("Validate");
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String place_departure = txtDeparturePlace.getText().trim();
				String desc = "";
				Enumeration<AbstractButton> desc1 = descGroup.getElements();
				while (desc1.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) desc1.nextElement();
					if (jrd.isSelected()) {
						if (jrd.getText().equals("AM")) {
							desc = "Matin";
						} else {
							desc = "Après-midi";
						}
					}
				}
				String cat = cb_category.getSelectedItem().toString();
				String date_pick = dateField.getText();
				Date date_p = Date.valueOf(date_pick);
				long millis=System.currentTimeMillis();
				Date now = new Date(millis);
				
				Walk walk = new Walk(place_departure,date_p, desc, cat, 0);		
				Walk check = new Walk();
				check = walk.find();
				boolean verif = false;
				if (place_departure.equals("") || place_departure.equals("Departure Place") ||
						desc.equals("") || cat.equals("Select a category") || date_p == null) {
					JOptionPane.showMessageDialog(null, "Please, complete all fields");
					verif = false;
				} else if (date_p.compareTo(now)<0 ){
					JOptionPane.showMessageDialog(null, "You cannot choose a date before today");
					verif = false;
				} else if (check.getPlaceDeparture().equals(walk.getPlaceDeparture())) {
					JOptionPane.showMessageDialog(null, "A walk with this configuration already exist");
					verif = false;
				} else {
					verif = true;
				}
				
				if (verif) {
					boolean add = walk.create();
					if(add) {
						JOptionPane.showMessageDialog(null, "Great, you add a new walk!");
						dispose();
						ManagerHome mh = new ManagerHome(manager);
						mh.setVisible(true);
					}
				}
				
			}
		});
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(426, 391, 205, 32);
		contentPane.add(btn_validate);
		
		JLabel lbl_datepick = new JLabel("Pick a date :");
		lbl_datepick.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_datepick.setBounds(397, 124, 154, 40);
		contentPane.add(lbl_datepick);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setVisible(false);
		dateField.setBounds(164, 320, 162, 42);
		contentPane.add(dateField);
		dateField.setColumns(10);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}

