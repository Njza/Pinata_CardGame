package GLi;

import javax.swing.*;

public class card extends element{
    public card(String color,int num){
        super(color,num);
    }
    @Override
    public void showCard() {
        setPicture("img/" + getColors()+getElementNum()+".png");
        this.setIcon(new ImageIcon(getPicture()));
    }
}
