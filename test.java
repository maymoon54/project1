package join;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class 패널테스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 프레임 및 패널 만들기
				Frame f = new Frame();
				Panel p = new Panel();
				Panel p2 = new Panel();
				
				// 프레임 셋팅
				f.setTitle("TEST");
				f.setBounds(100, 100, 500, 500);
				f.setVisible(true);			
				
				// 프레임의 레이아웃 설정
				f.setLayout(null);				
				
				// 패널 셋팅
				p.setBounds(0, 0, 250, 250);
				p2.setBounds(250, 0, 250, 250);
				p2.setLayout(null);
				
				// 컴포넌트 만들기
				Button btn = new Button("패널1 버튼");
				btn.setBounds(50, 50, 100, 100);
				Button btn2 = new Button("패널2 버튼");
				Button btn3 = new Button("패널2 버튼2");
				btn2.setBounds(50, 50, 100, 100);
				btn3.setBounds(150, 50, 100, 100);
				p.setLayout(null);
				
				// 패널에 컴포넌트 붙이기
				p.add(btn);
				p2.add(btn2);
				p2.add(btn3);
				
				// 프레임에 패널 붙이기
				f.add(p);
				f.add(p2);
		
	}

}
