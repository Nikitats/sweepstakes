package com.totalizator.services;


import com.totalizator.dao.entities.Bet;
import com.totalizator.dao.entities.Match;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by dennya on 23.06.16.
 */
public class MathBrain implements ISetCoefficient {

    private final float betRiser = 1.1f;
    private final float minimumAmount = 5f;
    private final float maximumCoefficient = 50f;
    private final float homeDefaultPosibility = 0.5f;
    private final float drawDefaultPosibility = 0.21f;
    private final float awayDefaultPosibility = 0.29f;

    public Match setCoefficients(Match match) {
        float homeBank = 0, drawBank = 0, awayBank = 0;

        Set<Bet> bets = match.getBets();
        Iterator<Bet> iterator = bets.iterator();
        while (iterator.hasNext()) {
            Bet item = iterator.next();

            switch(item.getGoal()) {
                case 0:
                    homeBank += item.getAmount();
                    break;
                case 1:
                    drawBank += item.getAmount();
                    break;
                case 2:
                    awayBank += item.getAmount();
                    break;
                default:
                    break;
            }
        }
        if ((homeBank == 0) && (drawBank == 0) && (awayBank == 0)) {
            return setDefaultCoefficients(match);
        }

        if ((homeBank < minimumAmount) || (drawBank < minimumAmount) || (awayBank < minimumAmount)) {
            homeBank += minimumAmount;
            drawBank += minimumAmount;
            awayBank += minimumAmount;
        }

        float overallBank = homeBank + drawBank + awayBank;

        float homeWinPosibility = (homeBank / overallBank) * betRiser;
        float drawPosibility = (drawBank / overallBank) * betRiser;
        float awayWinPosibility = (awayBank / overallBank) * betRiser;

        float homeCoefficient = 1f / homeWinPosibility;
        if (homeCoefficient > maximumCoefficient) { homeCoefficient = maximumCoefficient; }

        float drawCoefficient = 1f / drawPosibility;
        if (drawCoefficient > maximumCoefficient) { drawCoefficient = maximumCoefficient; }

        float awayCoefficient = 1f / awayWinPosibility;
        if (awayCoefficient > maximumCoefficient) { awayCoefficient = maximumCoefficient; }

        match.setHomeClubWinCoefficient(homeCoefficient);
        match.setDrawCoeffficient(drawCoefficient);
        match.setGuestClubWinCoefficient(awayCoefficient);

        return match;
    }

    public Match setCoefficientsWithPosibilities(Match match, float homeWinPosibility, float drawPosibility, float awayWinPosibility) {
        if (homeWinPosibility + drawPosibility + awayWinPosibility != 1f) {
            homeWinPosibility = 0.34f; drawPosibility = 0.33f; awayWinPosibility = 0.34f;
        }

        float homeCoefficient = 1f / (homeWinPosibility * betRiser);
        if (homeCoefficient > maximumCoefficient) { homeCoefficient = maximumCoefficient; }

        float drawCoefficient = 1f / (drawPosibility * betRiser);
        if (drawCoefficient > maximumCoefficient) { drawCoefficient = maximumCoefficient; }

        float awayCoefficient = 1f / (awayWinPosibility * betRiser);
        if (awayCoefficient > maximumCoefficient) { awayCoefficient = maximumCoefficient; }

        match.setHomeClubWinCoefficient(homeCoefficient);
        match.setDrawCoeffficient(drawCoefficient);
        match.setGuestClubWinCoefficient(awayCoefficient);

        return match;
    }



    private Match setDefaultCoefficients(Match match) {
        return setCoefficientsWithPosibilities(match, homeDefaultPosibility, drawDefaultPosibility, awayDefaultPosibility);
    }
}
