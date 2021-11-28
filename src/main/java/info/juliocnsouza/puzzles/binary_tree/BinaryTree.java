package info.juliocnsouza.puzzles.binary_tree;

public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public static BinaryTree builder(int value) {
        return new BinaryTree(value);
    }

    public BinaryTree left(BinaryTree left){
        this.left = left;
        return this;
    }

    public BinaryTree right(BinaryTree right){
        this.right = right;
        return this;
    }

    private BinaryTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean isLeaf(){
        return right == null && left == null;
    }

}
