package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.DTO.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.DTO.DadosCancelamentoConsulta;
import med.voll.api.domain.DTO.DadosDetalhamentoConsultaDTO;
import med.voll.api.service.AgendaConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaConsultaService agendaConsultaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsultaDTO> agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        var dadosAgendamentoDto = agendaConsultaService.agendar(dados);
        return ResponseEntity.ok(dadosAgendamentoDto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosCancelamentoConsulta> cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agendaConsultaService.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
