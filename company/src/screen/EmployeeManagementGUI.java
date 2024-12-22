package screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public EmployeeManagementGUI() {
        frame = new JFrame("Quản Lý Nhân Sự");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Tạo CardLayout cho phần giao diện
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Các panel quản lý
        JPanel employeePanel = new EmployeeManagementPanel();
        JPanel departmentPanel = new DepartmentManagementPanel();
        JPanel projectPanel = new ProjectManagementPanel();
        JPanel taskPanel = new TaskManagementPanel();

        // Thêm các panel vào CardLayout
        mainPanel.add(employeePanel, "Quản Lý Nhân Viên");
        mainPanel.add(departmentPanel, "Quản Lý Phòng Ban");
        mainPanel.add(projectPanel, "Quản Lý Dự Án");
        mainPanel.add(taskPanel, "Quản Lý Nhiệm Vụ");

        // Tạo thanh điều hướng
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Canh trái các nút
        JButton employeeButton = createNavigationButton("Nhân Viên", "/icons/employee-icon.png");
        JButton departmentButton = createNavigationButton("Phòng Ban", "/icons/department-icon.png");
        JButton projectButton = createNavigationButton("Dự Án", "/icons/project-icon.png");
        JButton taskButton = createNavigationButton("Nhiệm Vụ", "/icons/task-icon.png");

        // Xử lý sự kiện điều hướng
        employeeButton.addActionListener(e -> cardLayout.show(mainPanel, "Quản Lý Nhân Viên"));
        departmentButton.addActionListener(e -> cardLayout.show(mainPanel, "Quản Lý Phòng Ban"));
        projectButton.addActionListener(e -> cardLayout.show(mainPanel, "Quản Lý Dự Án"));
        taskButton.addActionListener(e -> cardLayout.show(mainPanel, "Quản Lý Nhiệm Vụ"));

        // Thêm các nút vào thanh điều hướng
        navigationPanel.add(employeeButton);
        navigationPanel.add(departmentButton);
        navigationPanel.add(projectButton);
        navigationPanel.add(taskButton);

        // Cấu hình giao diện
        frame.setLayout(new BorderLayout());
        frame.add(navigationPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Phương thức giúp tạo nút điều hướng với icon
    private JButton createNavigationButton(String text, String iconPath) {
        // Tạo ImageIcon từ đường dẫn biểu tượng
        ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));

        // Thay đổi kích thước của biểu tượng (ví dụ: 32x32 pixel)
        Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);

        // Tạo ImageIcon mới từ ảnh đã được thay đổi kích thước
        icon = new ImageIcon(image);

        // Tạo nút với biểu tượng
        JButton button = new JButton(text);
        button.setIcon(icon);
        button.setBackground(new Color(76, 175, 80)); // Màu xanh
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        return button;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeManagementGUI());
    }
}
