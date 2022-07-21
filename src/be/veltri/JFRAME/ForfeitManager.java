package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Manager;
import be.veltri.POJO.Member;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ForfeitManager extends JFrame {

	private static final long serialVersionUID = -8433197535458377306L;
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
	public ForfeitManager(Manager manager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_title = new JLabel("Forfeit for all members");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(146, 24, 393, 58);
		contentPane.add(lbl_title);

		JScrollPane memberlist = new JScrollPane();
		memberlist.setBounds(31, 113, 345, 316);
		contentPane.add(memberlist);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Number", "Member name", "Member firstname", "Member Forfeit" }));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<Member> lst_member = new ArrayList<Member>();
		Member p = new Member();
		int cpt = 1;
		for (Member pers : p.getAll()) {
			Object[] row = new Object[] { cpt ,pers.getName(), pers.getFirstname(), pers.getPay() };
			Member m = new Member(pers.getUsername(), pers.getName(), pers.getFirstname(), "", pers.getPassword(),
					"Member", pers.getPay());
			lst_member.add(m);
			model.addRow(row);
			cpt++;
		}
		memberlist.setViewportView(table);

		JButton btn_forfeit = new JButton("View details");
		btn_forfeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String cpt = model.getValueAt(index, 0).toString();
					String name = model.getValueAt(index, 1).toString();
					String firstname = model.getValueAt(index, 2).toString();
					String f = model.getValueAt(index, 3).toString();
					float forfeit = Float.parseFloat(f);
					
					Member member = lst_member.get(Integer.parseInt(cpt) - 1);
							
					setVisible(false);
					DetailsForfeit da = new DetailsForfeit(manager, member);
					da.setVisible(true);
				}
			}
		});
		btn_forfeit.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_forfeit.setBounds(439, 233, 205, 32);
		contentPane.add(btn_forfeit);

		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerHome mh = new ManagerHome(manager);
				mh.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(439, 397, 205, 32);
		contentPane.add(btn_back);

		image = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}
}
