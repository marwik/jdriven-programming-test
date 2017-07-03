package nl.marwik.jdriventest;

import java.util.*;

/**
 * Created by marwik on 2017-07-03.
 */
public class BetterProgrammerTask3 {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }

    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
        // the largest root-to-leaf sum is the largest root-to-leaf sum of the node's children plus the node's value
        // FIXME: sum can be greater than Integer.MAX_VALUE, should return long or even better a BigInteger
        return (int)getLargestRootToLeafSum(root, 0);
    }

    private static long getLargestRootToLeafSum(Node root, int sum) {
        if (root.getChildren() == null || root.getChildren().isEmpty()) {
            return sum + root.getValue();
        } else {
            Long max = Long.MIN_VALUE;
            for (Node child : root.getChildren()) {
                long largestSum = getLargestRootToLeafSum(child, root.getValue());
                if (largestSum > max) {
                    max = largestSum;
                }
            }
            return sum + max;
        }
    }

    /** Test class */
    static class NodeImpl implements Node {
        final int value;
        final List<Node> children;

        public NodeImpl(final int value, final List<Node> children) {
            this.value = value;
            this.children = children;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public List<Node> getChildren() {
            return children;
        }
    }

    /** test */
    public static void main(String[] args) {
    /*
             root=1
            /      \
        n1=2        n2=3
        |   \      /    \
        l3=4 l4=5 l5=6 l6=38

        => maxSum = 1+3+38 = 42
     */
        NodeImpl l6 = new NodeImpl(38, null);
        NodeImpl l5 = new NodeImpl(6, null);
        NodeImpl l4 = new NodeImpl(5, null);
        NodeImpl l3 = new NodeImpl(4, null);
        List<Node> c2 = new ArrayList<Node>();
        c2.add(l5);
        c2.add(l6);
        NodeImpl n2 = new NodeImpl(3, c2);
        List<Node> c1 = new ArrayList<Node>();
        c1.add(l3);
        c1.add(l4);
        NodeImpl n1 = new NodeImpl(2, c1);
        List<Node> c0 = new ArrayList<Node>();
        c0.add(n1);
        c0.add(n2);
        NodeImpl root = new NodeImpl(1, c0);
        System.out.println( getLargestRootToLeafSum(root) );
    }

}
