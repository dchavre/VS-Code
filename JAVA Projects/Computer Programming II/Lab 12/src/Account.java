import java.text.NumberFormat;

public class Account
{
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();

   private final double RATE = 0.045;  // interest rate of 4.5%

   private long acctNumber;
   private double balance;
   private String name;

//_________________________________________________________
   public Account (String owner, long account, double initial)
   {
      name = owner;
      acctNumber = account;
      balance = initial;
   }

//__________________________________________________________ 
   public double deposit (double amount)
   {
      if (amount < 0)  // deposit value is negative
      {
         System.out.println ();
         System.out.println ("Error: Deposit amount is invalid.");
         System.out.println (acctNumber + "  " + fmt.format(amount));
      }
      else
         balance = balance + amount;

      return balance;
   }

//___________________________________________________________
    public double withdraw (double amount, double fee)
   {
      amount += fee;

      if (amount < 0)  // withdraw value is negative
      {
         System.out.println ();
         System.out.println ("Error: Withdraw amount is invalid.");
         System.out.println ("Account: " + acctNumber);
         System.out.println ("Requested: " + fmt.format(amount));
      }
      else if (amount > balance)  // withdraw value exceeds balance
         {
            System.out.println ();
            System.out.println ("Error: Insufficient funds.");
            System.out.println ("Account: " + acctNumber);
            System.out.println ("Requested: " + fmt.format(amount));
            System.out.println ("Available: " + fmt.format(balance));
         }
         else
{
            balance = balance - amount;
}
      return balance;
   }

//____________________________________________________________
   public double addInterest ()
   {
      balance += (balance * RATE);
      return balance;
   }

//_____________________________________________________________
   public double getBalance ()
   {
      return balance;
   }

//______________________________________________________________
   public long getAccountNumber ()
   {
      return acctNumber;
   }

 //_____________________________________________________________
   public String toString ()
   {
      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }

public void printSummary() {
System.out.println("Customer Name: " + name);
System.out.println("Account Number: "  + acctNumber);
System.out.println("Balance: " + balance);
System.out.println();
}
public double chargeFee(){
if (balance < 1000) {
balance -=10;
}
return balance;
}

public void changeName(String newName) { 
name = newName;
}}





