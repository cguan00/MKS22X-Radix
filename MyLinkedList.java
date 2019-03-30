import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class MyLinkedList<E>{
  private int length;
  private Node start;
  private Node end;

  //constructor
  public MyLinkedList(){
    length = 0;
  }

  //returns size of MyLinkedList
  public int size(){
    return length;
  }

  //accessor method for node
  private Node getNthNode(int index){
    //loop through the list until you get to the target index
    Node current = start;
    for(int i = 0; i < index; i++){
      current = current.next();
    }
    return current;
  }

  //Returns the element at the specified position in this list.
  //IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
  public E get(int index){
    //throw exception if index is out of range
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    //return the integer at the target index
    return getNthNode(index).getData();
  }

  public String toString(){
    String output = "[";
    Node current = start;
    while(current != null){
      output += current.getData() + ", ";
      current = current.next();
    }
    output += "]";
    return output;
  }

  //Appends the specified element to the end of this list.
  public boolean add(E value){
    Node toAdd = new Node(value); //create the Node
    if(length == 0){
      start = toAdd;
      end = toAdd;
    }
    if(length == 1){
      start.setNext(toAdd);
      end = toAdd;
      end.setPrev(start);
    }
    if(length > 1){
      end.setNext(toAdd); //newVal added to the end
      toAdd.setPrev(end); //end is now the second to last value
      end = toAdd; //end of Linked List is newVal
    }
    length++; //size increases by 1 for each new Node
    return true;
  }

  //reset the list to an empty state. Very similar to the constructor.
  public void clear(){
    length = 0;
    start = null;
    end = null;
  }

  // in O(1) time, connect the other list to the end of this list.
  // The other list is then reset to size 0 (do not wipe out the nodes, just disconnect them.)
  // This is how you will merge lists together for your radix sort.
  public void extend(MyLinkedList<E> other){
    if(size() == 0){
      start = other.start;
      end = other.end;
    }else{
      length += other.size();//add the lengths together
      end = other.end;//new end is the end of the other list

      end.setNext(other.start);//connect the end of this list to the start of the other list
      other.start.setPrev(end);//connect the end of this list to the start of the other list

      other.length = 0;//length of other list becomes 0 (like deleting it)
      other.start = null;//like clearing the other list
      other.end = null;//like clearing the other list
    }
  }

  // remove the 1st element of the list, and return that value.
  public E removeFront(){
    if(size() == 0){//an empty list
      throw new NoSuchElementException();
    }
    E temp = start.getData();
    if(size() == 1){//if only one Node in list
      start = null;//start is null
      return temp;
    }
    start = getNthNode(1);//Node at index 1 is now the start
    start.setPrev(null);//no Nodes before the start
    length--;//decrease length by 1
    return temp;
  }


  private class Node{
    private E data;
    private Node next, prev;

    //constructors
    public Node(E value){
      data = value;
    }

    public Node(E value, Node nextNode, Node prevNode){
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

    public E getData(){
      return data;
    }

    public E setData(E i){
      data = i;
      return data;
    }

    public String toString(){
      return data + "";
    }

  }


}
