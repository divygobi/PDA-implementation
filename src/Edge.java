public class Edge {
    public String target;
    public String input;
    public String pop;
    public String push;

    public Edge(String target, String input, String pop, String push) {
        this.target = target;
        this.input = input;
        this.pop = pop;
        this.push = push;
    }

    public String getTarget() {
        return target;
    }

    public String getInput() {
        return input;
    }

    public String getPop() {
        return pop;
    }

    public String getPush() {
        return push;
    }
}
