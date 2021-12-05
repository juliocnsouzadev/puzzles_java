package info.juliocnsouza.puzzles.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(n) space | O(h) space
public class NodeDepths {

    public int nodeDepths(BinaryTree root) {
        Map<String, Integer> accumulator = new HashMap<>();
        accumulator.put("",0);
        calcDepth(0,accumulator,  root);
        return accumulator.get("");
    }

    private void calcDepth(int depth, Map<String, Integer> accumulator, BinaryTree node){
        if(node == null){
            return ;
        }
        calcDepth(depth + 1, accumulator, node.left);
        calcDepth(depth + 1, accumulator,  node.right);
        accumulator.put("", accumulator.get("") + depth);
    }

}
