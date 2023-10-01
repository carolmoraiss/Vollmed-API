package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.DTO.MedicoAtualizaDTO;
import med.voll.api.domain.DTO.MedicoDTO;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO dado) {
        this.ativo = true;
        this.nome = dado.nome();
        this.crm  =dado.crm();
        this.email = dado.email();
        this.telefone = dado.telefone();
        this.especialidade = dado.especialidade();
        this.endereco = new Endereco(dado.endereco());
    }

    public void atualizarInformacoes(MedicoAtualizaDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
          this.telefone = dados.telefone();
        }


        if(dados.endereco() != null) {
          this.endereco.atualizaInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
