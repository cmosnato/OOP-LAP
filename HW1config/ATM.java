package HW1config;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        // สร้าง ArrayList สำหรับเก็บบัญชี
        ArrayList<AccountBank> accounts = new ArrayList<>();
        // รับข้อมูลบัญชีจากผู้ใช้
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of all account = ");
        int amount = scanner.nextInt();
        scanner.nextLine();  // เคลียร์บัฟเฟอร์หลังจาก nextInt()
        
        // ตรวจสอบเงื่อนไขของ amount
        while (amount < 1 || amount > 5) {
            System.out.println("Invalid amount! Please enter a value between 1 and 5.");
            System.out.print("Please enter value again: ");
            amount = scanner.nextInt();
            scanner.nextLine();  // เคลียร์บัฟเฟอร์
        }
        
        System.out.println("Enter Detail of each account.");
        for (int count = 0; count < amount; count++) {
            System.out.println("NO." + (count + 1));
            
            System.out.print("Enter Account ID: ");
            String accountId = scanner.nextLine();
            // ตรวจสอบความยาวของ Account ID
            while (accountId.length() != 13) {
                System.out.println("Invalid Account ID! Please enter Account ID not over 13 characters.");
                System.out.print("Enter Account ID: ");
                accountId = scanner.nextLine();
            }

            System.out.print("Enter Account Name: ");
            String accountName = scanner.nextLine();
            // ตรวจสอบความยาวของ Account Name
            while (accountName.length() > 51) {
                System.out.println("Invalid Account Name! Please enter Account Name not over 50 characters.");
                System.out.print("Enter Account Name: ");
                accountName = scanner.nextLine();
            }

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            // ตรวจสอบความยาวของ Password
            while (password.length()!=4) {
                System.out.println("Invalid Password! Please enter Password not over 4 characters.");
                System.out.print("Enter Password: ");
                password = scanner.nextLine();
            }

            System.out.print("Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();  
            while (balance < 1 || balance > 1000000) {
                System.out.println("Invalid Balance! Please enter a balance between 1 and 1,000,000.");
                balance = scanner.nextDouble();
                System.out.print("Balance: ");
                scanner.nextLine();  // เคลียร์บัฟเฟอร์
            }
            
            // เพิ่มบัญชีใหม่ลงใน ArrayList
            accounts.add(new AccountBank(accountName, accountId, password, balance));
            System.out.println();
        }
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
