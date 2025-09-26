public class TextEditor {
    // node inner class
    private static class Node {
        String textState;  // storing whole text after adding
        Node prev;         // node for undo
        Node next;         // node for redo 

        // Constructor Node
        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode; // node currentNode

    // initialize empty node 
    public TextEditor() {
        Node initialNode = new Node("", null, null); 
        this.currentNode = initialNode; 
    }

    //
    public void add(String newText) {
        // remove Xóa redo history: nếu có nhánh next thì cắt bỏ
        currentNode.next = null;

        //new Status Trạng thái mới = trạng thái cũ + text mới
        String updatedText = currentNode.textState + newText;

        // create new node Tạo node mới, nối prev về current
        Node newNode = new Node(updatedText, currentNode, null);

        //Update  Cập nhật current.next để trỏ tới node mới
        currentNode.next = newNode;

        // Di chuyển current sang node mới
        currentNode = newNode;
    }

    // Undo
    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;  // lùi về node trước
            return currentNode.textState;
        } else {
            System.out.println("Can not undo anymore!");
            return currentNode.textState; // giữ nguyên
        }
    }

    // Redo
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;  // tiến tới node sau to next node
            return currentNode.textState;
        } else {
            System.out.println("Can not redo anymore!");
            return currentNode.textState; // giữ nguyên keep
        }
    }

    // print 
    public void printCurrent() {
        System.out.println("Current Text: " + currentNode.textState);
    }
}
