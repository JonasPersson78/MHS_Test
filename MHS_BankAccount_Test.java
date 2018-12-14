public class MHS_BankAccount_Test {

  public boolean testConstructor(){
    MHS_BankAccount mhsBankAccount = new MHS_BankAccount("1234567890", 100);
    return (mhsBankAccount.accountNumber == "1234567890" && mhsBankAccount.balance == 100);
  }

  public boolean testConstructorMaxAmount(){
    MHS_BankAccount mhsBankAccount = new MHS_BankAccount("1234567890", 900000);
    return (mhsBankAccount.accountNumber == "1234567890" && mhsBankAccount.balance == 900000);
  }

  public static void main (String[] args) {

    MHS_BankAccount_Test test = new MHS_BankAccount_Test();

    System.out.println("\nFailed tests MHS_BankAccount:");
    if(!test.testConstructor()){
      System.out.println("FAILED: " + "testConstructor()");
    }
    if(!test.testConstructorMaxAmount()){
      System.out.println("FAILED: " + "testConstructorMaxAmount()");
    }
  }
}
