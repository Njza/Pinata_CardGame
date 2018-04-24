package GLi;

import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PinataTest {
//    @Test
//    public void testFull()throws IOException {
//        Pinata m = new Pinata();
//        initialise i = new initialise();
//        i.player1.addMatLocation(0, i.player1.getCard(0));
//        i.player1.addMatLocation(0, i.player1.getCard(1));
//        assertFalse(m.checkFull(i.player1, 1));
//    }
//    @Test
//    public void testNotFull()throws IOException {
//        Pinata m = new Pinata();
//        initialise i = new initialise();
//        i.player1.addMatLocation(1, i.player1.getCard(0));
//        assertTrue(m.checkFull(i.player1, 2));
//    }
//
//
//    @Test
//    public void testMat1Color()throws IOException {
//        Pinata m = new Pinata();
//        Player p=new Player("test");
//        ArrayList<element>a=new ArrayList<>();
//        element candy=new element(Color.GREEN,1);
//        a.add(candy);
//        p.setMatCandy(0,a);
//        element element =new element(Color.RED,1);
//        element elementT =new element(Color.GREEN,1);
//        element elementB =new element(Color.BLACK,1);
//        assertFalse(m.checkColor(element,p,0));
//        assertTrue(m.checkColor(elementT,p,0));
//        assertTrue(m.checkColor(elementB,p,0));
//    }
//    @Test
//    public void testMat2Color()throws IOException {
//        Pinata m = new Pinata();
//        Player p=new Player("test");
//        ArrayList<element>a=new ArrayList<>();
//        element candy1=new element(Color.GREEN,1);
//        element candy2=new element(Color.RED,1);
//        a.add(candy1);
//        a.add(candy2);
//        p.setMatCandy(1,a);
//        element element =new element(Color.RED,1);
//        element elementF =new element(Color.YELLOW,1);
//        element elementT =new element(Color.GREEN,1);
//        element elementB =new element(Color.BLACK,1);
//        assertTrue(m.checkColor(element,p,1));
//        assertTrue(m.checkColor(elementT,p,1));
//        assertTrue(m.checkColor(elementB,p,1));
//        assertFalse(m.checkColor(elementF,p,1));
//    }
//
//    @Test
//    public void testCheckTotalNotEqual()throws IOException {
//        Pinata m = new Pinata();
//        ArrayList<element>e =new ArrayList<>();
//        Player p1=new Player("Test1");
//        Player p2=new Player("Test2");
//        element element1 =new element(Color.RED,5);
//        element element2 =new element(Color.RED,4);
//        e.add(element1);
//        p2.setMatcards(0,e);
//        assertTrue(m.checkTotalEqual(0,p1,p2, element2));
//    }
//    @Test
//    public void testCheckTotalEqual()throws IOException {
//        Pinata m = new Pinata();
//        ArrayList<element>e1 =new ArrayList<>();
//        ArrayList<element>e2 =new ArrayList<>();
//        Player p1=new Player("Test1");
//        Player p2=new Player("Test2");
//        element element1 =new element(Color.RED,3);
//        element element2 =new element(Color.RED,4);
//        element element3 =new element(Color.YELLOW,3);
//        element element4 =new element(Color.YELLOW,2);
//        element element5 =new element(Color.GREEN,3);
//        element element6 =new element(Color.GREEN,5);
//        e2.add(element1);
//        e2.add(element3);
//        e2.add(element2);
//        e1.add(element4);
//        e1.add(element6);
//        p2.setMatcards(2,e2);
//        p1.setMatcards(2,e1);
//        assertFalse(m.checkTotalEqual(2,p1,p2, element5));
//    }
//
//    @Test
//    public void TestGetCard() throws IOException {
//        Pinata m=new Pinata();
//        Player p1=new Player("test");
//        element e1=new element(Color.RED,7);
//        element e2=new element(Color.BLACK,3);
//        p1.addCards(e1);
//        p1.addCards(e2);
//        int num=1;
//        assertEquals(e1,p1.getCard(num-1));
//
//    }
}