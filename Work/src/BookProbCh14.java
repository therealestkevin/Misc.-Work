import java.awt.*;
import java.util.*;
import java.util.List;

public class BookProbCh14 {

    public static void main(String[] args) {
        /*Stack<Integer> cur = new Stack<>();
        cur.add(6);
        cur.add(-5);
        cur.add(4);
        cur.add(-1);
        cur.add(1);
        System.out.println("Initial: " + cur);
        Stack<Integer> bob = splitStack(cur);
        System.out.println("Final: " + bob);

       /*int[] scores = {99, 88, 92, 100, 78, 69, 93, 78, 16, 12, 23, 45, 34, 23};
       Queue<Integer> nums = new LinkedList<>();
       for(int i : scores){
           nums.add(i);
       }
       System.out.println(cur);
       System.out.println();
       System.out.println(splitStack(nums));*/

        ArrayList<Double> temps = new ArrayList<Double>();
        temps.add(97.2);
        temps.add(52.8);
        temps.add(52.8);
        temps.add(75.2);
        temps.add(75.2);
        temps.add(75.2);
        temps.add(75.2);temps.add(75.2);temps.add(75.2);
        temps.add(66.1);
        temps.add(66.1);
        temps.add(66.1);
        temps.add(66.1);
        temps.add(66.1);
        temps.add(66.1);
        printSortedTempsByFrequency(temps);




    }
    public static void printSortedTempsByFrequency(ArrayList<Double> temps){
        Map<Double, Integer> counts = new TreeMap<>();
        for(Double i : temps){
            if(counts.containsKey(i)){
                counts.put(i, counts.get(i) + 1);
            }else{
                counts.put(i, 1);
            }
        }

        Map<Integer, ArrayList<Double>> sorted = new TreeMap<>();
        for(Map.Entry<Double, Integer> i : counts.entrySet()){
            if(sorted.containsKey(i.getValue())){
                sorted.get(i.getValue()).add(i.getKey());
            }else{
                ArrayList<Double> newArray = new ArrayList<>();
                newArray.add(i.getKey());
                sorted.put(i.getValue(), newArray);
            }
        }

        for(int i : sorted.keySet()){
            ArrayList<Double> vals = sorted.get(i);
            for(Double j : vals){
                System.out.println(j + ": " + i);
            }
        }

    }

    public static boolean mazeExplorer(int[][]maze){
        Stack<Point> locations = new Stack<>();
        locations.push(new Point(0,0));
        Set<Point> visited = new HashSet<>();
        while(!locations.isEmpty()){
            Point cur = locations.pop();
            if(visited.contains(cur)){
                System.out.println("Visited");
            }else if(maze[(int)cur.getX()][(int)cur.getY()] == 2){
                return true;
            }else{
                for(int i = -1; i <= 1 ; i++){
                    for(int j = -1; j <= 1; j++){
                        if( (int)cur.getX() + i >= 0 && (int)cur.getX() + i < maze.length &&
                                (int)cur.getY() + j >=0 && (int)cur.getY() + j < maze.length){
                            if( maze[(int)cur.getX()+i][(int)cur.getY()+j]!=1 &&((int)cur.getY() + j !=0 && (int)cur.getX() + i !=0 )){
                            locations.push(new Point((int)cur.getX() + i, (int)cur.getY() + j));
                        }

                        }
                    }
                }
                visited.add(cur);
            }
        }
        return false;
    }
    public static boolean equals(Stack<Integer> n, Stack<Integer> n1){
        if(n.size() != n1.size()){
            return false;
        }
        Stack<Integer> storage = new Stack<>();
        while(!n.isEmpty()){
            int one = n.pop();
            int two = n1.pop();
            if(one != two){
                return false;
            }
            storage.push(one);
            storage.push(two);
        }
        while(!storage.isEmpty()){
            n1.push(storage.pop());
            n.push(storage.pop());
        }
        return true;
    }
    public static Stack<Integer> collapse(Stack<Integer> n){
        Stack<Integer> storage = new Stack<>();
        while(!n.isEmpty()){
            storage.add(n.pop() + n.pop());
        }

        while(!storage.isEmpty()){
            n.push(storage.pop());
        }

        return n;
    }
    public static Stack<Integer> copyStack(Stack<Integer> n){
        Queue<Integer> storage = new LinkedList<>();
        Stack<Integer> copiedStack = new Stack<>();

        while(!n.isEmpty()){
            int cur = n.pop();
            copiedStack.push(cur);
        }

        while(!copiedStack.isEmpty()){
            int rmvd = copiedStack.pop();
            n.push(rmvd);
            storage.add(rmvd);
        }

        while(!storage.isEmpty()){
            int rmvd = storage.remove();
            copiedStack.push(rmvd);
        }
        return copiedStack;
    }
    public static Stack<Integer> splitStack(Stack<Integer> n){
        Stack<Integer> finReturn = new Stack<>();
        finReturn.addAll(n);

        Set<Integer> negative = new HashSet<>();
        Set<Integer> nonNegative = new HashSet<>();

        while(!finReturn.isEmpty()){
            int cur = finReturn.pop();
            if(cur>=0){
                nonNegative.add(cur);
            }else{
                negative.add(cur);
            }
        }
        Stack<Integer> splitStak = new Stack<>();
        for(int i : nonNegative){
            splitStak.push(i);
        }
        for(int i : negative){
            splitStak.push(i);
        }


        n = finReturn;

        return splitStak;
    }

    public static Queue<Integer> stutter(Queue<Integer> cur){
        Queue<Integer> doubleCount = new LinkedList<>();
        while(!cur.isEmpty()){

            doubleCount.add(cur.peek());
            doubleCount.add(cur.peek());
            cur.remove();
        }
        while(!doubleCount.isEmpty()){
            cur.add(doubleCount.remove());
        }
        return cur;
    }
}
