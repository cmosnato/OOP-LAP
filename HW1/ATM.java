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
        boolean keepRunning = true; // ใช้สำหรับควบคุมการทำงานของโปรแกรม

        while (keepRunning) { // ลูปหลักที่ทำงานจนกว่าจะปิดโปรแกรม
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.print("Account ID: ");
            String idInput = scanner.nextLine();
            System.out.print("Account Password: ");
            String pinInput = scanner.nextLine();

            // ค้นหาบัญชีที่ตรงกับ ID และ PIN
            AccountBank currentAccount = null;
            for (AccountBank account : accounts) {
                if (account.verifyIdAccount(idInput) && account.verifyPassword(pinInput)) { 
                    currentAccount = account;
                    break;
                }
            }

            if (currentAccount != null) { // พบบัญชีที่ตรง
                boolean exitSession = false; // ควบคุมการทำงานในเซสชันของผู้ใช้
                while (!exitSession) {
                    System.out.println("\n1. Check Balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // เคลียร์บัฟเฟอร์

                    switch (choice) {
                        case 1: // ตรวจสอบยอดเงิน
                            System.out.println("Non have function");
                            break;
                        case 2: // ถอนเงิน
                            System.out.println("Non have function");
                            break;
                        case 3: // ออกจากเซสชัน (กลับไปหน้า Login)
                            exitSession = true;
                            System.out.println("You have been exit.");
                            break;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid ID or PIN! Please try again.");
            }
        }
        scanner.close();
    }

    // public void AddAccountBanktoAtm() {
    // Scanner scanner2 = new Scanner(System.in);

    // System.out.println("Add a new Account to ATM");

    // // รับค่า Account ID
    // System.out.print("Enter Account ID: ");
    // String accountId = scanner2.nextLine();

    // // รับค่า Account Name
    // System.out.print("Enter Account Name: ");
    // String accountName = scanner2.nextLine();

    // // รับค่า Password
    // System.out.print("Enter Password: ");
    // String password = scanner2.nextLine();

    // // รับค่า Balance
    // System.out.print("Enter Initial Balance: ");
    // double balance = scanner2.nextDouble();
    // scanner2.nextLine(); // เพื่อจัดการ newline ที่เหลือ

    // // สร้างออบเจกต์ AccountBank ใหม่
    // AccountBank newAccount = new AccountBank(accountId, accountName, password,
    // balance);

    // // เพิ่มบัญชีใหม่ลงใน ArrayList
    // accounts.add(newAccount);

    // System.out.println("Account added successfully!");
    // }

}
