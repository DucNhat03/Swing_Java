

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai02_SoNguyenTo extends JFrame implements ActionListener {

	private JTextField nhapLieu;
	private JTextArea ketQua;
	private JButton geneRate;

	public Bai02_SoNguyenTo() {
		setTitle("Primes");
		setSize(650, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); /* Xuất hiện bảng ở giữa màn hình */
		setResizable(false); /* Không phóng to */
		createGUI();
	}

	// GUI
	public void createGUI() {
		setLayout(null);
		// Tạo ô nhập liệu
		add(nhapLieu = new JTextField());
		int x = 50, y = 50, width = 350, height = 30;
		nhapLieu.setBounds(x, y, width, height);
		// Tạo nút bấm
		add(geneRate = new JButton("Generate"));
		geneRate.setBounds(420, 50, 150, 30);
		//Tạo thanh cuộn
		JScrollPane scrollPane;
		add(scrollPane = new JScrollPane(ketQua = new JTextArea()));
		scrollPane.setBounds(50, 100, 520, 330);
		ketQua.setToolTipText("Danh sách các số nguyên tố");
		ketQua.setEditable(false);
		
		/**
		 * Đăng kí sự kiện
		 */
		geneRate.addActionListener(this);

	}

	/**
	 * Kiểm tra số nguyên và ném lỗi.
	 * 
	 * @param args
	 */
	public boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	/**
	 * Thông báo lôi nhập liệu
	 * 
	 * @param args
	 */
	public void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
		this.nhapLieu.setText("");
		this.requestFocus();
	}

	public static void main(String[] args) {
		new Bai02_SoNguyenTo().setVisible(true);
	}

	/**
	 * Kiểm tra số nguyên tố.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrimeNumber(int n) {
		// so nguyen n < 2 khong phai la so nguyen to
		if (n < 2) {
			return false;
		}
		// check so nguyen to khi n >= 2
		int squareRoot = (int) Math.sqrt(n);
		for (int i = 2; i <= squareRoot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(geneRate)) {
			if (!isInt(nhapLieu)) {
				focus(nhapLieu);
			} else {
				int so = Integer.parseInt(nhapLieu.getText());
				if(so <= 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên dương");
					this.nhapLieu.setText("");
					this.requestFocus();
				}else {
					for(int i = 2; i< Integer.MAX_VALUE; i++) {
						if(isPrimeNumber(i)) {
							ketQua.append(i+"\n");
							so--;
						}if(so ==0)
							break;
					}
				}
			}

		}

	}
}
