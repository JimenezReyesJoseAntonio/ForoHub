create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null,
    clave varchar(300) not null,

    primary key(id)

);

CREATE TABLE cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    activo BOOLEAN NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE SET NULL
);


CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    solucion BOOLEAN DEFAULT FALSE,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (topico_id) REFERENCES topicos(id) ON DELETE CASCADE
);