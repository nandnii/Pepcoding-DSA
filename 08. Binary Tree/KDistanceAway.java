import java.io.*;
import java.util.*;

public class KDistanceAway {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  // Use Node To Root Path code (here AL is of node type)
  public static ArrayList<Node> nodeToRootPath(Node node, int data) {
    if (node == null) {
      return new ArrayList< >();
    }

    if (node.data == data) {
      ArrayList<Node> list = new ArrayList< >();
      list.add(node);
      return list;
    }

    ArrayList <Node> llist = nodeToRootPath(node.left, data);
    if (llist.size() > 0) {
      llist.add(node);
      return llist;
    }

    ArrayList <Node> rlist = nodeToRootPath(node.right, data);
    if (rlist.size() > 0) {
      rlist.add(node);
      return rlist;
    }

    return new ArrayList< >();
  }

  // Use K Level Down code
  public static void printKLevelsDown(Node node, int k, Node blocker){
    // write your code here
    if(node == null || k < 0 || node == blocker){
      return;
    }

    if(k==0){
        System.out.println(node.data);
        return;
    }

    printKLevelsDown(node.left, k-1, blocker);
    printKLevelsDown(node.right, k-1, blocker);
  }

  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here

    // 1. Get NTR path for data
    ArrayList<Node> n2rpath = nodeToRootPath(node, data);
    
    // 2. Get k level down for each node in path
    for(int i=0; i<n2rpath.size(); i++){
        // if(distance < 0) break;
        // Node blockage = (i == 0) ? null : n2rpath.get(i - 1);    
        // printKLevelsDown(n2rpath.get(i), distance, blockage);
        // distance--;
        // Node block = (i == 0) ? null : n2rpath.get(i - 1);
        printKLevelsDown(n2rpath.get(i), k-i, i==0 ? null : n2rpath.get(i-1));
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}