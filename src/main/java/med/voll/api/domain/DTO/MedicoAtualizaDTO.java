package med.voll.api.domain.DTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.Endereco;

public record MedicoAtualizaDTO(

        @NotNull
        Long id,

        String nome,

        String telefone,

        Endereco endereco) {
}
