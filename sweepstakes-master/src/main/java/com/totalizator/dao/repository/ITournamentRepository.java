package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrei Savchuk.
 */

public interface ITournamentRepository extends JpaRepository<Tournament, Long> {
}
