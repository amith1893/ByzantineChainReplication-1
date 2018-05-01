package bc3.src.client;

import java.io.Console;
import java.util.Scanner;

public class ConsoleBankAccount {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: ConsoleClient for Banking management <client id>");
            System.exit(0);
        }

        MapClient client = new MapClient(Integer.parseInt(args[0]));
        Console console = System.console();

        Scanner sc = new Scanner(System.in);

        while (true) {
	    System.out.println("1. Add bank account");
	    System.out.println("2. Get balance from an account");
	    System.out.println("3. Add money to account");
	    System.out.println("4. Withdraw money from account");

            int cmd = sc.nextInt();

	    switch(cmd){
		case 1:
			System.out.println("Adding a bank account to the database");
			String id = console.readLine("Enter the account name");
                        int balance = Integer.parseInt(console.readLine("Enter the money to deposit"));
                        String result = client.put(id, Integer.toString(balance));
       			System.out.println("Previous value: " + result);
			break;
		case 2:
			System.out.println("Reading account balance");
			id = console.readLine("Enter the account id");
			result = client.get(id);
			System.out.println("Account balance for is " +result);
			break;
		case 3:
			System.out.println("Adding money to account");
			id = console.readLine("Enter the account id");
			int deposit = Integer.parseInt(console.readLine("Enter the money to deposit"));
			balance = Integer.parseInt(client.get(id));
			result = client.put(id, Integer.toString(deposit + balance));
			System.out.println("Deposited successfully! New balance is "+ client.get(id));
			break;
		case 4:
			System.out.println("Withdrawing money from account");
			id = console.readLine("Enter the account id");
			int withdrawal = Integer.parseInt(console.readLine("Enter the money to withdraw"));	
			balance = Integer.parseInt(client.get(id));
			if(balance > withdrawal)
			{
				result = client.put(id, Integer.toString(balance - withdrawal));
				System.out.println("Withdrawal successfull! New balance is "+ client.get(id));
			}
			else
			{
				System.out.println("Insufficient funds in the account. Try again with lower amount");
			}
			break;
		case 5:
                    	System.out.println("Getting total number of accounts");
                    	int size = client.size();
                    	System.out.println("Total accounts: " + size);
			break;
	    }
        }
    }
}
