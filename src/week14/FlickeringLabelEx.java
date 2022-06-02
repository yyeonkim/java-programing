package week14;

import javax.swing.*;
import java.awt.*;

public class FlickeringLabelEx extends JFrame {
	public FlickeringLabelEx() {
		setTitle("FlickeringLabelEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		FlickeringLabel fLabel = new FlickeringLabel("±ôºý", 500);
		JLabel label = new JLabel("¾È±ôºý");
		FlickeringLabel fLabel2 = new FlickeringLabel("¿©±âµµ ±ôºý", 300);
		
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlickeringLabelEx();

	}

}
