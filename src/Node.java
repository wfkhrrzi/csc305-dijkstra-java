import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Node>{
    private char id;
    private HashMap<Node, Integer> neighbors = new HashMap<>();
    private int shortestDist;
    private Node prevNode;

    public Node(char id){
        this.id = id;
        this.shortestDist = (int) Double.POSITIVE_INFINITY;
        this.prevNode = null;
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

    public void addNeighbor(Node neighbor, int distance){
        this.neighbors.put(neighbor, distance);
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

    @Override
    public String toString() {
        
        String output = "\nNode: "+this.id+"\nNeighbors:\n";
        if (this.neighbors.isEmpty()) {
            output += "-\n";
        } else {
            for (Map.Entry<Node, Integer> neighbor : this.neighbors.entrySet()) {
                output += neighbor.getKey().id + ", " + neighbor.getValue().intValue() + "\n";
            }    
        }

        output += "Shortest Distance: " + this.shortestDist + "\nPrevious Node: " + (this.prevNode != null ? this.prevNode.getId() : "-");

        return output;
    }

    @Override
    public int compareTo(Node node) {
        return this.shortestDist - node.getShortestDist();
    }

}
