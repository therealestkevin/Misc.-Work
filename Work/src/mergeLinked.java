import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class mergeLinked{
    public static void main(String[] args) {
        Stack<Integer> bob = new Stack<>();
        bob.push(1);
        //System.out.println(bob.peek());
        //System.out.println(bob.pop());
        Queue<Integer> bob1 = new PriorityQueue<>();
                bob1.add(2);
                bob1.add(1);

                for(int a : bob1){
                    System.out.println(a);
                }
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(4);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);
        ListNode result =mergeTwoLists(root, root2);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&l2==null){
            return null;
        }
        ArrayList<Integer> holdNums = new ArrayList<>();
        if(l1!=null){
        holdNums.add(l1.val);
        while(l1.next!=null){
              l1 = l1.next;
              holdNums.add(l1.val);
        }
    }
    if(l2!=null){
        holdNums.add(l2.val);
        while(l2.next!=null){
           
            l2 = l2.next; 
            holdNums.add(l2.val);
        }
    }
        Collections.sort(holdNums);
        ListNode result = new ListNode(holdNums.get(0));
        ListNode resultTracker = result;
        for(int i =1; i<holdNums.size();i++){
            result.next = new ListNode(holdNums.get(i));

            result = result.next;
        }
        System.out.println(holdNums);
        return resultTracker;

        
        
    }


    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
}