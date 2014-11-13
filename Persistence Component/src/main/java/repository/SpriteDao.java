package repository;

import model.Sprite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpriteDao extends JpaRepository<Sprite, Long> {
}