public class Problem4 {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.add_unidirectional_edge('a','c',5);
        g.add_unidirectional_edge('a','b',3);
        g.add_unidirectional_edge('f','a',3);
        g.add_unidirectional_edge('f','d',7);
        g.add_unidirectional_edge('b','c',2);
        g.add_unidirectional_edge('b','d',6);
        g.add_unidirectional_edge('c','b',1);
        g.add_unidirectional_edge('c','d',4);
        g.add_unidirectional_edge('c','f',6);
        g.add_unidirectional_edge('d','f',3);

        g.shortestPath('a', 'd');
    }
}
