package GLi;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private BufferedWriter writer;
    private initialise newgame;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.newgame = new initialise();
        main.writer = new BufferedWriter(new FileWriter("output.txt"));
        main.intro();
        main.display(main.newgame.player1,main.newgame.player2);
        main.playing(main.newgame.player1,main.newgame.player2);
        main.writer.flush();
        main.writer.close();
    }
    //get user input want to play
    public int getplayercard(Player p) throws IOException {
        System.out.println(p.getName() + " Please input which card you want to play:");
        writer.write(p.getName() + " Please input which card you want to play:" + "\r\n");
        String line;
        int cardNum = -1;
        try {
            //read the value from keboard
            line = scanner.nextLine();
            cardNum = Integer.valueOf(line);
            writer.write(line + "\r\n");
            //check the number if >8 ||<0 return null
            if (cardNum > 8 || cardNum < 1) {
                cardNum = -1;
                System.out.println(p.getName() + " You must input card number from 1-8");
                writer.write(p.getName() + " You must input card number from 1-8" + "\r\n");
            }
            //catch input not a number
        } catch (Exception ex) {
            System.out.println("You can only input number 1-8");
            writer.write("You can only input number 1-8" + "\r\n");
        }
        return cardNum;
    }
    //get the location where to put the cards, retun the position
    public int getlocation(Player p) throws IOException {
        String line;
        int location = 0;
        try {
            System.out.println(p.getName() + " Please input which location you want to play:(1-4)");
            writer.write(p.getName() + " Please input which location you want to play:(1-4)" + "\r\n");
            //get inupt number
            line = scanner.nextLine();
            location = Integer.valueOf(line);
            writer.write(line + "\r\n");
            //if not between 1-4 display error
            if (location < 1 || location > 4) {
                System.out.println("Sorry input a number between 1-4");
                writer.write("Sorry input a number between 1-4" + "\r\n");
            }
            //not number display error
        } catch (Exception ex) {
            System.out.println("Sorry input a number between 1-4");
            writer.write("Sorry input a number between 1-4" + "\r\n");
        }
        //return position
        return location;
    }

    public void playing(Player p1,Player p2) throws IOException {
        Player p;
        while (true) {
            if(p1.getPlayerMetalSize()==3){
                System.out.println(p1.getName()+" YOU WIN!!");
                writer.write(p1.getName()+" YOU WIN!!"+ "\r\n");
                break;
            }
            if(p2.getPlayerMetalSize()==3){
                System.out.println(p1.getName()+" YOU WIN!!");
                writer.write(p1.getName()+" YOU WIN!!"+ "\r\n");
                break;
            }
            int num = getplayercard(p1);
            //get where to put the card
            int location = getlocation(p1);
            //if get a null let user input again
            if (num == -1||location==0) {
                playing(p1, p2);
            }
            element e=p1.getCard(num-1);
            //check is full to put the card and check the card color match the candy color and check last put card value can not make them equal
            for (int index = 0; index <4; index++) {
                if (location - 1 == index) {
                    if (checkFull(p1, location) && checkColor(e, p1, index)) {
                        if(checkTotalEqual(index, p1, p2, e)) {
                            p1.removeCards(num-1);
                            p1.addMatLocation(index, e);
                            p1.addCards(newgame.randomAcard());
                            if (p1.getMatcards(index).size() == location && p2.getMatcards(index).size() == location) {
                                boolean state = newgame.Mats.get(index).getMatStates();
                                p = comparePlayer(state, index, p1, p2);
                                p.addWonCandy(newgame.Mats.get(index).getCandy());
                                newgame.Mats.get(index).reverseState();
                                newgame.Mats.get(index).getCandy().clear();
                                newgame.addcandy(location);
                                p1.getMatcards(index).clear();
                                p2.getMatcards(index).clear();
                                p1.getMatCandy(index).clear();
                                p2.getMatCandy(index).clear();
                                p1.setMatCandy(index, newgame.Mats.get(index).getCandy());
                                p2.setMatCandy(index, newgame.Mats.get(index).getCandy());
                                winMetal(p1);
                                winMetal(p2);
                                System.out.println(p.getName() + " You Win The Mat " + newgame.Mats.get(index).getMatValue() + "'s candy");
                                writer.write(p.getName() + " You Win The Mat " + newgame.Mats.get(index).getMatValue() + "'s candy" + "\r\n");
                            }
                            display(p2,p1);
                            playing(p2, p1);
                        }
                    } else {
                        System.out.println("sorry this card can not put in here please select another one!!");
                        writer.write("sorry this card can not put in here please select another one!!" + "\r\n");
                        playing(p1, p2);
                    }

                }
            }
        }
    }
    //check the each mat place is full or not return true false to let player put
    public boolean checkFull(Player p, int i) {
        boolean notfull = true;
        if (p.getMatcards(i-1).size() >= i)
            notfull = false;
        return notfull;
    }

    //check the each mat candy color is same as the player played card color
    //if true return true else false
    public boolean checkColor(element e,Player p, int i) {
        boolean matchColor = false;
        if (e.getColors().equals(Color.BLACK)) {
            matchColor = true;
        } else {
            for (int a = 0; a < p.getMatCandy(i).size(); a++) {
                if (e.getColors().equals(p.getMatCandy(i).get(a).getColors())) {
                    matchColor = true;
                }
            }
        }
        return matchColor;
    }

    //check last value can not make them to equal
    public boolean checkTotalEqual(int i, Player p1, Player p2,element e) {

        boolean notEqual = true;
        int totalp1, totalp2;
        if (p2.getMatcards(i).size() == i+1 && p1.getMatcards(i).size() == i) {
            totalp2 = calTotalValue(p2, i);
            totalp1 = calTotalValue(p1, i)+e.getNum();
            if (totalp2 == totalp1) {
                notEqual = false;
            }
        }
        //return
        return notEqual;
    }

    // calculate the total num of player put in a mat
    public int calTotalValue(Player p, int i) {
        int total = 0;
        for (int a = 0; a < p.getMatcards(i).size(); a++) {
            total += p.getMatcards(i).get(a).getNum();
        }
        return total;
    }
    //each candy can exchange metal card
    private void winMetal(Player p) {
        for (int i = 0; i < 5; i++) {
            if (p.getColoredCandy(i).size() >= i + 3 && newgame.getMetal().get(i).getNum() == i + 3) {
                p.addWonMetal(newgame.getMetal().get(i));
                newgame.getMetal().get(i).setElementNum(0);
                for (int a = 0; a < i + 3; a++)
                    p.getColoredCandy(i).remove(0);
            }
        }
    }
    //compare which player win the candys
    public Player comparePlayer(boolean state, int location,Player p1,Player p2) {
        int num = calTotalValue(p1,location) - calTotalValue(p2,location);
        if (num > 0 && state || num < 0 && !state)
            return p1;
        else
            return p2;
    }


    private void intro() {
        try {
            System.out.println("!!!!!!!Pinata Game!!!");
            writer.write("!!!!!!!Pinata Game!!!"+ "\r\n");

            System.out.println("            Rules              ");
            writer.write("            Rules              "+ "\r\n");

            System.out.println("                           ");
            writer.write("                           "+ "\r\n");

            System.out.println("1. This 2-player card game ");
            writer.write("1. This 2-player card game "+ "\r\n");

            System.out.println("2. We have 4 playing mats,");
            writer.write("2. We have 4 playing mats,"+ "\r\n");

            System.out.println("3. 1 bag, 45 colored candy pieces, ");
            writer.write("3. 1 bag, 45 colored candy pieces, "+ "\r\n");

            System.out.println("4. 54 playing cards (45 color, 9 wild)");
            writer.write("4. 54 playing cards (45 color, 9 wild)"+ "\r\n");

            System.out.println("5. 5 “medal” cards in this game. ");
            writer.write("5. 5 “medal” cards in this game. "+ "\r\n");

            System.out.println("6. Each player have 8 cards Each card has a color and number,including the 9 wild cards that are used as any color.");
            writer.write("6. Each player have 8 cards Each card has a color and number,including the 9 wild cards that are used as any color."+ "\r\n");

            System.out.println("7. the cards you play next to each mat must match the color of the candy on the ma,and that number of cards must be on each side of the mat. ");
            writer.write("7. the cards you play next to each mat must match the color of the candy on the ma,and that number of cards must be on each side of the mat. "+ "\r\n");

            System.out.println("8. An important rule to remember is that the final card played on a mat cannot make the score on either side of the mat equal ");
            writer.write("8. An important rule to remember is that the final card played on a mat cannot make the score on either side of the mat equal "+ "\r\n");

            System.out.println("9. If they have the matching number of candies on its colour's medal card, they may take that medal.\n"
                    + "The game ends when a player has collected 3 medal cards.");
            writer.write("9. If they have the matching number of candies on its colour's medal card, they may take that medal." +
                    "The game ends when a player has collected 3 medal cards."+ "\r\n");

            System.out.println(" If at any time the candies begin to run low and a mat must be placed, it is removed from game if there are not enough candies. \n"
                    + "10. If Mat 4 scores, and the players go to place 4 candies but there are only 3, that mat is discarded from the game and continues.");
            writer.write(" If at any time the candies begin to run low and a mat must be placed, it is removed from game if there are not enough candies. " +
                    "10. If Mat 4 scores, and the players go to place 4 candies but there are only 3, that mat is discarded from the game and continues."+ "\r\n");

            System.out.println("                           ");
            writer.write("                           "+ "\r\n");

            System.out.println("                           ");
            writer.write("                           "+ "\r\n");

            System.out.println("If ready tpye yes to play");
            writer.write("If ready tpye yes to play"+ "\r\n");

            String line=scanner.nextLine();
            line=line.replaceAll("\\s", "");
            line=line.toUpperCase();
            if (!line.equals("YES"))
                intro();

        } catch (Exception ex) {
            intro();
        }


    }

    private void display(Player p1, Player p2) throws IOException {
        String number;
        String cardnum ;
        String color;
        System.out.print("Metal Cards:   ");
        writer.write("Metal Cards:   ");
        //display metals
        for (int i = 0; i < newgame.Metal.size(); i++) {
            if (newgame.Metal.get(i).getNum() != 0) {
                color=newgame.Metal.get(i).colorToString();
                cardnum=String.valueOf(newgame.Metal.get(i).getNum());
                System.out.print(padLeft(cardnum,4) + padLeft(color,20));
                writer.write(padLeft(cardnum,4) + padLeft(color,20));
            }
        }
        System.out.println("                                 ");
        writer.write("                                 " + "\r\n");
        System.out.println("                                 ");
        writer.write("                                 " + "\r\n");
        //display candys and player played cards
        for (int a = 0; a <4; a++) {
            //display Mats card
            System.out.println(newgame.Mats.get(a).getMatValue() + "  " + newgame.Mats.get(a).getName());
            writer.write(newgame.Mats.get(a).getMatValue() + "  " + newgame.Mats.get(a).getName() + "\r\n");
            //display Mats candys
            for (int i = 0; i < newgame.Mats.get(a).getCandy().size(); i++) {
                color=newgame.Mats.get(a).getCandy().get(i).colorToString();
                System.out.println(padLeft("Candy",8)+ padLeft(color,10));
                writer.write(padLeft("Candy",8)+ padLeft(color,10)+ "\r\n");
                    //display each card in each mat that player played
                    for (int b = 0; b < p1.getMatcards(a).size(); b++) {
                        if(p1.getMatcards(i).size()>0) {
                            cardnum = String.valueOf(p1.getMatcards(i).get(b).getNum());
                            color = p1.getMatcards(i).get(b).colorToString();
                            System.out.println(padLeft(p1.getName(), 10) + padLeft(cardnum, 5) + padLeft(color, 20));
                            writer.write(padLeft(p1.getName(), 10) + padLeft(cardnum, 5) + padLeft(color, 20) + "\r\n");
                        }
                    }
                    //display each card in each mat that another player played
                    for (int b = 0; b < p2.getMatcards(a).size(); b++) {
                        if(p2.getMatcards(i).size()>0) {
                            cardnum = String.valueOf(p2.getMatcards(i).get(b).getNum());
                            color = p2.getMatcards(i).get(b).colorToString();
                            System.out.println(padLeft(p2.getName(), 10) + padLeft(cardnum, 5) + padLeft(color, 20));
                            writer.write(padLeft(p2.getName(), 10) + padLeft(cardnum, 5) + padLeft(color, 20) + "\r\n");
                        }
                    }
            }
        }
        System.out.println("                                 ");
        writer.write("                                 " + "\r\n");
        System.out.println(padLeft(p1.getName(), 30));
        writer.write(padLeft(p1.getName(), 30) + "\r\n");
        System.out.println("                                 ");
        writer.write("                                 "+ "\r\n");
        //display player owned cards
        for (int i = 0; i < p1.getPlayerSize(); i++) {
            number = String.valueOf(i+1);
            cardnum = String.valueOf(p1.getCard(i).getNum());
            color=p1.getCard(i).colorToString();
            System.out.println(padLeft(number, 10) + padLeft(cardnum, 5) + padLeft(color, 20));
            writer.write(padLeft(number, 10) + padLeft(cardnum, 5) + padLeft(color, 20)+"\r\n");
        }
        System.out.println("                                 ");
        writer.write("                                 "+ "\r\n");
        System.out.println(padLeft(p1.getName(), 30)+padLeft("candys: ",30));
        writer.write(padLeft(p1.getName(), 30) +padLeft("candys: ",30)+ "\r\n");
        //dispaly player owned candy
        for (int i = 0; i < 5; i++) {
                try {
                    if (i == 0) {
                        color = "Yellow";
                        number = String.valueOf(p1.getPlayerMetal(i).getNum());
                        System.out.println(padLeft(number, 3) + padLeft(color, 5));
                        writer.write(padLeft(number, 3) + padLeft(color, 5) + "\r\n");
                    }
                    if (i == 1) {
                        color = "Pink";
                        number = String.valueOf(p1.getPlayerMetal(i).getNum());
                        System.out.println(padLeft(number, 3) + padLeft(color, 5));
                        writer.write(padLeft(number, 3) + padLeft(color, 5) + "\r\n");
                    }
                    if(i==2){
                        color = "Purple";
                        number = String.valueOf(p1.getPlayerMetal(i).getNum());
                        System.out.println(padLeft(number, 3) + padLeft(color, 5));
                        writer.write(padLeft(number, 3) + padLeft(color, 5) + "\r\n");
                    }
                    if(i==3){
                        color = "Green";
                        number = String.valueOf(p1.getPlayerMetal(i).getNum());
                        System.out.println(padLeft(number, 3) + padLeft(color, 5));
                        writer.write(padLeft(number, 3) + padLeft(color, 5) + "\r\n");
                    }
                    if(i==4){
                        color = "Red";
                        number = String.valueOf(p1.getPlayerMetal(i).getNum());
                        System.out.println(padLeft(number, 3) + padLeft(color, 5));
                        writer.write(padLeft(number, 3) + padLeft(color, 5) + "\r\n");
                    }
            }
            catch (Exception ex)
            {

            }

        }
        System.out.println("                                 ");
        writer.write("                                 "+ "\r\n");
        System.out.println(padLeft(p1.getName(), 30)+padLeft("Metals: ",30));
        writer.write(padLeft(p1.getName(), 30) +padLeft("Metals: ",30)+ "\r\n");
        //display plpayer owned metal cards
        for (int i = 0; i < p1.getPlayerMetalSize(); i++) {
            try {
                if(p1.getPlayerMetalSize()>0) {
                    color = p1.getPlayerMetal(i).colorToString();
                    number = String.valueOf(p1.getPlayerMetal(i).getNum());
                    System.out.println(padLeft(number, 3) + padLeft(color, 5));
                    writer.write(padLeft(number, 3) + padLeft(color, 5) + "\r\n");
                }
            }
            catch (Exception ex)
            {

            }

        }
    }
    //display format
    private static String padLeft(String s, int len) {
        return String.format("%1$-" + len + "s", s);
    }
}
