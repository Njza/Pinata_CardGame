package GLi;

import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testFull() {
        Main m = new Main();
        initialise i = new initialise();
        i.player1.addMatLocation(0, i.player1.getCard(0));
        i.player1.addMatLocation(0, i.player1.getCard(1));
        assertFalse(m.checkFull(i.player1, 1));
    }
    @Test
    public void testNotFull() {
        Main m = new Main();
        initialise i = new initialise();
        i.player1.addMatLocation(1, i.player1.getCard(0));
        assertTrue(m.checkFull(i.player1, 2));
    }


    @Test
    public void testMat1Color() {
        Main m = new Main();
        Player p=new Player("test");
        ArrayList<element>a=new ArrayList<>();
        element candy=new element(Color.GREEN,1);
        a.add(candy);
        p.setMatCandy(0,a);
        element card=new element(Color.RED,1);
        element cardT=new element(Color.GREEN,1);
        element cardB=new element(Color.BLACK,1);
        assertFalse(m.checkColor(card,p,0));
        assertTrue(m.checkColor(cardT,p,0));
        assertTrue(m.checkColor(cardB,p,0));
    }
    @Test
    public void testMat2Color() {
        Main m = new Main();
        Player p=new Player("test");
        ArrayList<element>a=new ArrayList<>();
        element candy1=new element(Color.GREEN,1);
        element candy2=new element(Color.RED,1);
        a.add(candy1);
        a.add(candy2);
        p.setMatCandy(1,a);
        element card=new element(Color.RED,1);
        element cardF=new element(Color.YELLOW,1);
        element cardT=new element(Color.GREEN,1);
        element cardB=new element(Color.BLACK,1);
        assertTrue(m.checkColor(card,p,1));
        assertTrue(m.checkColor(cardT,p,1));
        assertTrue(m.checkColor(cardB,p,1));
        assertFalse(m.checkColor(cardF,p,1));
    }

    @Test
    public void testCheckTotalNotEqual() {
        Main m = new Main();
        ArrayList<element>e =new ArrayList<>();
        Player p1=new Player("Test1");
        Player p2=new Player("Test2");
        element card1 =new element(Color.RED,5);
        element card2 =new element(Color.RED,4);
        e.add(card1);
        p2.setMatcards(0,e);
        assertTrue(m.checkTotalEqual(0,p1,p2,card2));
    }
    @Test
    public void testCheckTotalEqual() {
        Main m = new Main();
        ArrayList<element>e1 =new ArrayList<>();
        ArrayList<element>e2 =new ArrayList<>();
        Player p1=new Player("Test1");
        Player p2=new Player("Test2");
        element card1 =new element(Color.RED,3);
        element card2 =new element(Color.RED,4);
        element card3 =new element(Color.YELLOW,3);
        element card4 =new element(Color.YELLOW,2);
        element card5 =new element(Color.GREEN,3);
        element card6 =new element(Color.GREEN,5);
        e2.add(card1);
        e2.add(card3);
        e2.add(card2);
        e1.add(card4);
        e1.add(card6);
        p2.setMatcards(2,e2);
        p1.setMatcards(2,e1);
        assertFalse(m.checkTotalEqual(2,p1,p2,card5));
    }

    @Test
    public void TestGetCard() throws IOException {
        Main m=new Main();
        Player p1=new Player("test");
        element e1=new element(Color.RED,7);
        element e2=new element(Color.BLACK,3);
        p1.addCards(e1);
        p1.addCards(e2);
        int num=1;
        assertEquals(e1,p1.getCard(num-1));

    }
}