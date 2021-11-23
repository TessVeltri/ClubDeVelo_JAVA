package be.veltri.JFRAME;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import be.veltri.POJO.Member;

import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class MemberHome extends JFrame {

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
	public MemberHome(Member member) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Welcome");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(216, 43, 254, 58);
		contentPane.add(lbl_title);
		
		JButton btn_account = new JButton("");
		Image img = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/user_logo.jpg")).getImage();
		btn_account.setIcon(new ImageIcon(img));
		btn_account.setBounds(601, 24, 50, 50);
		contentPane.add(btn_account);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(419, 112, 205, 153);
		contentPane.add(calendar);
		
		JScrollPane walkList = new JScrollPane();
		walkList.setBounds(41, 112, 305, 340);
		contentPane.add(walkList);
		
		JButton btn_driverA = new JButton("Drivers available");
		btn_driverA.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_driverA.setBounds(419, 276, 205, 32);
		contentPane.add(btn_driverA);
		
		JButton btn_signWalk = new JButton("Sign up for a walk");
		btn_signWalk.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_signWalk.setBounds(419, 319, 205, 32);
		contentPane.add(btn_signWalk);
		
//		image = new JLabel("");
//		Image img2 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
//		image.setIcon(new ImageIcon(img2));
//		image.setBounds(-24, 0, 700, 500);
//		getContentPane().add(image);
	}
}
