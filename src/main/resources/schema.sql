create table CURSO
(
    ID_CURSO INTEGER auto_increment,
    NOME     CHARACTER VARYING not null,
    constraint CURSO_PK
        primary key (ID_CURSO)
);

create table ALUNO
(
    ID_ALUNO        INTEGER auto_increment,
    ID_CURSO        INTEGER,
    NOME            CHARACTER VARYING not null,
    CPF             CHARACTER VARYING not null,
    RG              CHARACTER VARYING not null,
    DATA_NASCIMENTO TIMESTAMP,
    ENDERECO        CHARACTER VARYING not null,
    CEP             CHARACTER VARYING not null,
    CIDADE          CHARACTER VARYING not null,
    ESTADO          CHARACTER VARYING not null,
    constraint ALUNO_PK
        primary key (ID_ALUNO),
    constraint ALUNO_CURSO_ID_CURSO_FK
        foreign key (ID_CURSO) references CURSO
);

create unique index ALUNO_ID_UINDEX
    on ALUNO (ID_ALUNO);

