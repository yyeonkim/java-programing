package hw4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseWheelEventEx extends JFrame {
	public MouseWheelEventEx() {
		super("���콺 ���� ���� ��Ʈ ũ�� �����ϱ�"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel()); 

		setSize(450, 200);
		setVisible(true);
		
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	
	public class MyPanel extends JLabel {
		private JLabel text = new JLabel("Love Java");
		
		public MyPanel() {
			setLayout(new FlowLayout());
			text.setFont(new Font("�������", 0, 20));
			add(text); // �����̳ʿ� �߰�
			
			addMouseWheelListener(new MyMouseWheelListener());
		}
		
		private class MyMouseWheelListener implements MouseWheelListener{
			public void mouseWheelMoved(MouseWheelEvent e) {
				Font f = text.getFont();
				int size = f.getSize();
				int n = e.getWheelRotation();
				
				if (n < 0 && size >= 10) {
					text.setFont(new Font("�������", Font.PLAIN,size-5));
				} else {
					text.setFont(new Font("�������", Font.PLAIN,size+5));
				}
			}
		}
	}

	public static void main(String[] args) {
		new MouseWheelEventEx();

	}

}
