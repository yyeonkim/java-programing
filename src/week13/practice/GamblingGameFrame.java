package week13.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// �߰� ����: ���̺� 5��

public class GamblingGameFrame extends JFrame {
	public GamblingGameFrame() {
		super("�ڹ����α׷��� ����"); // JFrame(String): ������ ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X ������ ���Ḧ default�� ����
		
		setContentPane(new GamePanel()); // GamePanel�� ����Ʈ��(container)���� ����Ѵ�
		
		setSize(450, 200);
		setVisible(true);
		
		// GamePanel�� Ű �̺�Ʈ�� ���� �� �ֵ��� ��Ŀ���� �����Ѵ�
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	

	public class GamePanel extends JLabel {
		private JLabel[] label = new JLabel[5];
		private JLabel result = new JLabel("�����մϴ�.");
		
		public GamePanel() {
			setLayout(null); // ��ġ�����ڸ� ������� �ʰ� ���� ��ġ ���
			
			// 5���� ���̺��� �����Ͽ� �����̳ʿ� �ܴ�.
			for (int i = 0; i < label.length; i++) {
				label[i] = new JLabel("0");
				label[i].setSize(60, 30);
				label[i].setLocation(30 + 80 * i, 50);
				label[i].setHorizontalAlignment(JLabel.CENTER);
				label[i].setOpaque(true);
				label[i].setBackground(Color.MAGENTA);
				label[i].setForeground(Color.YELLOW);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				add(label[i]); // �����̳ʿ� �߰�
			}
			result.setSize(200, 25);
			result.setLocation(150, 100);
			result.setFont(new Font("�������", 0, 20));
			add(result); // �����̳ʿ� �߰�
			
			addKeyListener(new KeyAdapter() { // keyApdater �̿�
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == '\n') {
						int x1 = (int) (Math.random() * 5);
						label[0].setText(Integer.toString(x1));
						int x2 = (int) (Math.random() * 5);
						label[1].setText(Integer.toString(x2));
						int x3 = (int) (Math.random() * 5);
						label[2].setText(Integer.toString(x3));
						int x4 = (int) (Math.random() * 5);
						label[3].setText(Integer.toString(x4));
						int x5 = (int) (Math.random() * 5);
						label[4].setText(Integer.toString(x5));
						
						if (x1 == x2 && x2 == x3 && x3 == x4 && x4 == x5)
							result.setText("�����մϴ�!!");
						else
							result.setText("�ƽ�����");
					}
				}
			});
			
			// ���콺�� �����г��� Ŭ���ϸ� ��Ŀ���� ������ ������ ������ �Ѵ�
			addMouseListener(new MouseAdapter( ) { // MouseAdapter �̿�
				public void mouseClicked(MouseEvent e) {
					Component c = (Component) e.getSource(); // ���콺�� Ŭ���� ������Ʈ�� �����´�
					c.requestFocus(); // �� ������Ʈ�� ��Ŀ��
				}
			});
		}
	}	

	public static void main(String[] args) {
		new GamblingGameFrame();

	}

}
