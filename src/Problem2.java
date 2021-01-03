public class Problem2{
    public static void main(String[] args) {
        Graph g = new Graph();

        g.add_unidirectional_edge('a','e',7);
        g.add_unidirectional_edge('b','a',4);
        g.add_unidirectional_edge('c','b',1);
        g.add_unidirectional_edge('d','b',2);
        g.add_unidirectional_edge('d','c',6);

        g.shortestPath('d', 'a');
    }
}