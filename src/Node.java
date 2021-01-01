import java.util.HashMap;


public class Node {
    private char id;
    private HashMap<Node, Integer> neighbors = new HashMap<>();
    private int shortestDist;
    private Node prevNode;

    public Node(char id){
        this.id = id;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public HashMap<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(HashMap<Node, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public int getShortestDist() {
        return shortestDist;
    }

    public void setShortestDist(int shortestDist) {
        this.shortestDist = shortestDist;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    
}
