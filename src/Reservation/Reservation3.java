package Reservation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import ReserveCheck.ReserveCheck3;
import main.LoginAfter;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Reservation3 extends JFrame {

	String region;
	String room_num;
	String time;
	String seat_num;
	String date;
	int seat_index;
	public static int same;

	public Reservation3(String id, String pw, String subject) {

		setSize(1000, 800);
		getContentPane().setBackground(SystemColor.textHighlight);
		getContentPane().setLayout(null); // frame 생성.
		setLocationRelativeTo(null); // 창을 가운데서 생성.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램 종료.
		setVisible(true); // 창이 보이게 해주기.

		JPanel p_top = new JPanel();
		p_top.setBounds(0, 0, 984, 70);
		p_top.setBackground(SystemColor.textHighlight);
		getContentPane().add(p_top);
		p_top.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBox.setBounds(12, 12, 200, 30);
		p_top.add(comboBox);
		comboBox.setMaximumRowCount(20);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "-", "강남", "건대입구", "대학로", "명동", "송파", "압구정", "영등포", "용산", "홍대", "신촌" }));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				region = comboBox.getSelectedItem().toString();

				System.out.println(region);
			}
		});

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datepick = new JDatePickerImpl(datePanel);
		datepick.getJFormattedTextField().setFont(new Font("굴림", Font.PLAIN, 15));
		datepick.setBounds(224, 12, 200, 30);
		p_top.add(datepick);
		datepick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

