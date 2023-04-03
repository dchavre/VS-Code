public class ManageAccount
{
    public static void main(String[] args)
    {
        Account acct1, acct2;
        
        //create account1 for Sally with $1500
        acct1 = new Account("Sally", 1111, 1500);
        
        //create account2 for Joe, account number 2222, with $500
        acct2 = new Account("Joe", 2222, 500);

        //deposit $100 to Joes account.
        acct2.deposit(100);

        //print Joe's new balance 
        System.out.println("Joe's new balance: " + acct2.getBalance());

        //withdraw $500 from Sally's account with a $0 fee
        acct1.withdraw(500, 0);

        //print Sally's new balance
        System.out.println("Sally's new balance: " + acct1.getBalance());

        //charge fees to both accounts
        acct1.chargeFee();
        acct2.chargeFee();
        
        //change the name on Joe's account to Joseph
        acct2.changeName("Joseph");

        //print summary for both accounts
        acct1.printSummary();
        acct2.printSummary();

    }
}
