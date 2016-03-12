/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.com.example.domain.rank;

import poker.com.example.domain.HoleCards;

/**
 *
 * @author madi
 */
public class Straight extends HoleCardsRank implements Comparable <Straight> {
    
    protected int HighestCard; 

    public Straight(int HighestCard, HoleCards holeCards) {
        super(holeCards);
        this.HighestCard = HighestCard;
    }

    public int getHighestCard() {
        return HighestCard;
    }

    @Override
    public int compareTo(Straight  s) {
        if (HighestCard > s.getHighestCard())
            return 1;
        else if(HighestCard < s.getHighestCard())
            return -1;
        else
            return 0;
    }
    
}
