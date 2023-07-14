import java.io.*;
import java.util.*;

public class TraversalPrePost {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
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

  public static void traversals(Node node){
    // write your code here

    // AREA 1 = Node Pre / Euler's left / While going in recursion
    System.out.println("Node Pre " + node.data);
    for (Node child : node.children) {

        // Edge Pre
        System.out.println("Edge Pre " + node.data + "--" + child.data);

        // CALL
        traversals(child);

        // Edge Post
        System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    // AREA 2 = Node Post / Euler's right / While coming out of recursion
    System.out.println("Node Post " + node.data);
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
    traversals(root);
  }

}