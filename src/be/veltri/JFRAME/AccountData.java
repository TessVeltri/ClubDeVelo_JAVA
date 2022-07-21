package be.veltri.JFRAME;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Category;
import be.veltri.POJO.Member;
import be.veltri.POJO.Person;
import be.veltri.POJO.Trialist;

public class AccountData extends JFrame {

	private static final long serialVersionUID = 8720014732492671076L;
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
	public AccountData(Person person) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Your data");
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
		btn_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountCarBike ac = new AccountCarBike(person);
				ac.setVisible(true);
			}
		});
		btn_car.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_car.setBounds(28, 227, 205, 32);
		contentPane.add(btn_car);
		
		JButton btn_data = new JButton("Your data");
		btn_data.setEnabled(false);
		btn_data.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_data.setBounds(28, 294, 205, 32);
		contentPane.add(btn_data);
		
		JLabel lbl_catTitle = new JLabel("Your categories : ");
		lbl_catTitle.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_catTitle.setBounds(291, 262, 299, 42);
		contentPane.add(lbl_catTitle);
		
		JTextArea categoriesArea = new JTextArea();
		categoriesArea.setEditable(false);
		categoriesArea.setFont(new Font("Serif", Font.PLAIN, 12));
		Category cat = new Trialist();
		ArrayList<Category> lst_cat = new ArrayList<Category>();
		lst_cat = cat.getAll(person);

		if (lst_cat.size() != 0) {
			categoriesArea.setColumns(1);
			categoriesArea.setRows(lst_cat.size());
			for (int i=0 ; i<lst_cat.size(); i++) {
				categoriesArea.append(lst_cat.get(i).getCategoryName() + ", ");
			}
		} 
		categoriesArea.setBackground(new Color (240,240,240));
		categoriesArea.setBounds(291, 303, 372, 40);
		contentPane.add(categoriesArea);
		
		JButton btn_addCategory = new JButton("Add a new category");
		btn_addCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Category c = new Trialist();
				ArrayList<String> lst_allCat_tmp = c.checkDouble(person);
				
				if (lst_allCat_tmp.size()== 0) {
					JOptionPane.showMessageDialog(null, "You have already all the categories");			
				} else {
					setVisible(false);
					AddCategory ac = new AddCategory(person);
					ac.setVisible(true);
				}
			}
		});
		btn_addCategory.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_addCategory.setBounds(290, 354, 205, 32);
		contentPane.add(btn_addCategory);
		
		JLabel lbl_username = new JLabel("Username : ");
		lbl_username.setText("Username : " + person.getUsername());
		lbl_username.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_username.setBounds(291, 156, 372, 42);
		contentPane.add(lbl_username);
		
		JLabel lbl_fullname = new JLabel("Fullname : ");
		lbl_fullname.setText("Fullname : " + person.getName() + " " + person.getFirstname());
		lbl_fullname.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_fullname.setBounds(291, 209, 372, 42);
		contentPane.add(lbl_fullname);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
		
	}
}
