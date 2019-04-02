public class Radix{

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data){
    //array of all buckets
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];

    //created a MyLinkedList bucket for each digit
    for(int i = 0; i < 10; i++){
      buckets[i] = new MyLinkedList();
    }

    //determining the largest number in the data array
    int max = 0;
    for(int i = 0; i < data.length; i++) {
      if(data[i] > max){
        max = data[i];
      }
    }
    int passes = (int)Math.log10(max) + 1;//number of passes is number of digits in max value

    //special case?
    if(max == 0){
      passes = 1;
    }
  }

  //parameters are the digit and the position of the digit you want
  //ex. digit(23,0) would return 3, digit(23,1) would return 2
  public static int digit(int num, int pos){
    if(pos == 0){
      return num / 10;
    }
    return (int) (num % Math.pow(10, pos));
  }

  public static void main(String[] args) {
    // System.out.println((int)Math.log10(5) + 1);//1 digit
    // System.out.println((int)Math.log10(3) + 1);//1 digit
    // System.out.println((int)Math.log10(7) + 1);//1 digit
    // System.out.println((int)Math.log10(0) + 1);//weird number
    // System.out.println((int)Math.log10(56) + 1);//2 digit
    // System.out.println((int)Math.log10(45) + 1);//2 digit
    // System.out.println((int)Math.log10(450) + 1);//3 digit

    System.out.println(digit(23,0));
    System.out.println(digit(23,1));

    // System.out.println(23 % 10);
    // System.out.println(23 % 100);
  }

}
