package GLi;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SelectFrame extends JFrame {
    private ArrayList<String> introArray=new ArrayList<String>();
    public void array(){
        introArray.add("This 2-player card game ");
        introArray.add("We have 4 playing mats,");
        introArray.add("1 bag, 45 colored candy pieces, ");
        introArray.add("54 playing cards (45 color, 9 wild)");
        introArray.add("5 medal cards in this game");
        introArray.add("Each player have 8 cards, Each card has a color and number,including the 9 wild cards that are used as any color");
        introArray.add("the cards you play next to each mat must match the color of the candy on the mat,and that number of cards must be on each side of the mat");
        introArray.add("An important rule to remember is that the final card played on a mat cannot make the score on either side of the mat equal");
        introArray.add("If they have the matching number of candies on its colour's medal card, they may take that medal");
        introArray.add("The game ends when a player has collected 3 medal cards.");
        introArray.add("If at any time the candies begin to run low and a mat must be placed, it is removed from game if there are not enough candies");
        introArray.add("For example Mat 4 scores, and the players go to place 4 candies but there are only 3, that mat is discarded from the game and continues");
    }
    public SelectFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel a1=new JLabel("PINATA");
        JLabel rules=new JLabel("Rules");
        array();
        JButton score = new JButton("Score");
        score.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                scoreGame();
            }
        });
        JButton ok = new JButton("Start");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        JButton cancel = new JButton("Exit");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                closeGame();
            }
        });
        int y=100;
        for(String a:introArray){
            y+=30;
            JLabel aa=new JLabel(a);
            aa.setBounds(10,y,1024,30);
            this.add(aa);
        }
        a1.setBounds(500,10,1024,10);
        rules.setBounds(500,40,1024,10);
        score.setBounds(100, 650, 100, 40);
        ok.setBounds(450, 650, 100, 40);
        cancel.setBounds(800, 650, 100, 40);
        this.add(a1);
        this.add(rules);
        this.add(score);
        this.add(ok);
        this.add(cancel);
        panel.setBackground(new Color(220, 220, 220));
        this.add(panel);
        this.setSize(1024, 768);
        initLocation();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pinata");
        this.setVisible(true);

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
    public void startGame() {
        this.dispose();
        new GameFrame();
    }

    public void closeGame() {
        this.dispose();
        System.exit(0);
    }
    public void scoreGame() {
        this.dispose();
    }
}
