package screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProjectManagementPanel extends JPanel {
    private JTable projectTable;
    private DefaultTableModel tableModel;

    public ProjectManagementPanel() {
        setLayout(new BorderLayout());

        // Tạo bảng hiển thị dự án
        String[] columns = {"ID Dự Án", "Tên Dự Án", "Thời Hạn", "Phòng Ban Phụ Trách"};
        tableModel = new DefaultTableModel(columns, 0);
        projectTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(projectTable);

        // Thêm các thành phần vào panel
        add(scrollPane, BorderLayout.CENTER);
    }
}
