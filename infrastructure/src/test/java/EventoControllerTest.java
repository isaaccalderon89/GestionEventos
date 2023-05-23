import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.infrastructure.controller.EventoController;
import com.neoris.segundaprueba.usecases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

public class EventoControllerTest {

    @Mock
    DeleteEventoUseCase deleteEventoUseCase;
    @Mock
    FindAllEventosUseCase findAllEventosUseCase;
    @Mock
    FindForDateUseCase findForDateUseCase;
    @Mock
    SaveEventoUseCase saveEventoUseCase;
    @Mock
    UpdateEventoUseCase updateEventoUseCase;

    @InjectMocks
    EventoController eventoController;

    List<Evento> eventoList;
    Evento evento;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void FindAllTest() {
        when(findAllEventosUseCase.findAllEventos()).thenReturn(eventoList);
        ResponseEntity<List<Evento>> result = eventoController.getAllEventos();
        assertEquals(eventoList, result.getBody());
    }

    @Test
    void testCrearEvento() {
        Evento evento = new Evento(8L, "Evento de prueba", 100, LocalDateTime.now(), LocalDateTime.now(), 50.0);
        when(saveEventoUseCase.saveEvento(evento)).thenReturn(evento);
        ResponseEntity<Evento> respuesta = eventoController.crearEvento(evento);
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
        assertEquals(evento, respuesta.getBody());
    }

    @Test
    void testModificarEvento(){
        Evento evento = new Evento(8L, "Evento de prueba", 100, LocalDateTime.now(), LocalDateTime.now(), 50.0);
        when(updateEventoUseCase.updateEvento(evento)).thenReturn(evento);
        ResponseEntity<Evento> respuesta = eventoController.modificarEvento(evento);
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
        assertEquals(evento, respuesta.getBody());
    }

    @Test
    void testDeleteEvento(){
        Long eventoId = 1L;
        when(deleteEventoUseCase.deleteEvento(eventoId)).thenReturn(true);
        ResponseEntity<Void> respuesta = eventoController.deleteEvento(eventoId);
        assertEquals(HttpStatus.NO_CONTENT, respuesta.getStatusCode());
    }

    @Test
    void testDeleEventoNotFound(){
        Long eventoId = 1L;
        when(deleteEventoUseCase.deleteEvento(eventoId)).thenReturn(false);
        ResponseEntity<Void> respuesta = eventoController.deleteEvento(eventoId);
        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
    }

    @Test
    void testGetEventoForDateFound(){
        LocalDateTime startDate = LocalDateTime.of(2023, 5, 23, 17, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 5, 23, 21, 0, 0);
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 23, 18, 30, 0);
        Evento evento = new Evento(8L, "Evento de prueba", 100, startDate, endDate, 50.0);
        when(findForDateUseCase.findForDate(dateTime)).thenReturn(evento);
        ResponseEntity<Evento> respuesta = eventoController.getEventoForDate(dateTime);
        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertEquals(evento, respuesta.getBody());
    }

    @Test
    void testGetEventoForDateInternalServerError(){
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 23, 18, 30, 0);
        when(findForDateUseCase.findForDate(dateTime)).thenThrow(new RuntimeException());
        ResponseEntity<Evento> respuesta = eventoController.getEventoForDate(dateTime);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, respuesta.getStatusCode());
    }

    @Test
    void testGetEventoForDateNotFound(){
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 23, 18, 30, 0);
        when(findForDateUseCase.findForDate(dateTime)).thenReturn(null);
        ResponseEntity<Evento> respuesta = eventoController.getEventoForDate(dateTime);
        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
    }

}
