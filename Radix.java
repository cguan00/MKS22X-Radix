public class Radix{

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data){
    //array of all buckets. 20 buckets because you have negative numbers as well
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];

    //created a MyLinkedList bucket for each digit
    for(int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList();
    }

    //determining the largest number in the data array
    int max = 0;
    for(int i = 0; i < data.length; i++){
      if(data[i] > max){
        max = data[i];
      }
    }
    int passes = (int)Math.log10(max) + 1;//number of passes is number of digits in max value

    //special case?
    if(max == 0){
      passes = 1;
    }

    //use this to hold the list temporarily
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();

    for(int x = 0; x < passes; x++){
      if(x == 0){
        for(int i = 0; i < data.length; i++){
          int num = data[i];
          int digit = digit(num, x);
          if(num < 0){//if a negative number, place in buckets[9 - digit]
            buckets[9 - digit].add(num);
          } else{//if a positive number, place in buckets[digit + 10];
            buckets[digit + 10].add(num);
          }
        }
      } else{//not first pass, look to temp for the values
        while(temp.size() > 0){
          int num = temp.removeFront();
          int digit = digit(num, x);
          if(num < 0){//if a negative number, place in buckets[9 - digit]
            buckets[9 - digit].add(num);
          } else{//if a positive number, place in buckets[digit + 10];
            buckets[digit + 10].add(num);
          }
        }
      }

      //merging the buckets together
      for(int j = 0; j < buckets.length; j++){
        temp.extend(buckets[j]);
      }
    }

    //putting the complete list back into the original data array
    int index = 0;
    while(temp.size() > 0){
      data[index] = temp.removeFront();
      index++;
    }
  }

  //parameters are the digit and the position of the digit you want
  //ex. digit(23,0) would return 3, digit(23,1) would return 2
  public static int digit(int num, int pos){
    int modFactor = 0;
    int divFactor = 1;
    if(pos == 0){
      modFactor = 10;
    }else{
      modFactor = (int) Math.pow(10, (pos + 1));//10 ^ (pos + 1);
    }
    if(pos == 0){
      divFactor = 1;
    }else{
      divFactor = (int) Math.pow(10, pos);//10 ^ pos;
    }
    return Math.abs(num % modFactor / divFactor);
  }

  //printing array of int for debugging purposes in the driver
  public static String printArray(int[] data){
    String output = "";
    for(int i = 0; i < data.length; i++){
      output += data[i] + ", ";
    }
    return output;
  }

  public static void main(String[] args) {
    // System.out.println((int)Math.log10(5) + 1);//1 digit
    // System.out.println((int)Math.log10(3) + 1);//1 digit
    // System.out.println((int)Math.log10(7) + 1);//1 digit
    // System.out.println((int)Math.log10(0) + 1);//weird number
    // System.out.println((int)Math.log10(56) + 1);//2 digit
    // System.out.println((int)Math.log10(45) + 1);//2 digit
    // System.out.println((int)Math.log10(450) + 1);//3 digit

    // System.out.println(digit(23,0));
    // System.out.println(digit(23,1));

    // System.out.println(23 % 10);//3
    // System.out.println(23 % 100);//23
    // System.out.println(23 % 100 / 10);//2
    // System.out.println();

    // System.out.println(145 % 10);//5
    // System.out.println(145 % 100 / 10);//4
    // System.out.println(145 % 1000 / 100);//1

    // System.out.println((int)Math.pow(10, 1));
    // System.out.println((int)Math.pow(10,(1 + 1)));
    // System.out.println((int)Math.pow(10,(2 + 1)));

    // System.out.println(digit(23,0));//3
    // System.out.println(digit(23,1));//2

    // System.out.println(digit(987654321,0));//1
    // System.out.println(digit(987654321,1));//2
    // System.out.println(digit(987654321,2));//3
    // System.out.println(digit(987654321,3));//4
    // System.out.println(digit(987654321,4));//5
    // System.out.println(digit(987654321,5));//6
    // System.out.println(digit(987654321,6));//7
    // System.out.println(digit(987654321,7));//8
    // System.out.println(digit(987654321,8));//9
    //
    // System.out.println(digit(-46,0));
    // System.out.println(digit(-46,1));



  }

}
