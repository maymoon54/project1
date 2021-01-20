package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import join.Membership;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class MainPage {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.getContentPane().setBackground(SystemColor.textHighlight);
		f.setSize(1000, 800);
		f.setLocationRelativeTo(null); // 화면 가운데 창 띄우기
		f.setResizable(false);// 창 크기 변환불가
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton login = new JButton("로그인");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그인창 호출
				new join.Login();
				f.setVisible(false);

			}
		});
		login.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		login.setBounds(766, 22, 97, 23);
		f.getContentPane().setLayout(null);
		JButton join = new JButton("회원가입");
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입창 호출
				new Membership();
				f.setVisible(false);

			}
		});
		join.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		join.setBounds(875, 22, 97, 23);
		f.getContentPane().add(join);
		f.getContentPane().add(login);

		JPanel panel = new JPanel();// 패널생성
		panel.setBounds(12, 101, 970, 648);
		panel.setBackground(SystemColor.textHighlight);
		f.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("영화순위");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(28, 28, 213, 51);
		f.getContentPane().add(lblNewLabel);

//		JButton btnNewButton = new JButton("New button");
//		panel.add(btnNewButton);

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
			panel.add(b[i]); // 패널에 버튼 배치

			b[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton) e.getSource();
					Icon icon = b.getIcon();
					System.out.println(subject);
					new join.Login();
					f.setVisible(false);
				}
			});

		}

		f.setVisible(true);

	}
}
