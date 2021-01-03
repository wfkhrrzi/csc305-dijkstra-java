public class Problem1 {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph();

        g.add_unidirectional_edge('a','b',6);
        g.add_unidirectional_edge('b','e',2);
        g.add_unidirectional_edge('b','d',1);
        g.add_unidirectional_edge('d','e',1);
        g.add_unidirectional_edge('c','a',4);
        g.add_unidirectional_edge('c','d',3);
        g.add_unidirectional_edge('s','a',1);
        g.add_unidirectional_edge('s','c',2);

        g.shortestPath('s', 'e');
    }
}
