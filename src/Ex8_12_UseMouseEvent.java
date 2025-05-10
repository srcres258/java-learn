import javax.swing.*;
import java.awt.event.*;

public class Ex8_12_UseMouseEvent {
    public static void main(String[] args) {
        JFrame frm;
        JLabel label1, label2;
        JTextField text;
        MouseListenerImpl mouse;

        frm = new JFrame("深入掌握事件处理");
        frm.setLayout(null);

        label1 = new JLabel("请在窗体内移动鼠标，");
        label1.setBounds(15, 5, 200, 25);
        frm.add(label1);
        label2 = new JLabel("或按住鼠标左键拖动鼠标！");
        label2.setBounds(15, 30, 200, 25);
        frm.add(label2);

        // 创建文本框对象
        text = new JTextField(30);
        text.setBounds(15, 55, 200, 30);
        frm.getContentPane().add(text);

        // 注册监听器，参数为事件处理者对象
        mouse = new MouseListenerImpl(text);
        frm.addMouseListener(mouse);
        frm.addMouseMotionListener(mouse);
        frm.addWindowListener(mouse);

        frm.setBounds(500, 250, 250, 150);
        frm.setVisible(true);
    }
}

// 实现鼠标、窗体相关的接口
class MouseListenerImpl implements MouseMotionListener, MouseListener, WindowListener {
    JTextField text;

    public MouseListenerImpl(JTextField text) {
        this.text = text;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        String s;

        s = String.format("拖拽鼠标，坐标：X=%d, Y=%d", e.getX(), e.getY());
        text.setText(s);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String s;

        s = "鼠标进入了窗体";
        text.setText(s);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        String s;

        s = "鼠标离开了窗体";
        text.setText(s);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // 为了使窗口能正常关闭，程序正常退出
        System.exit(0);
    }

    // 不打算实现新功能的方法，让方法体为空即可，但不能没有这些空方法

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
