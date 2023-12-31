import java.io.*;
import java.util.*;

public class Linearize {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static void linearize(Node node){
    // write your code here

    // Children will do the job
    for(Node child: node.children){
        linearize(child);
    }

    // keep looping unless you're left with one child
    while(node.children.size() > 1){    
        Node lastChild = node.children.remove(node.children.size() - 1);    // remove last child
        Node secondLastChild = node.children.get(node.children.size() - 1); // get second last child (since last removed that's why it's size-1) 
        Node secondLastChildTail = getTail(secondLastChild);                // get tail, i.e. last element of the secondLastChild list
        secondLastChildTail.children.add(lastChild);                        // connect tail of secondLastChild with first element of last child
    }
  }

  private static Node getTail(Node node){
    // keep looping/going down unless you keep finding node which have children, 
    // finally you'll stop at leaf, return leaf node i.e. tail
    while(node.children.size() == 1){ 
        node = node.children.get(0);
    }

    return node;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    linearize(root);
    display(root);
  }

}