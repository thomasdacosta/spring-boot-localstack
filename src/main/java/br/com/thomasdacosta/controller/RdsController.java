package br.com.thomasdacosta.controller;

import br.com.thomasdacosta.dto.AlunoRequest;
import br.com.thomasdacosta.dto.AlunoResponse;
import br.com.thomasdacosta.service.RdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class RdsController {

    @Autowired
    private RdsService rdsService;

    @GetMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlunoResponse>> buscarAluno(
    		@RequestParam(value = "nome") String nome) {
        return ResponseEntity.ok(rdsService.buscarAluno(nome));
    }

    @PostMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> criarAluno(
    		@RequestBody AlunoRequest alunoRequest) {
        return ResponseEntity.ok(rdsService.criarAluno(alunoRequest));
    }

    @PutMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> atualizarAluno(
    		@RequestBody AlunoRequest alunoRequest) {
        return ResponseEntity.ok(rdsService.atualizarAluno(alunoRequest));
    }

    @DeleteMapping(value = "/aluno/{id_aluno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> excluirAluno(@PathVariable(value = "id_aluno") Integer idAluno) {
        return ResponseEntity.ok(rdsService.excluirAluno(idAluno));
    }

}
