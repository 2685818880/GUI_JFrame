package com.hotel.java;
/*
 * 1.����ѧ����Student
���԰���
ѧ�ţ�id����������name��������ɼ���japScore����java�ɼ���javaScore�����ܳɼ���sum��
��������
���췽����get������set������toString������equals������
compare�������Ƚ�����ѧ�����ܳɼ�, ����ִ��ڣ�С�ڣ����ڣ���sumScore�����������ܳɼ�*/
public class Student {
	private String id;
	private String name;
	private int japScore;//����ɼ�
	private int javaScore;//java�ɼ�
	private int sum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJapScore() {
		return japScore;
	}
	public void setJapScore(int japScore) {
		this.japScore = japScore;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Student( String id, String name, int japScore, int javaScore){
	this. id = id;
	this. name = name;
	this. japScore = japScore;
	this. javaScore = javaScore;
	sumScore();
	}
	public String getId() {
		return id; }
	public void setId( String id) {
		this. id = id;} 
	public void sumScore(){
		this. sum = japScore + javaScore;
	} 	
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + "\t" + getName() + "\t" + getJapScore() + "\t" + getJavaScore() + "\t" + getSum();
		}
	//��дequals����
	public boolean equals( Object obj) {
		// TODO Auto-generated method stub
		if ( this. getClass() !=  obj.getClass()){
			return false;
		}
		else{
			Student  student = (Student) obj;
			return this.getId(). equals( student.getId() );	
		}
	}
	//�ȽϹ���
	public int compare( Student student){
		if (this. getSum() >  student. getSum() ){
			return 1;
		}
		else if (this. getSum() == student .getSum()){
			return 0;
		}
		else{
			return -1;
		}
	}


}
