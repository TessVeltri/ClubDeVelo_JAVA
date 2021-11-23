package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class SignUp extends JFrame {

	private static final long serialVersionUID = -5038775509984411805L;
	private JPanel frame;
	private JTextField txt_username;
	private JTextField txt_name;
	private JTextField txt_firstname;
	private JTextField txtPhoneNumber;
	private JTextField txt_password;
	private JTextField txt_confirmPassword;
	private JButton btn_validate;
	private JLabel image;

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
	public SignUp() {
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

		JLabel lbl_title = new JLabel("Sign Up");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(199, 21, 288, 59);
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
		txt_username.setFont(new Font("Serif", Font.PLAIN, 20));
		txt_username.setText("Username");
		txt_username.setBounds(60, 114, 250, 40);
		getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_name.getText().trim().equals("Name")) {
					txt_name.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_name.getText().trim().equals("")) {
					txt_name.setText("Name");
				}
			}
		});
		txt_name.setText("Name");
		txt_name.setFont(new Font("Serif", Font.PLAIN, 20));
		txt_name.setColumns(10);
		txt_name.setBounds(60, 165, 250, 40);
		getContentPane().add(txt_name);
		
		txt_firstname = new JTextField();
		txt_firstname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_firstname.getText().trim().equals("Firstname")) {
					txt_firstname.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_firstname.getText().trim().equals("")) {
					txt_firstname.setText("Firstname");
				}
			}
		});
		txt_firstname.setText("Firstname");
		txt_firstname.setFont(new Font("Serif", Font.PLAIN, 20));
		txt_firstname.setColumns(10);
		txt_firstname.setBounds(371, 165, 250, 40);
		getContentPane().add(txt_firstname);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhoneNumber.getText().trim().equals("Phone number")) {
					txtPhoneNumber.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPhoneNumber.getText().trim().equals("")) {
					txtPhoneNumber.setText("Phone number");
				}
			}
		});
		txtPhoneNumber.setText("Phone number");
		txtPhoneNumber.setFont(new Font("Serif", Font.PLAIN, 20));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(371, 114, 250, 40);
		getContentPane().add(txtPhoneNumber);
		
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
		txt_password.setBounds(60, 216, 250, 40);
		getContentPane().add(txt_password);
		
		txt_confirmPassword = new JTextField();
		txt_confirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_confirmPassword.getText().trim().equals("Confirm password")) {
					txt_confirmPassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_confirmPassword.getText().trim().equals("")) {
					txt_confirmPassword.setText("Confirm password");
				}
			}
		});
		txt_confirmPassword.setText("Confirm password");
		txt_confirmPassword.setFont(new Font("Serif", Font.PLAIN, 20));
		txt_confirmPassword.setColumns(10);
		txt_confirmPassword.setBounds(371, 216, 250, 40);
		getContentPane().add(txt_confirmPassword);
		
		Object[] lst = new Object[] {"Select a category", "Cyclo", "Hiker", "Trialist", "Descent"};
		JComboBox cb_category = new JComboBox(lst);
		cb_category.setBounds(60, 267, 250, 40);
		getContentPane().add(cb_category);
		
		btn_validate = new JButton("Validate");
		btn_validate.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_validate.setBounds(251, 340, 184, 49);
		getContentPane().add(btn_validate);

		image = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img));
		image.setBounds(-24, 0, 730, 476);
		getContentPane().add(image);
	}
}
