public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Public wrapper method to start the maze-solving process.
     * It should find the starting 'S' position and initiate the recursive search.
     * @return true if a path is found, false otherwise.
     */
    public boolean solve() {
        // Tìm vị trí bắt đầu 'S'
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        // Nếu tìm thấy 'S', bắt đầu đệ quy từ vị trí đó
        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    /**
     * The core recursive method to solve the maze.
     * @param row The current row position.
     * @param col The current column position.
     * @return true if this position leads to a solution, false otherwise.
     */
    private boolean solve(int row, int col) {
        // 1. Base Case (Điều kiện dừng)
        // Nếu ra ngoài biên mê cung → không hợp lệ
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }

        // Nếu là tường '#' hoặc đã đi qua '.' → không hợp lệ
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        // Nếu là đích 'F' ->tìm thấy lối ra
        if (maze[row][col] == 'F') {
            return true;
        }

        // 2. Recursive Step (Bước đệ quy)
        // Đánh dấu ô hiện tại là đã đi qua để tránh lặp
        if (maze[row][col] != 'S') { // không ghi đè ký tự 'S'
            maze[row][col] = '.';
        }

        // Thử đi theo 4 hướng: Bắc, Đông, Nam, Tây
        if (solve(row - 1, col)) return true; // Lên
        if (solve(row, col + 1)) return true; // Phải
        if (solve(row + 1, col)) return true; // Xuống
        if (solve(row, col - 1)) return true; // Trái

        // 3. Backtracking (Quay lui)
        // Nếu cả 4 hướng đều sai → quay lại và bỏ đánh dấu
        if (maze[row][col] != 'S') {
            maze[row][col] = ' ';
        }

        return false;
    }

    public static void main(String[] args) {
        // Maze có lời giải
        char[][] mazeToSolve = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver.printMaze();

        // Maze KHÔNG có lời giải
        char[][] mazeNoSolution = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', '#', ' ', '#'},
            {'#', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver2 = new MazeSolver(mazeNoSolution);
        System.out.println("Original Maze (No Solution):");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver2.printMaze();
    }
}
