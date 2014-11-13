package repository;

import model.Field;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends JpaRepository<Field, Long> {
}