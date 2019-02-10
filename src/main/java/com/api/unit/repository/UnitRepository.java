package com.api.unit.repository;

import com.feature.unit.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides the data access layer API to work on {@link Unit} objects
 **/
public interface UnitRepository extends JpaRepository<Unit, String> {
}
