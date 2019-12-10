import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SeniorAssasin {
    public static void main(String[] args) throws IOException {
        BufferedReader objReader = new BufferedReader(new
                FileReader("assasin.txt"));
        List<String> allPlayers = new ArrayList<>();
        String curLine;
        while(( curLine = objReader.readLine()) != null){
            allPlayers.add(curLine);
        }
        Collections.shuffle(allPlayers);
        LinkedAssasin allNodes = new LinkedAssasin();
        for(String s : allPlayers){
            allNodes.add(s);
        }
        Set<String> graveyard = new HashSet<>();
        Scanner assasinScanner = new Scanner(System.in);
        printNodes(allNodes.getFront());
        System.out.println();
        System.out.println("Who Has Been Killed? (Type 'grave' to get the killed)");
        while(allNodes.size() > 1 && assasinScanner.hasNextLine()){
            String line = assasinScanner.nextLine();
            if(line.equals("grave")){

                System.out.println("Graveyard: " + graveyard);
            }else{
                String n = allNodes.remove(line);
                if(n.equals("Invalid Name")){
                    System.out.println("Invalid Name");
                }else{
                    graveyard.add(n);
                }
            }

            printNodes(allNodes.getFront());
            System.out.println();
            System.out.println("Who Has Been Killed? (Type 'grave' to get the killed)");
        }
        System.out.println("Winner: " + allNodes.getFront().name);
    }

    public static void printNodes(LinkedAssasin.AssasinNode root){
        LinkedAssasin.AssasinNode cur = root;
        while(cur != null){
            System.out.print(cur.name + " ");
            cur = cur.next;
        }
    }
}
