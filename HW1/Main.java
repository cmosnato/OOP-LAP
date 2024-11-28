package HW1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
            while (accountId.length() != 14) {
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

        // สร้าง ATM ด้วยบัญชีที่เตรียมไว้
        ATM atm = new ATM(accounts, "ATMCPERMUTT");

        // เริ่มต้นการทำงานของ ATM
        atm.start();

        scanner.close();
    }
}
