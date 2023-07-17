import java.io.*;
import java.util.*;

public class SizeSumHeightMax {
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

  public static int size(Node node) {
    // write your code here
    if (node == null) {
        return 0;
    }

    int lcsize=0, rcsize=0, s=0;
    lcsize = size(node.left);
    rcsize = size(node.right);

    s = 1 + lcsize + rcsize;
    return s;

  }

  public static int sum(Node node) {
    // write your code here
    if (node == null) {
        return 0;
    }
    int lcsum=0, rcsum=0, sum=0;
    lcsum = sum(node.left);
    rcsum = sum(node.right);

    sum = node.data + lcsum + rcsum;
    return sum;

  }

  public static int max(Node node) {
    // write your code here
    if (node == null) {
        return 0;
    }
    int lcmax=Integer.MIN_VALUE, rcmax=Integer.MIN_VALUE;
    lcmax = max(node.left);
    rcmax = max(node.right);
    int temp_max_val = (lcmax>=rcmax) ? lcmax : rcmax;
    int max_val = (temp_max_val>=node.data) ? temp_max_val : node.data;

    return max_val;
  }

  public static int height(Node node) {
    // write your code here
    if (node == null) {
        return -1;          //  since height = number of max edges; if nodes then return 0
    }

    int lcheight = height(node.left);
    int rcheight = height(node.right);
    int temp_height = (lcheight>=rcheight) ? lcheight : rcheight;
    int height_val = temp_height + 1;

    return height_val;
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

    Node root = construct(arr);

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int ht = height(root);
    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(ht);
  }

}