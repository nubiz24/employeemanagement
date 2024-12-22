package screen;

import work.Department;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentManagementPanel extends JPanel {
    private JTable departmentTable;
    private DefaultTableModel tableModel;
    private JButton addButton, editButton, deleteButton;

    public DepartmentManagementPanel() {
        setLayout(new BorderLayout());

        // Tạo bảng hiển thị phòng ban
        String[] columns = {"ID Phòng Ban", "Tên Phòng Ban", "Trưởng Phòng"};
        tableModel = new DefaultTableModel(columns, 0);
        departmentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(departmentTable);

        // Thêm các thành phần vào panel
        add(scrollPane, BorderLayout.CENTER);

        // Tạo panel điều khiển
        JPanel controlPanel = new JPanel();
        addButton = new JButton("Thêm");
        editButton = new JButton("Sửa");
        deleteButton = new JButton("Xóa");

        // Thêm các nút vào panel điều khiển
        controlPanel.add(addButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Thêm sự kiện cho các nút
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDepartmentForm(false, null);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = departmentTable.getSelectedRow();
                if (selectedRow != -1) {
                    int departmentId = (Integer) tableModel.getValueAt(selectedRow, 0);
                    Department department = getDepartmentById(departmentId); // Lấy phòng ban theo ID
                    showDepartmentForm(true, department);
                } else {
                    JOptionPane.showMessageDialog(DepartmentManagementPanel.this, "Chọn phòng ban để sửa", "Lỗi", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = departmentTable.getSelectedRow();
                if (selectedRow != -1) {
                    int departmentId = (Integer) tableModel.getValueAt(selectedRow, 0);
                    int confirm = JOptionPane.showConfirmDialog(DepartmentManagementPanel.this,
                            "Bạn có chắc muốn xóa phòng ban này?", "Xóa phòng ban", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        deleteDepartment(departmentId);  // Xóa phòng ban khỏi danh sách
                    }
                } else {
                    JOptionPane.showMessageDialog(DepartmentManagementPanel.this, "Chọn phòng ban để xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    // Hiển thị cửa sổ thêm/sửa phòng ban
    private void showDepartmentForm(boolean isEdit, Department department) {
        Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(this); // Ép kiểu sang Frame
        DepartmentForm departmentForm = new DepartmentForm(
                parentFrame,
                isEdit ? "Sửa Phòng Ban" : "Thêm Phòng Ban",
                true,
                isEdit,
                department);
        departmentForm.setVisible(true);

        // Cập nhật bảng sau khi thêm hoặc sửa
        departmentForm.setOnSaveAction(() -> refreshDepartmentTable());
    }


    // Cập nhật bảng phòng ban sau khi thay đổi
    private void refreshDepartmentTable() {
        // Clear old data
        tableModel.setRowCount(0);

        // Reload updated data (Ví dụ: getDepartments())
        for (Department department : getDepartments()) {
            tableModel.addRow(new Object[]{
                    department.getDepartmentId(),
                    department.getName(),
                    department.getHead().getName()});
        }
    }

    // Lấy danh sách phòng ban (Giả sử đây là phương thức lấy dữ liệu từ database hoặc bộ nhớ)
    private java.util.List<Department> getDepartments() {
        // Return danh sách phòng ban giả lập (bạn có thể thay thế bằng dữ liệu thực tế)
        return new java.util.ArrayList<>();
    }

    // Lấy phòng ban theo ID (Giả sử đây là phương thức lấy dữ liệu từ database hoặc bộ nhớ)
    private Department getDepartmentById(int departmentId) {
        // Giả sử tìm phòng ban theo ID
        for (Department department : getDepartments()) {
            if (department.getDepartmentId() == departmentId) {
                return department;
            }
        }
        return null;
    }

    // Xóa phòng ban (Giả sử đây là phương thức xóa phòng ban từ database hoặc bộ nhớ)
    private void deleteDepartment(int departmentId) {
        // Xóa phòng ban khỏi danh sách (bạn có thể thay thế bằng dữ liệu thực tế)
        JOptionPane.showMessageDialog(this, "Phòng ban đã được xóa!");
        refreshDepartmentTable();
    }
}
