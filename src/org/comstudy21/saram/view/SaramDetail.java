package org.comstudy21.saram.view;

public class SaramDetail extends SaramView {
	@Override
	public void display() {
		if(R.type == R.SEARCH) {
			System.out.println("::::: 사람 정보 검색 :::::");
		} else {
			System.out.println("::::: 사람 정보 상세보기 :::::");
		}
	}
}
