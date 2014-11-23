package repository;

import model.FieldColumn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldColumnDao extends JpaRepository<FieldColumn, Long>{
}
