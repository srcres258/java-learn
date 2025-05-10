import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex8_21_StudentScore {
    public static void main(String[] args) {
        LoginDialog dlg;

        dlg = new LoginDialog();
        dlg.setVisible(true);
    }
}

class MainWindow extends JFrame { // 主窗体类
    static JLabel submit; // 回显录入成绩标签

    MainWindow() {
        setTitle("学生成绩录入系统");
        setBounds(400, 200, 200, 120);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null); // 设置为不使用布局管理器
        createMenu();
        submit = new JLabel();
        submit.setBounds(5, 5, 400, 20);
        add(submit);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });
    }

    void exitSystem() { // 处理退出系统事件
        int ret;

        ret = JOptionPane.showConfirmDialog(this, "退出系统吗？",
                "退出系统吗？", JOptionPane.YES_NO_OPTION);
        if (ret == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    void createMenu() {
        JMenuBar mbar;
        JMenu m1, m2;
        JMenuItem mi11, mi12, mi13, mi21, mi22;

        // 创建菜单栏并添加到窗体顶部
        mbar = new JMenuBar();
        setJMenuBar(mbar);

        // 创建两个下拉式菜单并添加到菜单栏
        m1 = new JMenu("系统管理");
        m2 = new JMenu("成绩管理");
        mbar.add(m1);
        mbar.add(m2);

        // 创建菜单项并添加到相应的菜单下
        mi11 = new JMenuItem("基本信息管理");
        mi12 = new JMenuItem("修改密码");
        mi13 = new JMenuItem("退出系统");
        mi11.setEnabled(false);
        mi12.setEnabled(false);
        m1.add(mi11);
        m1.add(mi12);
        m1.add(mi13);
        // 为退出系统菜单项添加事件监听器
        mi13.addActionListener(event -> exitSystem());

        mi21 = new JMenuItem("成绩录入");
        mi22 = new JMenuItem("成绩查询");
        mi22.setEnabled(false);
        m2.add(mi21);
        m2.add(mi22);
        // 为成绩录入菜单项添加事件监听器
        mi21.addActionListener(event -> inputScores());
    }

    void inputScores() { // 录入成绩方法
        InputScoreDialog isd;

        isd = new InputScoreDialog();
        isd.setVisible(true);
    }

    static void setSubmit(String str) {
        submit.setText(str);
    }
}

class InputScoreDialog extends JDialog { // 录入成绩对话框类
    JComboBox<String> name;
    JTextField maths;
    JComboBox<String> english;

    InputScoreDialog() {
        setTitle("成绩录入");
        setBounds(500, 250, 240, 180);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null); // 设置为不使用布局管理器
        setModal(true);
        createGUIElements();
    }

    void createGUIElements() {
        JLabel namelbl, mathslbl, englishlbl;
        String[] ranks;
        JButton submitBtn, cancelBtn;
        int i;
        Component comp;

        namelbl = new JLabel("姓名:");
        namelbl.setBounds(10, 20, 60, 25);
        add(namelbl);
        mathslbl = new JLabel("数学:");
        mathslbl.setBounds(10, 50, 60, 25);
        add(mathslbl);
        englishlbl = new JLabel("英语:");
        englishlbl.setBounds(10, 80, 80, 25);
        add(englishlbl);
        name = new JComboBox<>();
        name.setBounds(100, 20, 120, 25);
        name.addItem("孙文轩");
        name.addItem("孙文迪");
        add(name);
        maths = new JTextField();
        maths.setBounds(100, 50, 120, 25);
        maths.setText("100");
        add(maths);
        ranks = new String[] { "优秀", "良好", "中等", "及格", "不及格" };
        english = new JComboBox<>(ranks);
        english.setBounds(100, 80, 120, 25);
        add(english);

        submitBtn = new JButton("提交");
        submitBtn.setBounds(20, 120, 80, 25);
        add(submitBtn);
        cancelBtn = new JButton("放弃");
        cancelBtn.setBounds(130, 120, 80, 25);
        add(cancelBtn);
        // 遍历容器中的所有组件，设置字体
        for (i = 0; i < getContentPane().getComponentCount(); i++) {
            comp = getContentPane().getComponent(i);
            comp.setFont(new Font("宋体", Font.BOLD, 20));
        }
        // 添加提交成绩事件监听器
        submitBtn.addActionListener(event -> {
            String str;
            Object selName, selEnglish;

            selName = name.getSelectedItem();
            selEnglish = english.getSelectedItem();
            if (selName != null && selEnglish != null) {
                str = String.format("姓名：%s；数学：%s；英语：%s", selName, maths.getText(), selEnglish);
                MainWindow.setSubmit(str);
            }
        });
        cancelBtn.addActionListener(event -> dispose()); // 撤销成绩录入对话框，返回主窗体
    }
}

class LoginDialog extends JDialog { // 登录对话框类
    JLabel usernamelbl, passwordlbl;
    JComboBox<String> username;
    JPasswordField password;
    JButton loginBtn, cancelBtn;

    LoginDialog() {
        createGUIElements();
    }

    void createGUIElements() {
        // 设置登录对话框并设置位置及大小、模态等
        setTitle("登录系统");
        setBounds(500, 250, 200, 120);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setModal(true);
        // 创建用户名与密码标签
        usernamelbl = new JLabel("用户名：");
        usernamelbl.setBounds(20, 10, 50, 20);
        add(usernamelbl);
        passwordlbl = new JLabel("密 码：");
        passwordlbl.setBounds(20, 32, 50, 20);
        add(passwordlbl);

        // 创建用户名与密码输入组件并赋初值
        username = new JComboBox<>();
        username.addItem("administator");
        username.addItem("whitesun");
        username.setBounds(75, 10, 105, 20);
        add(username);
        password = new JPasswordField("123456");
        password.setBounds(75, 33, 105, 20);
        password.setEchoChar('*');
        add(password);

        // 创建“登录”与“退出”按钮并添加事件监听器
        loginBtn = new JButton("登录");
        loginBtn.setBounds(20, 60, 60, 20);
        add(loginBtn);
        loginBtn.addActionListener(event -> login());
        cancelBtn = new JButton("退出");
        cancelBtn.setBounds(110, 60, 60, 20);
        add(cancelBtn);
        cancelBtn.addActionListener(event -> logout());
    }

    void login() { // 处理“登录”按钮事件
        String account, pwd;
        Object selUsername;

        selUsername = username.getSelectedItem();
        if (selUsername == null) {
            return;
        }
        account = selUsername.toString();
        pwd = new String(password.getPassword());

        // 如果用户名与密码正确，则隐藏登录对话框，显示主窗体
        if (account.equals("administator") && pwd.equals("123456")) {
            setVisible(false); // 只隐藏存在潜在问题，可用 dispose 彻底销毁
            showMainWindow(); // 显示主窗体
        } else {
            JOptionPane.showMessageDialog(this,
                    String.format("用户名是%s，密码是%s，登录失败！", account, pwd));
        }
    }

    void logout() { // 处理“退出”按钮事件
        int ret;

        ret = JOptionPane.showConfirmDialog(this, "选择是，取消登录。",
                "取消登录", JOptionPane.YES_NO_OPTION);
        if (ret == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    void showMainWindow() { // 显示主窗体
        MainWindow frm;

        frm = new MainWindow();
        frm.setVisible(true);
    }
}
