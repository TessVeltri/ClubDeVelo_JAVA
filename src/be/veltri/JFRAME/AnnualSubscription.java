package be.veltri.JFRAME;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Member;
import be.veltri.POJO.Person;
import be.veltri.POJO.Treasurer;
import be.veltri.POJO.Walk;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AnnualSubscription extends JFrame {

	private static final long serialVersionUID = 2714514835151823763L;
	private JPanel contentPane;
	private JTable table;

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
				new String[] { "Member name", "Annual subscription", "Payed ?" }));

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Member member = new Member();
		for (Member p : member.getAll()) {
			if (p.isPayed()) {
				Object[] row = new Object[] { p.getName() + " " + p.getFirstname(), p.getPay(), "Payé"};
				model.addRow(row);
			} else {
				Object[] row = new Object[] { p.getName() + " " + p.getFirstname(), p.getPay(), "Pas payé"};
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
		btn_reminder.setBounds(444, 215, 205, 32);
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
		
	}
}
