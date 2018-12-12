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
    if(test_StartValueOfNameOfBank()){
      System.out.println("test_StartValueOfNameOfBank: " + "PASSED");
    } else {
      System.out.println("test_StartValueOfNameOfBank: " + "FAILED");
    }
    if(test_StartValueOfisValid()){
      System.out.println("test_StartValueOfisValid: " + "PASSED");
    } else {
      System.out.println("test_StartValueOfisValid: " + "FAILED");
    }
  }
}
