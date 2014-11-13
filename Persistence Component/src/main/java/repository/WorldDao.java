package repository;

import model.World;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldDao extends JpaRepository<World, Long> {
}