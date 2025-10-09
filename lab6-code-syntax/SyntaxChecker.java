import java.util.EmptyStackException;

// stack implement
class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int t = -1;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
    }

    public int size() {
        return (t + 1);
    }

    public boolean empty() {
        return (t == -1);
    }

    public void push(E element) throws IllegalStateException {
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[++t] = element;
    }

    @SuppressWarnings("unchecked")
    public E peek() throws EmptyStackException {
        if (empty())
            throw new EmptyStackException();
        return (E) data[t];
    }

    @SuppressWarnings("unchecked")
    public E pop() throws EmptyStackException {
        if (empty())
            throw new EmptyStackException();
        E answer = (E) data[t];
        data[t--] = null;
        return answer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i <= t; i++) {
            sb.append(data[i]);
            if (i < t)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}

// stack interface
interface Stack<E> {
    int size();

    boolean empty();

    void push(E element);

    E peek();

    E pop();
}

// syntaxchecker.
public class SyntaxChecker {

    /**
     * Dùng ngăn xếp để kiểm tra xem chuỗi có các ký hiệu () {} [] cân bằng hay
     * không.
     * 
     * @param line Chuỗi cần kiểm tra.
     * @return true nếu cân bằng, false nếu không.
     */
    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * 
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        Stack<Character> buffer = new ArrayStack<>(line.length());

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            // Nếu là ký hiệu mở thì đưa vào ngăn xếp
            if (ch == '(' || ch == '{' || ch == '[') {
                buffer.push(ch);
            }

            // Nếu là ký hiệu đóng thì kiểm tra
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (buffer.empty()) {
                    return false; // Không có ký hiệu mở tương ứng
                }

                char open = buffer.pop();

                // Kiểm tra cặp ký hiệu có khớp không
                if ((ch == ')' && open != '(') ||
                        (ch == '}' && open != '{') ||
                        (ch == ']' && open != '[')) {
                    return false; // Không khớp place holder
                }
            }

            // Các ký tự khác thì bỏ qua
        }

        // Nếu ngăn xếp rỗng thì tất cả ký hiệu đã khớp
        return buffer.empty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
