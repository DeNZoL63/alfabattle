package com.alfa.battle.repository;

import com.alfa.battle.model.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchesRepo extends JpaRepository<Branches, Long> {

    Optional<Branches> findById(Long id);
}
