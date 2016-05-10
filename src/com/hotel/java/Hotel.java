package com.hotel.java;

import java.util.Scanner;

class Room {

	// 房间号 标准间 套间 豪华间 占用/空闲
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
				+ (type == 0 || type == 1 ||type == 3 ||type == 4 ?"1号库位" : type == 5 ||type == 6? "2号库位" : type == 8 ? "3号库位"
						: "") + "bool=" + (bool ? "占用" : "空闲") + "]" + "\t";
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
			System.out.println("请选择房间，输入房间号即可。 或 输入exit退出。");
			System.out.println(num);
			String str = sca.next();
			if (str.equals("exit")) {
				// System.exit(0);
				System.out.print("成功退出！");
				break;
			}
			if (!hotel.find(str)) {
				hotel.search(str);
				hotel.rooms();
				System.out.println("已经预订成功！");
			} else {
				System.out.print("房间已经被使用或输入有误，请重新输入！");

			}

			System.out.println();
		}

	}

}
