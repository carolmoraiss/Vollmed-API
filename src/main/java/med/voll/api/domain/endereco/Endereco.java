package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.domain.DTO.EnderecoDTO;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }



    public void atualizaInformacoes(Endereco endereco) {
        if(endereco.logradouro != null) {
        this.logradouro = endereco.getLogradouro();
        }
        if(endereco.bairro != null) {
            this.bairro = endereco.getBairro();
        }
        if(endereco.cep != null) {
            this.cep = endereco.getCep();
        }
        if(endereco.numero != null) {
            this.numero = endereco.getNumero();
        }
        if(endereco.complemento != null) {
            this.complemento = endereco.getComplemento();
        }
        if(endereco.cidade != null) {
            this.cidade = endereco.getCidade();
        }
        if(endereco.uf != null) {
            this.uf = endereco.getUf();
        }


    }
}
