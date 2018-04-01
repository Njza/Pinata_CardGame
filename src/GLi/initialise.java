package GLi;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class initialise {
    //matsArrayList
    public ArrayList<Mat> Mats = new ArrayList<>();
    // all candy ArrayList
    private ArrayList<element> Allcandys = new ArrayList<>();
    //each mat candy ArrayList

    //all card ArrayList
    private ArrayList<element> AllCards = new ArrayList<>();
    //metal ArrayList
    public ArrayList<element> Metal = new ArrayList<>();

    public Player player1 = null;
    public Player player2 = null;
    private Random random = new Random();
    public initialise(){
        //create all
        creatAllCards();
        creatMetalCard();
        createMats();
        createCandy();
        player1=new Player("Player1");
        player2=new Player("Player2");
        for(int i=1;i<=8;i++) {
            if(i%2==0){
                addcandy(i/2);
            }
            player1.addCards(randomAcard());
            player2.addCards(randomAcard());
        }
        for(int a=1;a<4;a++){
            player1.setMatCandy(a,Mats.get(a).getCandy());
            player2.setMatCandy(a,Mats.get(a).getCandy());
        }

    }
    // add candys
    public void addcandy(int neednumber) {
        for (int a = neednumber; a > 0; a--) {
            if (Allcandys.size() > 0) {
                int number = random.nextInt(Allcandys.size());
                    if (Allcandys.size() > neednumber) {
                        Mats.get(neednumber - 1).addCandy(Allcandys.get(number));
                    }
                    else
                        break;
                //remove that added candy
                Allcandys.remove(number);
                }
            }
        }
    //carete all cards
    private void creatAllCards() {
        int number = 0;
        for (int i = 1; i <= 5; i++) {
            number = (i + 1) / 2;
            //each card has 2 number last one have 1
            if (i % 2 == 0) {
                AllCards.add(new element(Color.YELLOW, number));
            } else {
                AllCards.add(new element(Color.YELLOW, number));
            }
        }
        for (int i = 1; i <= 7; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                AllCards.add(new element(Color.PINK, number));
            } else {
                AllCards.add(new element(Color.PINK, number));
            }
        }
        for (int i = 1; i <= 9; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                AllCards.add(new element(Color.MAGENTA, number));
            } else {
                AllCards.add(new element(Color.MAGENTA, number));
            }
        }
        for (int i = 1; i <= 11; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                AllCards.add(new element(Color.GREEN, number));
            } else {
                AllCards.add(new element(Color.GREEN, number));
            }
        }
        for (int i = 1; i <= 13; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                AllCards.add(new element(Color.RED, number));
            } else {
                AllCards.add(new element(Color.RED, number));
            }
        }
        for (int i = 1; i <= 9; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                AllCards.add(new element(Color.BLACK, number));
            } else {
                AllCards.add(new element(Color.BLACK, number));
            }
        }
    }

    //create all metal cards
    private void creatMetalCard() {
        Metal.add(new element(Color.YELLOW, 3));
        Metal.add(new element(Color.PINK, 4));
        Metal.add(new element(Color.MAGENTA, 5));
        Metal.add(new element(Color.GREEN, 6));
        Metal.add(new element(Color.RED, 7));
    }

    //create all Mats cards
    private void createMats() {
        int i = 1;
        while (i <= 4) {
            boolean a = random.nextBoolean();
            Mats.add(new Mat(i, a));
            i++;
        }
    }
    //create all Candys
    private void createCandy() {
        int i = 0;
        while (i < 45) {
            //yellow have 5
            if (i >= 0 && i < 5)
                Allcandys.add(new element(Color.YELLOW, i));
            else if (i >= 5 && i < 12)
                Allcandys.add(new element(Color.PINK, i));
            else if (i >= 12 && i < 21)
                Allcandys.add(new element(Color.MAGENTA, i));
            else if (i >= 21 && i < 33)
                Allcandys.add(new element(Color.GREEN, i));
            else
                Allcandys.add(new element(Color.RED, i));
            i++;
        }
    }
    // random a card
    public element randomAcard() {
        element b = AllCards.get(random.nextInt(AllCards.size()));
        AllCards.remove(b);
        return b;
    }

    public ArrayList<element> getMetal() {
        return Metal;
    }
}
