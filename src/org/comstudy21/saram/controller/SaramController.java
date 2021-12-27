package org.comstudy21.saram.controller;

import org.comstudy21.saram.R;
import org.comstudy21.saram.ViewContainer;

public class SaramController {
	private ViewContainer vc = new ViewContainer();
	public void action() {
		//System.out.println(">>>> SaramController ���� ...");
		if(R.no == 0) {
			vc.run(R.menuView); // ���� ���ε� ó���ȴ�.
		}
		
		switch(R.no) {
		case 1 : vc.run(R.insertView); break;
		case 2 : vc.run(R.saramListView); break;
		case 3 : vc.run(R.saramDetail); break;
		case 4 : vc.run(R.saramEdit); break;
		case 5 : vc.run(R.saramDelete); break;
		case 6 : System.out.println("���α׷� ����"); System.exit(0); break;
		default : System.out.println("�ش� ����� �����ϴ�!");
		}
		
		// ��� ȣ��
		R.no = 0;
		action();
	}
}
