/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author madi
 */
public class Deck {

    Suit[] suitList = Suit.values();
    private ArrayList<Card> cardList = new ArrayList(52);
    private int index = 0; // window card index

    //getter
    public ArrayList<Card> getCardList() {
        return cardList;
    }

    //initialize deck by merging rank/suit combinations, adding to cardList and shuffling
    public Deck() {
        mergeRankNSuit();
        Collections.shuffle(cardList);

    }

    public void mergeRankNSuit() {
        for (int i = 0; i < suitList.length; i++) {
            for (int j = 2; j <= 14; j++) {
                cardList.add(new Card(j, suitList[i]));
            }
        }
    }

    public Card getCard() {
        Card c = cardList.get(index);
        index++;
        return c;
    }


    public Flop getFlop() {
        Card c1 = getCard();
        Card c2 = getCard();
        Card c3 = getCard();
        return new Flop(c1, c2, c3);
    }

    public Card getTurn() {
        Card c = getCard();
        return c;
    }

    public Card getRiver() {
        Card c = getCard();
        return c;
    }

}
