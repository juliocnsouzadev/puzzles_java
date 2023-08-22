package info.juliocnsouza.puzzles.binary_search_tree;


public class BST {

    protected int value;
    protected BST left;
    protected BST right;

    public BST(int value) {
        this.value = value;
    }

    protected boolean towardsLeft(int value) {
        return this.value > value;
    }


    public BST insert(int value) {
        // left
        if (this.towardsLeft(value)) {
            if (this.left == null) {
                this.left = new BST(value);
                return this;
            }
            return this.left.insert(value);
        }

        // right
        if (this.right != null) {
            return this.right.insert(value);
        }
        this.right = new BST(value);
        return this;
    }


    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        }
        if (this.towardsLeft(value) && this.left != null) {
            return this.left.contains(value);
        }
        if (this.right != null) {
            return this.right.contains(value);
        }
        return false;
    }

    public BST remove(int value) {
        return remove(this, value);
    }

    private BST remove(BST bst, int value) {
        if (bst == null) {
            return null;
        }

        final boolean towardsLeft = bst.towardsLeft(value);
        if (towardsLeft) {
            bst.left = remove(bst.left, value);
            return bst;
        }
        if (!towardsLeft && value != bst.value) {
            bst.right = remove(bst.right, value);
            return bst;
        }

        if (bst.left == null) {
            return bst.right;
        }

        if (bst.right == null) {
            return bst.left;
        }

        bst.value = minValue(bst.right);
        bst.right = remove(bst.right, bst.value);
        return bst;
    }

    private int minValue(BST bst) {
        int minValue = bst.value;
        while (bst.left != null) {
            minValue = bst.left.value;
            bst = bst.left;
        }
        return minValue;
    }
}
