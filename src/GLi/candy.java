package GLi;

import javax.swing.*;

public class candy extends element {
    public candy(String color,int num){
        super(color,num);
    }

    @Override
    public void showCard() {
        setPicture("img/suger" + getColors() +".png");
        this.setIcon(new ImageIcon(getPicture()));
    }

}
