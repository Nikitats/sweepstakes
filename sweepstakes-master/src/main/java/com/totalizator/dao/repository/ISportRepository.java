package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by home
 */
public interface ISportRepository extends JpaRepository<Sport, Long> {
}
