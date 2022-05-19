import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PDARunner {

    public static void main(String[] args){
        PushDownAutomaton PDA = new PushDownAutomaton(getStates(), getTFunction(), "Q0", getAccepts());
        String[] inputs = new String[]{"", "000111", "1","00110"};
        for(String i: inputs) {
            System.out.println("Test Case: " + i);
            System.out.println(PDA.accepts(i));
        }
    }

    //Declares states
    public static List<String> getStates(){
        List<String> states = new ArrayList<>();
        states.add("Q0");
        states.add("Q1");
        states.add("Q2");
        states.add("Q3");
        states.add("Q4");
        return states;
    }

    //declares Transition function
    public static HashMap<String, List<Edge>> getTFunction(){
        HashMap<String, List<Edge>> edges = new HashMap<>();
        //Q0
        List<Edge> Q0EdgeList= new ArrayList<>();
        Q0EdgeList.add(new Edge("Q1", "", "", "$"));
        edges.put("Q0",Q0EdgeList);

        //Q1
        List<Edge> Q1EdgeList= new ArrayList<>();
        Q1EdgeList.add(new Edge("Q2", "0", "", "0"));
        edges.put("Q1",Q1EdgeList);

        //Q2
        List<Edge> Q2EdgeList= new ArrayList<>();
        Q2EdgeList.add(new Edge("Q2", "0", "", "0"));
        Q2EdgeList.add(new Edge("Q3", "1", "0", ""));
        edges.put("Q2",Q2EdgeList);

        //Q3
        List<Edge> Q3EdgeList= new ArrayList<>();
        Q3EdgeList.add(new Edge("Q3", "1", "0", ""));
        Q3EdgeList.add(new Edge("Q4", "", "$", ""));
        edges.put("Q3",Q3EdgeList);

        //Q4
        List<Edge> Q4EdgeList= new ArrayList<>();
        edges.put("Q4",Q4EdgeList);

        return edges;
    }

    //Declares Accept States
    public static List<String> getAccepts(){
        List<String> states = new ArrayList<>();
        states.add("Q0");
        states.add("Q4");
        return states;
    }

}
