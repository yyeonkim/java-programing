package week13.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 추가 문제: 레이블 5개

public class GamblingGameFrame extends JFrame {
	public GamblingGameFrame() {
		super("자바프로그래밍 게임"); // JFrame(String): 프레임 제목 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X 누르면 종료를 default로 설정
		
		setContentPane(new GamePanel()); // GamePanel를 컨텐트팬(container)으로 등록한다
		
		setSize(450, 200);
		setVisible(true);
		
		// GamePanel이 키 이벤트를 받을 수 있도록 포커스를 설정한다
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	

	public class GamePanel extends JLabel {
		private JLabel[] label = new JLabel[5];
		private JLabel result = new JLabel("시작합니다.");
		
		public GamePanel() {
			setLayout(null); // 배치관리자를 사용하지 않고 절대 위치 사용
			
			// 5개의 레이블을 생성하여 컨테이너에 단다.
			for (int i = 0; i < label.length; i++) {
				label[i] = new JLabel("0");
				label[i].setSize(60, 30);
				label[i].setLocation(30 + 80 * i, 50);
				label[i].setHorizontalAlignment(JLabel.CENTER);
				label[i].setOpaque(true);
				label[i].setBackground(Color.MAGENTA);
				label[i].setForeground(Color.YELLOW);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				add(label[i]); // 컨테이너에 추가
			}
			result.setSize(200, 25);
			result.setLocation(150, 100);
			result.setFont(new Font("나눔고딕", 0, 20));
			add(result); // 컨테이너에 추가
			
			addKeyListener(new KeyAdapter() { // keyApdater 이용
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
							result.setText("축하합니다!!");
						else
							result.setText("아쉽군요");
					}
				}
			});
			
			// 마우스로 게임패널을 클릭하면 포커스를 강제로 가지고 오도록 한다
			addMouseListener(new MouseAdapter( ) { // MouseAdapter 이용
				public void mouseClicked(MouseEvent e) {
					Component c = (Component) e.getSource(); // 마우스가 클릭한 컴포넌트를 가져온다
					c.requestFocus(); // 그 컴포넌트를 포커스
				}
			});
		}
	}	

	public static void main(String[] args) {
		new GamblingGameFrame();

	}

}
