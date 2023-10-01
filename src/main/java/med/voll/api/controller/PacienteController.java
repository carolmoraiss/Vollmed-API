package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.DTO.PacienteAtualizaDTO;
import med.voll.api.domain.DTO.PacienteDTO;
import med.voll.api.domain.DTO.PacienteListagemDTO;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteDTO dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteListagemDTO> findAllByAtivoTrue(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(PacienteListagemDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid PacienteAtualizaDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizaDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.desativar();
    }


}

