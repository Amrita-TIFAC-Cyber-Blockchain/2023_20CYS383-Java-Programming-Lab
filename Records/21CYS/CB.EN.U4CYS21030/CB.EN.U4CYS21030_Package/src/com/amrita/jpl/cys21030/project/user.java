package com.amrita.jpl.cys21030.project;
package account;
import java.util.Scanner;
import card.*;

import java.lang.Math;   
abstract public class user {
	protected static final int min_bal=1000;
	public int	 acc_n;
	protected final static int lim= 5;
	public int acc_bal;
	public String user_name;
	public final static int limit =50;
	static public  int receipt[][];
	protected int pointer=0;
	public String pass;
	public String dob;
	public String phone;
	public int card_details;
	public static int point = 0;
	public static int point_withdraw=0;
	public static int point_deposit=0;
	protected static int withdrawals[][];
	protected static int deposits[][];
	public user() {	
		receipt = new int[lim][3];
		 withdrawals = new int[lim][2];
		 deposits = new int[lim][2];
	}
	public void get() {
		Scanner s = new Scanner(System.in);	
		System.out.println("enter the user name "+ point);
		user_name = s.next();
		System.out.println("enter the password "+ point);
		pass = s.next();
		System.out.println("enter the date of birth "+ point);
		dob = s.next();
		System.out.println("enter the phone number "+ point);
		phone = s.next();
		
		setCard_details((int)(Math.random()*100000));
		System.out.println("enter the balance "+ point);
		acc_bal= s.nextInt();
	}
	abstract public void register();
	public void sendmoney(user r,user u, int amt) {
		// TODO Auto-generated method stub
	}	
	
	abstract public void deposit();
	abstract public void withdraw();
	abstract public void runn();
	public int getCard_details() {
		return card_details;
	}
	public void setCard_details(int card_details) {
		this.card_details = card_details;
	}
}
