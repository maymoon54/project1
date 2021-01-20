package join;

import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

import main.LogoutAfter;
import java.awt.SystemColor;

public class Membership extends JFrame {
	private JPasswordField inputpw;
	private JPasswordField inputpwc;

	public Membership() {

		setSize(1000, 800);
		setVisible(true);
		getContentPane().setBackground(SystemColor.textHighlight);
		setLocationRelativeTo(null); // 화면 가운데 창 띄우기
		setResizable(false);// 창 크기 변환불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 페이지 제목
		JLabel title = new JLabel();
		title.setForeground(Color.WHITE);
		title.setBounds(430, 43, 126, 68);
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		title.setText("회원가입");

		// 회원가입 메뉴
		JLabel lname = new JLabel();
		lname.setForeground(Color.WHITE);
		lname.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lname.setBounds(219, 145, 59, 41);
		JLabel lid = new JLabel();
		lid.setForeground(Color.WHITE);
		lid.setBounds(219, 216, 59, 41);
		lid.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JLabel lpw = new JLabel();
		lpw.setForeground(Color.WHITE);
		lpw.setBounds(219, 309, 98, 41);
		lpw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JLabel lpwc = new JLabel();
		lpwc.setForeground(Color.WHITE);
		lpwc.setBounds(219, 380, 107, 41);
		lpwc.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JLabel lemail = new JLabel();
		lemail.setForeground(Color.WHITE);
		lemail.setBounds(219, 448, 107, 41);
		lemail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JLabel lphone = new JLabel();
		lphone.setForeground(Color.WHITE);
		lphone.setBounds(222, 512, 90, 41);
		lphone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		lid.setText("아이디");
		lpw.setText("비밀번호");
		lpwc.setText("비밀번호 확인");
		lname.setText("이름");
		lemail.setText("이메일주소");
		lphone.setText("휴대폰번호");

		// 입력받기
		TextField inputid = new TextField();
		inputid.setBounds(376, 216, 252, 44);
		inputid.setFont(new Font("Arial", Font.PLAIN, 15));
		inputid.setColumns(20);
		TextField inputname = new TextField();
		inputname.setFont(new Font("Arial", Font.PLAIN, 15));
		inputname.setColumns(20);
		inputname.setBounds(376, 142, 252, 44);
		getContentPane().add(inputname);
		TextField inputemail = new TextField();
		inputemail.setBounds(376, 448, 252, 41);
		inputemail.setFont(new Font("Arial", Font.PLAIN, 15));
		inputemail.setColumns(20);
		TextField inputphone = new TextField();
		inputphone.setBounds(376, 512, 252, 41);
		inputphone.setFont(new Font("Arial", Font.PLAIN, 15));
		inputphone.setColumns(20);
		getContentPane().setLayout(null);
		inputpw = new JPasswordField();
		inputpw.setBounds(376, 316, 252, 34);
		getContentPane().add(inputpw);
		inputpwc = new JPasswordField();
		inputpwc.setBounds(376, 380, 252, 34);
		getContentPane().add(inputpwc);

		// 라벨화면에 배치하기
		getContentPane().add(title);
		getContentPane().add(lid);
		getContentPane().add(inputid);
		getContentPane().add(lpw);
		getContentPane().add(lpwc);
		getContentPane().add(lemail);
		getContentPane().add(inputemail);
		getContentPane().add(lphone);
		getContentPane().add(inputphone);
		getContentPane().add(lname);

		JButton btnNewButton = new JButton("ID중복체크");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(644, 219, 120, 34);
		getContentPane().add(btnNewButton);

		JLabel idresult = new JLabel(""); // id중복체크 결과 보여주는 라벨
		idresult.setForeground(Color.RED);
		idresult.setFont(new Font("돋움", Font.PLAIN, 13));
		idresult.setBounds(376, 266, 252, 25);
		getContentPane().add(idresult);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력한 id 값을 가져옴
				String id = inputid.getText();

				// read()메소드 호출
				MembershipDAO dao = new MembershipDAO();

				// 반환값 넘겨받아서 처리
				try {
					boolean result = dao.read(id);
					if (result) {
						idresult.setText("아이디중복!! 다른아이디를 입력하세요");
					} else {
						idresult.setText("사용가능 아이디");
					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		// 회원가입버튼
		JButton joinbt = new JButton("회원가입");
		joinbt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// membership 테이블에 자료를 전송하기전에 확인할 것
				// 필수로 적어야 하는 항목
				// id중복체크
				// pw확인

				// 입력한 회원정보 가져오기
				String id = inputid.getText();
				String pw = inputpw.getText();
				String pwc = inputpwc.getText();
				String name = inputname.getText();
				String email = inputemail.getText();
				String phone = inputphone.getText();

				String con1 = idresult.getText();

				// 필수항목 입력 체크
				JoinChk inputchk = new JoinChk();

				boolean joinrst = inputchk.joinm(id, pw, pwc, name, phone);
				boolean pwrst = inputchk.pwChk(pw, pwc);
				MembershipDAO dao = new MembershipDAO();
				boolean result;
				try {
					result = dao.read(id);
					if (joinrst && pwrst) { // 필수항목입력체크와 비밀번호 확인이 완료되었다면
						if (result || con1.equals("")) {
							// 아이디 입력란이 비어있을 경우 사용가능 아이디 라고 체크함 (but 입력하지 않은 항목이 있다고 알려줌)
							// 아이디 중복체크 버튼을 누르지 않았을 경우
							// 아이디가 중복된 경우
							JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요");
						} else {
							// 가방을 만든다
							MembershipVO bag = new MembershipVO();

							// 가방에 값들을 하나씩 넣는다
							bag.setId(id);
							bag.setPw(pw);
							bag.setName(name);
							bag.setEmail(email);
							bag.setPhone(phone);

							// 가방을 DAO로 넘긴다
							MembershipDAO dao2 = new MembershipDAO();
							try {
								dao2.create(bag);
								new Login();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
		});
		joinbt.setBounds(396, 599, 98, 35);
		getContentPane().add(joinbt);

		JButton joinbt_1 = new JButton("취소");
		joinbt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LogoutAfter();
				setVisible(false);
			}
		});
		joinbt_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinbt_1.setBounds(522, 599, 90, 35);
		getContentPane().add(joinbt_1);

	}

	public static void main(String[] args) {
		new Membership();
	}
}