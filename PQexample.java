// CS224 Fall 2021
//
// *** this is for grad students only ***
//
// example of a priority queue of instances of Thing

import java.util.Queue;
import java.util.PriorityQueue;

public class PQexample {
  public static void main(String argv[]) {
    PriorityQueue<Thing> pq = new PriorityQueue<Thing>(10);
    Thing n1 = new Thing(1);
    Thing n2 = new Thing(2);
    Thing n3 = new Thing(3);
    Thing n4 = new Thing(4);

    pq.add(n4);
    pq.add(n2);
    pq.add(n3);
    pq.add(n1);

    Object arr[] = pq.toArray();
    System.out.print("PQ:");
    for (int i=0; i<arr.length; ++i) {
      Thing n = (Thing) arr[i];
      System.out.print(" " + n.name);
    }
    System.out.println();

    Thing s;
    s = pq.poll();
    while (s != null) {
      System.out.println("thing from pq is " + s.name);
      s = pq.poll();
    }
  }
}
