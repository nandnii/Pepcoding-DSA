import java.io.*;

public class AddLast {

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
      // Write your code here
      Node temp = new Node(val);

      if(size == 0){
        head = tail = temp;
      }

      else{
        tail.next = temp;   // by this prev node starts pointing to current, means they link
        tail = temp;        // by this we update tail value in LL as current (last) node 
      }

      size++;
      
    }
  }

  public static void testList(LinkedList list) {
    for (Node temp = list.head; temp != null; temp = temp.next) {
      System.out.println(temp.data);
    }
    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.data);
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
      } 
      str = br.readLine();
    }

    testList(list);
  }
}