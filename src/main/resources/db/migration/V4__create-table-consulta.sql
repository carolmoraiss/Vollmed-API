create table consultas(
    id  bigserial NOT NULL,
    medico_id bigint NOT NULL,
    paciente_id bigint NOT NULL,
    data timestamp NOT NULL,

    primary key(id),
    constraint fk_consultas_medico_id foreign key (medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key (paciente_id) references pacientes(id)
);