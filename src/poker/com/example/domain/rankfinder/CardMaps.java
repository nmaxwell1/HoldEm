/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain.rankfinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import poker.com.example.domain.Card;
import poker.com.example.domain.HoleCards;
import poker.com.example.domain.Suit;

/**
 *
 * @author madi
 */
public class CardMaps {

    protected Map<Integer, Integer> rankMap; // = rankCountMap(list);
    protected Map<Suit, Integer> suitMap; // = suitCountMap(board);
    protected ArrayList<Card> holeNCommunityCards; // sorted

    
    
    public CardMaps(List<Card> holeNCommunityCards) {
        rankMap = rankCountMap(holeNCommunityCards);
        suitMap = suitCountMap(holeNCommunityCards);
        this.holeNCommunityCards = (ArrayList<Card>) holeNCommunityCards;

    }

    public CardMaps(HoleCards holeCards, List<Card> communityCardList) {

        holeNCommunityCards = mergeHoleCardsToList(holeCards, communityCardList);
        Collections.sort(holeNCommunityCards);

        rankMap = rankCountMap(holeNCommunityCards);
        suitMap = suitCountMap(holeNCommunityCards);
    }

    public ArrayList<Card> getHoleNCommunityCards() {
        return holeNCommunityCards;
    }
    
    

    public Map<Integer, Integer> getRankMap() {
        return rankMap;
    }

    public Map<Suit, Integer> getSuitMap() {
        return suitMap;
    }

    //Maps number of times a suit is found in list of cards to that suit.
    public Map suitCountMap(List<Card> list) {
        Map<Suit, Integer> suitCountMap = new HashMap<>();
        for (Card c : list) {
            if (suitCountMap.containsKey(c.getSuit())) {
                int val = suitCountMap.get(c.getSuit());
                val++;
                suitCountMap.put(c.getSuit(), val);
            } else {
                suitCountMap.put(c.getSuit(), 1);
            }

        }

        return suitCountMap;
    }

    //Maps number of times a rank is found in list of cards to that rank.    
    public Map rankCountMap(List<Card> list) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Card c : list) {
            int rank = c.getRank();
            if (map.containsKey(rank)) {
                int val = map.get(rank);
                val++;
                map.put(rank, new Integer(val));
            } else {
                map.put(rank, new Integer(1));
            }

        }

        return map;
    }

    // merges HoleCards and card List into one list of 7 Cards
    public ArrayList<Card> mergeHoleCardsToList(HoleCards p, List<Card> list) {
        ArrayList<Card> boardNHoleCards = new ArrayList<>(7);
        // add board cards
        for (Card c : list) {
            boardNHoleCards.add(c);
        }
        //Add hole cards
        boardNHoleCards.add(p.getCard1());
        boardNHoleCards.add(p.getCard2());
        return boardNHoleCards;
    }

}
