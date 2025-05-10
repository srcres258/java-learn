import javax.swing.*;
import java.awt.*;

public class Ex8_19_UseOptionPaneAndColorChooser {
    public static void main(String[] args) {
        JFrame frm;
        String str;
        int t;
        Color c;

        frm = new JFrame("使用四种标准对话框");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(null); // 设置为不使用布局管理器

        str = JOptionPane.showInputDialog(frm, "你好！这是输入对话框，请输入：",
                "输入对话框", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(frm, "你输入的是：" + str,
                "消息对话框", JOptionPane.PLAIN_MESSAGE);
        t = JOptionPane.showConfirmDialog(frm, "请选择是否退出，选择颜色。",
                "确认对话框", JOptionPane.YES_NO_OPTION);
        if (t == JOptionPane.NO_OPTION) {
            c = JColorChooser.showDialog(frm, "颜色选择对话框", Color.BLUE);
        } else {
            JOptionPane.showMessageDialog(frm, "未显示颜色选择对话框！",
                    "消息对话框", JOptionPane.WARNING_MESSAGE);
        }
        frm.setBounds(400, 200, 450, 300);
        frm.setVisible(true);
    }
}
