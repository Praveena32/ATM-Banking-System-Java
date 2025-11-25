import java.util.Scanner;

class Bank_Account {

    String accholdername;
    String username;
    String password;
    String accno;
	String acctype;
    int transactions = 0;
    String transactionHistory = "";
    double balance;
	double overdraft;

    public void register() {
        Scanner s = new Scanner(System.in);

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("      Welcome to the Northern Bank");
        System.out.println("═══════════════════════════════════════\n");
        
        System.out.print("Enter the Account holder's name: ");
        this.accholdername = s.nextLine();
        
        System.out.print("Enter your username: ");
        this.username = s.nextLine();
        
        System.out.print("Enter your password: ");
        this.password = s.nextLine();
        
        System.out.print("Enter the Account Number: ");
        this.accno = s.nextLine();
		
		System.out.print("Enter the Account Type(Current or Savings): ");
        this.acctype = s.nextLine();
        
        System.out.print("Enter initial deposite: ");
        this.balance = s.nextDouble();
        
        System.out.println("\n Registration Successful!\n");
        System.out.println("Please log in to your bank account\n");
    }

    public boolean login() {
        boolean islogin = false;
        Scanner s = new Scanner(System.in);

        while (!islogin) {
            System.out.print("Enter your username: ");
            String user = s.nextLine();
            
            if (user.equals(username)) {
                System.out.print("Enter your password: ");
                String pass = s.nextLine();
                
                if (pass.equals(password)) {
                    System.out.println("\n Login Successful!\n");
                    islogin = true;
                } else {
                    System.out.println(" Incorrect password! Try again.\n");
                }
            } else {
                System.out.println(" Incorrect username! Try again.\n");
            }
        }
        return islogin;
    }

    public void deposite() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("            DEPOSIT");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter Amount to Deposit: Rs.");
        
        Scanner s = new Scanner(System.in);
        double amount = s.nextDouble();

        try {
            if (amount >= 100.00) {
                transactions++;
                balance = balance + amount;
                System.out.println("\n Transaction Successful!");
                System.out.println("Amount Deposited: Rs." + amount);
                System.out.println("Current Balance: Rs." + balance + "\n");
                
                String str = transactions + ". Rs." + amount + " deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\n Sorry. Minimum deposit amount is Rs.100.00\n");
            }
        } catch (Exception e) {
            System.out.println("\n Invalid input!\n");
        }
    }

    public void withdraw() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("           WITHDRAWAL");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter Amount to Withdraw: Rs.");
        
        Scanner s = new Scanner(System.in);
        double amount = s.nextDouble();
		
		if(acctype.equals("Savings")){
        try {
            if (balance >= amount) {
                transactions++;
                balance = balance - amount;
                System.out.println("\n Transaction Successful!\n");
                System.out.println("Amount Withdrawn: Rs." + amount);
                System.out.println("Current Balance: Rs." + balance + "\n");
                
                String str = transactions + ". Rs." + amount + " withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\n Insufficient Balance\n");
            }
        } catch (Exception e) {
            System.out.println("\n Invalid input!\n");
        }
		}
		else{
			try {
            if (balance >= amount) {
                transactions++;
                balance = balance - amount;
                System.out.println("\n Transaction Successful!");
                System.out.println("Amount Withdrawn: Rs." + amount);
                System.out.println("Current Balance: Rs." + balance + "\n");
                
                String str = transactions + ". Rs." + amount + " withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            }
			else if(balance<amount && amount<=50000){
				transactions++;
                balance = balance  - amount;
				overdraft =0- balance;
                System.out.println("\n Transaction Successful!");
                System.out.println("Amount Withdrawn: Rs." + amount+"\n");
                System.out.println("Current Balance: Rs." + balance);
				System.out.println("Overdrafted amount: Rs."+overdraft+"\n");
                
                String str = transactions + ". Rs." + amount + " withdrawn and Rs."+overdraft+" Overdrafted\n";
                transactionHistory = transactionHistory.concat(str);
            }
			else {
                System.out.println("\n Overdraft limit exceeded!\n");
            }
        } catch (Exception e) {
            System.out.println("\n Invalid input!\n");
        }
			
    }
	}

    public void transfer() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("            TRANSFER");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter Recipient's name: ");
        
        Scanner s = new Scanner(System.in);
        String recipient = s.nextLine();
        
        System.out.print("Enter amount to transfer: Rs.");
        double amount = s.nextDouble();

        try {
            if (balance >= amount) {
                if (amount <= 50000.00) {
                    transactions++;
                    balance = balance - amount;
                    System.out.println("\n Transaction Successful!");
                    System.out.println("Amount Transferred: Rs." + amount);
                    System.out.println("Recipient: " + recipient);
                    System.out.println("Current Balance: Rs." + balance + "\n");
                    
                    String str = transactions + ". Rs." + amount + " transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\n Transaction maximum amount limit is Rs.50,000.00\n");
                }
            } else {
                System.out.println("\n Insufficient Balance\n");
            }
        } catch (Exception e) {
            System.out.println("\n Invalid input!\n");
        }
    }

    public void check_balance() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         BALANCE INQUIRY");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Account Holder: " + accholdername);
        System.out.println("Account Number: " + accno);
        System.out.println("Current Balance: Rs." + balance + "\n");
    }

    public void transaction_history() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("       TRANSACTION HISTORY");
        System.out.println("═══════════════════════════════════════");
        
        if (transactions == 0) {
            System.out.println("No Previous Transactions.\n");
        } else {
            System.out.println(transactionHistory);
            System.out.println("Total Transactions: " + transactions + "\n");
        }
    }
}

public class ATMinterface_BankIndia {

    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
                flag = true;

                if (flag && (input > limit || input < 1)) {
                    System.out.println(" Choose a number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(" Enter only integer value.");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String args[]) {

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║     Welcome to Bank of India ATM Interface                    ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.print("\nChoose one option: ");
        
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            Bank_Account bacc = new Bank_Account();
            bacc.register();
            
            while (true) {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("\nEnter your choice: ");
                
                int ch = takenIntegerInput(2);
                
                if (ch == 1) {
                    if (bacc.login()) {
                        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
                        System.out.println("║     Welcome Back " + bacc.accholdername + "!"+               "║");  
                        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
                        
                        boolean isFinished = false;
                        
                        while (!isFinished) {
                            System.out.println("\n─────────────────────────────────────");
                            System.out.println("           MAIN MENU");
                            System.out.println("─────────────────────────────────────");
                            System.out.println("1. Withdrawal");
                            System.out.println("2. Deposit");
                            System.out.println("3. Transfer");
                            System.out.println("4. Check Balance");
                            System.out.println("5. Transaction History");
                            System.out.println("6. Exit");
                            System.out.print("\nEnter your choice: ");
                            
                            int choice = takenIntegerInput(6);

                            switch (choice) {
                                case 1:
                                    bacc.withdraw();
                                    break;

                                case 2:
                                    bacc.deposite();
                                    break;

                                case 3:
                                    bacc.transfer();
                                    break;

                                case 4:
                                    bacc.check_balance();
                                    break;

                                case 5:
                                    bacc.transaction_history();
                                    break;

                                case 6:
                                    isFinished = true;
                                    System.out.println("\n Thank you for using Bank of India ATM!");
                                    System.out.println("Have a great day!\n");
                                    break;
                            }
                        }
                    }
                } else {
                    System.out.println("\n Thank you for visiting Bank of India!");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("\n Thank you for visiting Bank of India!");
            System.exit(0);
        }
    }
} 