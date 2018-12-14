public class Payment_Test{
  public static Payment pay = new Payment();

  public static boolean test_StartValueOfNameOfBank(){
    String temp = pay.nameOfBank;
    if(temp.equals("")){
      return true;
    }
    return false;
  }

  public static boolean test_StartValueOfisValid(){
    boolean temp = pay.isValid;
    if(temp == false){
      return true;
    }
    return false;
  }

    public static void main(String[] args){
    int totalAmountOfErrors = 0;
    if(!test_StartValueOfNameOfBank()){
      System.out.println("test_StartValueOfNameOfBank: " + "FAILED");
      totalAmountOfErrors++;
    }
    if(!test_StartValueOfisValid()){
      System.out.println("test_StartValueOfisValid: " + "FAILED");
      totalAmountOfErrors++;
    }

    if (totalAmountOfErrors == 0) {
      System.out.println("\nALL PASSED");
    }
  }
}
