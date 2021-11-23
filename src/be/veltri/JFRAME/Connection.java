package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

import be.veltri.POJO.Manager;
import be.veltri.POJO.Member;
import be.veltri.POJO.Person;
import be.veltri.POJO.Treasurer;

public class Connection extends JFrame {

	private static final long serialVersionUID = 1087704466222391274L;
	private JPanel frame;
	private JTextField txt_username;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection window = new Connection();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connection() {
		initialize();
		setFocusable(true);
	}

	/**
	 * Initialize the contents of the
	 */
	private void initialize() {
		frame = new JPanel();
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lbl_title = new JLabel("\"Club de V\u00E9lo\"");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));
		lbl_title.setBounds(150, 44, 386, 105);
		getContentPane().add(lbl_title);

		txt_username = new JTextField();
		txt_username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_username.getText().trim().equals("Username")) {
					txt_username.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_username.getText().trim().equals("")) {
					txt_username.setText("Username");
				}
			}
		});
		txt_username.setText("Username");
		txt_username.setFont(new Font("Serif", Font.PLAIN, 20));
		txt_username.setBounds(218, 189, 250, 40);
		getContentPane().add(txt_username);
		txt_username.setColumns(10);

		txt_password = new JTextField();
		txt_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_password.getText().trim().equals("Password")) {
					txt_password.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_password.getText().trim().equals("")) {
					txt_password.setText("Password");
				}
			}
		});
		txt_password.setText("Password");
		txt_password.setFont(new Font("Serif", Font.PLAIN, 20));
		txt_password.setColumns(10);
		txt_password.setBounds(218, 240, 250, 40);
		getContentPane().add(txt_password);

		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txt_username.getText().trim();
				String password = txt_password.getText().trim();
				Person person = new Person(username, "", "", "", password, "");
				Person conn = person.find();

				if (conn.getName().equals("")) {
					JOptionPane.showMessageDialog(null, "Username or password incorrect");
				} else {
					if (conn.getType().equals("Member")) {
						Member member = new Member(conn.getUsername(), conn.getName(), conn.getFirstname(),
								conn.getPhone(), conn.getPassword(), conn.getType(), 0);
						setVisible(false);
						MemberHome home = new MemberHome(member);
						home.setVisible(true);
						dispose();
					} else if (conn.getType().equals("Treasurer")) {
						Treasurer treasurer = new Treasurer(conn.getUsername(), conn.getName(), conn.getFirstname(),
								conn.getPhone(), conn.getPassword(), conn.getType());
						setVisible(false);
						TreasurerHome home = new TreasurerHome(treasurer);
						home.setVisible(true);
						dispose();
					} else if (conn.getType().equals("Manager")) {
						Manager manager = new Manager(conn.getUsername(), conn.getName(), conn.getFirstname(),
								conn.getPhone(), conn.getPassword(), conn.getType());
						setVisible(false);
						ManagerHome home = new ManagerHome(manager);
						home.setVisible(true);
						dispose();
					}

				}
			}
		});
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton.setBounds(277, 318, 132, 35);
		getContentPane().add(btnNewButton);

		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SignUp window = new SignUp();
				window.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setFont(new Font("Serif", Font.PLAIN, 20));
		btnSignUp.setBounds(277, 364, 132, 35);
		getContentPane().add(btnSignUp);

		JLabel image = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img));
		image.setBounds(0, 0, 700, 500);
		getContentPane().add(image);
	}
}
