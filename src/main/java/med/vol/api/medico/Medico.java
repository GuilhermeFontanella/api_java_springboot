package med.vol.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.endereco.Endereco;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicos")
@Entity(name = "Medico")
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private  String telefone;
    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.ativo = true;
    }

    public void alteraInformacoes(DadosAlteracaoMedico dados) {
        this.nome = dados.nome();
        if (dados.nome() != null) { this.nome = dados.nome(); }
        if (dados.email() != null) {this.email = dados.email(); }
        if (dados.crm() != null) {this.crm = dados.crm(); }
        if (dados.especialidade() != null) {this.especialidade = dados.especialidade(); }
        if (dados.endereco() != null) {this.endereco.atualizaEndereco(dados.endereco()); }
        if (dados.telefone() != null) {this.telefone = dados.telefone(); }
        if (dados.ativo() != null) { this.ativo = dados.ativo(); }
    }

    public void excluir(Medico medico) {
        this.ativo = false;
    }
}
