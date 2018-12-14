public class MHS_Bank_Test {
  MHS_Bank mhsBank = new MHS_Bank();

  public boolean testAddAccountAddsCorrectData() {
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return (mhsBank.accountList.get(0).accountNumber == "1234567890" &&
           mhsBank.accountList.get(0).balance == 100);
  }

  public boolean testAddAccountAddsCorrectDataMaxAmount() {
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 900000);
    return (mhsBank.accountList.get(0).accountNumber == "1234567890" &&
           mhsBank.accountList.get(0).balance == 900000);
  }

  public boolean testSetStateEmptyAccountList(){
    mhsBank.addAccount("1234567890", 100);
    mhsBank.addAccount("1234567891", 150);
    mhsBank.setStateEmptyAccountList();
    return mhsBank.accountList.size() == 0;
  }

  public boolean testIndexIsLessThanSizeOfListWithSmallerIndexThanSize(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.indexIsLessThanSizeOfList(0);
  }

  public boolean testIndexIsLessThanSizeOfListWithSameIndexAsSize(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return !mhsBank.indexIsLessThanSizeOfList(1);
  }

  public boolean testIndexIsLessThanSizeOfListWithSameIndexAsSizeEmptyList(){
    mhsBank.setStateEmptyAccountList();
    return !mhsBank.indexIsLessThanSizeOfList(0);
  }

  public boolean testIndexIsLessThanSizeOfListWithGreaterIndexThanSize(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return !mhsBank.indexIsLessThanSizeOfList(2);
  }

  public boolean testgetIndexOfAccountNonExistentAccountNonEmptyList(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.accountList.size() == mhsBank.getIndexOfAccount("1234567891");
  }

  public boolean testgetIndexOfAccountNonExistentAccountEmptyList(){
    mhsBank.setStateEmptyAccountList();
    return mhsBank.accountList.size() == mhsBank.getIndexOfAccount("1234567890");
  }

  public boolean testgetIndexOfAccountExistentAccount(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.accountList.size() > mhsBank.getIndexOfAccount("1234567890");
  }

  public boolean testGetBalanceOfIndexExistentIndex() {
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.getBalanceOfIndex(0) == 100;
  }

  public boolean testGetBalanceOfIndexNonExistentIndexNonEmptyList() {
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.getBalanceOfIndex(1) == -1;
  }

  public boolean testGetBalanceOfIndexNonExistentIndexEmptyList() {
    mhsBank.setStateEmptyAccountList();
    return mhsBank.getBalanceOfIndex(0) == -1;
  }

  public boolean testSetBalanceOfAccountExistentAccount(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    mhsBank.setBalanceOfAccount("1234567890", 150);
    return mhsBank.accountList.get(0).balance == 150;
  }

  public boolean testSetBalanceOfAccountExistentAccountMaxAmount(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    mhsBank.setBalanceOfAccount("1234567890", 900000);
    return mhsBank.accountList.get(0).balance == 900000;
  }

  public boolean testTryPaymentExistentAccountEnoughMoney(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.tryPayment("1234567890", 99)
           && mhsBank.accountList.get(0).balance == 1;
  }

  public boolean testTryPaymentExistentAccountEnoughMoneyBorderline(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return mhsBank.tryPayment("1234567890", 100)
           && mhsBank.accountList.get(0).balance == 0;
  }

  public boolean testTryPaymentExistentAccountEnoughMoneyBorderLineZeroWithdrawal(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 0);
    return mhsBank.tryPayment("1234567890", 0)
           && mhsBank.accountList.get(0).balance == 0;
  }

  public boolean testTryPaymentExistentAccountEnoughMoneyBorderLineMaxWithdrawal(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 900000);
    return mhsBank.tryPayment("1234567890", 900000)
           && mhsBank.accountList.get(0).balance == 0;
  }

  public boolean testTryPaymentExistentAccountNotEnoughMoney(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return !mhsBank.tryPayment("1234567890", 101)
           && mhsBank.accountList.get(0).balance == 100;
  }

  public boolean testTryPaymentNonExistentAccountNonEmptyList(){
    mhsBank.setStateEmptyAccountList();
    mhsBank.addAccount("1234567890", 100);
    return !mhsBank.tryPayment("1234567891", 0);
  }

  public boolean testTryPaymentNonExistentAccountEmptyList(){
    mhsBank.setStateEmptyAccountList();
    return !mhsBank.tryPayment("1234567891", 0);
  }

  public static void main(String[] args) {
    MHS_Bank_Test test = new MHS_Bank_Test();
    System.out.println("\nFailed tests MHS_Bank_Test:");
    if(!test.testAddAccountAddsCorrectData()) {
        System.out.println("FAILED: " + "testAddAccountAddsCorrectData()");
    }
    if(!test.testAddAccountAddsCorrectDataMaxAmount()) {
        System.out.println("FAILED: " + "testAddAccountAddsCorrectDataMaxAmount()");
    }
    if(!test.testSetStateEmptyAccountList()) {
        System.out.println("FAILED: " + "testSetStateEmptyAccountList()");
    }
    if(!test.testIndexIsLessThanSizeOfListWithSmallerIndexThanSize()) {
        System.out.println("FAILED: " + "testIndexIsLessThanSizeOfListWithSmallerIndexThanSize()");
    }
    if(!test.testIndexIsLessThanSizeOfListWithSameIndexAsSize()) {
        System.out.println("FAILED: " + "testIndexIsLessThanSizeOfListWithSameIndexAsSize()");
    }
    if(!test.testIndexIsLessThanSizeOfListWithSameIndexAsSizeEmptyList()) {
        System.out.println("FAILED: " + "testIndexIsLessThanSizeOfListWithSameIndexAsSizeEmptyList()");
    }
    if(!test.testIndexIsLessThanSizeOfListWithGreaterIndexThanSize()) {
        System.out.println("FAILED: " + "testIndexIsLessThanSizeOfListWithGreaterIndexThanSize()");
    }
    if(!test.testgetIndexOfAccountNonExistentAccountNonEmptyList()) {
        System.out.println("FAILED: " + "testgetIndexOfAccountNonExistentAccountNonEmptyList()");
    }
    if(!test.testgetIndexOfAccountNonExistentAccountEmptyList()) {
        System.out.println("FAILED: " + "testgetIndexOfAccountNonExistentAccountEmptyList()");
    }
    if(!test.testgetIndexOfAccountExistentAccount()) {
        System.out.println("FAILED: " + "testgetIndexOfAccountExistentAccount()");
    }
    if(!test.testGetBalanceOfIndexExistentIndex()) {
        System.out.println("FAILED: " + "testGetBalanceOfIndexExistantAccount()");
    }
    if(!test.testGetBalanceOfIndexNonExistentIndexNonEmptyList()) {
        System.out.println("FAILED: " + "testGetBalanceOfIndexNonExistentIndexNonEmptyList()");
    }
    if(!test.testGetBalanceOfIndexNonExistentIndexEmptyList()) {
        System.out.println("FAILED: " + "testGetBalanceOfIndexNonExistentIndexEmptyList()");
    }
    if(!test.testSetBalanceOfAccountExistentAccount()) {
        System.out.println("FAILED: " + "testSetBalanceOfAccountExistentAccount()");
    }
    if(!test.testSetBalanceOfAccountExistentAccountMaxAmount()) {
        System.out.println("FAILED: " + "testSetBalanceOfAccountExistentAccountMaxAmount()");
    }
    if(!test.testTryPaymentExistentAccountEnoughMoney()) {
        System.out.println("FAILED: " + "testTryPaymentExistentAccountEnoughMoney()");
    }
    if(!test.testTryPaymentExistentAccountEnoughMoneyBorderline()) {
        System.out.println("FAILED: " + "testTryPaymentExistentAccountEnoughMoneyBorderline()");
    }
    if(!test.testTryPaymentExistentAccountEnoughMoneyBorderLineZeroWithdrawal()) {
        System.out.println("FAILED: " + "testTryPaymentExistentAccountEnoughMoneyBorderLineZeroWithdrawal()");
    }
    if(!test.testTryPaymentExistentAccountEnoughMoneyBorderLineMaxWithdrawal()) {
        System.out.println("FAILED: " + "testTryPaymentExistentAccountEnoughMoneyBorderLineMaxWithdrawal()");
    }
    if(!test.testTryPaymentExistentAccountNotEnoughMoney()) {
        System.out.println("FAILED: " + "testTryPaymentExistentAccountNotEnoughMoney()");
    }
    if(!test.testTryPaymentNonExistentAccountNonEmptyList()) {
        System.out.println("FAILED: " + "testTryPaymentNonExistentAccountNonEmptyList()");
    }
    if(!test.testTryPaymentNonExistentAccountEmptyList()) {
        System.out.println("FAILED: " + "testTryPaymentNonExistentAccountEmptyList()");
    }
  }
}
