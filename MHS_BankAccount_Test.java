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

      int totalAmountOfErrors = 0;

    MHS_BankAccount_Test test = new MHS_BankAccount_Test();



    if(!test.testConstructor()){
      System.out.println("FAILED: " + "testConstructor()");
      totalAmountOfErrors++;
    }
    if(!test.testConstructorMaxAmount()){
      System.out.println("FAILED: " + "testConstructorMaxAmount()");
      totalAmountOfErrors++;
    }
    if (totalAmountOfErrors == 0) {
      System.out.println("\nALL PASSED");
  }
}
}
