package com.amrita.jpl.cys21030.project;
package upi;
import account.*;
public class payment extends upi implements admin{
    int send;
    int receive;
    int amt;
    
    
    int count=0;
 
    public payment() {
    	
    }
    public void acc_details(user u) {
    	acc_bal = u.acc_bal;
    	user_name  = u.user_name;
    	dob=u.dob;
    	phone=u.phone;
    	acc_n= u.acc_n;
    	card_details =u.card_details;
    }
    public void getter(int s, int r, int a) {
    	send = s;
    	receive= r;
    	amt =a;
    	count=count+1;
    }
    
	 public void view_transactions() {
		// TODO Auto-generated method stub
		for(int i =0;i<lim;i++) {
			   System.out.println("sender: "+receipt[i][0]+" receiver :"+receipt[i][1]+" ammount :"+receipt[i][2]);
			}
	}
	public void view_acc_details(user u) {
		// TODO Auto-generated method stub
		acc_details(u);
		// TODO Auto-generated method stub
		System.out.println("user name : "+user_name);
		System.out.println("account number : "+acc_n);
		System.out.println(" dob : "+dob);
		System.out.println(" phone number : "+phone);
		System.out.println(" account balance : "+acc_bal);
		System.out.println(" card number : "+card_details);
		
	}
	@Override
	public void view_withdrawals() {
		// TODO Auto-generated method stub
		for(int i =0;i<lim;i++) {
			   System.out.println("acc number: "+withdrawals[i][0]+ " withdrawal ammount :"+withdrawals[i][1]);
			}

		
	}   
	public void view_deposits() {
		// TODO Auto-generated method stub
		for(int i =0;i<lim;i++) {
			   System.out.println("acc number: "+deposits[i][0]+ " deposit ammount :"+deposits[i][2]);
			}

		
	}   
}
