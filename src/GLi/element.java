package GLi;

import java.awt.*;
import java.security.PublicKey;

public class element {

    private Color colors;
    private int elementNum;

    public element(Color _colors, int _elementNum) {
        this.colors = _colors;
        this.elementNum = _elementNum;
    }

    public int getNum() {
        return elementNum;
    }

    public Color getColors() {
        return colors;
    }

    public void setElementNum(int elementNum) {
        this.elementNum = elementNum;
    }

    public String colorToString() {
        String color=null;
        if (colors.equals( Color.YELLOW))
            color= "Yellow";
        if (colors.equals( Color.PINK))
            color= "Pink";
        if (colors .equals(Color.MAGENTA))
            color= "Purple";
        if(colors.equals(Color.GREEN))
            color= "Green";
        if(colors.equals(Color.RED))
            color= "Red";
        if(colors.equals(Color.BLACK))
            color="wild";
        return color;

    }
}
