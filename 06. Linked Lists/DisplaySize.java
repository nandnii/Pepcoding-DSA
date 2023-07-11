import java.io.*;

public class DisplaySize {
  public static class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node(val);

      if (size == 0) {
        head = tail = temp;
      } 
      else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size(){
      // write code here
      return size;
    }

    public void display(){
      // write code here
      
      Node temp = head;         // temp variable (of type node) = first node
      while(temp != null){      
        System.out.println(temp.data + " ");
        temp.next = temp;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addLast")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if(str.startsWith("size")){
        System.out.println(list.size());
      } else if(str.startsWith("display")){
        list.display();
      }
      str = br.readLine();
    }
  }
}