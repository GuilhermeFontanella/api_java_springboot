package med.vol.api.controllers;

import jakarta.validation.Valid;
import med.vol.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void alterarMedico(@RequestBody DadosAlteracaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.alteraInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void ExcluirMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        System.out.println(medico);
        medico.excluir(medico);
    }
    //teste
}