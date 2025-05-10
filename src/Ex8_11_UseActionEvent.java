import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex8_11_UseActionEvent {
    public static void main(String[] args) {
        JFrame frm;
        JButton btn;
        ButtonHandler btnHandler;

        frm = new JFrame("理解事件处理");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(null);

        // 创建按钮对象
        btn = new JButton("请单击本按钮");
        btn.setBounds(120, 60, 120, 30);
        frm.add(btn);
//        // 创建按钮的监听器并注册，参数为事件处理者对象
//        btnHandler = new ButtonHandler();
//        btn.addActionListener(btnHandler); // 与单击事件相关的授权处理的方法
        // 新版 Java 上，可使用 Lambda 表达式简化代码
        btn.addActionListener(e -> System.out.println("单击一次按钮"));

        frm.setBounds(400, 200, 400, 200);
        frm.setVisible(true);
    }
}

class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("单击一次按钮");
    }
}