package screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementPanel extends JPanel {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JButton addButton, editButton, deleteButton;

    public EmployeeManagementPanel() {
        setLayout(new BorderLayout());

        // Tạo bảng hiển thị nhân viên
        String[] columns = {"ID", "Tên", "Phòng ban", "Lương cơ bản", "Số điện thoại", "Email"};
        tableModel = new DefaultTableModel(columns, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Các nút chức năng
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Thêm Nhân Viên");
        editButton = new JButton("Sửa Nhân Viên");
        deleteButton = new JButton("Xóa Nhân Viên");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Thêm các thành phần vào panel
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Các sự kiện cho nút
        addButton.addActionListener(this::openAddEmployeeForm);
        editButton.addActionListener(this::openEditEmployeeForm);
        deleteButton.addActionListener(this::deleteEmployee);
    }

    private void openAddEmployeeForm(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Mở form thêm nhân viên");
    }

    private void openEditEmployeeForm(ActionEvent e) {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            String employeeName = (String) employeeTable.getValueAt(selectedRow, 1);
            JOptionPane.showMessageDialog(this, "Sửa nhân viên: " + employeeName);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để sửa.");
        }
    }

    private void deleteEmployee(ActionEvent e) {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Nhân viên đã bị xóa.");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xóa.");
        }
    }
}

