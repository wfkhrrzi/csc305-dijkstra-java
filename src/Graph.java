import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<Node>();
    }
    
    /**
     * 
     * @param startNodeId
     * @param toNodeId
     * @return HashMap<String, Node> returnNodes
     */
    private HashMap<String, Node> createNode(char startNodeId, char toNodeId){
        // declare start node and end node
        Node startNode = null;
        Node toNode = null;

        // check if nodes are already existed
        if (!this.nodes.isEmpty()) {
            for (Node node : nodes) {

                if (node.getId() == startNodeId) {
                    startNode = node;
                }

                if (node.getId() == toNodeId) {
                    toNode = node;
                }

            }
        }

        // create node if any of the declared nodes are null
        if (startNode == null) {
            startNode = new Node(startNodeId);
            nodes.add(startNode);
        }

        if (toNode == null) {
            toNode = new Node(toNodeId);
            nodes.add(toNode);
        }

        //return node 
        HashMap<String, Node> returnNodes = new HashMap<String, Node>();
        returnNodes.put("startNode", startNode);
        returnNodes.put("toNode", toNode);

        return returnNodes;
    } 

    /**
     * Add unidrectional edge between the start node and the end node
     * 
     * @param startNodeId
     * @param toNodeId
     * @param distance
     */
    public void add_unidirectional_edge(char startNodeId, char toNodeId, int distance) {
        // check for nodes existence
        HashMap<String, Node> nodes = this.createNode(Character.toUpperCase(startNodeId), Character.toUpperCase(toNodeId));
        
        // set neighbor for start node
        if (nodes.containsKey("startNode") && nodes.containsKey("toNode")) {
            Node startNode = nodes.get("startNode");
            Node toNode = nodes.get("toNode");

            if (!startNode.getNeighbors().containsKey(toNode)) {
                startNode.addNeighbor(toNode, distance);
            }
            else {
                System.out.println("Error. Node "+toNode.getId()+" is already a neighbor of "+startNode.getId());
            }
            
        } else {
            System.out.println("Error. Nodes are not defined");
        }
    }

    /**
     * Add bidirectional edge between nodes
     * 
     * @param startNodeId
     * @param toNodeId
     * @param distance
     */
    public void add_bidirectional_edge(char startNodeId, char toNodeId, int distance) {
        // check for nodes existence
        HashMap<String, Node> nodes = this.createNode(Character.toUpperCase(startNodeId), Character.toUpperCase(toNodeId));
        
        // set neighbor for start node
        if (nodes.containsKey("startNode") && nodes.containsKey("toNode")) {
            Node startNode = nodes.get("startNode");
            Node toNode = nodes.get("toNode");

            if (!startNode.getNeighbors().containsKey(toNode)) {
                startNode.addNeighbor(toNode, distance);
            }
            else {
                System.out.println("Error. Node "+toNode.getId()+" is already a neighbor of "+startNode.getId());
            }

            if (!toNode.getNeighbors().containsKey(startNode)) {
                toNode.addNeighbor(startNode, distance);
            }
            else {
                System.out.println("Error. Node "+startNode.getId()+" is already a neighbor of "+toNode.getId());
            }
            
        } else {
            System.out.println("Error. Nodes are not defined");
        }
    }

    /**
     * Display all nodes in the graph 
     * 
     */
    public void displayNodes(){
        if (!this.nodes.isEmpty()) {
            for (Node node : this.nodes) {
                System.out.println(node.toString());
            }    
        }
        
    }

    /**
     * Process the shortest path from the start vertex using the Dijkstra's shortest path algorithm
     * 
     * @param startNode
     */
    private void dijkstra(Node startNode) {

        // declare variables
        ArrayList<Node> visitedNodes = new ArrayList<Node>();
        ArrayList<Node> unvisitedNodes = new ArrayList<Node>();
        int shortest_dist_from_start_node = 0;
        Node currentNode = startNode;

        // copy all graph nodes into unvisitedNodes array
        Iterator<Node> iterator = this.nodes.iterator();

        while(iterator.hasNext()) {
            unvisitedNodes.add(iterator.next());
        }

        // set shortest distance for current node 
        currentNode.setShortestDist(shortest_dist_from_start_node);


        while (currentNode != null) {
            // check unvisited neighbor
            if (!currentNode.getNeighbors().isEmpty()) {
                for (Map.Entry<Node, Integer> neighbor : currentNode.getNeighbors().entrySet()) {
                    
                    Node neighborNode = neighbor.getKey();
                    int neighborDist = neighbor.getValue();

                    // check if neighbor node is in visitedNodes array
                    if (visitedNodes.contains(neighborNode)) {
                        continue;
                    }

                    // add up shortest_dist_from_start_node with distance from neighbor distance
                    int calc_dist = shortest_dist_from_start_node + neighborDist;

                    // if the calc dist is less than known distance, update the distance and vertex 
                    if (calc_dist < neighborNode.getShortestDist()) {
                        neighborNode.setShortestDist(calc_dist);
                        neighborNode.setPrevNode(currentNode);
                    }
                }
            }

            // add current node to visited list & remove current node from unvisited array
            if (unvisitedNodes.remove(currentNode)) {
                visitedNodes.add(currentNode);
            }

            // update next shortest distance from start vertex if the calc distance is less than the current shortest distance
            // set next node if above condition is met
            int next_shortest_dist_from_start_vertex = (int) Double.POSITIVE_INFINITY;
            Node nextNode =null;

            if (!unvisitedNodes.isEmpty()) {
                for (Node unvisitedNode : unvisitedNodes) {
                    if (unvisitedNode.getShortestDist() < next_shortest_dist_from_start_vertex) {
                        next_shortest_dist_from_start_vertex = unvisitedNode.getShortestDist();
                        nextNode = unvisitedNode;
                    }
                }    
            }

            // update current node and shortest distance from start vertex
            if (nextNode != null) {
                currentNode = nextNode;
                shortest_dist_from_start_node = next_shortest_dist_from_start_vertex;
            } else {
                if (!unvisitedNodes.isEmpty()) {
                    currentNode = unvisitedNodes.get(0);
                } else {
                    currentNode = null;
                }
            }
            
        }

    }


    public void shortestPath(char startNodeId, char toNodeId) {

        // convert ids to uppercase
        startNodeId = Character.toUpperCase(startNodeId);
        toNodeId = Character.toUpperCase(toNodeId);

        // return error if both nodes id are the same
        if (startNodeId == toNodeId) {
            System.out.println("Cannot input same nodes!");
            return;
        } 

        // declare necessary variables
        Node startNode = null;
        Node toNode = null;

        // assign nodes according to the specified id
        for (Node node : nodes) {
            if (node.getId() == startNodeId) {
                startNode = node;
            }

            if (node.getId() == toNodeId) {
                toNode = node;
            }
        }

        // validate if both id exist
        if (startNode == null && toNode == null) {
            System.out.println("Cannot input non-existence id!");
            return;
        }

        // execute dijkstra method
        this.dijkstra(startNode);

        // output shortest path
        ArrayList<Node> outputNodes = new ArrayList<Node>();
        outputNodes.add(toNode);
        Node tempToNode = toNode;

        while (toNode != startNode) {
            toNode = toNode.getPrevNode();
            if (toNode == null) {
                break;
            }
            outputNodes.add(0, toNode);
        }

        if (outputNodes.get(0) != startNode) {
            System.out.println("Error. No path between node "+startNodeId+" and node "+toNodeId);
            return;
        }

        System.out.print("Shortest path: ");

        for (Node node : outputNodes) {
            if (node == tempToNode) {
                System.out.print(node.getId());
                break;
            }
            System.out.print(node.getId()+" -> ");
        }

        // output shortest distance
        System.out.println("\nShortest distance to node "+toNodeId+": "+tempToNode.getShortestDist());

        // output table
        this.displayTable(startNode);
    }


    private void displayTable(Node startNode) {
        System.out.println("\n\n------------------------------------Table------------------------------------------");
        System.out.println("Vertex\t\t|\tShortest Dist from vertex "+startNode.getId()+"\t|\tPrevious vertex");

        Collections.sort(nodes);

        for (Node node : nodes) {
            System.out.println( node.getId()+"\t\t|\t\t\t"+( node.getShortestDist() == (int) Double.POSITIVE_INFINITY ? "inf" : node.getShortestDist() )+"\t\t|\t\t"+ (node.getPrevNode() != null ? node.getPrevNode().getId() : '-') );
        }
    }
}
