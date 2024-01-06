package com.amrita.jpl.cys21030.project;
package card;
import account.*;
import java.util.Scanner;
import upi.*;
public class card extends upi {
	protected static int withdrawals[][];
	public static int point_withdraw=0;
	 public card(user u) {
		 withdrawals = new int[lim][3];
		 acc_bal = u.acc_bal;
	    	user_name  = u.user_name;
	    	dob=u.dob;
	    	phone=u.phone;
	    	acc_n= u.acc_n;
	 }
	 public void acc_details(user u) {
	    	acc_bal = u.acc_bal;
	    	user_name  = u.user_name;
	    	dob=u.dob;
	    	phone=u.phone;
	    	acc_n= u.acc_n;
	    	card_details =u.card_details;
	    }
	public void sendmoney(user receiver,user sender,int amt) {
	    System.out.println("enter card details");
		Scanner s = new Scanner(System.in);

	    int card_no =s.nextInt();
	    if(sender.card_details==card_no) {
	    	System.out.println("details entered are correct you can continue");
	    }
	    else {
	    	System.out.println("details entered are incorrect you cannot continue");
	    }
		sender.acc_bal -= amt; 
	    receiver.acc_bal+=amt;	   
		System.out.println("from the account :"+sender.acc_n+" to the account :" + receiver.acc_n+" transaction will take happen");
		System.out.println("card details of the sender: "+sender.getCard_details());
	}
	public void withdrawals() {
		
		for(int i =0;i<lim;i++) {
			   System.out.println("acc number: "+withdrawals[i][0]+ "ammount :"+withdrawals[i][2]);
			}
	}
	
	public void runn() {
		//withdraw money
		System.out.println("enter the ammount you want to withdraw");
		int withdraw;
		Scanner s = new Scanner(System.in);
		withdraw = 1000;
		if(acc_bal-withdraw>=min_bal) {
			
			withdrawals[point_withdraw][0]=acc_n;
			
			withdrawals[point_withdraw][2]=withdraw;
			point_withdraw++;
			acc_bal=acc_bal-withdraw;
			System.out.println("wthdrawal successful");
			
		}
		else {
			System.out.println("not enoug hbalance to withdraw");
		}
		
		
	}
}
