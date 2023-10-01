package med.voll.api.validation.cancelamento;

import med.voll.api.domain.DTO.DadosCancelamentoConsulta;


public interface ValidadorCancelamentoConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
