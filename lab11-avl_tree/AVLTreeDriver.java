public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        
        tree.insert(10); 
        tree.insert(20); 
        tree.insert(30); // trigger Left Rotate (RR) tại 10
        tree.insert(18);  
        tree.insert(21);  // trigger Right Rotate (LL)  subtree 20-30
        tree.insert(29);  // trigger Left-Right Rotate (LR)  subtree 20-30
        tree.insert(40); // trigger Right-Left Rotate (RL) subtree 30-40

        // TODO: Print traversals
        System.out.print("Inorder: ");   
      
        tree.inorder();

        System.out.print("Preorder: ");  
        
        tree.preorder();

        System.out.print("Postorder: "); 
       
        tree.postorder();

        // TODO: Add expected results as comments for verification
    }
}



/*public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        // Sequence này giúp trigger tất cả các kiểu xoay
        tree.insert(10); // bình thường (cây còn nhỏ)
        tree.insert(20); // bình thường (10 cân bằng, 20 là con phải)
        tree.insert(30); // trigger Left Rotate (RR) tại 10
        tree.insert(18);  // bình thường
        tree.insert(21);  // trigger Right Rotate (LL) tại subtree 20-30
        tree.insert(29);  // trigger Left-Right Rotate (LR) tại subtree 20-30
        tree.insert(40); // trigger Right-Left Rotate (RL) tại subtree 30-40

        // TODO: Print traversals
        System.out.print("Inorder: ");   
        // result inorder = 10 18 20 21 29 30 40 (theo thứ tự tăng dần)// Traversal gradually increasing order
        tree.inorder();

        System.out.print("Preorder: ");  
        // Cấu trúc cây sau các xoay
        // Một kết quả Preorder hợp lý có thể: 20 18 10 30 21 29 40
        tree.preorder();

        System.out.print("Postorder: "); 
        // Traversal hậu tự
        // Một kết quả Postorder hợp lý: 10 18 21 29 40 30 20
        tree.postorder();

        // TODO: Add expected results as comments for verification
    }
} */
