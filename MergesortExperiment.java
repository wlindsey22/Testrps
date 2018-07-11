import net.datastructures.LinkedQueue;
import net.datastructures.ArrayList;
import java.util.Random;
/**
 * Developed for use with the book:
 * Modified from the program dsaj.asymptotics.StringExperiment.java provided with the book
 * Data Structures and Algorithms in Java, Sixth Edition
 * Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 * John Wiley & Sons, 2014
 *
 * @author William Lindsey
 *
 */
public class MergesortExperiment {
private static LinkedQueue<Integer> lq = new LinkedQueue<>();
private static ArrayList<Integer> ar = new ArrayList<>();

     public static <E extends Comparable<E>> void mergesort1(LinkedQueue<E> q) {
    //handle null q
    if (q.size() <= 1)
      return;
    LinkedQueue<E> left = new LinkedQueue<>();
    LinkedQueue<E> right = new LinkedQueue<>();
    int mid = q.size()/2;
    for(int i = 0; i < mid; i++)
      left.enqueue(q.dequeue());
    while(!q.isEmpty())
      right.enqueue(q.dequeue());
    mergesort1(left);
    mergesort1(right);
    while(!left.isEmpty() && !right.isEmpty()){
      if(left.first().compareTo(right.first()) < 0 )
         q.enqueue(left.dequeue());
      else
         q.enqueue(right.dequeue());
    }
    while(!left.isEmpty())
      q.enqueue(left.dequeue());
    while(!right.isEmpty())
      q.enqueue(right.dequeue());
    }
    public static <E extends Comparable<E>> void mergesort2(ArrayList<E> q) {
    //handle null q
    if (q.size()<= 1)
      return;
    ArrayList<E> left = new ArrayList<>();
    ArrayList<E> right = new ArrayList<>();
    int mid = q.size();
    mid = mid/2;
    for(int i = 0; i < mid; i++){
      left.add(left.size(), q.remove(0));
    }
    while(!q.isEmpty())
      right.add(right.size(), q.remove(0));
    mergesort2(left);
    mergesort2(right);
    while(!left.isEmpty() && !right.isEmpty()){
      if(left.get(0).compareTo(right.get(0)) < 0 )
         q.add(q.size(), left.remove(0));
      else {
         q.add(q.size(), right.get(0));
         right.remove(0);
    }
    }
    while(!left.isEmpty())
       q.add(q.size(), left.remove(0));
    while(!right.isEmpty())
       q.add(q.size(), right.remove(0));
   }
  public static void main(String[] args) {
  Random rand = new Random();  
    int n = 50000;                           // starting value
    for ( int j = 0; j < n; j++)
      lq.enqueue(rand.nextInt(n));
    int trials = 10;
    try {
      if (args.length > 0)
        trials = Integer.parseInt(args[0]);
      if (args.length > 1)
        n = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) { }
    int start = n;  // remember the original starting value

    for (int t=0; t < trials; t++) {
      System.out.println("Timing the creation and data filling of a LinkedQueue...");
      long startTime = System.currentTimeMillis();
      lq = new LinkedQueue(); // resetting the LinkedQueue to empty
      for ( int j = 0; j < n; j++)
         lq.enqueue(rand.nextInt(n));
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      System.out.println("Testing mergesort1 on a LinkedQueue...");
      startTime = System.currentTimeMillis();
      mergesort1(lq);
      endTime = System.currentTimeMillis();
      elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      n *= 2;                                // double the problem size
    }
    n = start;                               // restore n to its start value
    for (int t=0; t < trials; t++) {
      System.out.println("Timing the creation and data filling of an ArrayList...");
      long startTime = System.currentTimeMillis();
      ar = new ArrayList(); //resetting the ArrayList to empty
      for ( int j = 0; j < n; j++)
         ar.add(ar.size(), rand.nextInt(n));
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      System.out.println("Testing mergesort2 on an ArrayList...");
      startTime = System.currentTimeMillis();
      mergesort2(ar);
      endTime = System.currentTimeMillis();
      elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      n *= 2;                                // double the problem size
    }
  }
}
