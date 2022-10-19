// CS224 Fall 2022

import java.util.ArrayList;
import java.util.LinkedList;
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
    int[]distances = new int[nodes.size()+1];
    
    boolean[]explored = new boolean[nodes.size()];
    int startDist = 0;
    distances[s.name] = startDist;
    explored[s.name-1] = true;
    
    ArrayList<Node>beenTo = new ArrayList<Node>(); 
    beenTo.add(s);
    ArrayList<Node>visited = new ArrayList<Node>();
    visited.add(s);
    
    while(beenTo.size() != nodes.size()){ 
      
      Node toAdd= new Node(0);
      int temp = 10000;
      
      for (Node n : visited){
        int distStart = distances[n.name];        
                
        for (Link l : n.adjlist){
          if(!visited.contains(l.n2)){
          Node other = l.n2; 
          int dist = l.weight + distStart;
          System.out.println(n.name + "->" + other.name + "=" + dist);
            if (dist < temp){
              temp = dist;
              toAdd = other;
            }          
          }
        }
        
      }
      System.out.println("found a node " + toAdd.name + ": distance is " + temp);     
      distances[toAdd.name] = temp;
      explored[toAdd.name-1] = true;
      beenTo.add(toAdd);
      visited.add(toAdd);
    }
    return distances;
    // implement this
  } // shortestPath()
}//when you add a node to visited add its distance