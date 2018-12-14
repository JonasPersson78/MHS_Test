public class MHS_Main_Test {

  static MHS_Main mhsMain = new MHS_Main();

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

  // Test MHS_Main.checkPayment() with non existing account and zero price
  public boolean testCheckPaymentWithNonExistingAccountZeroWithdrawal(String accountNumber) {
    Payment payment = mhsMain.checkPayment(accountNumber, 0);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment() with existing account with not enough money
  public boolean testCheckPaymentWithExistingAccountNotEnoughMoney(
                                                  MHS_Bank bank,
                                                  String accountNumber) {
    bank.setBalanceOfAccount(accountNumber, 29);
    Payment payment = mhsMain.checkPayment(accountNumber, 30);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment() with existing account with precisely right amount of money
  public boolean testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(
                                                  MHS_Bank bank,
                                                  String nameOfBank,
                                                  String accountNumber) {
    bank.setBalanceOfAccount(accountNumber, 30);
    Payment payment = mhsMain.checkPayment(accountNumber, 30);
    return (payment.nameOfBank.equals(nameOfBank) && payment.isValid == true);
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
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"1234\")");
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("1423")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"1423\")");
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("5531")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"5531\")");
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("9951")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"9951\")");
    }

    if(!test.testCheckPaymentWithNonExistingAccount("1234111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"1234111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccount("1423111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"1423111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccount("5531111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"5531111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccount("9951111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"9951111111\")");
    }

    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("1234111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"1234111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("1423111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"1423111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("5531111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"5531111111\")");
    }
    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("9951111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"9951111111\")");
    }

    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.nordea,
                                                               "1234789123")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.nordea, \"1234789123\")");
    }
    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.handelsbanken,
                                                               "1423012345")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.nordea, \"1423012345\")");
    }
    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.seb,
                                                               "5531223445")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.seb, \"5531223445\")");
    }
    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.swedbank,
                                                               "9951618539")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.swedbank, \"9951618539\")");
    }

    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.nordea,
                                                                         "Nordea",
                                                                         "1234789123")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.nordea,\"Nordea\", \"1234789123\")");
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.handelsbanken,
                                                                         "Handelsbanken",
                                                                         "1423012345")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.handelsbanken,\"Handelsbanken\", \"1423012345\")");
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.seb,
                                                                         "SEB",
                                                                         "5531223445")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.seb,\"SEB\", \"5531223445\")");
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.swedbank,
                                                                         "Swedbank",
                                                                         "9951618539")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.swedbank,\"Swedbank\", \"9951618539\")");
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
