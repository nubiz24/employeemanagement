package screen;

import work.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskForm extends JDialog {
    private JTextField idField, descriptionField, deadlineField;
    private JComboBox<String> projectComboBox;
    private JButton saveButton, cancelButton;
    private boolean isEdit = false;
    private Task task;

    public TaskForm(Frame parent, String title, boolean modal, boolean isEdit, Task task) {
        super(parent, title, modal);
        this.isEdit = isEdit;
        this.task = task;

        // Thiết lập giao diện
        setLayout(new GridLayout(5, 2));
        setSize(400, 250);
        setLocationRelativeTo(parent);

        // Các trường nhập liệu
        add(new JLabel("ID Nhiệm Vụ:"));
        idField = new JTextField(isEdit ? String.valueOf(task.getTaskId()) : "");
        idField.setEditable(false); // ID không thay đổi khi sửa
        add(idField);

        add(new JLabel("Mô Tả Nhiệm Vụ:"));
        descriptionField = new JTextField(isEdit ? task.getDescription() : "");
        add(descriptionField);

        add(new JLabel("Thời Hạn:"));
        deadlineField = new JTextField(isEdit ? task.getDeadline() : "");
        add(deadlineField);

        add(new JLabel("Dự Án Liên Quan:"));
        projectComboBox = new JComboBox<>(new String[]{"Dự Án A", "Dự Án B", "Dự Án C"});
        add(projectComboBox);

        // Các nút điều khiển
        saveButton = new JButton("Lưu");
        cancelButton = new JButton("Hủy");

        add(saveButton);
        add(cancelButton);

        // Sự kiện cho nút
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTask();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void saveTask() {
        try {
            String description = descriptionField.getText();
            String deadline = deadlineField.getText();
            String projectName = (String) projectComboBox.getSelectedItem();

            // Tạo nhiệm vụ mới hoặc sửa
            if (isEdit) {
                task.setDescription(description);
                task.setDeadline(deadline);
                // Cập nhật dự án liên quan nếu cần
            } else {
                int id = Integer.parseInt(idField.getText()); // ID được gán từ tệp dữ liệu
                // Thêm nhiệm vụ vào danh sách
            }

            JOptionPane.showMessageDialog(this, "Lưu thành công!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
