package med.vol.api.endereco;

import jakarta.validation.constraints.Pattern;

public record EnderecoAlteracaoRecord(
        String logradouro,
        String bairro,
        @Pattern(regexp = "\\d{8}")
        String cep,
        String cidade,
        String uf,
        String numero,
        String complemento
) {
}
