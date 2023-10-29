package med.vol.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.vol.api.endereco.EnderecoAlteracaoRecord;
import med.vol.api.endereco.EnderecoRecord;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        EnderecoRecord endereco,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotNull
        Boolean ativo
) {
}
