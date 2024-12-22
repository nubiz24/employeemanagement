package screen;

import work.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectForm extends JDialog {
    private JTextField idField, nameField, deadlineField;
    private JComboBox<String> departmentComboBox;
    private JButton saveButton, cancelButton;
    private boolean isEdit = false;
    private Project project;

    public ProjectForm(Frame parent, String title, boolean modal, boolean isEdit, Project project) {
        super(parent, title, modal);
        this.isEdit = isEdit;
        this.project = project;

        // Thiết lập giao diện với BorderLayout
        setLayout(new BorderLayout(10, 10));
        setSize(450, 350);
        setLocationRelativeTo(parent);

        // Panel cho các trường nhập liệu
        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        add(fieldsPanel, BorderLayout.CENTER);

        // Các trường nhập liệu
        fieldsPanel.add(new JLabel("ID Dự Án:"));
        idField = new JTextField(isEdit ? String.valueOf(project.getProjectId()) : "");
        idField.setEditable(false); // ID không thay đổi khi sửa
        fieldsPanel.add(idField);

        fieldsPanel.add(new JLabel("Tên Dự Án:"));
        nameField = new JTextField(isEdit ? project.getName() : "");
        fieldsPanel.add(nameField);

        fieldsPanel.add(new JLabel("Thời Hạn:"));
        deadlineField = new JTextField(isEdit ? project.getDeadline() : "");
        fieldsPanel.add(deadlineField);

        fieldsPanel.add(new JLabel("Phòng Ban Phụ Trách:"));
        departmentComboBox = new JComboBox<>(new String[]{"Phòng IT", "Phòng Kinh Doanh", "Phòng Nhân Sự"}); // Tạo danh sách phòng ban
        fieldsPanel.add(departmentComboBox);

        // Panel cho các nút điều khiển
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        // Các nút điều khiển
        saveButton = new JButton("Lưu");
        cancelButton = new JButton("Hủy");

        // Thêm các nút vào panel
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Cải thiện màu sắc và thêm icon cho các nút
        saveButton.setBackground(new Color(76, 175, 80)); // Màu xanh lá
        saveButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(244, 67, 54)); // Màu đỏ
        cancelButton.setForeground(Color.WHITE);

        // Thêm icon cho các nút
        saveButton.setIcon(new ImageIcon(getClass().getResource("/images/save-icon.png")));
        cancelButton.setIcon(new ImageIcon(getClass().getResource("/images/cancel-icon.png")));

        // Sự kiện cho nút
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProject();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void saveProject() {
        try {
            String name = nameField.getText();
            String deadline = deadlineField.getText();
            String departmentName = (String) departmentComboBox.getSelectedItem();

            // Kiểm tra dữ liệu nhập vào
            if (name.isEmpty() || deadline.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo dự án mới hoặc sửa
            if (isEdit) {
                project.setName(name);
                project.setDeadline(deadline);
                // Cập nhật phòng ban nếu cần
            } else {
                int id = Integer.parseInt(idField.getText()); // ID được gán từ tệp dữ liệu
                // Thêm dự án vào danh sách
            }

            JOptionPane.showMessageDialog(this, "Lưu thành công!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
