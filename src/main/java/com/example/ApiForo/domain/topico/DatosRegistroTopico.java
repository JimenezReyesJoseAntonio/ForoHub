package com.example.ApiForo.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(

        @NotBlank
        Integer idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        Integer idCurso
) {
}
