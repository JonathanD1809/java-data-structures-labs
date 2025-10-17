import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    // Độ sâu tối đa của cây (số lần đệ quy)
    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Bắt đầu vẽ từ giữa đáy của khung
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // 1. Base Case (Điều kiện dừng)
        // Nếu depth == 0, dừng vẽ
        if (depth == 0) return;

        // 2. Recursive Step (Bước đệ quy)
        // Chiều dài nhánh giảm dần theo độ sâu
        int length = depth * 10;

        // Tính toán tọa độ điểm cuối (x2, y2) của nhánh
        double rad = Math.toRadians(angle);
        int x2 = x1 + (int) (Math.cos(rad) * length);
        int y2 = y1 + (int) (Math.sin(rad) * length);

        // Chọn màu theo độ sâu (càng sâu càng nhạt)
        g.setColor(new Color(0, (int)(150 + depth * 10), 0));

        // Vẽ đường thẳng (nhánh)
        g.drawLine(x1, y1, x2, y2);

        // Gọi đệ quy để vẽ hai nhánh con: trái và phải
        drawTree(g, x2, y2, angle - 20, depth - 1); // Nhánh trái
        drawTree(g, x2, y2, angle + 20, depth - 1); // Nhánh phải
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
