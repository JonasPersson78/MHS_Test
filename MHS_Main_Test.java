public class MHS_Main_Test {

  static MHS_Main mhsMain = new MHS_Main();

  public boolean testCheckPaymentWithNonExistingBank() {
    Payment payment = mhsMain.checkPayment("1235111111", 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  public boolean testCheckPaymentWithInvalidAccountNumber(String accountNumber) {
    Payment payment = mhsMain.checkPayment(accountNumber, 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  public boolean testCheckPaymentWithNonExistingAccount(String accountNumber) {
    Payment payment = mhsMain.checkPayment(accountNumber, 15);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  public boolean testCheckPaymentWithNonExistingAccountZeroWithdrawal(String accountNumber) {
    Payment payment = mhsMain.checkPayment(accountNumber, 0);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  public boolean testCheckPaymentWithExistingAccountNotEnoughMoney(
                                                  MHS_Bank bank,
                                                  String accountNumber) {
    bank.setBalanceOfAccount(accountNumber, 29);
    Payment payment = mhsMain.checkPayment(accountNumber, 30);
    return (payment.nameOfBank.equals("") && payment.isValid == false);
  }

  public boolean testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(
                                                  MHS_Bank bank,
                                                  String nameOfBank,
                                                  String accountNumber) {
    bank.setBalanceOfAccount(accountNumber, 30);
    Payment payment = mhsMain.checkPayment(accountNumber, 30);
    return (payment.nameOfBank.equals(nameOfBank) && payment.isValid == true);
  }

  public boolean testCheckPaymentWithExistingAccountAndEnoughMoney(
                                                  MHS_Bank bank,
                                                  String nameOfBank,
                                                  String accountNumber) {
    bank.setBalanceOfAccount(accountNumber, 31);
    Payment payment = mhsMain.checkPayment(accountNumber, 30);
    return (payment.nameOfBank.equals(nameOfBank) && payment.isValid == true);
  }

  public boolean testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(
                                                  MHS_Bank bank,
                                                  String nameOfBank,
                                                  String accountNumber) {
    bank.setBalanceOfAccount(accountNumber, 0);
    Payment payment = mhsMain.checkPayment(accountNumber, 0);
    return (payment.nameOfBank.equals(nameOfBank) && payment.isValid == true);
  }

  public static void main (String[] args) {
    MHS_Main_Test test = new MHS_Main_Test();
    int totalAmountOfErrors = 0;
    System.out.println("\n");

    if(!test.testCheckPaymentWithNonExistingBank()){
      System.out.println("FAILED: " + "testCheckPaymentWithNonExistingBank()");
        totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithInvalidAccountNumber("1234")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"1234\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("1423")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"1423\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("5531")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"5531\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithInvalidAccountNumber("9951")){
      System.out.println("FAILED: " +
      "test.testCheckPaymentWithInvalidAccountNumber(\"9951\")");
        totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithNonExistingAccount("1234111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"1234111111\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithNonExistingAccount("1423111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"1423111111\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithNonExistingAccount("5531111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"5531111111\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithNonExistingAccount("9951111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccount(\"9951111111\")");
        totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("1234111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"1234111111\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("1423111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"1423111111\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("5531111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"5531111111\")");
        totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithNonExistingAccountZeroWithdrawal("9951111111")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithNonExistingAccountZeroWithdrawal(\"9951111111\")");
        totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.nordea,
                                                               "1234789123")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.nordea, \"1234789123\")");
      totalAmountOfErrors++;

    }
    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.handelsbanken,
                                                               "1423012345")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.nordea, \"1423012345\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.seb,
                                                               "5531223445")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.seb, \"5531223445\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.swedbank,
                                                               "9951618539")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountNotEnoughMoney(mhsMain.swedbank, \"9951618539\")");
      totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.nordea,
                                                                         "Nordea",
                                                                         "1234789123")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.nordea,\"Nordea\", \"1234789123\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.handelsbanken,
                                                                         "Handelsbanken",
                                                                         "1423012345")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.handelsbanken,\"Handelsbanken\", \"1423012345\")");
      totalAmountOfErrors++;
    }

    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.seb,
                                                                         "SEB",
                                                                         "5531223445")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.seb,\"SEB\", \"5531223445\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.swedbank,
                                                                         "Swedbank",
                                                                         "9951618539")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoneyBorderline(mhsMain.swedbank,\"Swedbank\", \"9951618539\")");
      totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.nordea,
                                                                         "Nordea",
                                                                         "1234789123")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.nordea,\"Nordea\", \"1234789123\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.handelsbanken,
                                                                         "Handelsbanken",
                                                                         "1423012345")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.handelsbanken,\"Handelsbanken\", \"1423012345\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.seb,
                                                                         "SEB",
                                                                         "5531223445")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.seb,\"SEB\", \"5531223445\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.swedbank,
                                                                         "Swedbank",
                                                                         "9951618539")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountAndEnoughMoney(mhsMain.swedbank,\"Swedbank\", \"9951618539\")");
      totalAmountOfErrors++;
    }


    if(!test.testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.nordea,
                                                                         "Nordea",
                                                                         "1234789123")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.nordea,\"Nordea\", \"1234789123\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.handelsbanken,
                                                                         "Handelsbanken",
                                                                         "1423012345")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.handelsbanken,\"Handelsbanken\", \"1423012345\")");
      totalAmountOfErrors++;
    }
    if(!test.testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.seb,
                                                                         "SEB",
                                                                         "5531223445")){
      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.seb,\"SEB\", \"5531223445\")");
      totalAmountOfErrors++;

    }
    if(!test.testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.swedbank,
                                                                         "Swedbank",
                                                                         "9951618539")){

      System.out.println("FAILED: " +
      "testCheckPaymentWithExistingAccountZeroWithdrawalBorderline(mhsMain.swedbank,\"Swedbank\", \"9951618539\")");
      totalAmountOfErrors++;
    }

    if (totalAmountOfErrors == 0) {
      System.out.println("ALL PASSED");
    }
  }
}
