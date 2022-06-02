package week14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThreadIneterruptEx extends JFrame {
	private Thread th;
	
	public ThreadIneterruptEx() {
		setTitle("ThreadIneterruptEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable);
		
		// Create button
		JButton btn = new JButton("Kill Timer");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				btn.setEnabled(false);
			}
		});
		c.add(btn);
		setSize(300, 170);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		new ThreadIneterruptEx();

	}

}
