package com.totalizator.dao.repository;

import com.totalizator.dao.entities.TournamentTeams;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrei Savchuk.
 */
public interface ITournamentTeamsRepository extends JpaRepository<TournamentTeams, Long> {
}
