package GLi;

import java.util.ArrayList;
import java.util.Random;

public class initialise {

    private Random random = new Random();

    public initialise() {
        init();
        //create all
        creatAllCards();
        creatMetalCard();
        createMats();
        createCandy();
        Cache.player1 = new Player("Player1");
        Cache.player2 = new Player("Player2");
        for (int i = 1; i <= 8; i++) {
            if (i % 2 == 0) {
                addcandy(i / 2);
            }
            Cache.player1.addCards(randomAcard());
            Cache.player2.addCards(randomAcard());
        }
        for (int a = 0; a < 4; a++) {
            Cache.player1.setMatCandy(a, Cache.Mats.get(a).getCandy());
            Cache.player2.setMatCandy(a, Cache.Mats.get(a).getCandy());
        }
    }

    public void init() {
        Cache.Mats = new ArrayList<>();
        Cache.Metal = new ArrayList<>();
        Cache.player1 = null;
        Cache.player2 = null;
        Cache.allCards = new ArrayList<>();
        Cache.Allcandys = new ArrayList<>();
    }

    // add candys
    public void addcandy(int neednumber) {
        for (int a = neednumber; a > 0; a--) {
            if (Cache.Allcandys.size() > 0) {
                int number = random.nextInt(Cache.Allcandys.size());
                if (Cache.Allcandys.size() > neednumber) {
                    Cache.Mats.get(neednumber - 1).addCandy(Cache.Allcandys.get(number));
                } else
                    break;
                //remove that added candy
                Cache.Allcandys.remove(number);
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
                Cache.allCards.add(new card("yellow", number));
            } else {
                Cache.allCards.add(new card("yellow", number));
            }
        }
        for (int i = 1; i <= 7; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                Cache.allCards.add(new card("pink", number));
            } else {
                Cache.allCards.add(new card("pink", number));
            }
        }
        for (int i = 1; i <= 9; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                Cache.allCards.add(new card("purple", number));
            } else {
                Cache.allCards.add(new card("purple", number));
            }
        }
        for (int i = 1; i <= 11; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                Cache.allCards.add(new card("green", number));
            } else {
                Cache.allCards.add(new card("green", number));
            }
        }
        for (int i = 1; i <= 13; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                Cache.allCards.add(new card("red", number));
            } else {
                Cache.allCards.add(new card("red", number));
            }
        }
        for (int i = 1; i <= 9; i++) {
            //each card has 2 number last one have 1
            number = (i + 1) / 2;
            if (i % 2 == 0) {
                Cache.allCards.add(new card("wild", number));
            } else {
                Cache.allCards.add(new card("wild", number));
            }
        }
    }

    //create all metal cards
    private void creatMetalCard() {
        Cache.Metal.add(new card("Ayellow", 3));
        Cache.Metal.add(new card("Apink", 4));
        Cache.Metal.add(new card("Apurple", 5));
        Cache.Metal.add(new card("Agreen", 6));
        Cache.Metal.add(new card("Ared", 7));
    }

    //create all Mats cards
    private void createMats() {
        int i = 1;
        while (i <= 4) {
            boolean a = random.nextBoolean();
            if (a)
                Cache.Mats.add(new Mat("up", i));
            else
                Cache.Mats.add(new Mat("down", i));
            i++;
        }
    }

    //create all Candys
    private void createCandy() {
        int i = 0;
        while (i < 45) {
            //yellow have 5
            if (i >= 0 && i < 5)
                Cache.Allcandys.add(new candy("sugeryellow", i));
            else if (i >= 5 && i < 12)
                Cache.Allcandys.add(new candy("sugerpink", i));
            else if (i >= 12 && i < 21)
                Cache.Allcandys.add(new candy("sugerpurple", i));
            else if (i >= 21 && i < 33)
                Cache.Allcandys.add(new candy("sugergreen", i));
            else
                Cache.Allcandys.add(new candy("sugerred", i));
            i++;
        }
    }
    // random a card
    public element randomAcard() {
        element b = Cache.allCards.get(random.nextInt(Cache.allCards.size()));
        Cache.allCards.remove(b);
        return b;
    }
}
