package com.amrita.jpl.cys21030.project;
package com.amrita.jpl.cys21030.project.welcome;

public class welcome extends Thread {
	public void run() {
		
		
        
        
        int rows =10;            
        for (int i= 0; i<= rows-1 ; i++)
        {
            for (int j=0; j <i; j++)
            {
                System.out.print(" ");
            }
            try {
        		Thread.sleep(500);
        	}catch(Exception e) {}
            for (int k=i; k<=rows-1; k++) { System.out.print("*" + " "); } System.out.println(""); }
        for (int i= rows-1; i>= 0; i--)
        {
            	try {
            		Thread.sleep(500);
            	}catch(Exception e) {}
            for (int j=0; j< i ;j++)
            {
                System.out.print(" ");
            }
            for (int k=i; k<=rows-1; k++)
            {
                System.out.print("*" + " ");
            }
           
            System.out.println("");
        }
        
	}
	public static void main(String[] args) {
		Thread t1 = new welcome();
		t1.start();
	}

}
