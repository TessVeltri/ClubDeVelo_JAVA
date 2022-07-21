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

public class CalculateForfeit extends JFrame {

	private static final long serialVersionUID = -2173800389212060809L;
	private JPanel contentPane;
	private JTextField forfaitValue;
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
	public CalculateForfeit(Manager manager, Member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_title = new JLabel("Calculate forfeit");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(146, 35, 393, 58);
		contentPane.add(lbl_title);

		JLabel lbl_name = new JLabel("Name : ");
		lbl_name.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_name.setBounds(81, 175, 109, 27);
		contentPane.add(lbl_name);

		JLabel lbl_nameValue = new JLabel((String) null);
		lbl_nameValue.setText(member.getName());
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

		forfaitValue = new JTextField();
		int pay = (int) member.getPay();
		forfaitValue.setText("" + pay);
		forfaitValue.setFont(new Font("Serif", Font.PLAIN, 20));
		forfaitValue.setBounds(481, 172, 47, 32);
		contentPane.add(forfaitValue);
		forfaitValue.setColumns(10);

		JTextArea categoriesArea = new JTextArea();
		categoriesArea.setEditable(false);
		categoriesArea.setFont(new Font("Serif", Font.PLAIN, 20));
		Category cat = new Trialist();
		ArrayList<Category> lst_cat = new ArrayList<Category>();
		lst_cat = cat.getAllById(member.findId());

		if (lst_cat.size() != 0) {
			categoriesArea.setColumns(1);
			categoriesArea.setRows(lst_cat.size());
			for (int i = 0; i < lst_cat.size(); i++) {
				categoriesArea.append(lst_cat.get(i).getCategoryName() + ", ");
			}
		}
		categoriesArea.setBackground(new Color(240, 240, 240));
		categoriesArea.setBounds(206, 227, 442, 41);
		contentPane.add(categoriesArea);

		JButton btn_validate = new JButton("Validate");
		btn_validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String f = forfaitValue.getText();
				int forfait = Integer.parseInt(f);
				if (forfait > 35) {
					JOptionPane.showMessageDialog(null, "You cannot assign a forfeit higher than €35.");
				} else if (forfait != 20 && forfait != 25 && forfait != 30 && forfait != 35) {
					JOptionPane.showMessageDialog(null,
							"You cannot assign this forfeit, choose between 20, 25, 30 or 35");
				} else {
					float forfait_f = (float) forfait;
					Member m = new Member(member.getUsername(), member.getName(), member.getFirstname(),
							member.getPhone(), member.getPassword(), member.getType(), forfait_f);
					member.update(m);
					JOptionPane.showMessageDialog(null, "The forfeit has been changed");
					ManagerHome mh = new ManagerHome(manager);
					mh.setVisible(true);
					dispose();
				}
			}
		});
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(421, 383, 205, 32);
		contentPane.add(btn_validate);

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
