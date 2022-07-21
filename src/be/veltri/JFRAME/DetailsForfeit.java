package be.veltri.JFRAME;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Category;
import be.veltri.POJO.Manager;
import be.veltri.POJO.Member;
import be.veltri.POJO.Trialist;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class DetailsForfeit extends JFrame {

	private static final long serialVersionUID = -2173800389212060809L;
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
	public DetailsForfeit(Manager manager, Member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_title = new JLabel("Details forfeit");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(146, 35, 393, 58);
		contentPane.add(lbl_title);

		JLabel lbl_name = new JLabel("Name : ");
		lbl_name.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_name.setBounds(81, 175, 109, 27);
		contentPane.add(lbl_name);

		JLabel lbl_nameValue = new JLabel((String) null);
		lbl_nameValue.setText(member.getName() + " " + member.getFirstname());
		lbl_nameValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_nameValue.setBounds(169, 175, 109, 27);
		contentPane.add(lbl_nameValue);

		JLabel lbl_categories = new JLabel("Category(ies) : ");
		lbl_categories.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_categories.setBounds(81, 229, 127, 27);
		contentPane.add(lbl_categories);

		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ForfeitManager fm = new ForfeitManager(manager);
				fm.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(51, 383, 205, 32);
		contentPane.add(btn_back);

		JLabel lbl_forfeit = new JLabel("Forfeit : ");
		lbl_forfeit.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_forfeit.setBounds(392, 175, 109, 27);
		contentPane.add(lbl_forfeit);

		JTextArea categoriesArea = new JTextArea();
		categoriesArea.setEditable(false);
		categoriesArea.setFont(new Font("Serif", Font.PLAIN, 20));
		Category cat = new Trialist();
		ArrayList<Category> lst_cat = new ArrayList<Category>();
		lst_cat = cat.getAll(member);

		if (lst_cat.size() != 0) {
			categoriesArea.setColumns(1);
			categoriesArea.setRows(lst_cat.size());
			for (int i = 0; i < lst_cat.size(); i++) {
				categoriesArea.append(lst_cat.get(i).getCategoryName() + ", ");
			}
		}
		categoriesArea.setBackground(new Color(240, 240, 240));
		categoriesArea.setBounds(81, 281, 543, 41);
		contentPane.add(categoriesArea);

		JLabel lbl_forfeitValue = new JLabel((String) null);
		lbl_forfeitValue.setText(Float.toString(member.getPay()));
		lbl_forfeitValue.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_forfeitValue.setBounds(474, 175, 50, 27);
		contentPane.add(lbl_forfeitValue);

		JLabel lbl_euro = new JLabel("\u20AC");
		lbl_euro.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_euro.setBounds(534, 175, 29, 27);
		contentPane.add(lbl_euro);

		image = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
