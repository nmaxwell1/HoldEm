/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain.rankfinder;

import poker.com.example.domain.rankfinder.CardMaps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import poker.com.example.domain.Card;
import poker.com.example.domain.CommunityCards;
import poker.com.example.domain.HoleCards;
import poker.com.example.domain.Suit;

/**
 * To establish ranking of Holecards relative to the Board (List <Card>)
 *
 * @author Hammad Quddus
 */
public class HoleCardsRankFinder extends CardMaps//implements Comparator<HoleCards> {
{

    protected HoleCards holeCards;
    protected ArrayList<Card> communityCards; // sorted

    public HoleCardsRankFinder(HoleCards holeCards, CommunityCards communityCardsInstance) {
        super(holeCards, communityCardsInstance.getCommunityCards());
        this.holeCards = holeCards;
        ArrayList<Card> communityCards = communityCardsInstance.getCommunityCards();
        Collections.sort(communityCards);
        this.communityCards = (ArrayList<Card>) communityCards;
    }

    public HoleCards getHoleCards() {
        return holeCards;
    }

    public ArrayList<Card> getCommunityCards() {
        return communityCards;
    }

    // returns 0 if no straight or else return high card for straight
    public int checkStraight() {
        int counter = 1;
        int howHigh = 0;
        int straightLength = 0;

        Set<Integer> mapKeys = rankMap.keySet();        // gets all the keys of map (unique since it's Set)
        Object[] arrayKeys = mapKeys.toArray();     // gets all the keys into an arrey
        int prev = (int) arrayKeys[0];

        System.out.println("Set rankMap.keySet() is : " + mapKeys.toString());
        // check if there is 5 consecutive increasing keys in array    
        for (int i = 1; i < arrayKeys.length; i++) {
            int cur = (int) arrayKeys[i];
//            System.out.println("prev: " + prev + " cur " + cur);

            if (prev + 1 == cur) {
//                prev = cur;
                counter++;
//                System.out.println("Counter: " + counter);

                if (counter >= 5) {   // straight found
                    howHigh = cur;
                    straightLength = counter;
                }

            } else {                // current key not connected to prev key, reset counter
                counter = 1;
            }
            prev = cur;

        }
        System.out.println("Player has a " + straightLength + " card straight, " + howHigh + " high.");
        return howHigh;
    }

    /*
    // Return highest hole card that comes into play for flush.
    // returns null if no hole card comes into play (None of the same suit or lower than 5 card board flush)
    public Card GetFlushCardInPlay() {

        Map<Suit, Integer> suitMap = cardMaps.getSuitMap();
        Map<Integer, Integer> rankMap = cardMaps.getRankMap();

        Suit flushSuit = getFlushSuit();
        Card card1 = holeCards.getCard1();
        Card card2 = holeCards.getCard2();

        if (flushSuit == null) // if no flush at all
        {
            return null;
        }

        //if 5 card flush on board and hole flush cards lower than board or non flush holdings
        // i.e no flush card in play
        if (suitMap.get(flushSuit) == 5) {
            Collections.sort(holeNCommunityCards);
            Card lowestOnBoard = holeNCommunityCards.get(0);


            System.out.println("lowes on board is " + lowestOnBoard);
            //compare hole cards to lowest on board
            if (card1.compareTo(lowestOnBoard) < 1 || card1.getSuit() != flushSuit) {
                if (card2.compareTo(lowestOnBoard) < 1 || card2.getSuit() != flushSuit) {

                    return null;

                }
            }
        }

        Card flushCard = null;

        if (card1.getSuit() == flushSuit) {
            flushCard = card1;
        }

        if (card2.getSuit() == flushSuit) {
            if (flushCard == null || card1.compareTo(card2) < 0) {
                flushCard = card2;
            }
        }
        return flushCard;
    }
     */
    // returns null if no flush or returns the flush suit 
    public Suit getFlushSuit() {
        Set<Suit> mapKeys = suitMap.keySet();

//        System.out.println("SuitMap is : " + suitMap);
        for (Suit s : mapKeys) {
            if (suitMap.get(s) >= 5) {
                return s;
            }
        }
        return null;
    }

    // returns 0 if no straight flush else returns how hight straight flush is
    public int checkStraightFlush() {
        Suit flushSuit = getFlushSuit();
        // run low overhead procedures first
        if (flushSuit == null || checkStraight() == 0) {
            return 0;
        }

        return checkStraightFlush(flushSuit);
    }

    // returns 0 if no straight or else return high card for straight
    public int checkStraightFlush(Suit flushSuit) {
        int counter = 1;
        int howHigh = 0;
        int straightLength = 0;

        Set<Integer> mapKeys = rankMap.keySet();        // gets all the keys of map (unique since it's Set)
        Object[] arrayKeys = mapKeys.toArray();     // gets all the keys into an arrey
        int prev = (int) arrayKeys[0];

//        System.out.println("Set map.keySet() is : " + mapKeys.toString());
        // check if there is 5 consecutive increasing keys in array    
        for (int i = 1; i < arrayKeys.length; i++) {
            int cur = (int) arrayKeys[i];
            //check if prev n cur are consecutive and flush suit
            if (prev + 1 == cur && cardFoundInHoleNCommunityCardsList(prev, flushSuit) && cardFoundInHoleNCommunityCardsList(cur, flushSuit)) {
                prev = cur;
                counter++;

                if (counter >= 5) {   // straight found
                    howHigh = cur;
                    straightLength = counter;
                }

            } else {                // current key not connected to prev key, reset counter
                counter = 1;
            }
        }
        System.out.println("Player has a " + straightLength + " card straight flush, " + howHigh + " high.");
        return howHigh;
    }

    // gives the highest rank for trips in list
    // i.e if list contains same rank three 
    public int getHighestTripsInList() {
        return getHighestKey(rankMap, 3);
    }

    public int getQuadsInList() {
        return getHighestKey(rankMap, 4);
    }

    // returns 0 if no key in map corresponds to the value
    //else returns the key corresponding to the value in map
    public int getHighestKey(Map<Integer, Integer> map, int value) {
//        Map<Integer, Integer> map = rankCountMap(list);
        int tripRank = 0;

        Set<Integer> mapKeys = map.keySet();        // gets all the keys of map (unique since it's Set)
        Object[] arrayKeys = mapKeys.toArray();     // gets all the keys into an arrey
        int prev = (int) arrayKeys[0];


        for (int i = 0; i < arrayKeys.length; i++) {
            int key = (int) arrayKeys[i];
            if (map.get(key) == value) {
                return key;
            }
        }
        System.out.println("Set map.keySet() is : " + mapKeys.toString());
        return tripRank;
    }
// added a new line

    public boolean cardFoundInHoleNCommunityCardsList(int rank, Suit suit) {
//        Card d = new Card(rank, suit);
//        System.out.println("Card found : " + d + " " + holeNCommunityCards.contains(d));
//        return holeNCommunityCards.contains(c);

        for (Card c : holeNCommunityCards) {
            if (c.getRank() == rank && c.getSuit() == suit) {
                return true;
            }
        }

        return false;

    }

}
