public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3" (toán tử hoặc toán hạng)
    BinaryTreeNode parent; // con trỏ trỏ về node cha (dùng để lưu mối quan hệ)
    BinaryTreeNode left;   // con trái
    //left child
    BinaryTreeNode right;  // con phải

    // Hàm khởi tạo: tạo một node mới với giá trị (value)
    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null; // lúc đầu chưa có cha
        // at the beginning, no children
        this.left = null;   // chưa có con trái
        // no right child initially
        this.right = null;  // chưa có con phải
        // no right child initially
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * (Visit Parent, then Left, then Right)
     * This should output Prefix notation.
     */
    public void traversePreorder() {
        // 1. Print this node's value
        // Preorder nghĩa là thăm node cha (hiện tại) trước
       
        System.out.print(this.value + " ");

        // 2. Recursively call on left child (if not null)
        // Sau đó duyệt con trái (nếu có)
        if (this.left != null) {
            this.left.traversePreorder();
        }

        // 3. Recursively call on right child (if not null)
        // Cuối cùng duyệt con phải (nếu có)
        if (this.right != null) {
            this.right.traversePreorder();
        }
    }

    /**
     * Performs an inorder traversal starting from this node.
     * (Visit Left, then Parent, then Right)
     * This should output Infix notation (you can add parentheses for clarity).
     */
    public void traverseInorder() {
        // Inorder nghĩa là thăm con trái → cha → con phải
        // => biểu thức in ra giống cách viết toán học thông thường

        // (Optional: Print "(" before recursing left)
        if (this.left != null) {
            System.out.print("("); // thêm ngoặc để rõ ràng thứ tự phép toán
            this.left.traverseInorder();
        }

        // 2. Print this node's value
        // In giữa hai nhánh con
        System.out.print(" " + this.value + " ");

        // 3. Recursively call on right child (if not null)
        if (this.right != null) {
            this.right.traverseInorder();
            System.out.print(")"); // đóng ngoặc sau khi duyệt xong nhánh phải
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * This should output Postfix (RPN) notation.
     */
    public void traversePostorder() {
        // Postorder nghĩa là thăm con trái → con phải → cha
        // Dạng duyệt này dùng để sinh ra biểu thức hậu tố (Reverse Polish Notation)

        // 1. Recursively call on left child (if not null)
        if (this.left != null) {
            this.left.traversePostorder();
        }

        // 2. Recursively call on right child (if not null)
        if (this.right != null) {
            this.right.traversePostorder();
        }

        // 3. Print this node's value
        System.out.print(this.value + " ");
    }
}
