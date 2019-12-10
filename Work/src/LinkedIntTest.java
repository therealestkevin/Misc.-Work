public class LinkedIntTest {
    public static void main(String[] args) {
        LinkedIntList bob = new LinkedIntList();
        bob.add(2);
        bob.add(10);
        bob.add(12);
        bob.add(15);
        bob.add(15);
        bob.add(12);

        printNodes(bob.getFront());
        System.out.println();
        System.out.println(bob.lastIndexOf(12));
    }

    public static void printNodes(LinkedIntList.LinkNode root){
        LinkedIntList.LinkNode cur = root;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
