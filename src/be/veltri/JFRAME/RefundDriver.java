package be.veltri.JFRAME;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Registration;
import be.veltri.POJO.Treasurer;
import be.veltri.POJO.Walk;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RefundDriver extends JFrame {

	private static final long serialVersionUID = 6765126772716620467L;
	private JPanel contentPane;
	private JLabel image;
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
	public RefundDriver(Treasurer treasurer, Walk walk) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Refund driver");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(161, 24, 363, 58);
		contentPane.add(lbl_title);
		
		JScrollPane driver = new JScrollPane();
		driver.setBounds(73, 124, 363, 279);
		contentPane.add(driver);

		int idW = walk.findId();
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Driver", "Number of walk", "€" }));

		Registration r = new Registration();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<String> lst = new ArrayList<String>();
		lst = r.getDriverForPay(idW);
		if (lst.size() != 0) {
			Object[] row = null;
			for(int i = 0; i< lst.size(); i+=4) {
				row = new Object[] { lst.get(i) + " " + lst.get(i+1), lst.get(i+2), lst.get(i+3) };
			}
			model.addRow(row);
		} else {
			JOptionPane.showMessageDialog(null, "There are no driver here!");
		}

		driver.setViewportView(table);
		
		JButton btn_pay = new JButton("Pay");
		btn_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "No row selected, please select one");
				} else {
					JOptionPane.showMessageDialog(null, "A request for the paiement has been send");
					dispose();
					TreasurerHome th = new TreasurerHome(treasurer);
					th.setVisible(true);
				}
			}
		});
		btn_pay.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_pay.setBounds(457, 215, 205, 32);
		contentPane.add(btn_pay);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TreasurerHome th = new TreasurerHome (treasurer);
				th.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(457, 371, 205, 32);
		contentPane.add(btn_back);
		

//		image = new JLabel("");
//		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
//		image.setIcon(new ImageIcon(img3));
//		image.setBounds(-24, 0, 700, 500);
//		getContentPane().add(image);
	}
}
