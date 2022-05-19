import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
public class PushDownAutomaton {
    Stack stack;
    List<String> states;
    HashMap<String, List<Edge>> edges;
    String start;
    List<String> accepts;

    public PushDownAutomaton(List<String> states, HashMap<String, List<Edge>> edges, String start, List<String> accepts) {
        stack = new Stack<String>();
        this.states = states;
        this.edges = edges;
        this.start = start;
        this.accepts = accepts;
    }

    public Boolean accepts(String input) {
        stack = new Stack<String>();
        String curr = start;
        //empty string is over on the state q0, which is an accept state so its accepted
        if (input.length() == 0 && accepts.contains(curr)) {
            return true;
        }
        int i = 0;

        while(true) {
            boolean found = false;
            String c = "";
            if(i < input.length()) {
                c = String.valueOf(input.charAt(i));
            }
            String prev = curr;
            for (Edge edge : edges.get(curr)) {
                String readChar = edge.getInput();
                String popChar = edge.getPop();
                String pushChar = edge.getPush();
                if ((readChar.equals("") || readChar.equals(c)) &&
                        (popChar.equals("") || (!stack.isEmpty() && stack.pop().equals(popChar)))) {
                    if (!pushChar.equals("")) {
                        stack.push(pushChar);
                    }
                    if (!readChar.equals("")) {
                        i++;
                    }
                    curr = edge.getTarget();
                    found = true;
                    break;
                }

            }
            if (i > input.length()||!found)
                break;
        }
        if(i==input.length()&& accepts.contains(curr)) {
            return true;
        }
        return false;
    }
}
