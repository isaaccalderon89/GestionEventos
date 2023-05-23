package com.neoris.segundaprueba.infrastructure.controller;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.infrastructure.repository.EventoEntityRepository;
import com.neoris.segundaprueba.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controlador REST para la gestión de eventos
 */
@RestController
public class EventoController {

    private SaveEventoUseCase saveEventoUseCase;

    private FindAllEventosUseCase findAllEventosUseCase;

    private DeleteEventoUseCase deleteEventoUseCase;

    private FindForDateUseCase findForDateUseCase;

    private UpdateEventoUseCase updateEventoUseCase;

    private EventoEntityRepository eventoEntityRepository;

    /**
     * Constructor de la clase EventoController.
     *
     * @param saveEventoUseCase       Caso de uso para guardar un evento.
     * @param findAllEventosUseCase   Caso de uso para obtener todos los eventos.
     * @param deleteEventoUseCase     Caso de uso para eliminar un evento.
     * @param findForDateUseCase      Caso de uso para obtener un evento por fecha.
     * @param updateEventoUseCase     Caso de uso para actualizar un evento.
     * @param eventoEntityRepository  Repositorio de eventos.
     */
    public EventoController(SaveEventoUseCase saveEventoUseCase, FindAllEventosUseCase findAllEventosUseCase, DeleteEventoUseCase deleteEventoUseCase, FindForDateUseCase findForDateUseCase, UpdateEventoUseCase updateEventoUseCase, EventoEntityRepository eventoEntityRepository) {
        this.saveEventoUseCase = saveEventoUseCase;
        this.findAllEventosUseCase = findAllEventosUseCase;
        this.deleteEventoUseCase = deleteEventoUseCase;
        this.findForDateUseCase = findForDateUseCase;
        this.updateEventoUseCase = updateEventoUseCase;
        this.eventoEntityRepository = eventoEntityRepository;
    }
    /**
     * Método GET para obtener todos los eventos.
     *
     * @return ResponseEntity con la lista de eventos obtenidos.
     */
    @GetMapping(value = "/evento", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Evento>> getAllEventos(){
        return ResponseEntity.ok(findAllEventosUseCase.findAllEventos());
    }
    /**
     * Método PUT para modificar un evento existente.
     *
     * @param evento El evento a modificar.
     * @return ResponseEntity con el evento modificado.
     */
    @PutMapping(value = "/evento/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> modificarEvento(@RequestBody Evento evento){
        try {
            Evento nuevoEvento = updateEventoUseCase.updateEvento(evento);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEvento);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Método POST para crear un nuevo evento.
     *
     * @param evento El evento a crear.
     * @return ResponseEntity con el evento creado.
     */
    @PostMapping(value = "/evento/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        try {
            Evento savedEvento = saveEventoUseCase.saveEvento(evento);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEvento);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Método DELETE para eliminar un evento.
     *
     * @param id El ID del evento a eliminar.
     * @return ResponseEntity sin contenido si se eliminó correctamente, o ResponseEntity de no encontrado si no existe el evento.
     */
    @DeleteMapping(value = "/evento/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id){
        if(deleteEventoUseCase.deleteEvento(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Método GET para obtener un evento por fecha.
     *
     * @param dateTime La fecha y hora del evento a buscar.
     * @return ResponseEntity con el evento encontrado o ResponseEntity de no encontrado si no existe el evento.
     */
    @GetMapping(value = "/evento/date/{dateTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> getEventoForDate(@PathVariable LocalDateTime dateTime){
        try{
            Evento evento = findForDateUseCase.findForDate(dateTime);

            if (evento != null) {
                return ResponseEntity.ok(evento);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
