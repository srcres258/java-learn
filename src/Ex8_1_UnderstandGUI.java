import javax.swing.*;
import java.awt.*;

public class Ex8_1_UnderstandGUI {
    public static void main(String[] args) {
        JFrame frm;
        JButton myBtn;

        // 创建容器
        frm = new JFrame();

        // 设置标题
        frm.setTitle("理解GUI编程");
        // 设置布局
        frm.setLayout(new BorderLayout());
        // 创建按钮组件
        myBtn = new JButton("按钮");
        // 将按钮组件添加到容器中
        frm.add(myBtn);

        // 设置窗口初始位置与大小并显示
        frm.setBounds(500, 200, 200, 100);
        // 设置窗体关闭方式
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体显示
        frm.setVisible(true);
    }
}
