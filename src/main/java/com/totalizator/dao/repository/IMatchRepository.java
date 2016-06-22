package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrei Savchuk.
 */
public interface IMatchRepository extends JpaRepository<Match, Long> {
}
