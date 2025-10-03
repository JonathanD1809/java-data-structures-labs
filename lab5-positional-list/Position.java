// --- Position interface ---
// Position là địa chỉ hợp lệ trong danh sách. 
// Nó cho phép lấy ra element, nhưng không cho can thiệp trực tiếp vào Node.
public interface Position<E> {
    E getElement(); // Trả về phần tử lưu trong Position này
}
// generic<E> is important 
