import java.io.*;
import java.util.stream.*;


class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }
}

class Result {

    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        if(llist == null){
            return;
        }
        
        // ITERATIVE APPRAOCH
        SinglyLinkedListNode curr = llist;
        SinglyLinkedListNode prev = null;
        
        while(curr!=null){
            // to save next node because as soon as we change
            // curr.next in next line we'll lose the next node
            SinglyLinkedListNode next = curr.next; 
            
            // change link from pointing to front to now back
            curr.next = prev;
            
            // shift all ahead by one
            // prev becomes curr, curr becomes next
            prev = curr; 
            curr = next;
        }
        
        while(prev!=null){
         System.out.println(prev.data);  
         prev = prev.next; 
        }
        
        // // RECURSIVE APPRAOCH
        // reversePrint(llist.next);
        // System.out.println((Integer)llist.data);
        
    }

}

public class ReverseIterative {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                Result.reversePrint(llist.head);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}