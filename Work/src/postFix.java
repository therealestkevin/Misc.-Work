import java.util.*;

public class postFix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Set<String>> op = new HashMap<>();
        Set<String> oper = new HashSet<>();
        oper.add("+");
        oper.add("-");
        oper.add("*");
        oper.add("/");
        op.put("operator", oper);
        System.out.println("Enter a Mathematical Statement");
        boolean condition = false;
    while(!condition) {
        if (sc.hasNextLine()) {
            String evaluate = sc.nextLine();
            if(evaluate.equals("exit")){
                condition = true;
            }else{
                postFixEvaluate(evaluate, op);

                System.out.println("Enter another Statement");
            }


        }
    }
    }

    public static void postFixEvaluate(String s, Map<String, Set<String>> op){
            String[] all = s.split(" ");

            if(all.length<2){
                System.out.println("Invalid Statement");
            }else{
                Stack<Integer> curStack = new Stack<>();
                for(String i : all){
                    if(op.get("operator").contains(i)){
                        int top = curStack.pop();
                        int bot = curStack.pop();
                        if(i.equals("+")){
                            curStack.push(top + bot);
                        }else if(i.equals("-")){
                            curStack.push(bot - top);
                        }else if(i.equals("*")){
                            curStack.push(top * bot);
                        }else if(i.equals("/")){
                            curStack.push(bot / top);
                        }
                    }else{
                        curStack.push(Integer.parseInt(i));
                    }
                }
                System.out.println("Answer: " + curStack.pop());
            }

    }
}
