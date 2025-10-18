// Definition for a binary tree node
class TreeNNode {
    int val;
    TreeNNode left;
    TreeNNode right;

    TreeNNode(int x) {
        val = x;
    }
}

// Main solution class
public class KTHSmallest {
    private int k;
    private int ans;

    public int kthSmallest(TreeNNode root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }

    private void helper(TreeNNode node) {
        if (node == null) return;

        // Inorder traversal (Left → Node → Right)
        helper(node.left);

        k--;
        if (k == 0) {
            ans = node.val;
            return;
        }

        helper(node.right);
    }

    // main() inside KTHSmallest class (so everything is together)
    public static void main(String[] args) {
        /*
                 5
                / \
               3   6
              / \
             2   4
            /
           1
        */

        TreeNNode root = new TreeNNode(5);
        root.left = new TreeNNode(3);
        root.right = new TreeNNode(6);
        root.left.left = new TreeNNode(2);
        root.left.right = new TreeNNode(4);
        root.left.left.left = new TreeNNode(1);

        KTHSmallest sol = new KTHSmallest();
        int k = 3;
        System.out.println("Kth smallest element: " + sol.kthSmallest(root, k));
    }
}
