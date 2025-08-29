package com.projeto.dionatan.repository;

import com.projeto.dionatan.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {
    Optional<TurmaEntity> findByNome(String nome);
    List<TurmaEntity> findByPeriodo(String periodo);
    List<TurmaEntity> findByCurso(String curso);
}