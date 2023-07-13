import java.io.*;
import java.util.*;

public class Display {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList< >();
    }

    public static Node construct(int[] arr) {
      Node root = null;

      Stack< Node> st = new Stack< >();
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

    // Expectation - d(root) will prime self + children
    // Faith - d(children) knows how to print self & children
    public static void display(Node node) {
      // print self + children
      String str = node.data + " -> ";
      
      // to iterate through children
      for (Node child: node.children) {
        str += child.data + ", ";
      }

      // mark the end of that line
      str += "."; 
      System.out.println(str);

      // call display chilren 
      for (Node child : node.children) {
        display(child);
      }
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
    display(root);
  }

}