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
public class HoleCardsRank {
    protected HoleCards holeCards;

    public HoleCardsRank(HoleCards holeCards) {
        this.holeCards = holeCards;
    }

    public HoleCards getHoleCards() {
        return holeCards;
    }

    
}
