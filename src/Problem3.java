public class Problem3 {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.add_bidirectional_edge('a','b',3);
        g.add_bidirectional_edge('a','c',5);
        g.add_bidirectional_edge('b','c',3);
        g.add_bidirectional_edge('b','d',4);
        g.add_bidirectional_edge('b','e',7);
        g.add_bidirectional_edge('c','e',6);
        g.add_bidirectional_edge('d','f',2);
        g.add_bidirectional_edge('d','e',2);
        g.add_bidirectional_edge('e','f',5);

        g.shortestPath('d', 'a');
    }
}
