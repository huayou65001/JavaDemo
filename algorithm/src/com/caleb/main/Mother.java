package com.caleb.main;

/**
 * @author:Caleb
 * @Date  :2021-08-31 19:21:04
 */
public abstract class Mother{

	public int getAge(){
		return 45;
	}
	public abstract class Son{
		public int getAge(){
			return 38;
		}
	}
	public static void main(String[] args) {
		Mother m = new Mother(){
			public int getAge(){
				return 22;
			}	
		};
		Mother.Son s = m.new Son(){
			public int getAge(){
				return 57+super.getAge();
			}
		};
		System.out.println(s.getAge() + " " + m.getAge());
	}

	

}