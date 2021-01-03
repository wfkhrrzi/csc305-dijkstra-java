public class Problem5 {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.add_unidirectional_edge('a','b',4);
        g.add_unidirectional_edge('a','c',2);
        g.add_unidirectional_edge('b','c',5);
        g.add_unidirectional_edge('b','d',10);
        g.add_unidirectional_edge('c','e',3);
        g.add_unidirectional_edge('d','f',11);
        g.add_unidirectional_edge('e','d',4);

        g.shortestPath('a', 'f');
    }
}
