package com.hotel.java;
/*声明学生班级类StudentClass
属性包括
班级名称（name），容量（capacity），学生（students），实际人数（size）。
方法包括
构造方法，get方法，set方法，toString方法。

*/
public class StudentClass {
	private String name;//班级名称
	private int capacity = 40;//班级容量
	private Student students[];//学生
	private int size;//实际人数
	
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
			this. students[i] =  students[i]; //传入值的范围必须
		}
	}
	public String toString(){	
		String result;
		result = "班级：" + name + "\t" + "容量：" + capacity + "\t" + "实际人数：" + size + "\n\n";	
		result += "学号" + "\t" + "姓名" + "\t" + "日语成绩" + "\t" + "Java成绩" + "\t" + "总成绩" + "\n" ;
		for (int i = 0; i < size; i++){
		result += students[i]. getId() + "\t" + students[i]. getName() + "\t" + students[i]. getJapScore() + "\t" + students[i]. getJavaScore() + "\t" + students[i]. getSum() + "\n";
		}
		return result;
	}

}