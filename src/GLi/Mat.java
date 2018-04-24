package GLi;

import javax.swing.*;
import java.util.ArrayList;

public class Mat extends element {

    private ArrayList<element> candyMat = new ArrayList<>();

    public Mat(String matStates, int matValue) {
        super(matStates, matValue);
    }

    public void reverseState() {
        if (getColors().equals("up"))
            setColors("down");
        else
            setColors("up");
    }

    public void addCandy(element e) {
        candyMat.add(e);
    }

    public ArrayList<element> getCandy() {
        return candyMat;
    }

    public void setCandyMat(ArrayList<element> candyMat) {
        this.candyMat = candyMat;
    }

    @Override
    public void showCard() {
        setPicture("img/" +getColors()+ getElementNum() + ".png");
        this.setIcon(new ImageIcon(getPicture()));
    }
}