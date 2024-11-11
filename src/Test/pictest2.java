package Test;

import UI.LoginJFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class pictest2 extends JFrame implements KeyListener,ActionListener {
    //创建一个二维数组,加载图片时会根据二维数组的数据进行加载
    int[][] data = new int[4][4];
    //记录空白方块（我没有设置）在二维数组中的位置
    int x = 0;
    int y = 0;
    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //记录步数
    int step = 0;
    Random rdm = new Random();
    int num = rdm.nextInt(9)+1;
    String path1 = "D:\\1学习1\\代码\\practice\\PuzzelGame\\image\\girl\\girl"+num;

    //D:\1学习1\代码\practice\PuzzelGame\image\girl\girl1
    String path2 = "PuzzelGame\\image\\GoodJobTeam\\Y\\";
    String path3 = "PuzzelGame\\image\\GoodJobTeam\\Y\\";
    String path4 = "PuzzelGame\\image\\GoodJobTeam\\Y\\";

    //创建选项下面的对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");


    JMenuItem womanItem = new JMenuItem("幕刃");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");
    JMenuItem goodjobteamItem = new JMenuItem("好事群");


    JMenuItem accountItem = new JMenuItem("我要氪金");


    //==============游戏主界面==============
    public pictest2() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱图片）
        initData();

        //初始化图片
        initImage();

        //让界面变得可见
        this.setVisible(true);
    }

    //========================这里是方法区========================


    private void initData() {
        //创建一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //随机一维数组里的元素
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int Index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[Index];
            tempArr[Index] = temp;
        }
        //把一维数组的元素加载到二维数组中
        /*int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++){
                data[i][j] = tempArr[index];
                index++;
            }
        } */
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    //初始化图片
    private void initImage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if (victory()) {
            //显示胜利图标
            JLabel winJLabel = new JLabel(new ImageIcon("PuzzelGame\\image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepcount = new JLabel("已用步数:"+ step);
        stepcount.setBounds(50,30,100,20);
        this.getContentPane().add(stepcount);

        //外循环========把内循环重复执行4次(4行)
        for (int i = 0; i < 4; i++) {
            //内循环=========在一行添加4张图片
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];
                //创建一个图片の对象
                ImageIcon icon = new ImageIcon(path4 + number + ".jpg");
                //创建管理容器Jlabel的对象
                JLabel jLabel = new JLabel(icon);
                //指定位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器加到界面中
                /*this.add(jLabel1);*/
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bg = new ImageIcon("PuzzelGame\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();
    }


    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();//创建整个菜单对象

        //创建菜单上面的两个选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("太难了！");

        JMenu changepicture = new JMenu("更换图片");

        //将选项下对象添加到选项中
        functionJMenu.add(changepicture);
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        changepicture.add(womanItem);
        changepicture.add(animalItem);
        changepicture.add(sportItem);
        changepicture.add(goodjobteamItem);


        aboutJMenu.add(accountItem);

        //给条目绑定事件（点击有反应）
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        womanItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
        goodjobteamItem.addActionListener(this);

        //把两个选项加到菜单里
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的大小（宽高）
        this.setSize(603, 680);
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
        //给整个界面添加键盘监听
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //删除当前界面的所有图片
            this.getContentPane().removeAll();
            //加载第一张完整图片
            JLabel all = new JLabel(new ImageIcon(path4+"all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片
            ImageIcon bg = new ImageIcon("PuzzelGame\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //先判断游戏是否胜利，若胜利就不执行了
        if (victory()) {
            //结束方法
            return;
        }

        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 0) {
                return;
            }
            System.out.println("向右移动");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 38) {
            if (x == 0) {
                return;
            }
            System.out.println("向下移动");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (code == 39) {
            if (y == 3) {
                return;
            }
            System.out.println("向左移动");
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        } else if (code == 40) {
            if (x == 3) {
                return;
            }
            System.out.println("向上移动");
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initImage();
        }
        //按a显示全图
        else if (code == 65) {
            initImage();
        }
        //一键胜利
        else if (code == 78/*对应的是n*/) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目
        Object obj = e.getSource();
        //判断是否是点的
        if (obj == replayItem){
            System.out.println("重新游戏");
            //计步器清零
            step = 0;
            //重新打乱图片
            initData();
            //重新加载图片
            initImage();
        } else if (obj == reloginItem)
        {
            System.out.println("重新登录");
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            //关闭虚拟机
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("我要氪金！");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            jDialog.setTitle("不是，哥们，这也要氪金的吗?");
            JLabel jLabel = new JLabel(new ImageIcon("PuzzelGame\\image\\GoodJobTeam\\busgemen.jpg"));
            jLabel.setBounds(0,0,393,294);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == womanItem) {
            this.getContentPane().removeAll();

            if (victory()) {
                //显示胜利图标
                JLabel winJLabel = new JLabel(new ImageIcon("PuzzelGame\\image\\win.png"));
                winJLabel.setBounds(203,283,197,73);
                this.getContentPane().add(winJLabel);
            }

            JLabel stepcount = new JLabel("已用步数:"+ step);
            stepcount.setBounds(50,30,100,20);
            this.getContentPane().add(stepcount);


            //外循环========把内循环重复执行4次(4行)
            for (int i = 0; i < 4; i++) {
                //内循环=========在一行添加4张图片
                for (int j = 0; j < 4; j++) {
                    int number = data[i][j];
                    //创建一个图片の对象
                    ImageIcon icon = new ImageIcon(path1 +"\\"+number + ".jpg");
                    //创建管理容器Jlabel的对象
                    JLabel jLabel = new JLabel(icon);
                    //指定位置
                    jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                    //给图片加边框
                    jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    //把管理容器加到界面中
                    /*this.add(jLabel1);*/
                    this.getContentPane().add(jLabel);
                }
            }
            //添加背景图片
            ImageIcon bg = new ImageIcon("PuzzelGame\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            //刷新界面
            this.getContentPane().repaint();
            System.out.println("重新游戏");
            //计步器清零
            step = 0;
            //重新打乱图片
            initData();
            //重新加载图片
            initImage();

        } else if (obj == animalItem) {

        } else if (obj == sportItem) {

        } else if (obj == goodjobteamItem) {

        }
    }
}