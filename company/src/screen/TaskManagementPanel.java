package screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TaskManagementPanel extends JPanel {
    private JTable taskTable;
    private DefaultTableModel tableModel;

    public TaskManagementPanel() {
        setLayout(new BorderLayout());

        // Tạo bảng hiển thị nhiệm vụ
        String[] columns = {"ID Nhiệm Vụ", "Mô Tả", "Thời Hạn", "Dự Án Liên Quan"};
        tableModel = new DefaultTableModel(columns, 0);
        taskTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        // Thêm các thành phần vào panel
        add(scrollPane, BorderLayout.CENTER);
    }
}

