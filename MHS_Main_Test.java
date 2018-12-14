public class MHS_Main_Test {

  MHS_Main mhsMain = new MHS_Main();

  // Test MHS_Main.checkPayment with non existing bank
  public boolean testCheckPaymentWithNonExistingBank() {
    Payment payment = mhsMain.checkPayment("1235111111", 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment with invalid accountNumber
  public boolean testCheckPaymentWithInvalidAccountNumber(String accountNumber) {
    Payment payment = mhsMain.checkPayment(accountNumber, 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment() with non existing account
  public boolean testCheckPaymentWithNonExistingAccount(String accountNumber) {
    Payment payment = mhsMain.checkPayment(accountNumber, 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  

  /* old way

  // Test MHS_Main.checkPayment with non existing bank, Try with none existig 4 first digits. FAILED/FALSE and empty String.

  // Test MHS_Main.checkPayment() with non existing account
  public boolean testCheckPaymentWithNonExistingAccount() {
    Payment payment = mhsMain.checkPayment("1234111111", 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment() with existing account with not enough money
  public boolean testCheckPaymentWithExistingAccount_NotEnoughMoney() {
    Payment payment = mhsMain.checkPayment("1234678912", 100);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment() with existing account with too much money. PASS/TRUE OBS! Corret name of Bank.
  public boolean testCheckPaymentWithExistingAccount_tooMuchMoney() {
    Payment payment = mhsMain.checkPayment("1234912345", 5000);
    return (payment.nameOfBank.equals("") && payment.isValid == true);
  }

  // Test MHS_Main.checkPayment() with existing account with equal of money PASS/TRUE OBS! Corret name of Bank.

  // Test MHS_Main.checkPayment() with existing account when ticketprice is 0 and balance is 0 PASS/TRUE OBS! Corret name of Bank.

  // Test MHS_Main.checkPayment() Free ticket with none existing account. FAILED/FALSE and empty String.*/

  public static void main (String[] args) {
    MHS_Main_Test test = new MHS_Main_Test();

    System.out.println("\n");
    if(!test.testCheckPaymentWithNonExistingBank()){
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingBank()");
    }

    if(!test.testCheckPaymentWithInvalidAccountNumber("1234")){
      System.out.println("FAILED: " + "test.testCheckPaymentWithInvalidAccountNumber(\"1234\")");
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("1423")){
      System.out.println("FAILED: " + "test.testCheckPaymentWithInvalidAccountNumber(\"1423\")");
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("5531")){
      System.out.println("FAILED: " + "test.testCheckPaymentWithInvalidAccountNumber(\"5531\")");
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("9951")){
      System.out.println("FAILED: " + "test.testCheckPaymentWithInvalidAccountNumber(\"9951\")");
    }

    if(!test.testCheckPaymentWithNonExistingAccount("1234111111")){
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingAccount(\"1234111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccount("1423111111")){
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingAccount(\"1423111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccount("5531111111")){
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingAccount(\"5531111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccount("9951111111")){
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingAccount(\"9951111111\")");
    }




    /* old way
    if(test.testCheckPaymentWithExistingAccount_NotEnoughMoney()) {
      System.out.println("PASSED: " + "testCheckPaymentWithExistingAccount_NotEnoughMoney()");
    } else {
      System.out.println("FAILED: " + "testCheckPaymentWithExistingAccount_NotEnoughMoney()");
    }

    if(test.testCheckPaymentWithNonExistingAccount()) {
      System.out.println("PASSED: " + "testCheckPaymentWithNonExistingAccount()");
    } else {
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingAccount()");
    }

    if(test.testCheckPaymentWithExistingAccount_tooMuchMoney()) {
    System.out.println("FAILED:  "+ "testCheckPaymentWithExistingAccount_tooMuchMoney");
    } else {
    System.out.println("PASSED:  "+ "testCheckPaymentWithExistingAccount_tooMuchMoney");
  }*/
  }
}
