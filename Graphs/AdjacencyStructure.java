import java.util.LinkedList;
/**
 * This program creates a tree and represents it in Adjacency List format and Adjacency Matrix format
 * Aryan Suri
 * 12/5/2021
 */
public class Graph
{
    //Adjacency List Structure
    public static class AdjacencyList
    {
        //instance varables
        int vertex;
        LinkedList<Integer> adjacencyList[] = new LinkedList[vertex];
        //Constructor
        public AdjacencyList(int vertex)
        {
            adjacencyList = new LinkedList[vertex];
            this.vertex = vertex;
            for(int i = 0; i < vertex ; i++){
                adjacencyList[i] = new LinkedList<>();
            }
        }
    }
    
    //adds the vertex from the source to destination and then from destination to source
    public static void addEdge(AdjacencyList graph, int source, int destination)
    {
        graph.adjacencyList[source].add(destination);
        graph.adjacencyList[destination].add(source);
    }

    //prints the adjacency list
    public static void print(AdjacencyList graph)
    {
        System.out.println("Adjacency list of vertex ");
        for(int i = 0; i < graph.vertex; i++)
        {
            System.out.print("|" + i + "|");
            for(Integer j: graph.adjacencyList[i])
                System.out.print(" -> "+ j);
            System.out.println("\n");
        }
    }

    //Adjacency Matrix Structure
    public static class AdjacencyMatrix
    {
        //instance variables
        private int adjacencyMatrix[][];  //creates a two dimensional array
        private int vertex;
        //constructor
        public AdjacencyMatrix(int vertex) 
        {
            this.vertex = vertex;
            adjacencyMatrix = new int[vertex + 1][vertex + 1];
            for(int i = 0; i <= vertex; i++)
            {
                for(int j = 0; j <= vertex; j++)
                    adjacencyMatrix[i][j] = 0;      //sets all the values in the two dimensonal array to 0
            }
        }

        //sets the coordinate to 1, indicating that there was a value added
        public void addEdge(int i, int j) 
        {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1;
        }
        
        //prints the graph 
        public void printGraph() 
        {
            System.out.println("Adjacency Matrix of the list: ");
            for(int k  = 0; k <= vertex; k++)
                System.out.print(" " + k  );
            System.out.println();
            System.out.println("----------------------------");
            for(int i = 0; i <= vertex; i++)
            {
                System.out.print("|" + i + "|");
                for(int j = 0; j <= vertex; j++)
                    System.out.print(" " + adjacencyMatrix[i][j] );
                System.out.println();
                System.out.println("----------------------------");
            }
        }
    }

    //Uses the mthods above and implements and prints the list and matrix structure
    public static void main(String args[])
    {
        //creates the List structure of the graph
        AdjacencyList adjacencyList = new AdjacencyList(5);
        //Adds edges
        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);
        //Prints the graph
        print(adjacencyList);
        System.out.println();

        //creates the Matrix structure of the graph
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(4);
        //adds edges
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 4);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(1, 3);
        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(2, 3);
        adjacencyMatrix.addEdge(3, 4);
        //prints the graph
        adjacencyMatrix.printGraph();
    }

}
