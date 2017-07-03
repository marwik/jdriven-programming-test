package nl.marwik.jdriventest;

import java.util.*;

/**
 * Created by marwik on 2017-07-03.
 */
public class BetterProgrammerTask4 {

    private static final String[] PEGS = { "A", "B", "C"};

    public static List<String> transferFromAtoC(int n) {
        /*
          Towers Of Hanoi.
          There are three pegs: A, B and C. There are n disks. All disks are different in size.
          The disks are initially stacked on peg A so that they increase in size from the top to the bottom.
          The goal is to transfer the entire tower from the A peg to the C peg.
          One disk at a time can be moved from the top of a stack either to an empty peg or to
          a peg with a larger disk than itself on the top of its stack.

          The method should return a sequence of disk moves, each move is a String with two letters (A, B or C)
          corresponding to the peg the disk moves from and the peg it moves to.
          For example, the move "AC" means that a top disk from peg A should be moved to peg C.
         */
        List<String> moves = new ArrayList<String>();
        return move(moves, n, 0, 2, 1);
    }

    // recursive algorithm taken from: https://en.wikipedia.org/wiki/Tower_of_Hanoi
    private static List<String> move(List<String> moves, int m, int source, int target, int spare) {
        if (m == 0) {
            return moves;
        } else if (m==1) {
            moves.add(PEGS[source] + PEGS[target]);
        } else {
            move(moves, m-1, source, spare, target);
            move(moves, 1, source, target, spare);
            move(moves, m-1, spare, target, source);
        }
        return moves;
    }

    /** test */
    public static void main(String[] args) {
        Iterable<String> l = transferFromAtoC(3);
        System.out.println(l); // 42
    }

}
