// Breadth First Search Using Adjacency List

/* Space Complexity O(V), where V is the number of Vertices ->
   Basically for using the boolean visited array and Queue */
  
/* Time Complexity O(V + E), where E is the number of Edges ->   
   Basically Adjacency List contains 2E Elements, where E is number of Edges, and each edge should be 
   computed exactly once and also we have to fill the visited array with 1's */

import java.util.*;
public class Main
{
    // Vertices of Graph
    
    int V;
    
    //Array of LinkedLists
    
    LinkedList<Integer> ll[];
    
    Main(int v)
    {
        V=v;
        ll=new LinkedList[v];
        
        //Creation of Empty LinkedList in each index of array
        
        for(int i=0;i<v;i++)
        ll[i]=new LinkedList();
    }
    
    //Creation of LinkedList at each index of array
    
    void edge(int u, int v)
    {
        ll[u].add(v);
    }
    
    // w below specifies the starting vertex from where we want to perform BFS in graph
    
    void BFS(int w)
    {
        // Creating a visited array of booleans, which keep track of Visited nodes of graph
        
        // By default it has all false values 
        
        boolean visited [] = new boolean [V];
        
        //Creating Queue via LinkedList, which contains the visited nodes, which are yet to be explored
        
        LinkedList<Integer> queue = new LinkedList();

        // Making the starting node as visited and adding it to queue        
        visited[w]=true;
        queue.add(w);
        
        while(queue.size()!=0)
        {
         
          // Dequeuing the front element from Queue
          
          w = queue.poll();
        
        System.out.print(w+" ");
        
        // Iterating the array from the visited node, so as to find out it's neighbour nodes
        
        Iterator<Integer> i = ll[w].listIterator();
        
        // Checking whether there is next Element present or are there neighbours of the currently visited node
        // which is yet to be explored
    
        while(i.hasNext())
        {
            // Getting the next element
            
            int ret=i.next();
            
            // Checking if that neighbour is already explored or not
            
            if(visited[ret]!=true)
            {
                // Flow comes here only when the neighbour is not yet explored

                visited[ret]=true;
                
                // Enqueuing it to the Queue
                
                queue.add(ret);
	  
	  }
            
       }
        
    }
}
    
	public static void main(String[] args) {
		
	Main m=new Main(4);	
	
	// Edge between 2 vertices, or RHS vertex is neighbour of each LHS indexed vertex, or there is edge 
	// between 2 specified vertices

	m.edge(0,1);	
        m.edge(0, 2);
        m.edge(1, 2);
        m.edge(2, 0);
        m.edge(2, 3);
        m.edge(3, 3);
 
    // Starting the traversal from Vertex "2"
    
    m.BFS(2);
		
	}
}
