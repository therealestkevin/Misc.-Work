import java.util.List;

public class addTwo {
    public static void main(String[]args){
        ListNode root = new ListNode(1);
        root.next = new ListNode(9);
        root.next.next = new ListNode(9);
        root.next.next.next = new ListNode(9);
        root.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode root2 = new ListNode(9);

       ListNode answer= addTwo(root,root2);



    }
    public static ListNode addTwo(ListNode l1, ListNode l2){
        ListNode root = new ListNode((l1.val + l2.val)%10);

        ListNode cur = root;
        boolean carryOver = false;
        if((l1.val+l2.val)>=10){
            carryOver=true;
        }

        while(l1.next!=null||l2.next!=null||carryOver){


            if(l1.next == null){
                l1.next = new ListNode(0);
            }
            if(l2.next == null){
                l2.next = new ListNode(0);
            }

          if(carryOver){
                if(l1.next.val+l2.next.val+1>=10){
                    carryOver=true;

                }else{
                    carryOver=false;
                }
                root.next = new ListNode((l1.next.val+l2.next.val+1)%10);
                l1 = l1.next;
                l2 = l2.next;
                root = root.next;
            }else{
                if(l1.next.val+l2.next.val>=10){
                    carryOver=true;

                }else{
                    carryOver=false;
                }
                root.next = new ListNode((l1.next.val+l2.next.val)%10);
                 l1 = l1.next;
                l2 = l2.next;
                 root = root.next;
            }
        }
        return cur;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return new ListNode(0);
        }
        int first =0;
        first+=l1.val;
        int counter=1;
        while (l1.next!=null){
            l1= l1.next;
            first+= (int)(l1.val * Math.pow(10,counter));

            counter++;
        }

        int second =0;
        second+=l2.val;
        int counter2=1;
        while (l2.next!=null) {
            l2= l2.next;
            second+= (int)(l2.val * Math.pow(10,counter2));

            counter2++;
        }

        int result = first + second;
        System.out.println(first);
        System.out.println(second);
        ListNode root = new ListNode(result%10);
        ListNode cur = root;
        while(result>=10){
            result/=10;
            root.next = new ListNode(result%10);
            root = root.next;


        }
        return cur;



    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
