/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import poker.com.example.domain.*;
import static poker.com.example.domain.Suit.*;

/**
 *
 * @author madi
 */
public class PokerTest {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {

        int count = 0;
        boolean found = false;

        while (found == false) {
            found = a();
            count++;
        }
  
System.out.println("Count is " + count);

    }

    static boolean a() {
        Deck d = new Deck();
        Flop flop = d.getFlop();
        Card turn = d.getTurn();
        Card river = d.getRiver();
        CommunityCards communityCards = new CommunityCards(flop,turn,river);

        HoleCards h1 = new HoleCards(d.getCard(),d.getCard());
        
        HoleCardsRankFinder rankFinder = new HoleCardsRankFinder(h1,communityCards.getCommunityCards());
        
        System.out.println("Hole cards: " + h1);
        printList("Commmunity Cards: ",communityCards.getCommunityCards());
        printList("Hole n CommunityCards: ", rankFinder.getHoleNCommunityCards());

        
        int straightFlushHighCard = rankFinder.checkStraightFlush();
        if (straightFlushHighCard > 0) {
            System.out.println("==========================================");

            printList("Board List: ", rankFinder.getHoleNCommunityCards());
            System.out.println(h1);

            System.out.println("suit map : " + rankFinder.getSuitMap());
            System.out.println("Player has " + straightFlushHighCard + " high straigh flush.");
            return true;
        }

        return false;

    }

    static void printList(String s, Collection col) {   // with toString implementation of elements
        System.out.print(s + "[");
        for (Object item : col) {
            System.out.print(item + " ");
        }
        System.out.println("]");
    }

    static Set<Comparable> getUniqueList(Collection<Comparable> list) {
        Set<Comparable> uniqueCardList = new TreeSet<>();

        for (Comparable c : list) {
            uniqueCardList.add(c);
        }
        return uniqueCardList;
    }

}
