package LoginScreen;

import java.util.Scanner;

import Exception.InvalidDecision;

public class Wallet {

	private static double balance=2500;

	public Wallet(double balance) {
		this.balance = balance;
	}

	public static double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static void deposit(double amount) {
        balance += amount;
    }
 
    public static boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public static void manageWallet() {
    	
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("\n My Wallet\n");
    	System.out.println("Your current wallet balance is INR \n"+Wallet.getBalance());
    	
    	
    	System.out.println("Do you want to add more");
    	System.out.println("\\n 1.Yes \\n 2.No");
    	
    	int decide=sc.nextInt();
    	
    	switch(decide) {
    	case 1:
    		System.out.println("Enter the amount(In INR)");
    		double amount=sc.nextDouble();
    		Wallet.deposit(amount);
    		System.out.println("Your wallet balance updated successfully"+"\n"+" Your current balance:INR %.2f\n "+Wallet.getBalance());
    		break;
    	
    	case 2:
    		break;
    		
    	default: 
    		//throw new InvalidDecision();
    		System.out.println("Invalid Decision");
    	}
    }
}
