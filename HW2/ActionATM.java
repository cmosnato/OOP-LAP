package HW2;
public interface ActionATM {
    public void Start();
    public void AddManager();
    public void AddAccount(Account NewAccount);
    public void Check(Account NowAccount);
    public void Withdraw(Account NowAccount, Double amount);
    public void Deposite(Account NowAccount, Double amount);
    public void Transfer(Account NowAccount,Account ToAccount,Double amount);
}
