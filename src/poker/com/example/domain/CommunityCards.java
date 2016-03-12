/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain;

import java.util.ArrayList;

/**
 *
 * @author madi
 */
public class CommunityCards {
    protected ArrayList<Card> communityCards;

    public ArrayList<Card> getCommunityCards() {
        return communityCards;
    }

    public CommunityCards(Flop flop, Card turn, Card river) {
        ArrayList<Card> tmp = new ArrayList<>(5);
        tmp.add(flop.card1);
        tmp.add(flop.card2);
        tmp.add(flop.card3);
        tmp.add(turn);
        tmp.add(river);
        communityCards = tmp;

    }
    
    public String toString(){
        return communityCards.toString();
    }
    
    
}
