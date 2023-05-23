package com.neoris.segundaprueba.repository;

import com.neoris.segundaprueba.entities.Evento;

import java.time.LocalDateTime;
import java.util.List;

public interface EventoRepository {
   /**
    * Método que permite crear un evento
    * @param evento le pasamos un Json con todos los atributos de la clase
    * @return el evento creado.
    */
   Evento saveEvento(Evento evento);

   /**
    * Metódo que sirve para eliminar por el <b>id</b> un evento
    * @param id le pasado el id de un evento que exista y queramos eliminar
    * @return un <b>true</b> si el evento ha sido elimando, <b>false</b> en caso de que no se haya eliminado.
    */
   Boolean deleteEvento(Long id);

   /**
    * Método que sirve para actualizar un evento. Tenemos que pasarle el evento con el id y los datos que queremos modificar.
    * @param evento que queremos modificar
    * @return evento ya modificado
    */
   Evento updateEvento(Evento evento);

   /**
    * Este métado devuelve una lista de todos los eventos. Normalmente utilizo este método para comprobar que la base de datos conecta correctamente.
    * @return una lista con todos los eventos
    */
   List<Evento> findAllEventos();

   /**
    * Metodo que devuevle un evento que comprenda entre dos fechas. Los eventos pueden durar varios días.
    * @param dateTime le pasamos por parametro una fecha.
    * @return evento localizado por la fecha
    */
   Evento findForDate(LocalDateTime dateTime);

}
