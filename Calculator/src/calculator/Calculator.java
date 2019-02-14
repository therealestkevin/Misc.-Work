/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xukev20
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        calcExecute();    }
    public static boolean isInteger( String input )  
{  
   try  
   {  
      Integer.parseInt( input );  
      return true;  
   }  
   catch( Exception e )  
   {  
      return false;  
   }  
}
    public static boolean isDouble( String input )  
{  
   try  
   {  
     Double.parseDouble( input );  
      return true;  
   }  
   catch( Exception e )  
   {  
      return false;  
   }  
}
    public static Double executeOrder66(String billy, Double first, Double second,int status){
        if(status==2) {
        	switch(billy){
            case "+":
               return first+second;
            case "-":
                return first-second;
            case "*":
                return first*second;
            case "/":
                return first/second;
            case "^":
                return Math.pow(first, second);
        }
        }else if(status==1) {
        	switch(billy){
        	case "|":
        		return Math.abs(first);
        	case "v":
        		return Math.sqrt(first);
        	case "s":
        		return Math.sin(first);
        	case "c":
        		return Math.cos(first);
        	case "t":
        		return Math.tan(first);
        		
        	}
        	}
        
    	
        
        
        return 0.0;
    }
    public static void calcExecute(){
        System.out.println("Welcome to the IB CS Calculator \n");
    Scanner sc=new Scanner(System.in);
    boolean status=false;
    while(status==false){
        try{
           
            System.out.println("Enter an expression, or quit to exit:");
            String input=sc.nextLine();
            String delim=" ";
            StringTokenizer sc2=new StringTokenizer(input,delim);
        
            if(input.equalsIgnoreCase("quit")){
                System.out.println("CALL CHEF MORNERY \n-------END-------");
                break;
            }  
            Double first=null;
            
            Double second=null;
            String operator="";
            while(sc2.hasMoreTokens()){
                String i=sc2.nextToken();
                if(isInteger(i)==true&&first==null ){
                   first=((double)Integer.parseInt(i));
                }else if(isInteger(i)==true && first!=null) {
                	second=((double)Integer.parseInt(i));
                }
                else if(isDouble(i)==true&&first==null){
                   first=Double.parseDouble(i);
                }else if(isDouble(i)==true&&first!=null) {
                	second=Double.parseDouble(i);
                }
                else if(i.equalsIgnoreCase("+")||i.equalsIgnoreCase("-")||i.equalsIgnoreCase("*")
                        ||i.equalsIgnoreCase("/")||i.equalsIgnoreCase("^")||i.equalsIgnoreCase("|")
                        ||i.equalsIgnoreCase("t")||i.equalsIgnoreCase("c")||i.equalsIgnoreCase("s")
                        ||i.equalsIgnoreCase("~")||i.equalsIgnoreCase("v")){
                   operator=i;
                }else{
                    System.out.println("Invalid Input");
                }
              
                
            }
            	System.out.println("Operands: "+first+" & "+second + "\n");
                System.out.println("Operators: "+operator + "\n");
               
            int state=0;
            if(first==null&&second==null) {
            	System.out.println("Invalid Input");
            }else if(first!=null&&second==null) {
            	state=1;
            }else if(first!=null&&second!=null) {
            	state=2;
            }
            if(operator.equals("~")&&state==1) {
            	System.out.println("Answer: "+input+" = "+Math.round(first)+"\n");
            }else {
            	System.out.println("Answer: "+input+" = "+executeOrder66(operator,first,second,state)+ "\n");
            }
              
            /*ArrayList<String> weBoolin= new ArrayList<>();
            while(sc2.hasMoreTokens()){
                
                weBoolin.add(sc2.nextToken());
            }
            ArrayList<Double> boolMaster= new ArrayList<>();
            ArrayList<String> operators = new ArrayList<>();
           
            for(String i: weBoolin){
                
                if(isInteger(i)==true){
                    boolMaster.add((double)Integer.parseInt(i));
                }else if(isDouble(i)==true){
                    boolMaster.add(Double.parseDouble(i));
                }else if(i.equalsIgnoreCase("+")||i.equalsIgnoreCase("-")||i.equalsIgnoreCase("*")
                        ||i.equalsIgnoreCase("/")||i.equalsIgnoreCase("^")||i.equalsIgnoreCase("|")
                        ||i.equalsIgnoreCase("t")||i.equalsIgnoreCase("c")||i.equalsIgnoreCase("s")
                        ||i.equalsIgnoreCase("~")||i.equalsIgnoreCase("v")){
                    operators.add(i);
                }else{
                    System.out.println("Invalid Input");
                }
            }
            System.out.println("Operands:");
            for(double i:boolMaster){
                System.out.println(i);
            }
            System.out.println("Operators:");
            for(String b:operators){
                System.out.println(b);
            }
            for(String i: operators){
                System.out.println("Answer: \n"+input+" = "+executeOrder66(i,boolMaster));
            }
            */
            //System.out.println(Integer.parseInt(input.replaceAll("[\\D]", "")));
            
           
           
            
            
            
        }catch(InputMismatchException e){
            System.out.println("Invalid Input");
        }
    }
}
}
