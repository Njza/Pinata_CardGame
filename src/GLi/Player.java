package GLi;

import java.util.ArrayList;

public class Player {
    //player cards ArrayList
    private ArrayList<element> player = new ArrayList<>();
    private ArrayList<ArrayList> totalPlayerCandy = new ArrayList<>();
    private ArrayList<ArrayList> totalEachMatcards = new ArrayList<>();
    private ArrayList<ArrayList> totalEachMatCandy = new ArrayList<>();
    private ArrayList<element> playerMetal = new ArrayList<>();
    private String name;

    // pass the name of this player
    public Player(String name) {
        this.name = name;
        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                totalEachMatcards.add(new ArrayList<element>());
                totalEachMatCandy.add(new ArrayList<element>());
            }
            totalPlayerCandy.add(new ArrayList<element>());
        }
    }
    //return Player Metal size
    public int getPlayerMetalSize() {
        return playerMetal.size();
    }
    //return Player card size
    public int getPlayerSize() {
        return player.size();
    }

    //return the player name
    public String getName() {
        return name;
    }
    //return the card
    public element getCard(int id) {
        return player.get(id);
    }
    //add cards
    public void addCards(element temp) {
        player.add(temp);
    }

    //return each position mat player cards
    public ArrayList<element> getMatcards(int i) {
        return totalEachMatcards.get(i);
    }
    //return each color candy player owned
    public ArrayList<element> getColoredCandy(int i) {
        return totalPlayerCandy.get(i);
    }
    //return each Mat Color left
    public ArrayList<element> getMatCandy(int i) {
        return totalEachMatCandy.get(i);
    }
    //return player Metal card
    public element getPlayerMetal(int i) {
        return playerMetal.get(i);
    }
    //add the player played card to the position mat
    public void addMatLocation(int i, element e) {
        totalEachMatcards.get(i).add(e);
    }
    //put the player won metal to their own arraylist
    public void addWonMetal(element a) {
        playerMetal.add(a);
    }
    //put the player won candy to their own arraylist
    public void addWonCandy(ArrayList<element> al) {
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getNum() >= 0 && al.get(i).getNum() < 5)
                totalPlayerCandy.get(0).add(al.get(i));
            else if (al.get(i).getNum() >= 5 && al.get(i).getNum() < 12)
                totalPlayerCandy.get(1).add(al.get(i));
            else if (al.get(i).getNum() >= 12 && al.get(i).getNum() < 21)
                totalPlayerCandy.get(2).add(al.get(i));
            else if (al.get(i).getNum() >= 21 && al.get(i).getNum() < 33)
                totalPlayerCandy.get(3).add(al.get(i));
            else
                totalPlayerCandy.get(4).add(al.get(i));
        }
    }
    //play a card and add a new one
    public void removeCards(int i) {
        player.remove(i);
    }

    public void setMatCandy(int i,ArrayList<element>ae) {
        for (int index = 0; index < 4; index++) {
            if (index == i)
                for (int a = 0; a < ae.size(); a++) {
                    totalEachMatCandy.get(index).add(ae.get(a));
                }
        }
    }

    public void setMatcards(int i,ArrayList<element>ae) {
        for (int index = 0; index < 4; index++) {
            if (index == i)
                for (int a = 0; a < ae.size(); a++) {
                    totalEachMatcards.get(index).add(ae.get(a));
                }
        }
    }
}
