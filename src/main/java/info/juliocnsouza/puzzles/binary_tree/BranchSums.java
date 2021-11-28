package info.juliocnsouza.puzzles.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public List<Integer> branchSums(BinaryTree root) {
      final List<Integer> sums = new ArrayList<>();

        boolean isLeaf = false;
        BinaryTree current = root;
        int sum = 0;
        while(!isLeaf){
            sum += current.value;
            isLeaf = current.isLeaf();
            current = current.left;
        }
        System.out.println(sum);

        return sums;
    }

}
