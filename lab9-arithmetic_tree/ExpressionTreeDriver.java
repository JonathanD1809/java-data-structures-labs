public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Manually build the tree for: ( (3 + 7) * (9 - 4) )
        //
        //         *
        //        / \
        //       +   -
        //      / \ / \
        //     3  7 9  4
        //
        // Mỗi node đại diện cho toán tử hoặc toán hạng trong biểu thức.

        BinaryTreeNode root = new BinaryTreeNode("*"); // gốc là phép nhân

        // Tạo hai node toán tử con của root
        BinaryTreeNode nodePlus = new BinaryTreeNode("+"); // bên trái: cộng
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-"); // bên phải: trừ

        // --- TO BE COMPLETED BY STUDENT ---
        // Connect root, nodePlus, and nodeMinus
        // Gắn node trái và phải cho root
        root.left = nodePlus;
        root.right = nodeMinus;

        // Gắn con trỏ parent cho hai node con
        nodePlus.parent = root;
        nodeMinus.parent = root;

        // Create and connect the leaves (operands)
        // Tạo 4 node lá tương ứng với các số 3, 7, 9, 4
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");
        
        // Connect leaves to their parents (nodePlus and nodeMinus)
        // Gắn 3,7 cho dấu + và 9,4 cho dấu -
        // attach leaves to plus and minus nodes
        nodePlus.left = node3;
        nodePlus.right = node7;
        nodeMinus.left = node9;
        nodeMinus.right = node4;

        // Gắn ngược parent cho các node lá
        // Set parent pointers for leaf nodes
        node3.parent = nodePlus;
        node7.parent = nodePlus;
        node9.parent = nodeMinus;
        node4.parent = nodeMinus;

        // 2. Perform Traversals
        // Gọi các phương thức duyệt khác nhau để xem thứ tự in ra
        // call different traversal methods to see the output order

        System.out.println("--- Preorder Traversal (Prefix) ---");
        // Preorder = Cha → Trái → Phải
        // Kết quả in ra: * + 3 7 - 9 4
        // result output: * + 3 7 - 9 4
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        // Inorder = Trái → Cha → Phải
        // Kết quả in ra: ((3 + 7) * (9 - 4))
        // result output: ((3 + 7) * (9 - 4))
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        // Postorder = Trái → Phải → Cha
        // Kết quả in ra: 3 7 + 9 4 - *
        // result output: 3 7 + 9 4 - *
        root.traversePostorder();
    }
}
