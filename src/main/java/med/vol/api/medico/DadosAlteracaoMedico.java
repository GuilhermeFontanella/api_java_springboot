package med.vol.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.endereco.EnderecoRecord;

public record DadosAlteracaoMedico(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        Especialidade especialidade,
        @Valid
        EnderecoRecord endereco,
        @Pattern(regexp = "\\d{11}")
        String telefone,
        Boolean ativo
) {

}
