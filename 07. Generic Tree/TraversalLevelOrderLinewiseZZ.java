import java.io.*;
import java.util.*;

public class TraversalLevelOrderLinewiseZZ {
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

  public static void levelOrderLinewiseZZ(Node node){
    // write your code here

    Stack<Node> mst = new Stack<>(); // main stack
    mst.push(node);

    Stack<Node> cst = new Stack<>(); // child stack
    int level = 1;

    while(mst.size() > 0){
        node = mst.pop();
        System.out.print(node.data + " ");

        // This if-else loop tells in which order to add children in child stack
        if(level % 2 == 1){ // odd levels
            for(int i=0; i<node.children.size(); i++){
                Node child = node.children.get(i);
                cst.add(child);
            }
        } 
        else{  // even levels
            for(int i=node.children.size()-1; i>=0; i--){
                Node child = node.children.get(i);
                cst.add(child);
            }
        }
        
        if(mst.size() == 0){       // means that level is over
            mst = cst;             // copy child stack contents to main stack
            cst = new Stack<>();  // restart cst with fresh stack
            level++;
            System.out.println();
        }
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
    levelOrderLinewiseZZ(root);
  }

}