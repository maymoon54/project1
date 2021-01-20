package Paycheck;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.LoginAfter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Paycheck3 extends JFrame {

	public Paycheck3(String id, String pw) {
		getContentPane().setForeground(Color.WHITE);
		// TODO Auto-generated method stub

		setSize(1000, 800);
		getContentPane().setBackground(SystemColor.textHighlight);
		getContentPane().setLayout(null); // frame 생성.
		setLocationRelativeTo(null); // 창을 가운데서 생성.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램 종료.
		setVisible(true); // 창이 보이게 해주기.

		JPanel p = new JPanel();
		p.setBorder(new LineBorder(Color.WHITE));
		p.setBackground(SystemColor.textHighlight);
		p.setSize(622, 229);
		p.setLocation(176, 227);
		p.setLayout(null);
		getContentPane().add(p);

		JLabel l1 = new JLabel();
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("굴림", Font.PLAIN, 30));
		l1.setText("-예매가 완료되었습니다.");
		l1.setSize(610, 50);
		l1.setLocation(6, 67);
		p.add(l1);

		JLabel l2 = new JLabel();
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("굴림", Font.PLAIN, 30));
		l2.setText("-마이페이지_예매내역에서 확인 가능합니다.");
		l2.setLocation(6, 127);
		l2.setSize(610, 50);
		p.add(l2);

		JButton hoom = new JButton();
		hoom.setBounds(382, 503, 210, 53);
		hoom.setFont(new Font("굴림", Font.PLAIN, 20));
		hoom.setText("메인으로 돌아가기");
		getContentPane().add(hoom);
		hoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginAfter(id, pw);
			}
		});

	}

}
