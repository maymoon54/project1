package main;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import join.Login;
import join.Membership;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class LogoutAfter extends JFrame {

	JPanel top;
	JPanel contents;
	JButton logout;
	JButton mypage;
	private JLabel lblNewLabel;

	public LogoutAfter() { // 로그아웃 한 후 메인 페이지
		setSize(1000, 800);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(SystemColor.textHighlight);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 패널 1
		top = new JPanel();
		top.setBackground(SystemColor.textHighlight);
		top.setLocation(0, 0);
		top.setSize(984, 74);

		getContentPane().setLayout(null);
		getContentPane().add(top);
		// 로그인, 회원가입 버튼
		logout = new JButton("로그인");
		logout.setBounds(731, 22, 97, 23);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);

			}
		});
		mypage = new JButton("회원가입");
		mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Membership();
				setVisible(false);
			}
		});
		mypage.setBounds(840, 22, 116, 23);
		top.setLayout(null);
		top.add(logout);
		top.add(mypage);

		JLabel lblNewLabel = new JLabel("영화순위");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(28, 28, 213, 51);
		top.add(lblNewLabel);
		// 패널2
		contents = new JPanel();
		contents.setBackground(SystemColor.textHighlight);
		contents.setSize(960, 667);
		contents.setLocation(12, 84);

		getContentPane().add(contents);
		getContentPane().setLayout(null);

		// 버튼을 배열에 저장하기
		JButton[] b = new JButton[8];

		// 버튼에 들어갈 이미지
		String[] img = { "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg" };

		// 영화제목
		String[] titles = { "테넷", "오!문희", "뉴 뮤턴트", "기기괴괴 성형수", "다만 악에서 구하소서", "테스와 보낸 여름", "에이바", "짱구는 못말려", "오케이마담",
				"드라이브" };

		// for문으로 버튼 여러개 만들기
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton();
			ImageIcon icon = new ImageIcon(img[i]);
			b[i].setIcon(icon);
			// 포스터를 클릭하면 해당영화 타이틀 값 변수에 저장
			String subject = titles[i];
			contents.add(b[i]); // 패널에 버튼 배치

			b[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton) e.getSource();
					Icon icon = b.getIcon();
					System.out.println(subject);
					new join.Login();
					setVisible(false);
				}
			});

		}

	}
}
