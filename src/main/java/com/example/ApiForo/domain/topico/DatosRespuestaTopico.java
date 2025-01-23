package com.example.ApiForo.domain.topico;

public record DatosRespuestaTopico(
        Long id,Long idUsario, String titulo, String mensaje, Long idCurso
) {
}
