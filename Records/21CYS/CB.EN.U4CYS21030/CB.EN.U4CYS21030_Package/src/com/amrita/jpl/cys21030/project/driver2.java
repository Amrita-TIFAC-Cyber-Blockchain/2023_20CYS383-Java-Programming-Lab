package com.amrita.jpl.cys21030.project;
package driver;
import account.*;
import upi.*;
import card.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import welcome.*;
public class driver2 {
	static final int limit = 5;
	public static void main(String[] args) {
		System.out.println("welcome to payment management system ");
		Thread t1 = new welcome();
		//t1.start();
		
		
		admin a = new payment();
		user u[];
		user c[];
		c= new user[5];
		u = new user[5];
		int tot=0;
//		try {
//			Thread.sleep(10500);
//		}catch(Exception e) {}
		//users registration 
		System.out.println("enter the details of all the users");
		for(int i =0;i<2;i++) {
		   u[i] = new upi();
		   c[i] = new card(u[i]);
		   u[i].register();
		   tot++;
		}
		Scanner s = new Scanner(System.in);	
		String username ;
		String pass;
		int exit = 1;
		while(exit ==1) {
			int adm = 0;
			System.out.println("enter 1 for admin login or 2 for user");
			adm = s.nextInt();
			if(adm==1) {
				
				
				

				System.out.println("Enter username for admin:");
				try {
				    username = s.next();
				} catch (InputMismatchException e) {
				    System.out.println("Invalid input. Please enter a valid username:");
				    s.next(); // consume the invalid input
				    username = s.next();
				}

				System.out.println("Enter the password:");
				try {
				    pass = s.next();
				} catch (InputMismatchException e) {
				    System.out.println("Invalid input. Please enter a valid password:");
				    s.next(); // consume the invalid input
				    pass = s.next();
				}

				if (username.equals(a.uname) && pass.equals(a.pass)) {
				    // ... rest of the admin login code
					
					if(username.equals(a.uname) && pass.equals(a.pass)) {
						int adm_c=0;
						//admin area
						while(adm_c==0) {
							
							int choice;
							System.out.println("enter 1 if you want to view account details 2 to see the transaction details 3 to see the withdrawal details 4 to see deposit details");
							choice=s.nextInt();
							switch(choice) {
							  case 1:
							    int acc_nn;
							    System.out.println("enter the account number to view");
							    acc_nn = s.nextInt();
							    a.view_acc_details(u[acc_nn]);
							    break;
							  case 2:
								a.view_transactions(); 
								break;
							  case 3:
								a.view_withdrawals();
							    break;
							  case 4:
								a.view_deposits();
							  default:
							    System.out.println("enter a valid number");
							}
							System.out.println("enter 1 to exit admin page 0 to continue");
							adm_c=s.nextInt();
						}
					}//
					else {
						System.out.println("enter correct cresentials");
					}
					
				} else {
				    System.out.println("Incorrect credentials");
				}
				//use similar approach for handling other inputs like account number, withdraw amount, deposit amount. It will ensure that only valid inputs are given by user and system can process the request.





				
				
				
				
//				String user_n;
//				System.out.println("enter username for admin");
//				String pass_a;
//				user_n = s.next();
//				System.out.println("enter the password");
				
				
				
			}
			else if(adm==2) {
				//t1.start();
				String user_n;
				int acc_num;
				String pass_u;
				System.out.println("enter account number");
				acc_num = s.nextInt();
				System.out.println("enter the user name");
				user_n = s.next();
				System.out.println("enter password");
				pass_u = s.next();
				if(user_n.equals(u[acc_num-1].user_name)&& pass_u.equals(u[acc_num-1].pass)) {
					System.out.println("entered users");
					int cont=0;
					while(cont==0) {
						int choice;
						System.out.println("enter 1 to transfer money to another account using upi");
						System.out.println("enter 2 to transfer money to another account using card");
						System.out.println("enter 3 to withdraw money");
						System.out.println("enter 4 to deposit money");
						System.out.println("enter 5 to view card number");


						choice = s.nextInt();
						
						switch(choice) {
						  case 1:
							int acc_nn;
						    int amt;
						    System.out.println("enter the account number to to transfer");
						    acc_nn = s.nextInt();
						    
						    
							if(acc_nn<=tot && acc_nn!=acc_num) {
								System.out.println("enter the ammount of money you want to transfer");
							    amt=s.nextInt();
								 u[acc_num-1].sendmoney(u[acc_nn-1], u[acc_num-1], amt);
							}
							else {
								System.out.println("entr a valid account number");
							}
						    
						   
						   
						    break;
						  case 2:
						  
						   System.out.println("enter the account number to to transfer");
						   acc_nn = s.nextInt();
						   
					       if(acc_nn<=tot && acc_nn!=acc_num) {
					    	   amt=0;
					    	   c[acc_num-1].sendmoney(u[acc_nn-1], u[acc_num-1], amt);
					    	   System.out.println("enter the ammount of money you want to transfer");
							   amt=s.nextInt();
					    	  
						       u[acc_num-1].sendmoney(u[acc_nn-1], u[acc_num-1], amt);
								}
						   else {
									System.out.println("entr a valid account number");
								}
					       break;
						  case 3:
							System.out.println("enter the ammount of money you want to withdraw");
							amt= s.nextInt();
							u[acc_num].withdraw();
							break;
						  case 4:
						    System.out.println("enter the ammount of money you want to deposit");
							amt= s.nextInt();
							u[acc_num].deposit();
							break;
						  case 5:
							  System.out.println("card number = "+u[acc_num].getCard_details());
							  break;
						  default:
						    System.out.println("enter a valid number");
						}//
						
					System.out.println("enter 1 to exit to continue enter 0 ");
						cont=s.nextInt();
					}
					
				}
				else {
					System.out.println("entered invalid credentials");
				}
			}
			
			
		}
		
		
		
    }        
}