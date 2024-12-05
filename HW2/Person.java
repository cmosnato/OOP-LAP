package HW2;

public class Person {
    private String IdCardNum;
    private String Fname;
    private String Lname;
    private String Gender;

    public Person(String IdCardNum, String Fname, String Lname, String Gender) {
        this.IdCardNum = IdCardNum;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Gender = Gender;
    }

    public String getIdCardNum() {
        return IdCardNum;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getGender() {
        return Gender;
    }

    public void setIdCardNum(String idCardNum) {
        IdCardNum = idCardNum;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

}
