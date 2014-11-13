package repository;

import model.Creature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureDao extends JpaRepository<Creature, Long> {
}