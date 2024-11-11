package UI;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //登录界面
    public LoginJFrame(){
        this.setSize(660,1054);
        //设置标题
        this.setTitle("我没做这个");
        //置顶界面
        this.setAlwaysOnTop(true);
        //让界面居中
        this.setLocationRelativeTo(null);
        //点叉关闭程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);

        //添加背景图片
        ImageIcon bg = new ImageIcon("image\\涩涩.jpg");
        JLabel background = new JLabel(bg);
        this.getContentPane().add(background);
    }

}
