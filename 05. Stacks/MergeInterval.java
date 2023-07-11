import java.util.*;

class Interval {
    int start;
    int end;
 
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
 
//Merge intervals
public class MergeInterval {
 
    public static List<Interval> mergeInterval(List<Interval> intervals) {
 
        //If list has less than two elements, then there is nothing to merge
        // [[1,4]] for example
        if(intervals.size() < 2) {
            return intervals;
        }

        ArrayList<Interval> output = new ArrayList<>();

        //Sort the interval on the basis of start attribute
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        //Take interval present at 0th element, i.e. 1st [x,y]
        Interval temp = intervals.get(0);
        int start = temp.start;
        int end = temp.end;

        //Traverse a list
        for(int i = 1; i < intervals.size(); i++) {
            temp = intervals.get(i); //ith [x,y], i.e. firstly 2nd then 3rd

            if(temp.start <= end) {
                end = Math.max(end, temp.end);
            } 
            else {
                output.add(new Interval(start, end));
                start = temp.start;
                end = temp.end;
            }
        }

        // Execited after if
        output.add(new Interval(start, end));
        return output;
    }
 
    public static void main(String[] args) {
 
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(6, 9));
 
        List<Interval> output = mergeInterval(input);

        for(Interval result : output) {
            System.out.println(result.start + " " + result.end);
        }
    }
}

// Leetcode solution - https://leetcode.com/problems/merge-intervals/solutions/3366909/java-o-n-no-sorting-verbose-code-comments/
// Alt - https://leetcode.com/problems/merge-intervals/solutions/3008939/super-easily-understandable-java-sol/
