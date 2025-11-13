// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        // TODO: Initialize key, height, left, and right
        this.key = key;
        this.height = 1; // nút mới thêm là lá, height = 1// newly added node is a leaf, height = 1
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        if (N == null)
            return 0; // nút rỗng có height = 0, null node has height = 0
        return N.height;
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right); // cân bằng = chiều cao trái - phải
    }// balance = height(left) - height(right)

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Thực hiện quay phải// perform right rotation
        x.right = y;
        y.left = T2;

        // Cập nhật lại chiều cao// update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Trả về nút gốc mới// return new root
        return x;
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Thực hiện quay trái// perform left rotation
        y.left = x;
        x.right = T2;

        // Cập nhật lại chiều cao// update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Trả về nút gốc mới// return new root
        return y;
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left); // bước 1: quay trái nút con trái// step 1: left rotate the left child
        return rightRotate(z);       // bước 2: quay phải nút gốc// step 2: right rotate the root
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode z) {
        z.right = rightRotate(z.right); // bước 1: quay phải nút con phải// step 1: right rotate the right child
        return leftRotate(z);           // bước 2: quay trái nút gốc//  step 2: left rotate the root
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        if (node == null)
            return new AVLNode(key); // tạo nút mới// create new node

        // 1. Chèn theo quy tắc BST// 1. Insert following BST rules
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // không chèn giá trị trùng// do not insert duplicate values

        // 2. Cập nhật chiều cao của nút// 2. Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Tính hệ số cân bằng// 3. Get the balance factor
        int balance = getBalance(node);

        // 4. Xử lý các trường hợp mất cân bằng// 4. If the node becomes unbalanced, then there are 4 cases

        // Case 1: Left Left (quay phải)// right rotate
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Case 2: Right Right (quay trái)// left rotate
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Case 3: Left Right (quay trái rồi quay phải)// left-right rotate
        if (balance > 1 && key > node.left.key)
            return leftRightRotate(node);

        // Case 4: Right Left (quay phải rồi quay trái)// right-left rotate
        if (balance < -1 && key < node.right.key)
            return rightLeftRotate(node);

        // Trả về nút không thay đổi// return the (unchanged) node pointer
        return node;
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}
