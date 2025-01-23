package com.example.ApiForo.domain.topico;

import com.example.ApiForo.domain.curso.Curso;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id, String titulo, String mensaje,
        LocalDateTime fechaCreacion, Long idAutor, Long idCurso
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getAutor().getId(),
                topico.getCurso().getId());
    }


}
