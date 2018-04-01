package GLi;

import java.util.ArrayList;

public class Mat {
    private int matValue;
    private boolean matStates;
    private ArrayList<element> candyMat = new ArrayList<>();

    public Mat(int _matValue, boolean _matStates) {
        this.matStates = _matStates;
        this.matValue = _matValue;
    }

    public int getMatValue() {
        return matValue;
    }

    public boolean getMatStates() {
        return this.matStates;
    }

    public void reverseState() {
        if(matStates==true)
            matStates=false;
        else
            matStates=true;
    }
    public void addCandy(element e){
        candyMat.add(e);
    }

    public void setCandyMat(ArrayList<element> candyMat) {
        this.candyMat = candyMat;
    }

    public ArrayList<element> getCandy() {
        return candyMat;
    }
}