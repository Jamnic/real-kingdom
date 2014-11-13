package repository;

import model.Hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroDao extends JpaRepository<Hero, Long> {
}