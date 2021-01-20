package join;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import main.LoginAfter;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Login extends JFrame {
	private JTextField inputid;
	String id;
	String pw;
	private JPasswordField inputpw;

	public Login() {

		setSize(1000, 800);
		getContentPane().setLayout(null);
		getContentPane().setBackground(SystemColor.textHighlight);
		setVisible(true);
		setLocationRelativeTo(null); // 화면 가운데 창 띄우기
		setResizable(false);// 창 크기 변환불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel.setBounds(512, 297, 115, 39);
		getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblPassword.setBounds(512, 362, 135, 39);
		getContentPane().add(lblPassword);

		inputid = new JTextField();
		inputid.setFont(new Font("굴림", Font.PLAIN, 30));
		inputid.setBounds(687, 297, 197, 39);
		getContentPane().add(inputid);

		JLabel error = new JLabel("");
		error.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		error.setForeground(new Color(255, 0, 0));
		error.setBounds(540, 451, 344, 25);
		getContentPane().add(error);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력한 id pw 값 가져오기
				id = inputid.getText();
				pw = inputpw.getText();

				// 로그인버튼 클릭시 read()메서드 호출
				MembershipDAO dao = new MembershipDAO();
				try {
					dao.read(id, pw);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// ture일때 로그인 성공
				try {
					boolean loginrst = dao.read(id, pw);
					if (loginrst) {
						// 로그인한 페이지로 이동
						new LoginAfter(id, pw);

						// 로그인창 닫기
						setVisible(false);

						// 로그인전 페이지 닫아야함

					} else {
						// 로그인 실패 메세지 출력
						error.setText("로그인 실패!!!!");
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btnNewButton.setBounds(512, 500, 135, 48);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("영화예매를 위해 로그인을 먼저 해주세요!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(510, 153, 374, 48);
		getContentPane().add(lblNewLabel_1);

		inputpw = new JPasswordField();
		inputpw.setBounds(687, 362, 197, 39);
		getContentPane().add(inputpw);

		// 예매가능 영화중 랜덤으로 포스터 출력
		String[] img = { "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg" };
		// 0~9까지 중 랜덤값
		Random r = new Random();
		int num = r.nextInt(10);
		System.out.println(num);

		JLabel randomImg = new JLabel("");
		randomImg.setIcon(new ImageIcon(img[num]));
		randomImg.setBounds(160, 163, 297, 399);
		getContentPane().add(randomImg);

		JButton home = new JButton("메인으로");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main.LogoutAfter();
				setVisible(false);
			}
		});
		home.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		home.setBounds(673, 500, 211, 48);
		getContentPane().add(home);

	}

	public static void main(String[] args) {
		new Login();
	}
}
