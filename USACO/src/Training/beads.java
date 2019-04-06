
/*
ID: kevinxu4
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.Arrays;

public class beads {

    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        int numBeads = Integer.parseInt(f.readLine());
        String beadOrder = f.readLine();
        char[] beadChars = new char[numBeads*2];
        for(int i=0; i<numBeads;i++){
            beadChars[i]=beadOrder.charAt(i);
            beadChars[numBeads+i] = beadOrder.charAt(i);
        }
        boolean condition=true;
        System.out.println(Arrays.toString(beadChars));
        int maxAnswer = -1;
        for(int i=numBeads-1; i<beadChars.length;i++){
            int curCount=0;
            char cur = beadChars[i];
            char cur2 = beadChars[i-1];
            if(i>=1){

            }
            if(i-1<0){
                curCount++;
            }else{

                    char tempChar = cur2;
                    boolean status=true;
                    boolean isW =true;
                    int counter=1;
                    while(status){
                        if(i-counter==-1){
                            status=false;
                        }else if(beadChars[i-counter]!='w'&&isW){
                            isW=false;
                            tempChar=beadChars[i-counter];
                        }else if(isW){
                            counter++;
                            curCount++;
                        }

                        if(i-counter==-1&&!isW){
                            status=false;
                        }else if(!isW){
                            if(beadChars[i-counter]==tempChar||beadChars[i-counter]=='w'){
                                curCount++;
                            }else{
                                status=false;
                            }
                            counter++;
                        }
                    }
                }


            if(i+1==beadChars.length){
                curCount++;
            }else{

                    char tempChar = cur;
                    boolean status=true;
                    boolean isW =true;
                    int counter=0;
                    while(status){
                        if(i+counter==beadChars.length){
                            status=false;
                        }else if(beadChars[i+counter]!='w'&&isW){
                            isW=false;
                            tempChar=beadChars[i+counter];
                        }else if(isW){
                            counter++;
                            curCount++;
                        }

                        if(i+counter==beadChars.length&&!isW){
                            status=false;
                        }else if(!isW){
                            if(beadChars[i+counter]==tempChar||beadChars[i+counter]=='w'){
                                curCount++;
                            }else{
                                status=false;
                            }
                            counter++;
                        }
                    }
                }


            if(curCount>=numBeads){
                maxAnswer=numBeads;
                condition=false;
            }
            if(curCount>maxAnswer&&condition){
                maxAnswer=curCount;
            }
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        //System.out.println(maxAnswer);
        out.println(maxAnswer);
        out.close();
        f.close();

    }
}
