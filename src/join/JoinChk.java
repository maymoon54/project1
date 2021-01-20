package join;

import javax.swing.JOptionPane;

public class JoinChk {

//가입시 필수항목 입력여부
	public boolean joinm(String id, String pw, String pwc, String name, String phone) {

		boolean join1 = false;
		if (id.equals("") || pw.equals("") || pwc.equals("") || name.equals("") || phone.equals("")) {
			JOptionPane.showMessageDialog(null, "입력하지 않은 항목이 있습니다");
		} else {
			join1 = true;
		}
		return join1;

		// TODO Auto-generated constructor stub
	}

//비밀번호 확인 (재입력 받아서 동일한지 확인)
	public boolean pwChk(String pw, String pwc) {
		boolean join2 = false;
		if (!pw.equals(pwc)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다");

		} else {
			join2 = true;
		}
		return join2;
	}

}
