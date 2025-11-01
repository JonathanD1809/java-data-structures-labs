public class CompanyTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Create the root node (e.g., "CEO")
        // Đây là nút gốc của cây, đại diện cho người lãnh đạo cao nhất trong công ty
        // In this case, chúng ta tạo một GeneralTreeNode với tên "CEO"
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads (children of root)
        // Hai nút con trực tiếp của CEO là hai Phó Giám đốc phụ trách mảng Sales và Engineering
        // Two direct children nodes of the CEO are VP of Sales and VP of Engineering
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // --- TO BE COMPLETED BY STUDENT ---
        // Add more nodes to build the following hierarchy:
        //
        // CEO
        //  |-- VP of Sales
        //  |    |-- Sales Manager (NA)
        //  |    |-- Sales Manager (EU)
        //  |
        //  |-- VP of Engineering
        //       |-- Dev Team Lead
        //       |    |-- Developer 1
        //       |    |-- Developer 2
        //       |
        //       |-- QA Team Lead
        //
        // Hình trên mô tả cấu trúc công ty dưới dạng cây (tree):
        // - CEO là root.
        // - VP of Sales và VP of Engineering là hai node con cấp 1.
        // - Sales Manager (NA) và (EU) là con của VP of Sales.
        // - Dev Team Lead và QA Team Lead là con của VP of Engineering.
        // - Developer 1 và Developer 2 là con của Dev Team Lead.

        // Example for "VP of Sales" children:
        // Hai Sales Manager thuộc VP of Sales phụ trách hai khu vực khác nhau
        // Two Sales Managers under VP of Sales handling different regions
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);
        
        // ... add children for "VP of Engineering" ...
        // VP of Engineering có hai nhóm: Dev Team và QA Team
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // Dev Team Lead quản lý 2 developer
        // Dev Team Lead manages 2 developers
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        // 2. Perform Traversals
        // Duyệt cây theo hai cách: Preorder và Postorder để thể hiện mối quan hệ cấp bậc
        // Traverse the tree in two ways: Preorder and Postorder to show hierarchical relationships
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        // Preorder: thăm node cha trước, rồi tới các con
        // => In ra theo thứ bậc tổ chức từ trên xuống
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        // Postorder: thăm các con trước, sau đó mới in node cha
        // => Mô phỏng kiểu duyệt “báo cáo ngược lên” (nhân viên báo cáo lên sếp)
        root.traversePostorder();
    }
}
