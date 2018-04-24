package GLi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GameFrame extends JFrame implements ActionListener {
    GamePanel panel=null;
    public GameFrame() {
        init();
    }
    public void init(){
        initMenu();

        panel =new GamePanel();
        this.add(panel);

        initFrameSize();
        initLocation();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pinata");
    }
    public void initMenu() {

        JMenuBar bar=new JMenuBar();
        JMenu game=new JMenu("Game");
        JMenu help=new JMenu("Help");
        JMenuItem item;
        game.add(item=new JMenuItem("New Game"));item.addActionListener(this);
        game.add(item=new JMenuItem("Score"));item.addActionListener(this);
        game.addSeparator();
        game.add(item=new JMenuItem("Exit"));item.addActionListener(this);
        help.add(item=new JMenuItem("About"));item.addActionListener(this);
        bar.add(game);
        bar.add(help);
        this.setJMenuBar(bar);
    }
    /**
     * 初始化窗口位置
     */
    public void initLocation() {
        int windowWidth = this.getWidth(); // 获得窗口宽
        int windowHeight = this.getHeight(); // 获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width; // 获取屏幕的宽
        int screenHeight = screenSize.height; // 获取屏幕的高
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2
                - windowHeight / 2);// 设置窗口居中显示
    }

    /**
     * 设置界面大小
     */
    private void initFrameSize() {
        this.setSize(1024, 768);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("New Game".equals(e.getActionCommand())) {
            this.dispose();
            new GameFrame();
            return;
        }
        if ("Score".equals(e.getActionCommand())) {
            return;
        }
        if ("Exit".equals(e.getActionCommand())) {
            System.exit(0);
            return;
        }
        if ("About".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "Name：Pinta\nVersion：1.0\nAuthor：Bohan Wang\nTime：2018.04.24", "Aout Pinata", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }
}
