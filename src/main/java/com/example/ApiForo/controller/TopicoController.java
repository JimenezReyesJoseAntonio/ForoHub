package com.example.ApiForo.controller;

import com.example.ApiForo.domain.curso.Curso;
import com.example.ApiForo.domain.curso.CursoRepository;
import com.example.ApiForo.domain.topico.*;
import com.example.ApiForo.domain.usuarios.Usuario;
import com.example.ApiForo.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {

        Usuario autor = usuarioRepository.findById(datosRegistroTopico.idUsuario().longValue())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + datosRegistroTopico.idUsuario()));

        // Obtiene el curso desde el repositorio
        Curso curso = cursoRepository.findById(datosRegistroTopico.idCurso().longValue())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con ID: " + datosRegistroTopico.idCurso()));

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico,autor,curso));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getAutor().getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getCurso().getId() );

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos (@PageableDefault(size = 2) Pageable paginacion){
        return  ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }


}
