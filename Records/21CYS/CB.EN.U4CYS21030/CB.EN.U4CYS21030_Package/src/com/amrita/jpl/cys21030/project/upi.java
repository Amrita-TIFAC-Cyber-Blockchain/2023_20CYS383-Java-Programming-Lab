package com.amrita.jpl.cys21030.project;
package upi;
import java.util.Scanner;
import account.*;

public class upi extends user{
	public void register() {
			get();
			acc_n =point+1;
			point+=1;
	}
	 public void acc_details(user u) {
	    	acc_bal = u.acc_bal;
	    	user_name  = u.user_name;
	    	dob=u.dob;
	    	phone=u.phone;
	    	acc_n= u.acc_n;
	    	card_details =u.card_details;
	    }
	 public void withdraw() {
		 System.out.println("enter the ammount you want to withdraw");
			int withdraw;
			Scanner s = new Scanner(System.in);
			withdraw = s.nextInt();
			if(acc_bal-withdraw>=min_bal) {
				withdrawals[point_withdraw][0]=acc_n;
				withdrawals[point_withdraw][1]=withdraw;
				point_withdraw++;
				acc_bal=acc_bal-withdraw;
				System.out.println("wthdrawal successful");
				
			}
			else {
				System.out.println("not enough balance to withdraw");
			}
	 }
	 public void deposit() {
		 int amt ;
		 Scanner s = new Scanner(System.in);
		 System.out.println("enter the ammount you want to deposit");
		 amt= s.nextInt();
		 acc_bal+=amt;
		 deposits[point_deposit][0]=acc_n;
		 deposits[point_deposit][1]=amt;
	 }
	 
	 
	public void sendmoney(user receiver,user sender,int amt) {
	    if(sender.acc_bal>=min_bal) {
	    	sender.acc_bal -= amt; 
			receipt[pointer][0]=sender.acc_n;
			receipt[pointer][1]=receiver.acc_n;
			receipt[pointer][2]=amt;
			pointer++;
		    receiver.acc_bal+=amt;	   
			System.out.println("from the account :"+sender.acc_n+" to the account :" + receiver.acc_n+" an ammount of :"+amt+" transferred");	
	    }
	    else {
	    	System.out.println("transaction failed due to low balance");
	    }
		
		
		
	}
	@Override
	public void runn() {
		// TODO Auto-generated method stub
		
	}
}
