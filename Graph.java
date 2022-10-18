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
    int[]Distances = new int[nodes.size()];
    boolean[]explored = new boolean[nodes.size()];
    Queue<Node> Tree = new LinkedList();
    Tree.add(s);
    int distStart = 0;
    Distances[s.name-1] = distStart;
    while(!Tree.isEmpty()){
      Node current = (Tree.remove());
      Distances[current.name-1] = 
      explored[0] = true;
      for (Link l : current.adjlist){
        System.out.print(current.name "->" l.n2.name "=" l.weight + Distances[current.name-1]);

      }
    }
    // implement this
  } // shortestPath()
}
