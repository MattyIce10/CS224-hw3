// CS224 Fall 2022

import java.util.ArrayList;
import java.util.Queue;

public class Graph {
  ArrayList<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<Node>();
  }

  public void addNode(Node newNode) {
    for (Node n: this.nodes) {
      if (n == newNode) {
        System.out.println("ERROR: graph already has a node " + n.name);
        assert false;
      }
    }
    nodes.add(newNode);
  }

  public void addEdge(Node n1, Node n2, int weight) {
    // make sure edge does not already exist
    int idx1 = this.nodes.indexOf(n1);
    if (idx1 >= 0) {
      for (Link link: this.nodes.get(idx1).adjlist) {
        if (link.n2 == n2) {
          System.out.println("ERROR: there is already an edge from " + n1.name + " to " + n2.name);
          return;
        }
      }
      this.nodes.get(idx1).addEdge(n2, weight);
    } else {
      System.out.println("ERROR: node " + n1.name + " not found in graph");
    }

    int idx2 = this.nodes.indexOf(n2);
    if (idx2 >= 0) {
      this.nodes.get(idx2).addEdge(n1, weight);
    } else {
      System.out.println("ERROR: node " + n2.name + " not found in graph");
    }
  } // addEdge()

  public void print() {
    for (Node n1: this.nodes) {
      System.out.print(n1 + ":");
      for (Link link: n1.adjlist) {
        System.out.print(" " + link.n2.name + " (d=" + link.weight + ")");
      }
      System.out.print("|");
    }
  }

  public int[] shortestPath(Node s) {
    // implement this
    //have grpah of nodes 
    //given starting node
    ArrayList<Node> explored = new ArrayList<Node>();
    int distStart = 0;
    explored.add(s);
    while (explored.size() != nodes.size()){
      for (Node n : explored){        
        
        for (Link l : n.adjlist) {
          //PRINT list of 'found nodes' - > 'node' : 'PATH TO start node'
          int path = dist
          System.out.print(n.name "->" l.n2.name ": " + distances[i]);
          //add the weight to the distance to staring node
          
          
        }
      }
    }
    

    //PRINT list of 'found nodes' - > 'node' : 'PATH TO start node'
    //PRINT found a node "" : distance is ""
    //Prints node from the list with shortest path to start

    //return array of ints 
    //each index is the distance to that node 
    //[0,1,2,3,2,4]

  } // shortestPath()



}
