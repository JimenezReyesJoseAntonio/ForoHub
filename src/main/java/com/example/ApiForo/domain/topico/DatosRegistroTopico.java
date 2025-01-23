package com.example.ApiForo.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

        @NotNull
        Integer idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Integer idCurso
) {
}
