/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madi
 */
public class Flop {
    protected Card card1;
    protected Card card2;
    protected Card card3;
    
    public Flop() {
    }

    public Flop(Card card1, Card card2, Card card3) {
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public Card getCard3() {
        return card3;
    }

    
    
    public String toString(){
        return "Flop: " + card1+ " " + card2 + " " + card3;
    }
}
