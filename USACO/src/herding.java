import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class herding {
     static int[] positionHold;
    private static int min = -1;
    private static int max = -1;
    public static void main (String[]args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        int nums = Integer.parseInt(f.readLine());
        positionHold = new int[nums];
        for(int i=0; i<nums; i++){
            positionHold[i] = Integer.parseInt(f.readLine());
        }

        findMoves(positionHold,nums);

        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("herding.out")));

        out.println(min);
        out.println(max);
        out.close();
        f.close();
    }
    public static void findMoves(int[] inputs, int len)
    {
        // first order the input
        Arrays.sort(inputs);
        // set default min, max
        min = 1001;
        max = 0;
        ArrayList orders = new ArrayList();
        for(int i = 0; i < len; i ++)
        {
            orders.add(inputs[i]);
        }
        findAndUpdateMoves(len, orders, 0);
    }

    private static void findAndUpdateMoves(int len, ArrayList<Integer> orders, int prevMoves)
    {
        // move head
        int first = orders.get(0);
        boolean findMove = false;
        if (orders.get(len-1) - orders.get(1) + 1 >= len)
        {
            // there are valid move
            for (int i = 2; i < len; i++)
            {
                for (int j = orders.get(i-1) + 1; j < orders.get(i); j++)
                {
                    // move head btw i-1 and i
                    ArrayList<Integer> temp = new ArrayList<Integer>(orders);
                    temp.remove(0);
                    temp.add(i-1, j);
                    findMove = true;
                    findAndUpdateMoves(len, temp, prevMoves+1);
                }
            }
        }

        // move tail
        int last = orders.get(len-1);
        if (orders.get(len-2) - orders.get(0) + 1 >= len)
        {
            // there are valid move
            for (int i = 1; i < len - 1; i++)
            {
                for (int j = orders.get(i-1) + 1; j < orders.get(i); j++)
                {
                    // move head btw i-1 and i
                    ArrayList<Integer> temp = new ArrayList<Integer>(orders);
                    temp.remove(len-1);
                    temp.add(i, j);
                    findMove = true;
                    findAndUpdateMoves(len, temp, prevMoves+1);
                }
            }
        }

        if (!findMove)
        {
            // updat max min
            min = Math.min(min, prevMoves);
            max = Math.max(max, prevMoves);
        }
    }
}