import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {// constructor
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;  
                // Gắn con trỏ ngược về cha
                // set this node as the parent of the child
        this.children.add(child);     // Thêm vào danh sách con
        // add the child to this node's children list
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        // Your code here
        // 1. Print this node's name
        System.out.println(this.name);

        // 2. Recursively call traversePreorder on each child
        for (GeneralTreeNode child : children) {
            child.traversePreorder();  // Đệ quy qua từng con
            // recursive call to traversePreorder on each child
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call traversePostorder on each child
        for (GeneralTreeNode child : children) {
            child.traversePostorder(); // Đệ quy qua từng con trước
            // recursive call to traversePostorder on each child
        }

        // 2. Print this node's name
        System.out.println(this.name);
    }
}
