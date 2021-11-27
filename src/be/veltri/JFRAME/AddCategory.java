package be.veltri.JFRAME;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Category;
import be.veltri.POJO.Cyclo;
import be.veltri.POJO.Descent;
import be.veltri.POJO.Hiker;
import be.veltri.POJO.Person;
import be.veltri.POJO.Trialist;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class AddCategory extends JFrame {

	private static final long serialVersionUID = -2151462914389056454L;
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
	public AddCategory(Person person) {
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Add a new category");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(130, 24, 426, 68);
		contentPane.add(lbl_title);
		
		Category c = new Trialist();
		ArrayList<Category> lst_cat = c.getAllById(person.findId());
		
		ArrayList<String> lst_allCat = new ArrayList<String>(
				Arrays.asList("VTT_Trialist", "VTT_Descent", "VTT_Hiker", "Cyclo"));
		ArrayList<String> lst_allCat_tmp = new ArrayList<String>(
				Arrays.asList("VTT_Trialist", "VTT_Descent", "VTT_Hiker", "Cyclo"));
		
		for (String allCat : lst_allCat) {
			for (Category cat : lst_cat) {
				if (allCat.equals(cat.getCategoryName())) {
					lst_allCat_tmp.remove(allCat);
				}
			}
		}
		if (lst_allCat_tmp.size()==0) {
			JOptionPane.showMessageDialog(null, "You have already all the categories");
			setVisible(false);
			AccountData ad = new AccountData (person);
			ad.setVisible(true);
		
		} 
		lst_allCat_tmp.add(0, "Select a category");
		Object[] lst = lst_allCat_tmp.toArray();
		JComboBox cb_category = new JComboBox(lst);
		cb_category.setModel(new DefaultComboBoxModel(lst));
		cb_category.setFont(new Font("Serif", Font.PLAIN, 20));
		cb_category.setBounds(218, 211, 250, 40);
		getContentPane().add(cb_category);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountData ad = new AccountData (person);
				ad.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(51, 370, 205, 32);
		contentPane.add(btn_back);
		
		JButton btn_validate = new JButton("Validate");
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = cb_category.getSelectedItem().toString();
				Category cat;
				if (category.equals("VTT_Trialist")) {
					cat = new Trialist();
				} else if (category.equals("VTT_Descent")) {
					cat = new Descent();
				} else if (category.equals("VTT_Hiker")) {
					cat = new Hiker();
				} else {
					cat = new Cyclo();
				}
				int id_category = cat.findId();
				
				if (category.equals("Select a category")) {
					JOptionPane.showMessageDialog(null, "Please, select a category");
				} else {
					boolean check = person.addCategoryToPerson(id_category);
					if (check) {
						JOptionPane.showMessageDialog(null, "You add a new category to your account");
						dispose();
						AccountData ad = new AccountData (person);
						ad.setVisible(true);
					}
					
				}
				
			}
		});
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(416, 370, 205, 32);
		contentPane.add(btn_validate);
		
		image = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
