package com.totalizator.services;

import com.totalizator.dao.entities.Match;

/**
 * Created by dennya on 23.06.16.
 */
public interface ISetCoefficient {
    Match setCoefficients(Match match);
    Match setCoefficientsWithPosibilities(Match match, float homeWinPosibility, float drawPosibility, float awayWinPosibility);
}
