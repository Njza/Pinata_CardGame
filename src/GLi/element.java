package GLi;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public abstract class element extends JLabel {

    private String colors;
    private int elementNum;
    private String picture;

    public element(String _colors, int _elementNum) {
        this.colors = _colors;
        this.elementNum = _elementNum;
    }

    public int getElementNum() {
        return elementNum;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public void setElementNum(int elementNum) {
        this.elementNum = elementNum;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public abstract void showCard();


}
