class TreeeNode {
    int val;
    TreeeNode left, right;

    TreeeNode(int val) {
        this.val = val;
    }
}
public class BTtoSwapped{

    private TreeeNode first = null;
    private TreeeNode second = null;
    private TreeeNode prev = new TreeeNode(Integer.MIN_VALUE);

    // Function to fix swapped BST
    public void recoverTree(TreeeNode root) {
        inorder(root);

        // Swap the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // Inorder traversal to find two swapped nodes
    private void inorder(TreeeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Detect violation
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;     // first wrong node
            }
            second = root;         // second wrong node
        }

        prev = root; // move prev
        inorder(root.right);
    }

    // Utility: print inorder traversal
    public void printInorder(TreeeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Test
    public static void main(String[] args) {
        /*
              3
             / \
            1   4
               /
              2
           (Nodes 2 and 3 swapped)
        */
        TreeeNode root = new TreeeNode(3);
        root.left = new TreeeNode(1);
        root.right = new TreeeNode(4);
        root.right.left = new TreeeNode(2);

     BTtoSwapped bst = new  BTtoSwapped();

        System.out.print("Before Fix: ");
        bst.printInorder(root);
        System.out.println();

        bst.recoverTree(root);

        System.out.print("After Fix:  ");
        bst.printInorder(root);
        System.out.println();
    }
}
