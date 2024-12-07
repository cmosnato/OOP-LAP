package HW2;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM implements ActionATM {
    private ArrayList<Account> accounts = new ArrayList<>(); // สร้าง instance
    private Manager manager; // ต้องกำหนดค่าในภายหลัง
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        if (atm.manager == null) {
            atm.AddManager();
        }
        System.out.println("Login Maneger ATM ComputerThanyaburi Bank");
        System.out.print("Manager ID: ");
        String idlogM = scanner.nextLine();
        System.out.print("Manager Password: ");
        String passlogM = scanner.nextLine();
        System.out.println();

        Manager currentAccountManager = null;
        if (atm.manager.verifyIdAccount(idlogM) && atm.manager.verifyPassword(passlogM)) {
            currentAccountManager = atm.manager;
        }
        if (currentAccountManager != null) {

            System.out.print("Enter amount of all account = ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            while (amount < 1 || amount > 5) {
                System.out.println("Invalid amount! Please enter a value between 1 and 5.");
                System.out.print("Please enter value again: ");
                amount = scanner.nextInt();
                scanner.nextLine(); // เคลียร์บัฟเฟอร์
            }

            System.out.println("Enter Detail of each account.");
            for (int count = 0; count < amount; count++) {
                System.out.println("NO." + (count + 1));

                System.out.print("Enter Your FirstName: ");
                String FnAcc = scanner.nextLine();
                System.out.print("Enter Your LastName: ");
                String LnAcc = scanner.nextLine();
                System.out.print("Enter Your ID CardNumber: ");
                String IdCardNAcc = scanner.nextLine();
                while (IdCardNAcc.length() != 13) {
                    System.out.println("Please validate ID Cardnumber to ensure it has exactly 13 digits");
                    System.out.print("Please enter Your ID Cardnumber again: ");
                    IdCardNAcc = scanner.nextLine();
                }
                System.out.print("Enter Your Gender (Male or Female)?: ");
                String GenderAcc = scanner.nextLine();
                System.out.println("Please Setup account");
                System.out.print("Enter ID: ");
                String IdAcc = scanner.nextLine();
                System.out.print("Enter Password: ");
                String PassAcc = scanner.nextLine();
                System.out.print("Balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine();
                while (balance < 1 || balance > 1000000) {
                    System.out.println("Invalid Balance! Please enter a balance between 1 and 1,000,000.");
                    balance = scanner.nextDouble();
                    System.out.print("Balance: ");
                    scanner.nextLine(); // เคลียร์บัฟเฟอร์
                }

                // เพิ่มบัญชีใหม่ลงใน ArrayList
                atm.AddAccount(new Account(IdAcc, FnAcc, LnAcc, GenderAcc, IdAcc, PassAcc, balance));
                System.out.println();
            }
        }
        atm.Start(); // เรียกใช้เมธอดเริ่มต้น
        scanner.close();
    }

    public void Start() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.print("Account ID: ");
            String idInput = scanner.nextLine();
            System.out.print("Account Password: ");
            String pinInput = scanner.nextLine();
            System.out.println();

            Account currentAccount = null;
            for (Account account : this.accounts) {
                if (account.verifyIdAccount(idInput) && account.verifyPassword(pinInput)) {
                    currentAccount = account;
                    break;
                }
            }

            if (currentAccount != null) { // พบบัญชีที่ตรง
                boolean exitSession = false;
                while (!exitSession) {
                    System.out.println("ATM ComputerThanyaburi Bank");
                    System.out.println("Account ID: " + currentAccount.getId());
                    System.out.println("1. Check Balance");
                    System.out.println("2. Withdrawable");
                    System.out.println("3. Depositeable");
                    System.out.println("4. Transferable");
                    System.out.println("5. Logout");
                    System.out.print("Choose : ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // เคลียร์บัฟเฟอร์

                    switch (choice) {
                        case 1:
                            Check(currentAccount);
                            System.out.println();
                            break;
                        case 2:
                            System.out.print("How many Withdraw: ");
                            Double withdraw = scanner.nextDouble();
                            scanner.nextLine();
                            if (currentAccount.getBalance() >= withdraw) {
                                Withdraw(currentAccount, withdraw);
                                System.out.println();
                                break;
                            } else
                                System.out.println("There is not enough money in the account.");
                                break;
                        case 3:
                            System.out.print("How many Deposite: ");
                            Double deposite = scanner.nextDouble();
                            scanner.nextLine();
                            Deposite(currentAccount, deposite);
                            System.out.println();
                            break;
                        case 4:
                            System.out.print("What Id you want Transfer: ");
                            String IdTransfer = scanner.nextLine();
                            System.out.print("How many you want Transfer: ");
                            Double amountTransfer = scanner.nextDouble();
                            scanner.nextLine();
                            Account AccountTransfer = null;
                            for (Account Searchaccount : accounts) {
                                if (Searchaccount.getId().equals(IdTransfer)) {
                                    AccountTransfer = Searchaccount;
                                }
                            }
                            if (AccountTransfer != null ) {
                                if (AccountTransfer.getBalance()>=amountTransfer) {
                                    Transfer(currentAccount, AccountTransfer, amountTransfer);
                                    System.out.println();
                                    break;  
                                }else System.out.println("There is not enough money in the account.");
                                break;
                            } else
                                System.out.println("There not have ID you want to transfer.");
                                break;
                        case 5:
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

    public void AddManager() {
        System.out.println("Hello,Please add manager information");
        System.out.print("Enter Your FirstName: ");
        String Fn = scanner.nextLine();
        System.out.print("Enter Your LastName: ");
        String Ln = scanner.nextLine();
        System.out.print("Enter Your ID CardNumber: ");
        String IdCardN = scanner.nextLine();
        while (IdCardN.length() != 13) {
            System.out.println("Please validate ID Cardnumber to ensure it has exactly 13 digits");
            System.out.print("Please enter Your ID Cardnumber again: ");
            IdCardN = scanner.nextLine();
        }
        System.out.print("Enter Your Gender (Male or Female)?: ");
        String gender = scanner.nextLine();
        System.out.println("Please Setup manager account");
        System.out.print("Enter ID: ");
        String IdManager = scanner.nextLine();
        System.out.print("Enter Password: ");
        String PassManager = scanner.nextLine();

        manager = new Manager(IdCardN, Fn, Ln, gender, IdManager, PassManager);
        System.out.println("Manager added successfully.");
        System.out.println();
    }

    public void AddAccount(Account NewAccount) {
        this.accounts.add(NewAccount);
    }

    public void Check(Account NowAccount) {
        System.out.println("Your balance now is:" + NowAccount.getBalance());
    }

    public void Withdraw(Account NowAccount, Double amount) {
        Double Nowbalance = NowAccount.getBalance() - amount;
        System.out.println("You Withdraw :" + amount);
        NowAccount.setBalance(Nowbalance);
        System.out.println("Your balance now is:" + NowAccount.getBalance());
    }

    public void Deposite(Account NowAccount, Double amount) {
        Double Nowbalance = NowAccount.getBalance() + amount;
        System.out.println("You Deposite :" + amount);
        NowAccount.setBalance(Nowbalance);
        System.out.println("Your balance now is:" + NowAccount.getBalance());
    }

    public void Transfer(Account NowAccount, Account ToAccount, Double amount) {
        Double Mainbalance = NowAccount.getBalance() - amount;
        NowAccount.setBalance(Mainbalance);
        Double Tobalance = ToAccount.getBalance() + amount;
        ToAccount.setBalance(Tobalance);
        System.out.println("ID :" + NowAccount.getId() + " balance now is:" + NowAccount.getBalance());
        System.out.println("ID :" + ToAccount.getId() + " balance now is:" + ToAccount.getBalance());
    }

}
