package hw4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseWheelEventEx extends JFrame {
	public MouseWheelEventEx() {
		super("¸¶¿ì½º ÈÙÀ» ±¼·Á ÆùÆ® Å©±â Á¶Á¤ÇÏ±â"); 
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
			text.setFont(new Font("³ª´®°íµñ", 0, 20));
			add(text); // ÄÁÅ×ÀÌ³Ê¿¡ Ãß°¡
			
			addMouseWheelListener(new MyMouseWheelListener());
		}
		
		private class MyMouseWheelListener implements MouseWheelListener{
			public void mouseWheelMoved(MouseWheelEvent e) {
				Font f = text.getFont();
				int size = f.getSize();
				int n = e.getWheelRotation();
				
				if (n < 0 && size >= 10) {
					text.setFont(new Font("³ª´®°íµñ", Font.PLAIN,size-5));
				} else {
					text.setFont(new Font("³ª´®°íµñ", Font.PLAIN,size+5));
				}
			}
		}
	}

	public static void main(String[] args) {
		new MouseWheelEventEx();

	}

}
