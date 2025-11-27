import javax.swing.*;
import java.awt.*;
import Shape.Circle;
import Shape.Rectangle;
import Shape.Triangle;

public class MainGUI extends JFrame {
    
    //Các biến GUI này chính là thành phần giao diện
    //JTextField: nhập dữ liệu
    //JTextArea: hiển thị kết quả
    private JTextField txtRectWidth, txtRectLength;
    private JTextField txtCircleRadius;
    private JTextField txtTriA, txtTriB, txtTriC;
    private JTextArea result;

    public MainGUI() {
        
        //cấu hình cửa sổ
        setTitle("Calculator Shape Program");              //tiêu đề cửa sổ
        setSize(500, 550);                           //kích thước
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng cửa sổ thoát chương trình
        setLocationRelativeTo(null);                          //căn giữa màn hình
        setLayout(new GridBagLayout());                         //layout cho toàn cửa sổ

        //c là "luật" để bố trí từng thành phần trong layout
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 8, 6, 8);   //khoảng cách quanh component
        c.fill = GridBagConstraints.HORIZONTAL;                 //kéo component cho full chiều ngang
        
        //khởi tạo font
        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 15);

// Rectangle
        c.gridx = 0;                                            //cột trong lưới
        c.gridy = 0;                                            //hàng trong lưới
        add(new JLabel("Rectangle width:"), c);

        txtRectWidth = new JTextField();
        txtRectWidth.setFont(inputFont);
        c.gridx = 1;
        add(txtRectWidth, c);

        c.gridx = 0; c.gridy = 1;
        add(new JLabel("Rectangle length:"), c);

        txtRectLength = new JTextField();
        txtRectLength.setFont(inputFont);
        c.gridx = 1;
        add(txtRectLength, c);

// Circle
        c.gridx = 0; c.gridy = 2;
        add(new JLabel("Circle radius:"), c);

        txtCircleRadius = new JTextField();
        txtCircleRadius.setFont(inputFont);
        c.gridx = 1;
        add(txtCircleRadius, c);

// Triangle
        c.gridx = 0; c.gridy = 3;
        add(new JLabel("Triangle side A:"), c);

        txtTriA = new JTextField();
        c.gridx = 1;
        add(txtTriA, c);

        c.gridx = 0; c.gridy = 4;
        add(new JLabel("Triangle side B:"), c);

        txtTriB = new JTextField();
        c.gridx = 1;
        add(txtTriB, c);

        c.gridx = 0; c.gridy = 5;
        add(new JLabel("Triangle side C:"), c);

        txtTriC = new JTextField();
        c.gridx = 1;
        add(txtTriC, c);

// Button Calculate
        JButton btnCalc = new JButton("Calculate");
        btnCalc.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnCalc.setBackground(new Color(223, 238, 253));    //màu rgb (red-green-blue)

        c.gridx = 0; c.gridy = 6; c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        add(btnCalc, c);

// Result display
        result = new JTextArea(12, 35);
        result.setFont(new Font("Consolas", Font.PLAIN, 13));
        result.setEditable(false);
        result.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JScrollPane scroll = new JScrollPane(result);         //thanh cuộn khi nội dung dài
        c.gridy = 7;
        add(scroll, c);

// Button action - khi nút bấm thì chạy hàm calculateShape()
        btnCalc.addActionListener(e -> calculateShapes());
    }

    private void calculateShapes() {
        try {
            double w = Double.parseDouble(txtRectWidth.getText());
            double l = Double.parseDouble(txtRectLength.getText());
            double r = Double.parseDouble(txtCircleRadius.getText());
            double a = Double.parseDouble(txtTriA.getText());
            double b = Double.parseDouble(txtTriB.getText());
            double c = Double.parseDouble(txtTriC.getText());

            Rectangle rect = new Rectangle(w, l);
            Circle circle = new Circle(r);
            Triangle tri = new Triangle(a, b, c);

            if (!tri.isValidate()) {
                JOptionPane.showMessageDialog(this,
                        "Invalid triangle! Sum of any 2 sides must be greater than the other.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            result.setText(
                    "===== Result =====\n"
                    + rect.getResult() + "\n"
                    + circle.getResult() + "\n"
                    + tri.getResult()
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MainGUI().setVisible(true);
        //tạo cửa sổ và hiện thị nó
    }
}
