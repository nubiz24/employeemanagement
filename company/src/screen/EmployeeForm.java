package screen;

import employee.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeForm extends JDialog {
    private JTextField idField, nameField, phoneField, emailField, salaryField;
    private JComboBox<String> departmentComboBox;
    private JButton saveButton, cancelButton;
    private boolean isEdit = false;
    private Employee employee;

    public EmployeeForm(Frame parent, String title, boolean modal, boolean isEdit, Employee employee) {
        super(parent, title, modal);
        this.isEdit = isEdit;
        this.employee = employee;

        // Thiết lập giao diện với BorderLayout
        setLayout(new BorderLayout(10, 10));
        setSize(450, 350);
        setLocationRelativeTo(parent);

        // Panel cho các trường nhập liệu
        JPanel fieldsPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        add(fieldsPanel, BorderLayout.CENTER);

        // Các trường nhập liệu
        fieldsPanel.add(new JLabel("ID Nhân Viên:"));
        idField = new JTextField(isEdit ? String.valueOf(employee.getId()) : "");
        idField.setEditable(false); // ID không thay đổi khi sửa
        fieldsPanel.add(idField);

        fieldsPanel.add(new JLabel("Tên Nhân Viên:"));
        nameField = new JTextField(isEdit ? employee.getName() : "");
        fieldsPanel.add(nameField);

        fieldsPanel.add(new JLabel("Lương Cơ Bản:"));
        salaryField = new JTextField(isEdit ? String.valueOf(employee.getBaseSalary()) : "");
        fieldsPanel.add(salaryField);

        fieldsPanel.add(new JLabel("Số Điện Thoại:"));
        phoneField = new JTextField(isEdit ? employee.getPhone() : "");
        fieldsPanel.add(phoneField);

        fieldsPanel.add(new JLabel("Email:"));
        emailField = new JTextField(isEdit ? employee.getEmail() : "");
        fieldsPanel.add(emailField);

        fieldsPanel.add(new JLabel("Phòng Ban:"));
        departmentComboBox = new JComboBox<>(new String[]{"Phòng IT", "Phòng Kinh Doanh", "Phòng Nhân Sự"}); // Danh sách phòng ban
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
                saveEmployee();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void saveEmployee() {
        try {
            String name = nameField.getText();
            double baseSalary = Double.parseDouble(salaryField.getText());
            String phone = phoneField.getText();
            String email = emailField.getText();
            String departmentName = (String) departmentComboBox.getSelectedItem();

            // Kiểm tra dữ liệu nhập vào
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra định dạng email
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo nhân viên mới hoặc sửa
            if (isEdit) {
                employee.setName(name);
                employee.setBaseSalary(baseSalary);
                employee.setPhone(phone);
                employee.setEmail(email);
                // Cập nhật phòng ban nếu cần
            } else {
                int id = Integer.parseInt(idField.getText()); // ID được gán từ tệp dữ liệu
                // Thêm nhân viên vào danh sách
            }

            JOptionPane.showMessageDialog(this, "Lưu thành công!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
