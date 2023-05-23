package com.neoris.segundaprueba.infrastructure.repository.jpa;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.infrastructure.domain.entity.InMemoryEventoRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Repositorio JPA para la entidad Evento.
 * Proporciona métodos para acceder y gestionar los datos de los eventos en la base de datos.
 */
@Repository
public interface EventoJpaRepository extends JpaRepository<InMemoryEventoRepositoryEntity, Long> {
    /**
     * Busca un evento en función de la fecha y hora especificadas.
     *
     * @param dateTime La fecha y hora para la cual se desea buscar el evento.
     * @return La entidad en memoria InMemoryEventoRepositoryEntity correspondiente al evento encontrado.
     */
    @Query("SELECT d FROM InMemoryEventoRepositoryEntity d WHERE d.startDate <= :dateTime AND d.endDate >= :dateTime")
    InMemoryEventoRepositoryEntity findForDate(@Param("dateTime") LocalDateTime dateTime);

}
