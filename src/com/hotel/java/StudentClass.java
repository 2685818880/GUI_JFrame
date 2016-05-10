package com.hotel.java;
/*����ѧ���༶��StudentClass
���԰���
�༶���ƣ�name����������capacity����ѧ����students����ʵ��������size����
��������
���췽����get������set������toString������

*/
public class StudentClass {
	private String name;//�༶����
	private int capacity = 40;//�༶����
	private Student students[];//ѧ��
	private int size;//ʵ������
	
	public StudentClass( String name, int size){
		this. name  = name;
		this. size = size;
		students = new  Student[capacity];
	}
	public void setName( String name){
		this. name = name;
	}
	public String getName(){
		return name;
	}
	public void setStudent( Student[] students){
		for (int i = 0; i < size; i++){
			this. students[i] =  students[i]; //����ֵ�ķ�Χ����
		}
	}
	public String toString(){	
		String result;
		result = "�༶��" + name + "\t" + "������" + capacity + "\t" + "ʵ��������" + size + "\n\n";	
		result += "ѧ��" + "\t" + "����" + "\t" + "����ɼ�" + "\t" + "Java�ɼ�" + "\t" + "�ܳɼ�" + "\n" ;
		for (int i = 0; i < size; i++){
		result += students[i]. getId() + "\t" + students[i]. getName() + "\t" + students[i]. getJapScore() + "\t" + students[i]. getJavaScore() + "\t" + students[i]. getSum() + "\n";
		}
		return result;
	}

}