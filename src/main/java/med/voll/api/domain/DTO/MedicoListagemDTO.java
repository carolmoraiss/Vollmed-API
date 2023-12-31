package med.voll.api.domain.DTO;

import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;

public record MedicoListagemDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListagemDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

