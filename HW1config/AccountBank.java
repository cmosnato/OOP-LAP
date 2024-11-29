package HW1config ;

public class AccountBank {
    private String nameAccount;
    private String idAccount;
    private String pin;
    private Double balance;

    public AccountBank(String name, String id, String pin , Double balance) {
        this.nameAccount = name;
        this.idAccount = id;
        this.pin = pin;
        this.balance = balance;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getPin() {
        return pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean verifyPassword(String pinInput) {
        // แสดงค่าที่ป้อนเข้ามา
        return pin.equals(pinInput.trim());  // ใช้ trim() เพื่อเอาช่องว่างออก
    }
    
    public boolean verifyIdAccount(String idInput) {
        // แสดงค่าที่ป้อนเข้ามา
        return idAccount.equals(idInput.trim());  // ใช้ trim() เพื่อเอาช่องว่างออก
    }
    
}