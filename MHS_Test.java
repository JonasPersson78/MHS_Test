public class MHS_Test{

  MHS_Main mhsMain = new MHS_Main();

  // Test MHS_Main.checkPayment with non existing bank

  // Test MHS_Main.checkPayment() with non existing account
  public boolean testCheckPaymentWithNonExistingAccount() {
    Payment payment = mhsMain.checkPayment("1234111111", 15);
    return (payment.nameOfBank.equals("Nordea") && payment.isValid == false);
  }

  // Test MHS_Main.checkPayment() with existing account with non enough money

  // Test MHS_Main.checkPayment() with existing account with enough money
  public static void main (String[] args) {
    MHS_Test test = new MHS_Test();
    if(test.testCheckPaymentWithNonExistingAccount()) {
      System.out.println("PASSED: " + "testCheckPaymentWithNonExistingAccount()");
    } else {
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingAccount()");
    }
  }
}
