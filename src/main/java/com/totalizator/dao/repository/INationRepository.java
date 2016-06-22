package com.totalizator.dao.repository;


import com.totalizator.dao.entities.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by home
 */
public interface INationRepository extends JpaRepository<Nation,Long> {
}
