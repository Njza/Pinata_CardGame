package GLi;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        this.setBackground(new Color(139, 138, 139));
        initialise a=new initialise();
        initCard();
        startShowCards();
        showMetalCards();
        showMat();
    }
    private void initCard() {
        this.setLayout(null);
    }
//    /**
//     * 鼠标移动调用的方法
//     * @param e
//     */
//    public void myMouseDragged(MouseEvent e) {
//        if (!GameTool.isCanMove()) {
//            return;
//        }
//        for (element card : Cache.moveCards) {
//            card.setLocation(card.getX() + e.getX() - Cache.xMouse, card.getY() + e.getY() - Cache.yMouse);
//        }
//    }
    public void startShowCards(){
        int x1=10;
        int x2=550;
        int y=600;
        for(int i=0;i<Cache.player1.getPlayerCardsSize();i++){
           element card2= Cache.player2.getCard(i);
            element card1=Cache.player1.getCard(i);
            card1.showCard();
            card2.showCard();
            card1.setBounds(x1,y,Const.cardWidth,Const.cardHeight);
            card2.setBounds(x2,y,Const.cardWidth,Const.cardHeight);
            x1=x1+Const.cardWidth+Const.Insert;
            x2=x2+Const.cardWidth+Const.Insert;
            this.add(card1);
            this.add(card2);
        }
    }
    public void showMetalCards(){
        int x=200;
        int y=10;
        for(int i=0;i<Cache.Metal.size();i++){
            element card=Cache.Metal.get(i);
            card.showCard();
            card.setBounds(x,y,Const.cardWidth,Const.cardHeight);
            x=x+Const.cardWidth+Const.Insert *10;
            this.add(card);
        }
    }
    public void showMat(){
        int x=460;
        int y=110;
        for(int i=Cache.Mats.size()-1;i>=0;i--){
            element card=Cache.Mats.get(i);
            card.showCard();
            card.setBounds(x,y,Const.MatWidth,Const.MatHeight);
            y=y+Const.MatHeight+Const.Insert *3;
            this.add(card);
        }
    }
}