//				date_f = (Date) datepick.getModel().getValue();
				Date date_f = (Date) datepick.getModel().getValue();
				date = new SimpleDateFormat("yyyy-MM-dd").format(date_f);
				System.out.println(date);
			}
		});

		JButton home = new JButton("메인으로 돌아가기");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginAfter(id, pw);
			}
		});
		home.setBounds(770, 8, 200, 50);
		p_top.add(home);
		home.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

		JLabel loginID = new JLabel(id + "님"); // 로그인한 아이디
		loginID.setForeground(Color.WHITE);
		loginID.setFont(new Font("굴림", Font.PLAIN, 15));
		loginID.setBounds(638, 12, 120, 30);
		p_top.add(loginID);

		JLabel movieTitle = new JLabel("영화: " + subject);// 영화제목
		movieTitle.setForeground(Color.WHITE);
		movieTitle.setFont(new Font("굴림", Font.PLAIN, 15));
		movieTitle.setBounds(436, 12, 200, 30);
		p_top.add(movieTitle);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(10, 80, 475, 600);
		getContentPane().add(panel_1);
		panel_1.setLayout(null); // 상영관 시간 선택 panel.

		JPanel p_time1 = new JPanel();
		p_time1.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_time1.setBackground(Color.white);
		p_time1.setBounds(6, 53, 463, 100);
		panel_1.add(p_time1);
		p_time1.setLayout(null); // 상영관 1일에 대한 panel 생성.

		JButton R_1 = new JButton("상영관 1"); // 상영관 1이라는 것을 보여주기 위한 버튼, 외관상 버튼으로 만들었고 클릭값을 없앴음.
		R_1.setForeground(Color.WHITE);
		R_1.setBackground(Color.DARK_GRAY);
		R_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		R_1.setEnabled(false);
		R_1.setBounds(6, 23, 100, 52);
		p_time1.add(R_1);

		JButton[] time1 = new JButton[2]; // 시간대를 넣어줄 버튼 1차원 배열 생성.
		for (int i = 0; i < time1.length; i++) { // 배열 길이 만큼 반복문 생성.
			time1[i] = new JButton((9 + (i * 3)) + ":30"); // 버튼 안에 넣을 글자 값 설정.
			time1[i].setLocation(118 + (i * 92), 40); // 초기 위치를 잡아주고 증가해서 위치를 지정.
			time1[i].setSize(80, 30);
			time1[i].setBackground(Color.white);
			p_time1.add(time1[i]);
			time1[i].addActionListener(new ActionListener() { // 버튼을 누를 시 밑에 코드를 실행.
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < time1.length; j++) { // 버튼마다 이벤트를 주기 위한 for문.
						if (e.getSource() == time1[j]) { // 누른 버튼의 값과 배열이 같으면 실행.
							if (same == 0 && time1[j].getText().equals((9 + (j * 3)) + ":30")) {
								// same 값을 주고 아직 선택이 안되었다면, 버튼의 값이 괄호 안과 같다면 실행.
								time1[j].setBackground(Color.red); // 표시를 위해 배경색을 바꿈.
								time = (9 + (j * 3)) + ":30"; // 시간 변수에 저장.
								room_num = "상영관1"; // 상영관 1 값을 변수에 저장.

								System.out.println(room_num);
								System.out.println(time);
								same++; // 선택되었다는 것을 표현해주기 위해 same값을 변경.
							} else if (same == 1 && time1[j].getText().equals((9 + (j * 3)) + ":30")) {
								// 버튼을 이미 눌렀다면 실행, 선택을 취소했단 소리.
								time1[j].setBackground(Color.white); // 배경색을 원래대로.
								time = "";
								room_num = ""; // time과 room_num값을 초기화.
								same--; // 표시를 제거.
							} // else if
						} // if
					} // for j
				} // action
			}); // add action
		} // for i

		JPanel p_time2 = new JPanel();
		p_time2.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_time2.setBackground(Color.WHITE);
		p_time2.setBounds(6, 153, 463, 100);
		panel_1.add(p_time2);
		p_time2.setLayout(null);

		JButton R_2 = new JButton("상영관 2");
		R_2.setForeground(Color.WHITE);
		R_2.setBackground(Color.DARK_GRAY);
		R_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		R_2.setEnabled(false);
		R_2.setBounds(6, 23, 100, 52);
		p_time2.add(R_2);

		JButton[] time2 = new JButton[3];
		for (int i = 0; i < time2.length; i++) {
			time2[i] = new JButton((9 + (i * 3)) + ":00");
			time2[i].setLocation(118 + (i * 92), 40);
			time2[i].setSize(80, 30);
			time2[i].setBackground(Color.white);
			p_time2.add(time2[i]);
			time2[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < time2.length; j++) {
						if (e.getSource() == time2[j]) {
							if (same == 0 && time2[j].getText().equals((9 + (j * 3)) + ":00")) {
								time2[j].setBackground(Color.red); // 표시를 위해 배경색을 바꿈.
								time = (9 + (j * 3)) + ":00";
								room_num = "상영관2";

								System.out.println(room_num);
								System.out.println(time);
								same++;
							} else if (same == 1 && time2[j].getText().equals((9 + (j * 3)) + ":00")) {
								time2[j].setBackground(Color.white); // 배경색을 원래대로.
								time = "";
								room_num = "";
								same--;
							} // else if

						} // if
					} // for j
				} // action
			}); // add action
		} // for i

		JPanel p_time3 = new JPanel();
		p_time3.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_time3.setBackground(Color.WHITE);
		p_time3.setBounds(6, 253, 463, 100);
		panel_1.add(p_time3);
		p_time3.setLayout(null);

		JButton R_3 = new JButton("상영관 3");
		R_3.setForeground(Color.WHITE);
		R_3.setBackground(Color.DARK_GRAY);
		R_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		R_3.setEnabled(false);
		R_3.setBounds(6, 23, 100, 52);
		p_time3.add(R_3);

		JButton[] time3 = new JButton[2];
		for (int i = 0; i < time3.length; i++) {
			time3[i] = new JButton((13 + (i * 3)) + ":30");
			time3[i].setLocation(118 + (i * 92), 40);
			time3[i].setSize(80, 30);
			time3[i].setBackground(Color.white);
			p_time3.add(time3[i]);
			time3[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < time3.length; j++) {
						if (e.getSource() == time3[j]) {
							if (same == 0 && time3[j].getText().equals((13 + (j * 3)) + ":30")) {
								time3[j].setBackground(Color.red); // 표시를 위해 배경색을 바꿈.
								time = (13 + (j * 3)) + ":30";
								room_num = "상영관3";

								System.out.println(room_num);
								System.out.println(time);
								same++;
							} else if (same == 1 && time3[j].getText().equals((13 + (j * 3)) + ":30")) {
								time3[j].setBackground(Color.white); // 배경색을 원래대로.
								time = "";
								room_num = "";
								same--;
							} // else if

						} // if
					} // for j
				} // action
			}); // add action
		} // for i

		JPanel p_time4 = new JPanel();
		p_time4.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_time4.setBackground(Color.WHITE);
		p_time4.setBounds(6, 353, 463, 100);
		panel_1.add(p_time4);
		p_time4.setLayout(null);

		JButton R_4 = new JButton("상영관 4");
		R_4.setForeground(Color.WHITE);
		R_4.setBackground(Color.DARK_GRAY);
		R_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		R_4.setEnabled(false);
		R_4.setBounds(6, 23, 100, 52);
		p_time4.add(R_4);

		JButton[] time4 = new JButton[3];
		for (int i = 0; i < time4.length; i++) {
			time4[i] = new JButton((15 + (i * 3)) + ":20");
			time4[i].setLocation(118 + (i * 92), 40);
			time4[i].setSize(80, 30);
			time4[i].setBackground(Color.white);
			p_time4.add(time4[i]);
			time4[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < time4.length; j++) {
						if (e.getSource() == time4[j]) {
							if (same == 0 && time4[j].getText().equals((15 + (j * 3)) + ":20")) {
								time4[j].setBackground(Color.red); // 표시를 위해 배경색을 바꿈.
								time = (15 + (j * 3)) + ":20";
								room_num = "상영관4";

								System.out.println(room_num);
								System.out.println(time);
								same++;
							} else if (same == 1 && time4[j].getText().equals((15 + (j * 3)) + ":20")) {
								time4[j].setBackground(Color.white); // 배경색을 원래대로.
								time = "";
								room_num = "";
								same--;
							} // else if

						} // if
					} // for j
				} // action
			}); // add action
		} // for i

		JPanel p_time5 = new JPanel();
		p_time5.setBorder(new LineBorder(new Color(0, 0, 0)));
		p_time5.setBackground(Color.WHITE);
		p_time5.setBounds(6, 453, 463, 100);
		panel_1.add(p_time5);
		p_time5.setLayout(null);

		JButton R_5 = new JButton("상영관 5");
		R_5.setForeground(Color.WHITE);
		R_5.setBackground(Color.DARK_GRAY);
		R_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		R_5.setEnabled(false);
		R_5.setBounds(6, 23, 100, 52);
		p_time5.add(R_5);

		JButton[] time5 = new JButton[2];
		for (int i = 0; i < time5.length; i++) {
			time5[i] = new JButton((20 + (i * 3)) + ":10");
			time5[i].setLocation(118 + (i * 92), 40);
			time5[i].setSize(80, 30);
			time5[i].setBackground(Color.white);
			p_time5.add(time5[i]);
			time5[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < time5.length; j++) {
						if (e.getSource() == time5[j]) {
							if (same == 0 && time5[j].getText().equals((20 + (j * 3)) + ":10")) {
								time5[j].setBackground(Color.red); // 표시를 위해 배경색을 바꿈.
								time = (20 + (j * 3)) + ":10";
								room_num = "상영관5";

								System.out.println(room_num);
								System.out.println(time);
								same++;
							} else if (same == 1 && time5[j].getText().equals((20 + (j * 3)) + ":10")) {
								time5[j].setBackground(Color.white); // 배경색을 원래대로.
								time = "";
								room_num = "";
								same--;
							} // else if
						} // if
					} // for j
				} // action
			}); // add action
		} // for i

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBounds(497, 80, 475, 600);
		getContentPane().add(panel_2);
		panel_2.setLayout(null); // 좌석 배치도 위한 panel.

		JButton screen = new JButton("SCREEN");
		screen.setForeground(Color.WHITE);
		screen.setBackground(Color.DARK_GRAY);
		screen.setEnabled(false);
		screen.setBounds(6, 53, 463, 38);
		panel_2.add(screen); // 스크린 표시를 위한 버튼, 외관상 버튼으로 만들고 클릭 값을 삭제.

		JPanel p_seat = new JPanel();
		p_seat.setBackground(Color.gray);
		p_seat.setBounds(6, 100, 463, 452);
		p_seat.setLayout(null);
		panel_2.add(p_seat); // 좌석 배열을 찍기위한 panel.

		JButton[][] seat = new JButton[5][10]; // 좌석 버튼을 2차원 배열을 이용해 생성.
		for (int i = 0; i < 5; i++) { // 한 줄에 버튼 5개.
			char alpa = 65; // char 65는 문자 A를 나타냄.
			for (int j = 0; j < 10; j++) { // 열줄 생성.
				String alpap_seat = String.valueOf(alpa); // char를 문자형으로 변환
				seat[i][j] = new JButton(alpap_seat + (i + 1) + ""); // 좌석 버튼 배열 안에 들어갈 값들 설정.
				seat[i][j].setLocation((i * 90) + 10, (j * 45) + 10); // 초기 위치 값을 잡고 증가시켜주기.
				seat[i][j].setSize(80, 30);
				seat[i][j].setBackground(Color.white);
				p_seat.add(seat[i][j]);
				alpa++; // 알바벳을 증가.
				seat[i][j].addActionListener(new ActionListener() { // 버튼을 눌렀을 때, 아래 코드를 실행.
					public void actionPerformed(ActionEvent e) {
						for (int k = 0; k < 5; k++) {
							for (int l = 0; l < 10; l++) { // 이차원 배열이기 때문에 같은 이중for문을 사용.
								if (e.getSource() == seat[k][l]) { // 버튼의 값과 배열의 값이 같으면 실행.
									if (same == 0 && seat[k][l].getText().equals(alpap_seat + (k + 1) + "")) {
										// same의 값이 0이고, 버튼의 값이 괄호과 같다면 실행.
										seat[k][l].setBackground(Color.red); // 클릭 시 배경 값 변
										seat_index = k; // 알바벳 뒤의 숫자값을 갖고 오기 위해 seat_index변수를 배열의 인덱스를 저장.
										seat_num = alpap_seat + (seat_index + 1); // seat_num변수를 선언하고, 좌석의 제대로 된 값을 저장.
										same++; // 눌렀다는 것을 표시하기 위해 same값 증가.

										System.out.println(seat_num);
									} else if (same == 1 && seat[k][l].getText().equals(alpap_seat + (k + 1) + "")) {
										// 이미 좌석이 선택되었다면 실행.
										seat[k][l].setBackground(Color.white);
										seat_index = 0;
										seat_num = ""; // 저장된 값을 초기화.
										same--; // 표시 제거를 위한 same값 제거.
									} // else if
								} // if
							} // for l
						} // for k
					} // action
				}); // add action
			} // for j
		}

		JButton nextpage = new JButton("예매확인하기");
		nextpage.setBounds(772, 690, 200, 50);
		nextpage.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		getContentPane().add(nextpage);
		nextpage.addActionListener(new ActionListener() {
			// 버튼을 누르면 값을 디비에 넘겨주고, 예매확인 창으로 넘겨주기.
			public void actionPerformed(ActionEvent e) {
				ReservationDAO dao = new ReservationDAO();
				ReservationVO bag = new ReservationVO();
				bag.setId(id);
				bag.setSubject(subject);
				bag.setRegion(region);
				bag.setDate(date);
				bag.setRoom_num(room_num);
				bag.setTime(time);
				bag.setSeat_num(seat_num);
				try {
					dao.create(bag);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					new ReserveCheck3(id, pw);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}