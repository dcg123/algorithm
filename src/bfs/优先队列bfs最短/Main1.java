package bfs.优先队列bfs最短;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by user on 2017/10/3.
 */
public class Main1 {

    class Node{
         String name;
        int score;
    }

    static Main1 main=new Main1();
    public static void main(String[] args) {
        Comparator<Node> OrderIsdn = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.score<o2.score?-1:1;
            }

        };
        Scanner scanner=new Scanner(System.in);
        Queue<Node> priorityQueue=new PriorityQueue<Node>(11,OrderIsdn);
        for (int i=0;i<5;i++){
            Node s=main.new Node();
            s.score=scanner.nextInt();
            priorityQueue.add(s);
        }
        System.out.println(priorityQueue.size());
        System.out.println();

    }

}
