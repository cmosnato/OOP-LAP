package HW1;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private ArrayList<AccountBank> accounts;
    private String idATM;

    public ATM(ArrayList<AccountBank> accounts, String idATM) {
        this.accounts = accounts;
        this.idATM = idATM;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true; 

        while (keepRunning) {
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.print("Account ID: ");
            String idInput = scanner.nextLine();
            System.out.print("Account Password: ");
            String pinInput = scanner.nextLine();
            System.out.println();

            
            AccountBank currentAccount = null;
            for (AccountBank account : accounts) {
                if (account.verifyIdAccount(idInput) && account.verifyPassword(pinInput)) { 
                    currentAccount = account;
                    break;
                }
            }

            if (currentAccount != null) { // พบบัญชีที่ตรง
                boolean exitSession = false;
                while (!exitSession) {
                    System.out.println("Account ID: " + currentAccount.getIdAccount());
                    System.out.println("1. Check Balance");
                    System.out.println("2. Withdrawal");
                    System.out.println("3. Exit");
                    System.out.print("Choose : ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // เคลียร์บัฟเฟอร์

                    switch (choice) {
                        case 1: // ตรวจสอบยอดเงิน
                            System.out.println("Non have function");
                            System.out.println();
                            break;
                        case 2: // ถอนเงิน
                            System.out.println("Non have function");
                            System.out.println();
                            break;
                        case 3: // ออกจากเซสชัน 
                            exitSession = true;
                            System.out.println("You have been exit.");
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                            System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid ID or PIN! Please try again.");
                System.out.println();
            }
        }
        scanner.close();
    }
}
