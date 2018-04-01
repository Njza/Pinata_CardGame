package GLi;

import java.security.PublicKey;
import java.util.ArrayList;

public class Player {
    //player cards ArrayList
    private ArrayList<element> player = new ArrayList<>();

    //player candy ArrayList
    private ArrayList<ArrayList> totalCandy = new ArrayList<>();
    private ArrayList<element> candy = new ArrayList<>();
    //player Metal ArrayList
    private ArrayList<element> playerMetal = new ArrayList<>();
    //player each position card
    private ArrayList<ArrayList> Matcards = new ArrayList<>();
    private ArrayList<element> MatCardsplayer = new ArrayList<>();
    private String name;

    private ArrayList<ArrayList> MatCandy = new ArrayList<>();
    private ArrayList<element> MatCandyplayer = new ArrayList<>();

    // pass the name of this player
    public Player(String name) {
        this.name = name;
        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                Matcards.add(MatCardsplayer);
                MatCandy.add(MatCandyplayer);
            }
            totalCandy.add(candy);
        }
    }
    //get player owned Metal cards
    public int getPlayerMetalSize() {
        return playerMetal.size();
    }

    public int getPlayerSize() {
        return player.size();
    }

    //return the player name
    public String getName() {
        return name;
    }

    //return the card
    public element getcards(int id) {
        return player.get(id);
    }
    //return each position mat player cards
    public ArrayList<element> getMatcards(int i) {
        return Matcards.get(i);
    }
    //return each color candy player owned
    public ArrayList<element> getColoredCandy(int i) {
        return totalCandy.get(i);
    }
    //return each Mat Color left
    public ArrayList<element> getMatCandy(int i) {
        return MatCandy.get(i);
    }

    public element getPlayerMetal(int i) {
        return playerMetal.get(i);
    }

    //add cards
    public void addCards(element temp) {
        player.add(temp);
    }

    //add the player played card to the poistion mat
    public void addMatLocation(int i, element e) {
        Matcards.get(i).add(e);
    }

    //put the player won candy to their own arraylist
    public void addWonCandy(ArrayList<element> al) {
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getNum() >= 0 && al.get(i).getNum() < 5)
                totalCandy.get(0).add(al.get(i));
            else if (al.get(i).getNum() >= 5 && al.get(i).getNum() < 12)
                totalCandy.get(1).add(al.get(i));
            else if (al.get(i).getNum() >= 12 && al.get(i).getNum() < 21)
                totalCandy.get(2).add(al.get(i));
            else if (al.get(i).getNum() >= 21 && al.get(i).getNum() < 33)
                totalCandy.get(3).add(al.get(i));
            else
                totalCandy.get(4).add(al.get(i));
        }
    }

    //put the player won metal to their own arraylist
    public void addWonMetal(element a) {
        playerMetal.add(a);
    }

    //play a card and add a new one
    public void removeCards(element oldCard) {
        player.remove(oldCard);
    }

    public void setMatCandy(int i,ArrayList<element>ae) {
        for(int a=0;a<ae.size();a++){
            MatCandy.get(i).add(ae.get(a));
        }
    }

}
