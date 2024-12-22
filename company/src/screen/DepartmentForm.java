package screen;

import work.Department;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentForm extends JDialog {
    private JTextField idField, nameField, headField;
    private JButton saveButton, cancelButton;
    private boolean isEdit = false;
    private Department department;
    private Runnable onSaveAction;

    public void setOnSaveAction(Runnable onSaveAction) {
        this.onSaveAction = onSaveAction;
    }
    public DepartmentForm(Frame parent, String title, boolean modal, boolean isEdit, Department department) {
        super(parent, title, modal);
        this.isEdit = isEdit;
        this.department = department;

        // Thiết lập giao diện với BorderLayout
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(parent);

        // Panel cho các trường nhập liệu
        JPanel fieldsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        add(fieldsPanel, BorderLayout.CENTER);

        // Các trường nhập liệu
        fieldsPanel.add(new JLabel("ID Phòng Ban:"));
        idField = new JTextField(isEdit ? String.valueOf(department.getDepartmentId()) : "");
        idField.setEditable(false); // ID không thay đổi khi sửa
        fieldsPanel.add(idField);

        fieldsPanel.add(new JLabel("Tên Phòng Ban:"));
        nameField = new JTextField(isEdit ? department.getName() : "");
        fieldsPanel.add(nameField);

        fieldsPanel.add(new JLabel("Trưởng Phòng:"));
        headField = new JTextField(isEdit ? department.getHead().getName() : "");
        fieldsPanel.add(headField);

        // Panel cho các nút điều khiển
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        // Các nút điều khiển
        saveButton = new JButton("Lưu");
        cancelButton = new JButton("Hủy");

        // Thêm các nút vào panel
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Sự kiện cho nút
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDepartment();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        // Cải thiện hiển thị của các nút
        saveButton.setBackground(new Color(76, 175, 80)); // Màu xanh lá
        saveButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(244, 67, 54)); // Màu đỏ
        cancelButton.setForeground(Color.WHITE);

        // Thêm icon cho các nút
        saveButton.setIcon(new ImageIcon(getClass().getResource("/images/save-icon.png")));
        cancelButton.setIcon(new ImageIcon(getClass().getResource("/images/cancel-icon.png")));

        setVisible(true);
    }

    private void saveDepartment() {
        try {
            String name = nameField.getText();
            String headName = headField.getText();

            // Tạo phòng ban mới hoặc sửa
            if (isEdit) {
                department.setName(name);
                // Cập nhật trưởng phòng nếu cần
            } else {
                int id = Integer.parseInt(idField.getText()); // ID được gán từ tệp dữ liệu
                // Thêm phòng ban vào danh sách
            }

            // Gọi hành động lưu (nếu có)
            if (onSaveAction != null) {
                onSaveAction.run();
            }

            JOptionPane.showMessageDialog(this, "Lưu thành công!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

}
