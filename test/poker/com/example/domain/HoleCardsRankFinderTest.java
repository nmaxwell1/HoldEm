/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain;

import poker.com.example.domain.rankfinder.HoleCardsRankFinder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static poker.com.example.domain.Suit.*;
import poker.com.example.domain.rank.*;

/**
 *
 * @author madi
 */
public class HoleCardsRankFinderTest {

    CommunityCards communityCardsInstance;
    HoleCards holeCards;

    public HoleCardsRankFinderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
                System.out.println("myBeforeClassMethod - Set things up once for all");

    }

    @AfterClass
    public static void tearDownClass() {
                System.out.println("myBeforeClassMethod - Clean things up once for all");

    }

    @Before
    public void setUp() {
        Card a = new Card(11, CLUB);
        Card b = new Card(9, CLUB);
        holeCards = new HoleCards(a, b);

        Card f1 = new Card(10, CLUB);
        Card f2 = new Card(12, SPADE);
        Card f3 = new Card(13, HEART);
        Card turn = new Card(3, CLUB);
        Card river = new Card(7, CLUB);

        Flop flop = new Flop(f1, f2, f3);

        communityCardsInstance = new CommunityCards(flop, turn, river);

    }

    @After
    public void tearDown() {
    }

/*    
    public HoleCardsRankFinder getInstanceHoleCardRank() {
        Card a = new Card(11, CLUB);
        Card b = new Card(9, CLUB);
        HoleCards holeCards = new HoleCards(a, b);
        
        Card f1 = new Card(10, CLUB);
        Card f2 = new Card(12, SPADE);
        Card f3 = new Card(13, HEART);
        Card turn = new Card(3, CLUB);
        Card river = new Card(7, CLUB);
        
        Flop flop = new Flop(f1,f2,f3);
        
        CommunityCards boardClass = new CommunityCards(flop,turn,river);
        
        return new HoleCardsRankFinder(holeCards, boardClass);
         
        return null;

    }
*/
    /**
     * Test of getHoleCards method, of class HoleCardsRankFinder.
     */
    @Test
    public void testGetHoleCards() {
        
        
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
//        System.out.println("getHoleCards: " + instance.getHoleCards());

        HoleCards expResult = holeCards;
        HoleCards result = instance.getHoleCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommunityCards method, of class HoleCardsRankFinder.
     */
    @Test
    public void testGetCommunityCards() {
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);

//        System.out.println("getCommunityCards: " + instance.getCommunityCards());

          ArrayList<Card> expResult = communityCardsInstance.getCommunityCards();
        ArrayList<Card> result = instance.getCommunityCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkStraight method, of class HoleCardsRankFinder.
     */
    @Test
    public void testCheckStraight() {
        System.out.println("checkStraight");
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        int expResult = 13;
        int result = instance.checkStraight();
        System.out.println(instance.getRankMap() + "Straight: " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlushSuit method, of class HoleCardsRankFinder.
     */
    @Test
    public void testGetFlushSuit() {
        System.out.println("getFlushSuit");
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        Suit expResult = CLUB;

        Suit result = instance.getFlushSuit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkStraightFlush method, of class HoleCardsRankFinder.
     */
    @Test
    public void testCheckStraightFlush_0args() {
        System.out.println("checkStraightFlush");
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        int expResult = 0;
        int result = instance.checkStraightFlush();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkStraightFlush method, of class HoleCardsRankFinder.
     */
    @Test
    public void testCheckStraightFlush_Suit() {
        System.out.println("checkStraightFlush");
        Suit flushSuit = SPADE;
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        int expResult = 0;
        int result = instance.checkStraightFlush(flushSuit);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestTripsInList method, of class HoleCardsRankFinder.
     */
    @Test
    public void testGetHighestTripsInList() {
        System.out.println("getHighestTripsInList");
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        int expResult = 0;
        int result = instance.getHighestTripsInList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuadsInList method, of class HoleCardsRankFinder.
     */
    @Test
    public void testGetQuadsInList() {
        System.out.println("getQuadsInList");
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        int expResult = 0;
        int result = instance.getQuadsInList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestKey method, of class HoleCardsRankFinder.
     */
    @Test
    public void testGetHighestKey() {
        System.out.println("getHighestKey");
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        Map<Integer, Integer> map = instance.getRankMap();
        int value = 2;

        int expResult = 0;
        int result = instance.getHighestKey(map, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of cardFoundInHoleNCommunityCardsList method, of class
     * HoleCardsRankFinder.
     */
    @Test
    public void testCardFoundInHoleNCommunityCardsList() {
        System.out.println("cardFoundInHoleNCommunityCardsList");
        int rank = 14;
        Suit suit = SPADE;
        HoleCardsRankFinder instance = new HoleCardsRankFinder(holeCards, communityCardsInstance);
        boolean expResult = false;
        boolean result = instance.cardFoundInHoleNCommunityCardsList(rank, suit);
        assertEquals(expResult, result);
    }

}
