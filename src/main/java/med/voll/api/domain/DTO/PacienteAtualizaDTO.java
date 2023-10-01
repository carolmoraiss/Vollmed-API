package med.voll.api.domain.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.Endereco;

public record PacienteAtualizaDTO(

        @NotNull
        Long id,

        String nome,

        String email,

        String telefone,

        Endereco endereco
        )
{}
