package be.veltri.JFRAME;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.veltri.POJO.Person;

public class AccountData extends JFrame {

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
		
		JButton btn_car = new JButton("Your car");
		btn_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountCar ac = new AccountCar(person);
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
		lbl_catTitle.setBounds(290, 148, 299, 42);
		contentPane.add(lbl_catTitle);
		
		JLabel lbl_lstCat = new JLabel("");
		lbl_lstCat.setFont(new Font("Serif", Font.PLAIN, 20));
		lbl_lstCat.setBounds(290, 201, 364, 42);
		contentPane.add(lbl_lstCat);
		
		JButton btn_addCategory = new JButton("Add a new category");
		btn_addCategory.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_addCategory.setBounds(290, 294, 205, 32);
		contentPane.add(btn_addCategory);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
		
	}

}
