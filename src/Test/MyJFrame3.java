package Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3(){
        //设置界面的大小（宽高）
        this.setSize(603,680);
        //设置标题
        this.setTitle("幼儿园智力测试之拼拼图  Ver1.0");
        //置顶界面
        this.setAlwaysOnTop(true);
        //让界面居中
        this.setLocationRelativeTo(null);
        //点叉关闭程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，让图片能够按照要求自己放置
        this.setLayout(null);

        //给整个窗体添加键盘监听
        this.addKeyListener(this);











        //让界面变得可见
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开了");
    }
}
