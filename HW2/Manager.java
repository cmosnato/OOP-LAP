package HW2;

public class Manager extends Person {
    private String Id ;
    private String Password ;

    public Manager(String IdCardNum, String Fname, String Lname, String Gender, String id, String password) {
        super(IdCardNum, Fname, Lname, Gender);
        this.Id = id;
        this.Password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public boolean verifyPassword(String Passcheck) {
        // แสดงค่าที่ป้อนเข้ามา
        return Password.equals(Passcheck);  // ใช้ trim() เพื่อเอาช่องว่างออก
    }
    
    public boolean verifyIdAccount(String IdCheck) {
        // แสดงค่าที่ป้อนเข้ามา
        return Id.equals(IdCheck);  // ใช้ trim() เพื่อเอาช่องว่างออก
    }
}
