package info.juliocnsouza.puzzles.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public List<Integer> branchSums(BinaryTree root) {
      final List<Integer> sums = new ArrayList<>();
        sum(root, 0, sums);
        return sums;
    }

    private void sum(BinaryTree node, int sum, List<Integer> sums){
        if (node == null){
            return;
        }
        sum += node.value;
        if (node.isLeaf()){
            sums.add(sum);
        }
        sum(node.left, sum, sums);
        sum(node.right, sum, sums);
    }

}
