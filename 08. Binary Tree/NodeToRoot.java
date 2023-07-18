import java.io.*;

import java.util.*;

public class NodeToRoot {
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

    Stack< Pair> st = new Stack< >();
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

  // this function returns whether data present in tree or not
  public static boolean find(Node node, int data) {
    if (node == null) {
      return false;
    }

    if (node.data == data) {                //find self
      return true;
    }

    boolean filc = find(node.left, data);   //find in left child
    if (filc) {
      return true;
    }

    boolean firc = find(node.right, data);
    if (firc) {                             //find in right child
      return true;
    }

    return false;                           //not found anywhere then return 
  }

  // this function will return path from node to root
  public static ArrayList< Integer> nodeToRootPath(Node node, int data) {
    if (node == null) {
      return new ArrayList< >();
    }

    // check if root node is equal then just return that
    if (node.data == data) {
      ArrayList< Integer> list = new ArrayList< >();
      list.add(node.data);
      return list;
    }

    // in child nodes, only consider that path where we get a non empty AL
    // cause that's where we got the data (rest all child will have blank AL)
    ArrayList <Integer> llist = nodeToRootPath(node.left, data);
    if (llist.size() > 0) {
      llist.add(node.data);
      return llist;
    }

    ArrayList <Integer> rlist = nodeToRootPath(node.right, data);
    if (rlist.size() > 0) {
      rlist.add(node.data);
      return rlist;
    }

    // If we fon't get data from any branch/child, return an empty AL
    return new ArrayList< >();
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
    Node root = construct(arr);
    boolean found = find(root, data);
    System.out.println(found);

    ArrayList< Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
  }
}