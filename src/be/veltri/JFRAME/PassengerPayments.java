package be.veltri.JFRAME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.veltri.POJO.Registration;
import be.veltri.POJO.Treasurer;
import be.veltri.POJO.Walk;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerPayments extends JFrame {

	private static final long serialVersionUID = -7206112908319678669L;
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
	public PassengerPayments(Treasurer treasurer, Walk walk) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Passenger payments");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lbl_title.setBounds(133, 24, 420, 58);
		contentPane.add(lbl_title);
		
		JScrollPane payments = new JScrollPane();
		payments.setBounds(63, 155, 563, 144);
		contentPane.add(payments);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Passenger", "Number of walk", "€" }));

		int idW = walk.findId();
		Registration r = new Registration();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<String> lst = new ArrayList<String>();
		lst = r.getPassenger(idW);
		if (lst.size() != 0) {
			Object[] row = null;
			for(int i = 0; i< lst.size(); i+=4) {
				row = new Object[] { lst.get(i) + " " + lst.get(i+1), lst.get(i+2), Integer.parseInt(lst.get(i+3))/(lst.size()/4) };
				model.addRow(row);
			}
		} else {
			JOptionPane.showMessageDialog(null, "There are no passenger here!");
		}
		payments.setViewportView(table);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TreasurerHome th = new TreasurerHome(treasurer);
				th.setVisible(true);
			}
		});
		btn_back.setFont(new Font("Serif", Font.PLAIN, 20));
		btn_back.setBounds(457, 390, 205, 32);
		contentPane.add(btn_back);

		image = new JLabel("");
		Image img3 = new ImageIcon (this.getClass().getResource("/be/veltri/IMG/background.jpg")).getImage();
		image.setIcon(new ImageIcon(img3));
		image.setBounds(-24, 0, 700, 500);
		getContentPane().add(image);
	}

}
