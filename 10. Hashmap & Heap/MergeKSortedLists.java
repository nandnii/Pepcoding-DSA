import java.io.*;
import java.util.*;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair> {
        int listIndex;
        int dataIndex;
        int val;

        Pair(int listIndex, int dataIndex, int val){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> mergeList = new ArrayList<>();
        
        // write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i < lists.size(); i++){                                // loop on lists
            Pair p = new Pair(i, 0, lists.get(i).get(0));   // this will get us 1st memeber (get(0)) of ith list hence all lists
            pq.add(p);                                                      // this will add the pair in PQ
        }

        while(pq.size() > 0){
            Pair p = pq.remove();           // remove pair whose "val" is smallest
            mergeList.add(p.val);           // add this value to mergeList list
            p.dataIndex++;                  // we have to put next member of this list only in the PQ

            if(p.dataIndex < lists.get(p.listIndex).size()){        // check whether there is next element in that list
                p.val = lists.get(p.listIndex).get(p.dataIndex);    // if yes then set it as next value of that list
                pq.add(p);
            }
            
        }

        return mergeList;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }

}