import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty(); // Node là leaf nếu không có child// if children is empty
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys); // Sort tăng dần// ascending order
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode(); // Root ban đầu rỗng // initially empty
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent; // Tiếp tục kiểm tra parent
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        System.out.println("Splitting node with keys: " + node.keys);

        // Lưu tạm keys để tránh IndexOutOfBounds// temporarily store keys to avoid IndexOutOfBounds
        List<Integer> tempKeys = new ArrayList<>(node.keys);

        int middleKey = tempKeys.get(2); // middle key = key thứ 3// the 3rd key

        // 1. Tạo right node// create right node
        TwoFourNode rightNode = new TwoFourNode();
        rightNode.keys.add(tempKeys.get(3));
        if (!node.isLeaf()) {
            rightNode.children.add(node.children.get(2));
            rightNode.children.add(node.children.get(3));
            for (TwoFourNode child : rightNode.children) {
                child.parent = rightNode;
            }
        }

        // 2. Left node giữ 2 key nhỏ nhất//    left node keeps the 2 smallest keys
        node.keys = new ArrayList<>();
        node.keys.add(tempKeys.get(0));
        node.keys.add(tempKeys.get(1));
        if (!node.isLeaf()) {
            List<TwoFourNode> leftChildren = new ArrayList<>();
            leftChildren.add(node.children.get(0));
            leftChildren.add(node.children.get(1));
            node.children = leftChildren;
            for (TwoFourNode child : node.children) {
                child.parent = node;
            }
        }

        TwoFourNode leftNode = node;

        // 3. Nếu node là root → tạo root mới// if node is root → create new root
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(middleKey);
            newRoot.children.add(leftNode);
            newRoot.children.add(rightNode);
            leftNode.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
        } else {
            TwoFourNode parent = node.parent;
            parent.insertKey(middleKey);
            parent.children.remove(node);
            parent.children.add(leftNode);
            parent.children.add(rightNode);
            leftNode.parent = parent;
            rightNode.parent = parent;
            Collections.sort(parent.children, (a, b) -> a.keys.get(0) - b.keys.get(0));
        }
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) inorder(node.children.get(i));
        }
    }

    // Preorder traversal
    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }

    private void preorder(TwoFourNode node) {
        if (node == null) return;

        // In node key trước, sau đó traverse children
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
        for (TwoFourNode child : node.children) {
            preorder(child);
        }
    }

    // Postorder traversal
    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(TwoFourNode node) {
        if (node == null) return;

        // Traverse children trước, in node key sau// children first, then node keys
        for (TwoFourNode child : node.children) { // each loop though all children
            postorder(child);
        }
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
    }
}
