package org.comstudy21.saram.model;

import org.comstudy21.saram.SaramMain;

// ���� Ŀ�ø�
// ���յ� ���߰� ������ ������.
// SOLID 5��Ģ
public class SaramDao {
	// �ӽ÷� �迭�� �����ϵ��� �������� DB���� �Ǵ� FileIO�� ó��
	private static final int MAX = 100;
	private static final SaramVo[] saramArr = new SaramVo[MAX];
	public static int top = 0;
	public static int sequenceNo = 1; // ����� ���� ���� �ʴ´�.
	// static �ʱ�ȭ ��
	static {
		saramArr[top++] = new SaramVo(sequenceNo++, "KIM","010-1111-1111","kim@comstudy.org");
		saramArr[top++] = new SaramVo(sequenceNo++, "LEE","010-2222-2222","lee@comstudy.org");
		saramArr[top++] = new SaramVo(sequenceNo++, "PARK","010-3333-3333","park@comstudy.org");
	}
	
	// ��ü ���
	public SaramVo[] selectAll() {
		// saramArr�� ���� ���� - �� �迭�� �� ��ü�� �ʿ��ϴ�.
		SaramVo[] newArr = new SaramVo[top];
		for(int i=0; i<newArr.length; i++) {
			// ���� ���� ��ü�� ���� �ð� ���.
			SaramVo newSaram = new SaramVo();
			newSaram.setNo(saramArr[i].getNo());
			newSaram.setName(saramArr[i].getName());
			newSaram.setPhone(saramArr[i].getPhone());
			newSaram.setEmail(saramArr[i].getEmail());
			newArr[i] = newSaram;
		}
		return newArr;
	}
	// �󼼺��� - �̸����� �˻�
	public SaramVo selectOne(SaramVo vo) {
		// 1. �˻��ϱ�
		// 2. ���� �䰡�� ���� �ϸ� �����ؼ� ��ȯ(return)
		for(int i=0; i<top; i++) {
			if(vo.getName().equals(saramArr[i].getName())) {
				SaramVo newSaram = new SaramVo();
				newSaram.setNo(saramArr[i].getNo());
				newSaram.setName(saramArr[i].getName());
				newSaram.setPhone(saramArr[i].getPhone());
				newSaram.setEmail(saramArr[i].getEmail());
				return newSaram;
			}
		}
		return null;
	}
	// �󼼺��� - �̸����� �˻�
	public SaramVo selectByNo(int no) {
		// 1. �˻��ϱ�
		// 2. ���� �䰡�� ���� �ϸ� �����ؼ� ��ȯ(return)
		for(int i=0; i<top; i++) {
			if(no  == saramArr[i].getNo()) {
				SaramVo newSaram = new SaramVo();
				newSaram.setNo(saramArr[i].getNo());
				newSaram.setName(saramArr[i].getName());
				newSaram.setPhone(saramArr[i].getPhone());
				newSaram.setEmail(saramArr[i].getEmail());
				return newSaram;
			}
		}
		return null;
	}
	// �Է�
	public void insert(SaramVo vo) {
		if(top >= MAX) {
			System.out.println(">>> ���̻� �Է��� �Ұ����մϴ�!");
			return;
		}
		saramArr[top++] = vo;
	}
	// ����
	public void update(SaramVo vo) {
		// �˻��ؼ� ���� ��Ұ� �ִٸ� �����ϱ�, no�� �˻��ؼ� index�� ã��
		for(int i=0; i<top; i++) {
			if(saramArr[i].getNo() == vo.getNo()) {
				saramArr[i] = vo;
			}
		}
	}
	// ���� 
	public void delete(SaramVo vo) {
		// 1. no�� �˻��ϱ�
		// 2. ���� ��Ұ� �ִٸ� ��ĭ�� �����
		// 3. ������ ��Ҵ� null�� �����ϰ� top����
		for(int i=0; i<top; i++) {
			if(saramArr[i].getNo() == vo.getNo()) {
				for(int j=i; j<top-1; j++) {
					saramArr[j] = saramArr[j+1];
				}
				saramArr[top-1] = null;
				top--;
			}
		}
	}
}