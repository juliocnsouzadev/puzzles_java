package info.juliocnsouza.puzzles.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class NodeDepths {

    public int nodeDepths(BinaryTree root) {
        List<Integer> depths = new ArrayList<>();
        calcDepth(0,depths,  root);
        return depths.stream().reduce(Integer::sum).get();
    }

    private int calcDepth(int depth, List<Integer> depths, BinaryTree node){
        int leftSum = node.left == null ? depth : calcDepth(depth + 1, depths, node.left);
        int rightSum = node.right == null? depth : calcDepth(depth + 1, depths,  node.right);
        depths.add(depth);
        return depth;
    }
}
