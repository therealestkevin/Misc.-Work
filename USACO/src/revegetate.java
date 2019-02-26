import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class revegetate {
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        String s = f.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int cows = Integer.parseInt(st.nextToken());
        ArrayList<Integer> firstS = new ArrayList<>();
        ArrayList<Integer> secondS = new ArrayList<>();
        ArrayList<Integer> firstD = new ArrayList<>();
        ArrayList<Integer> secondD = new ArrayList<>();
        int SCount=0;
        int DCount=0;
        for(int i=0; i<cows;i++){
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            if(st2.nextToken().equals("S")){
               SCount++;
               firstS.add(Integer.parseInt(st2.nextToken()));
               secondS.add(Integer.parseInt(st2.nextToken()));

            }else{
                DCount++;
                firstD.add(Integer.parseInt(st2.nextToken()));
                secondD.add(Integer.parseInt(st2.nextToken()));
            }

        }
        String num = NumWays(cows, SCount, firstS, secondS, DCount, firstD, secondD);
        // convert to binary
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("revegetate.out")));

        out.println( num);
        out.close();
        f.close();
    }


    public static String NumWays(int N, int samecount, ArrayList<Integer> same1,  ArrayList<Integer>  same2, int diffcount, ArrayList<Integer>  diff1,  ArrayList<Integer>  diff2)
    {
        // merge same list
        ArrayList<HashSet<Integer>> sameSets = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < samecount; i++)
        {
            // if either same1[i] or same2[i] in any of the existing samesets, add both in
            // else create a new list
            boolean find = false;
            int same1Match = -1;
            int same2Match = -1;
            for (int j = 0; j < sameSets.size(); j++)
            {
                HashSet<Integer> set = sameSets.get(j);
                if (set.contains(same1.get(i)))
                {
                    same1Match = j;
                    find = true;
                }
                if (set.contains(same2.get(i)))
                {
                    same2Match = j;
                    find = true;
                }
            }

            if (find)
            {
                if (same1Match != -1 && same2Match != -1 && same1Match != same2Match)
                {
                    // just merge the existing sets
                    HashSet<Integer> match1 = sameSets.get(same1Match);
                    HashSet<Integer> match2 = sameSets.get(same2Match);
                    match1.addAll(match2);
                    sameSets.remove(same2Match);

                }
                else if (same1Match != -1 && same2Match != -1)
                {
                    // already in
                }
                else if (same1Match != -1)
                {
                    //
                    sameSets.get(same1Match).add(same2.get(i));
                }
                else
                {
                    sameSets.get(same2Match).add(same1.get(i));
                }

            }
            else
            {
                HashSet<Integer> newSet = new HashSet<Integer>();
                newSet.add(same1.get(i));
                newSet.add(same2.get(i));
                sameSets.add(newSet);
            }
        }

        // for diff pairs -- convert to diff sets

        ArrayList<SetPair> pairList = new ArrayList<SetPair>();
        for (int i = 0; i < diffcount; i++)
        {
            // if either same1[i] or same2[i] in any of the existing samesets, add both in
            // else create a new list
            boolean find = false;
            int same1Match = -1;
            int same2Match = -1;
            for (int j = 0; j < sameSets.size(); j++)
            {
                HashSet<Integer> set = sameSets.get(j);
                if (set.contains(diff1.get(i)))
                {
                    same1Match = j;
                    find = true;
                }
                if (set.contains(diff2.get(i)))
                {
                    same2Match = j;
                    find = true;
                }
            }

            if (find)
            {
                if (same1Match != -1 && same2Match != -1 && same1Match != same2Match)
                {
                    // replace test
                    HashSet<Integer> match1 = sameSets.get(same1Match);
                    HashSet<Integer> match2 = sameSets.get(same2Match);
                    SetPair setpair = SetPair.createNew();
                    setpair.first.addAll(match1);
                    setpair.second.addAll(match2);
                    AddSetPair(pairList, setpair);

                }
                else if (same1Match != -1 && same2Match != -1)
                {
                    // this is error and cannot happen
                }
                else if (same1Match != -1)
                {
                    //
                    HashSet<Integer> match1 = sameSets.get(same1Match);
                    SetPair setpair = SetPair.createNew();
                    setpair.first.addAll(match1);
                    setpair.second.add(diff2.get(i));
                    AddSetPair(pairList, setpair);
                }
                else
                {
                    HashSet<Integer> match2 = sameSets.get(same2Match);
                    SetPair setpair = SetPair.createNew();
                    setpair.second.addAll(match2);
                    setpair.first.add(diff1.get(i));
                    AddSetPair(pairList, setpair);
                }

            }
            else
            {
                // not found from same set
                SetPair setpair = SetPair.createNew();
                setpair.first.add(diff1.get(i));
                setpair.second.add(diff2.get(i));
                AddSetPair(pairList, setpair);
            }
        }

        //remove from same pairs any items that already in pairlist
        for (int j = sameSets.size() -1; j >=0; j--)
        {
            HashSet<Integer> same = sameSets.get(j);
            if (containsAny(pairList, same))
            {
                // remove
                sameSets.remove(j);
            }
        }

        String result = "1";
        for (int i = 0; i < pairList.size() + sameSets.size(); i ++)
        {
            result = result + "0";
        }

        for (int m = 1; m <= N; m++)
        {
            // any areas that are not in the list can be any color
            if (!containsAny(pairList, sameSets, m))
            {
                result = result + "0";
            }
        }
        return result;
    }

    private static void AddSetPair(ArrayList<SetPair> pairList, SetPair setpair)
    {
        // process pairlist and merge
        boolean find = false;
        for (int i = 0; i < pairList.size(); i ++)
        {
            SetPair pair = pairList.get(i);
            if (containsAny(pair.first, setpair.first) || containsAny(pair.second, setpair.second))
            {
                // merge
                pair.first.addAll(setpair.first);
                pair.second.addAll(setpair.second);
                find = true;
            }
            else if (containsAny(pair.first, setpair.second) || containsAny(pair.second, setpair.first))
            {
                // merge but swap
                pair.first.addAll(setpair.second);
                pair.second.addAll(setpair.first);
                find = true;
            }
        }

        if (!find)
        {
            pairList.add(setpair);
        }
    }
    private static boolean containsAny(ArrayList<SetPair> pairList, ArrayList<HashSet<Integer>> sameSets, int item)
    {
        for(HashSet<Integer> set : sameSets)
        {
            if (set.contains(item))
            {
                return true;
            }
        }

        for(SetPair pair : pairList)
        {
            if (pair.first.contains(item) || pair.second.contains(item))
            {
                return true;
            }
        }

        return false;

    }
    private static boolean containsAny(ArrayList<SetPair> pairList, HashSet<Integer> set2)
    {
        for(SetPair pair : pairList)
        {
            if (containsAny(pair.first, set2) || containsAny(pair.second, set2))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean containsAny(HashSet<Integer> set1, HashSet<Integer> set2)
    {
        for(int i : set1)
        {
            if (set2.contains(i))
            {
                return true;
            }
        }

        return false;
    }

    private static class SetPair
    {
        public SetPair()
        {
            first = new HashSet<Integer>();
            second = new HashSet<Integer>();
        }

        public static SetPair createNew()
        {
            return new SetPair();
        }

        public HashSet<Integer> first;
        public HashSet<Integer> second;
    }
}

