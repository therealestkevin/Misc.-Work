public class hanoi {
    public static void main(String[] args) {
        hanoiRecursion(3, "A", "B", "C");
    }

    public static void hanoiRecursion(int discs, String first, String middle, String last){
        if(discs!=0){
            int newDisc = discs - 1;
            hanoiRecursion(newDisc, first, last, middle);
            System.out.println(discs + " Moves From " + first + " to " + last);
            hanoiRecursion(newDisc, middle, first, last);
        }
    }
}
