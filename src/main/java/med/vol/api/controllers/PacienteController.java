package med.vol.api.controllers;

import jakarta.validation.Valid;
import med.vol.api.paciente.DadosCadastroPaciente;
import med.vol.api.paciente.Paciente;
import med.vol.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}
