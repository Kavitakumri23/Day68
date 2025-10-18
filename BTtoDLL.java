// Doubly Linked List Node
    class LLNode {
        int val;
        LLNode prev;
        LLNode next;

        public LLNode(int val) {
            this.val = val;
        }
    }

    // Binary Tree Node
    class treeNode {
        int val;
        treeNode left;
        treeNode right;

        public treeNode(int val) {
            this.val = val;
        }
    }

    // Main Class
    public class BTtoDLL {
        private LLNode head = null;
        private LLNode tail = null;

        // Function to convert Binary Tree → Doubly Linked List
        public LLNode convert(treeNode root) {
            if (root == null) {
                return null;
            }
            helper(root);
            return head;
        }

        // Inorder traversal helper
        private void helper(treeNode node) {
            if (node == null) {
                return;
            }

            // Left subtree
            helper(node.left);

            // Create new DLL node for current tree node
            LLNode newNode = new LLNode(node.val);

            if (head == null) {
                // First node becomes head
                head = newNode;
                tail = newNode;
            } else {
                // Attach at the end
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            // Right subtree
            helper(node.right);
        }

        // Print the doubly linked list
        public void printDLL(LLNode head) {
            System.out.print("Doubly Linked List: ");
            LLNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Main method to test
        public static void main(String[] args) {
        /*
                   10
                  /  \
                 5    15
                / \     \
               2   7     20
        */
            treeNode root = new treeNode(10);
            root.left = new treeNode(5);
            root.right = new treeNode(15);
            root.left.left = new treeNode(2);
            root.left.right = new treeNode(7);
            root.right.right = new treeNode(20);

            BTtoDLL converter = new BTtoDLL();
            LLNode head = converter.convert(root);
            converter.printDLL(head);
        }
    }

