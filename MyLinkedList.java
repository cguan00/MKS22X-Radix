import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class MyLinkedList{
  private int length;
  private Node start;
  private Node end;
  private List<Integer> data;

  //constructor
  public MyLinkedList(){
    length = 0;
    data = new ArrayList<Integer>();
  }

  //adds Node to MyLinkedList
  public boolean add(Integer value){
    data.add(value);
    Node newVal = new Node(value); //create the Node
    if(length == 0){
      start = newVal;
      end = newVal;
    }
    if(length == 1){
      start.setNext(newVal);
      end = newVal;
      end.setPrev(start);
    }
    if(length > 1){
      end.setNext(newVal); //newVal added to the end
      newVal.setPrev(end); //end is now the second to last value
      end = newVal; //end of Linked List is newVal
    }
    length++; //size increases by 1 for each new Node
    return true;
  }

  //returns size of MyLinkedList
  public int size(){
    return length;
  }

  public String toString(){
    if(length == 0){
      return "[]";
    }
    String output = "[";
    Node current = start;
    while(current != null){
      output += current.getData() + ", ";
      current = current.next();
    }
    return output + "]";
  }

  public Integer get(int index){
    return 1;
  }

  private class Node{
    private int data;
    private Node next, prev;

    //constructors
    public Node(int value){
      data = value;
    }

    public Node(int value, Node nextNode, Node prevNode){
      data = value;
      next = nextNode;
      prev = prevNode;
    }

    public Node next(){
      return next;
    }

    public Node prev(){
      return prev;
    }

    public void setNext(Node other){
      next = other;
    }

    public void setPrev(Node other){
      prev = other;
    }

    public Integer getData(){
      return data;
    }

    public Integer setData(Integer i){
      data = i;
      return data;
    }

    public String toString(){
      return data + "";
    }

  }


}
