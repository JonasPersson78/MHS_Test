public class MHS_Main_Test {

  MHS_Main mhsMain = new MHS_Main();

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

  // Test MHS_Main.checkPayment() with existing account with equal of money PASS/TRUE OBS! Corret name of Bank.

  // Test MHS_Main.checkPayment() with existing account when ticketprice is 0 and balance is 0 PASS/TRUE OBS! Corret name of Bank.

  // Test MHS_Main.checkPayment() Free ticket with none existing account. FAILED/FALSE and empty String.

  public static void main (String[] args) {
    MHS_Main_Test test = new MHS_Main_Test();
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
  }
}
