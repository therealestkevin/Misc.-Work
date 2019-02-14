import java.io.*;
import java.util.*;

public class planting {

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("mixmilk.txt"));
       
      int status = Integer.parseInt(f.readLine());
      List<HashSet<Integer>> booling = new ArrayList<>(); 
      List<HashSet<Integer>> neighbors = new ArrayList<>(); 
      for (int i = 0; i < status; i++) {
        booling.add(new HashSet<Integer>());
        neighbors.add(new HashSet<Integer>());
      }
      for (int i = 1; i < status; i++) {
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        booling.get(a).add(b);
        booling.get(b).add(a);
      }
      for (int head = 0; head < status; head++) {
        for (int stat : booling.get(head)) { 
          neighbors.get(head).add(stat);
          for (int roo : booling.get(stat)) { 
            neighbors.get(head).add(roo);
          }
          neighbors.get(head).remove(head); 
        }
      }
      HashMap<Integer, List<Integer>> times = new HashMap<>(); 
      for (int i = 0; i < status; i++) {
        HashSet<Integer> nextDoor = neighbors.get(i);
        int outD = nextDoor.size();
        List<Integer> group = times.get(outD);
        if (group == null) {
          times.put(outD, group = new ArrayList<>());
        }
        group.add(i);
      }
      List<Integer> answers = new ArrayList<>(times.keySet());
      Collections.sort(answers, Comparator.reverseOrder()); 
    
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.txt"))); 
       out.println(workDab(times, neighbors, answers));
   
  }

  public static int workDab(HashMap<Integer, List<Integer>> times, List<HashSet<Integer>> neighbors,
      List<Integer> answers) {
    int[] grasses = new int[neighbors.size()];
    int max = 0;
    for (int outD : answers) {
      List<Integer> roots = times.get(outD);
      for (int head : roots) {
        finale(neighbors, head, grasses);
        max = Math.max(max, grasses[head]);
      }
    }
    return max;
  }

  public static void finale(List<HashSet<Integer>> neighbors, int head, int[] grasses) {
    HashSet<Integer> getRid = new HashSet<>(); 
    HashSet<Integer> nextDoor = neighbors.get(head);
    for (int stat : nextDoor) {
      if (grasses[stat] != 0) {
        getRid.add(grasses[stat]);
      }
    }
    int max = 0;
    for (int u : getRid) {
      max = Math.max(max, u);
    }
    for (int g = 1; g < max; g++) {
      if (!getRid.contains(g)) {
        grasses[head] = g;
        return;
      }
    }
    grasses[head] = max + 1;
  }
}