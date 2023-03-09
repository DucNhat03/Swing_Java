

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai01_GiaiPhuongTrinhBacHai extends JFrame implements ActionListener {

	private JButton btGiai;
	private JButton btXoa;
	private JButton btThoat;
	private JTextField tfnhapA;
	private JTextField tfnhapB;
	private JTextField tfnhapC;
	private JTextField tfKetqua;

	public Bai01_GiaiPhuongTrinhBacHai() {
		setTitle("<3");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUI();
	}

	private void createGUI() {
		JPanel paneNorth;
		add(paneNorth = new JPanel(), BorderLayout.NORTH);
		paneNorth.setBackground(Color.CYAN);
		JLabel lbTieude;
		paneNorth.add(lbTieude = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI"));
		lbTieude.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panelCenter;
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		panelCenter.setLayout(null);

		JLabel lbnhapA, lbnhapB, lbnhapC, lbKetqua;
		panelCenter.add(lbnhapA = new JLabel("Nhập a: "));
		int x = 20, y = 40, width = 100, height = 30;
		lbnhapA.setBounds(x, y, width, height);
		panelCenter.add(lbnhapB = new JLabel("Nhập b: "));
		y += 50;
		lbnhapB.setBounds(x, y, width, height);
		panelCenter.add(lbnhapC = new JLabel("Nhập c: "));
		y += 50;
		lbnhapC.setBounds(x, y, width, height);
		panelCenter.add(lbKetqua = new JLabel("Kết quả: "));
		y += 50;
		lbKetqua.setBounds(x, y, width, height);
		// Tao textfield A
		panelCenter.add(tfnhapA = new JTextField());
		x += 100;
		y = 40;
		width = 300;
		tfnhapA.setBounds(x, y, width, height);
		// Tao textfield B
		panelCenter.add(tfnhapB = new JTextField());
		y += 50;
		tfnhapB.setBounds(x, y, width, height);
		// Tao textfield C
		panelCenter.add(tfnhapC = new JTextField());
		y += 50;
		tfnhapC.setBounds(x, y, width, height);
		// Tao textfield ket qua
		panelCenter.add(tfKetqua = new JTextField());
		y += 50;
		tfKetqua.setBounds(x, y, width, height);
		
		tfKetqua.setEditable(false);
		JPanel panelSouth;
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		panelSouth.add(btGiai = new JButton("Giải"));
		panelSouth.add(btXoa = new JButton("Xóa rỗng"));
		panelSouth.add(btThoat = new JButton("Thoát"));

		/**
		 * Đăng kí sự kiện
		 */
		btGiai.addActionListener(this);
		btThoat.addActionListener(this);
		btXoa.addActionListener(this);
	}

	public static void main(String[] args) {
		new Bai01_GiaiPhuongTrinhBacHai().setVisible(true);
	}

	/**
	 * Kiểm tra số nguyên và ném lỗi
	 * 
	 * @param text
	 * @return
	 */
	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
			result = false;
		}
		return result;
	}

	/**
	 * Thông báo lỗi nhập liệu
	 * 
	 * @param text
	 */
	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
		text.selectAll();
		text.requestFocus();
	}

	/**
	 * Giải phương trình bậc 1
	 * 
	 * @param a
	 * @param b
	 */
	private void giaiPhuongTrinhBac1(int a, int b) {
		if (a != 0) {
			tfKetqua.setText("Nghiệm x = " + (-b / (float) a));
		} else if (b == 0) {
			tfKetqua.setText("Vô số nghiệm");
		} else {
			tfKetqua.setText("Vô nghiệm");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btThoat)) {
			System.exit(0);
		} else if (o.equals(btXoa)) {
			tfnhapA.setText("");
			tfnhapB.setText("");
			tfnhapC.setText("");
			tfKetqua.setText("");
		} else if (o.equals(btGiai)) {
			if (!isInt(tfnhapA)) {
				focus(tfnhapA);
			} else if (!isInt(tfnhapB)) {
				focus(tfnhapB);
			} else if (!isInt(tfnhapC)) {
				focus(tfnhapC);
			} else {
				int a = Integer.parseInt(tfnhapA.getText());
				int b = Integer.parseInt(tfnhapB.getText());
				int c = Integer.parseInt(tfnhapC.getText());
				if (a == 0) {
					giaiPhuongTrinhBac1(b, c);
				} else {
					float delta = b * b - 4 * a * c;
					if (delta < 0) {
						tfKetqua.setText("Vô nghiệm.");
					} else if (delta == 0) {
						tfKetqua.setText("Nghiệm kép x1 = x2 = " + (-b / 2 * (float) a));
					} else {
						tfKetqua.setText("Có 2 nghiệm x1 = " + ((-b + Math.sqrt(delta)) / (2 * (float) a)) + ",x2 =  "
								+ ((-b - Math.sqrt(delta)) / 2 * (float) a));
					}
				}
			}
		}

	}

}
