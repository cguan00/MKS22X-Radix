public class Radix{
  public static void radixsort(int[] data){
    // MyLinkedList<Integer> buckets = new MyLinkedList<Integer>();
    MyLinkedList<Integer> zero = new MyLinkedList<Integer>();

    for(int i = 0; i < data.length; i++){
      int num = data[i];
      int digit = num % 10;//change later to reflect the number of passes you have to go through. use another loop
      zero.add(num);
    }


  }

}
