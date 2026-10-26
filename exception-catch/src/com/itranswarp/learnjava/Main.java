package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) {
		try {
			process1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void process1() {
		process2();
	}

	static void process2() {
		Integer.parseInt(null); // 会抛出NumberFormatException
	}
}
