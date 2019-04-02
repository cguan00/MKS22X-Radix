public class Radix{

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];

    //determining the largest number in the data array
    int max = 0;
    for(int i = 0; i < data.length; i++) {
      if(data[i] > max){
        max = data[i];
      }
    }

    //created a MyLinkedList bucket for each digit
    for(int i = 0; i < 10; i++){
      buckets[i] = new MyLinkedList();
    }



  }

}
