package com.hotel.java;
/*
 * 1.声明学生类Student
属性包括
学号（id），姓名（name），日语成绩（japScore），java成绩（javaScore），总成绩（sum）
方法包括
构造方法，get方法，set方法，toString方法，equals方法，
compare方法（比较两个学生的总成绩, 结果分大于，小于，等于），sumScore方法（计算总成绩*/
public class Student {
	private String id;
	private String name;
	private int japScore;//日语成绩
	private int javaScore;//java成绩
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
	//重写equals方法
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
	//比较规则
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
