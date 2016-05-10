package com.hotel.java;

import java.util.Scanner;

class Room {

	// ����� ��׼�� �׼� ������ ռ��/����
	private String no;
	private int type;
	private boolean bool;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean getBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	@Override
	public String toString() {
		return "Room [no="
				+ no
				+ " type="
				+ (type == 0 || type == 1 ||type == 3 ||type == 4 ?"1�ſ�λ" : type == 5 ||type == 6? "2�ſ�λ" : type == 8 ? "3�ſ�λ"
						: "") + "bool=" + (bool ? "ռ��" : "����") + "]" + "\t";
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String no, int type, boolean bool) {
		super();
		this.no = no;
		this.type = type;
		this.bool = bool;
	}
}

public class Hotel {
	Room room[][][] = new Room[14][49][5];
	static int num;

	Hotel() {
		//010101 014905
		//140101  144905
		//1-5 2-6 3-7 4-8     9 10 11 12 13 14 
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				for (int k = 0; k < room[i][j].length; k++) {

					if (i == 0 || i == 4) {
						room[i][j][k] = new Room((i+1)*10000+(j+1)*100+k+1
								+ "", 0, false);
					}
					if (i == 1 || i == 5) {
						room[i][j][k] = new Room((i+1)*10000+(j+1)*100+k+1
								+ "", 0, false);
					}
					if (i == 2 || i == 6) {
						room[i][j][k] = new Room((i+1)*10000+(j+1)*100+k+1
								+ "", 0, false);
						
						
						
					}
					if (i == 3 || i == 7) {
						room[i][j][k] = new Room((i+1)*10000+(j+1)*100+k+1
								+ "", 0, false);
					}
					
					
					num++;
				}
			}
		}

	}

	void rooms() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				for (int k = 0; k < room[i][j].length; k++) {
					System.out.print(room[i][j][k]);
				}
				System.out.println();
			}
		}
	}

	void search(String no) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				for (int k = 0; k < room[i][j].length; k++) {
					if (room[i][j][k].getNo().equals(no)) {
						room[i][j][k].setBool(true);
					}
				}
			}
		}
	}

	boolean find(String no) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				for (int k = 0; k < room[i][j].length; k++) {
					if (room[i][j][k].getNo().equals(no)) {
						if (room[i][j][k].getBool() == false) {

							return false;
						}
					}
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		Scanner sca = new Scanner(System.in);
		hotel.rooms();
		while (true) {
			System.out.println("��ѡ�񷿼䣬���뷿��ż��ɡ� �� ����exit�˳���");
			System.out.println(num);
			String str = sca.next();
			if (str.equals("exit")) {
				// System.exit(0);
				System.out.print("�ɹ��˳���");
				break;
			}
			if (!hotel.find(str)) {
				hotel.search(str);
				hotel.rooms();
				System.out.println("�Ѿ�Ԥ���ɹ���");
			} else {
				System.out.print("�����Ѿ���ʹ�û������������������룡");

			}

			System.out.println();
		}

	}

}
