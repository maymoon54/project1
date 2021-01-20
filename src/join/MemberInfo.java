package join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import main.LoginAfter;
import main.LogoutAfter;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Reservation.ReservationDAO;
import Reservation.ReservationVO;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class MemberInfo extends JFrame {
	private JTextField editname;
	private JTextField editemail;
	private JTextField editphone;
	private JPasswordField editpw;
	private JPasswordField editpwc;
	private JTextField t_cancle;

	public MemberInfo(String id, String pw) throws Exception {

		setSize(1000, 800);
		setVisible(true);
		getContentPane().setBackground(SystemColor.textHighlight);
		setLocationRelativeTo(null); // 화면 가운데 창 띄우기
		setResizable(false);// 창 크기 변환불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// id로 회원정보 검색
		join.MembershipDAO dao = new join.MembershipDAO();
		Reservation.ReservationDAO dao_r = new Reservation.ReservationDAO();

		// 가방을 가져옴
		MembershipVO bag = dao.one(id);
		ArrayList<ReservationVO> list = dao_r.call(id);

		// 테이블안에 생성될 값
		Object rowData[][] = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			ReservationVO bag_r = list.get(i);
			Object[] o = { bag_r.getReserv_num(), bag_r.getSubject(), bag_r.getRegion(), bag_r.getDate(),
					bag_r.getRoom_num(), bag_r.getTime(), bag_r.getSeat_num() };
			rowData[i] = o;
		}
		Object colNames[] = { "예매번호", "영화제목", "영화관지점", "날짜", "상영관번호", "상영시간", "좌석번호" };

		// 패널생성
		JPanel change1 = new JPanel();
		JPanel change2 = new JPanel();

		// 패널1 : 예매내역 (초기화면)
		change1.setBounds(266, 98, 711, 547);
		change1.setBackground(SystemColor.textHighlight);
		getContentPane().add(change1);
		change1.setLayout(null);
		change1.setVisible(true);
		change2.setVisible(false);

		JLabel lblNewLabel_4 = new JLabel("예매내역");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(31, 10, 100, 41);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		change1.add(lblNewLabel_4);

		// 테이블 생성
		DefaultTableModel dtable = new DefaultTableModel(rowData, colNames);
		JTable table = new JTable(dtable);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 93, 652, 202);
		change1.add(scrollPane);

		JLabel lblNewLabel_5 = new JLabel("예매를 취소하시려면, 예매번호를 입력해주세요.");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(31, 320, 311, 35);
		change1.add(lblNewLabel_5);

		t_cancle = new JTextField();
		t_cancle.setFont(new Font("굴림", Font.PLAIN, 15));
		t_cancle.setBounds(350, 320, 100, 35);
		change1.add(t_cancle);
		t_cancle.setColumns(10);

		JButton cancle = new JButton("예매취소");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "예매가 취소되었습니다.");
				JOptionPane.showMessageDialog(null, "마이페이지를 나갔다 들어오세요.");
				ReservationDAO dao = new ReservationDAO();
				ReservationVO bag = new ReservationVO();
				String t = t_cancle.getText();
				int num = Integer.parseInt(t);
				bag.setReserv_num(num);
				try {
					dao.delete(bag);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cancle.setBounds(456, 320, 105, 35);
		change1.add(cancle);

		// 패널2 : 회원정보 수정
		JLabel blNewLabel = new JLabel("회원정보");
		blNewLabel.setForeground(Color.WHITE);
		blNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		blNewLabel.setBounds(31, 10, 99, 41);
		change2.add(blNewLabel);

		change2.setBounds(266, 99, 716, 535);
		change2.setBackground(SystemColor.textHighlight);
		getContentPane().add(change2);
		change2.setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(137, 93, 157, 28);
		change2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호 변경");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(137, 214, 157, 28);
		change2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("비밀번호 확인");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(137, 258, 157, 28);
		change2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("이메일 주소");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(137, 318, 157, 28);
		change2.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("휴대폰 번호");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(137, 377, 157, 28);
		change2.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(137, 148, 157, 28);
		change2.add(lblNewLabel_3);

		JLabel readId = new JLabel(id);
		readId.setForeground(Color.WHITE);
		readId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		readId.setBounds(300, 93, 121, 24);
		change2.add(readId);

		editname = new JTextField(bag.getName());// 이름
		editname.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		editname.setBounds(300, 148, 170, 28);
		change2.add(editname);
		editname.setColumns(10);

		editemail = new JTextField(bag.getEmail());// 이메일
		editemail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		editemail.setColumns(10);
		editemail.setBounds(300, 319, 233, 28);
		change2.add(editemail);

		editphone = new JTextField(bag.getPhone()); // 휴대폰번호
		editphone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		editphone.setColumns(10);
		editphone.setBounds(300, 377, 233, 28);
		change2.add(editphone);

		editpw = new JPasswordField(bag.getPw()); // 비밀번호
		editpw.setBounds(300, 214, 170, 28);
		change2.add(editpw);

		editpwc = new JPasswordField(); // 비밀번호 재입력해서 동일해야 회원정보 수정 가능
		editpwc.setBounds(300, 261, 170, 28);
		change2.add(editpwc);

		JButton btnNewButton_1 = new JButton("회원정보 수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원정보 수정 버튼 클릭
				// 수정할 회원정보 입력값
				String name = editname.getText();
				String pw = editpw.getText();
				String pwc = editpwc.getText();
				String email = editemail.getText();
				String phone = editphone.getText();

				// DAO로 넘기기

				// 비밀번호와 비밀번호 확인이 일치해야 회원정보 수정
				JoinChk editpw = new JoinChk();
				boolean editrst = editpw.pwChk(pw, pwc); // true일때 회원정보 수정

				if (editrst) {
					MembershipDAO edit = new MembershipDAO();
					try {
						edit.update(pw, name, email, phone, id);
						JOptionPane.showMessageDialog(null, "회원정보 수정 완료");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_1.setBounds(300, 480, 170, 37);
		change2.add(btnNewButton_1);

		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LogoutAfter();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(845, 34, 105, 37);
		getContentPane().add(btnNewButton);

		JLabel loginID = new JLabel(id + "님");
		loginID.setForeground(Color.WHITE);
		loginID.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		loginID.setBounds(590, 35, 126, 35);
		getContentPane().add(loginID);

		// 사이드메뉴
		JButton btn1 = new JButton("예매내역 확인");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change1.setVisible(true);
				change2.setVisible(false);
			}
		});
		btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn1.setBounds(27, 99, 215, 56);
		getContentPane().add(btn1);

		JButton btn2 = new JButton("회원정보수정");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change2.setVisible(true);
				change1.setVisible(false);

			}
		});
		btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn2.setBounds(27, 165, 215, 56);
		getContentPane().add(btn2);

		JLabel lblNewLabel_2 = new JLabel("마이페이지");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel_2.setBounds(27, 21, 350, 68);
		getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("메인으로");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginAfter(id, pw);
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_2.setBounds(728, 34, 105, 37);
		getContentPane().add(btnNewButton_2);

	}
}