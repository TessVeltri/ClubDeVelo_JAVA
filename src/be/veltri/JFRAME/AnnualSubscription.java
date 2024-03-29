package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Member;
import be.veltri.POJO.Person;
import be.veltri.POJO.Treasurer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnnualSubscription extends JFrame {

	private static final long serialVersionUID = 2714514835151823763L;
	private JPanel contentPane;
	private JTable table;
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
	public AnnualSubscription(Treasurer treasurer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Annual subscription");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(144, 24, 397, 58);
		contentPane.add(lbl_title);
		
		JScrollPane annual = new JScrollPane();
		annual.setBounds(64, 122, 334, 291);
		contentPane.add(annual);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Username", "Member name", "Annual subscription", "Payed ?" }));

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Member member = new Member();
		for (Member p : member.getAll()) {
			if (p.isPayed()) {
				Object[] row = new Object[] { p.getUsername(), p.getName() + " " + p.getFirstname(), p.getPay(), "Pay�"};
				model.addRow(row);
			} else {
				Object[] row = new Object[] { p.getUsername(), p.getName() + " " + p.getFirstname(), p.getPay(), "Pas pay�"};
				model.addRow(row);
			}
			
		}
		annual.setViewportView(table);
		
		JButton btn_reminder = new JButton("Reminder");
		btn_reminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					JOptionPane.showMessageDialog(null, "A reminder has been send ");
					dispose();
					TreasurerHome th = new TreasurerHome(treasurer);
					th.setVisible(true);
				}
				
			}
		});
		btn_reminder.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_reminder.setBounds(444, 204, 205, 32);
		contentPane.add(btn_reminder);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TreasurerHome th = new TreasurerHome(treasurer);
				th.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(444, 381, 205, 32);
		contentPane.add(btn_back);
		
		JButton btn_payed = new JButton("Paid");
		btn_payed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					String username = model.getValueAt(index, 0).toString();
					Member pers = new Member();
					pers.setUsername(username);
					Member pers2 = pers.findByName();
					if(pers2.isPayed())
						pers2.setPayed(false);
					else
						pers2.setPayed(true);
					pers2.update(pers2);
					
					dispose();
					AnnualSubscription as = new AnnualSubscription(treasurer);
					as.setVisible(true);
					JOptionPane.showMessageDialog(null, "The change is done");
				}
			}
		});
		btn_payed.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_payed.setBounds(444, 249, 205, 32);
		contentPane.add(btn_payed);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
		
	}
}
