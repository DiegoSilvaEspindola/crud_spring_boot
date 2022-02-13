package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")

public class AlunoController {
    private AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    List<Aluno> alunos = new ArrayList<>();
    @GetMapping
    public List<Aluno> findAll () {
        return alunoService.getAll();
    }
    @GetMapping
    public List<Aluno>getByName(@RequestBody Aluno aluno){
        return alunoService.getNameAluno(aluno);
    }
    @GetMapping
    public List<Aluno>getById(@RequestParam Aluno aluno){
        return alunoService.getIdAluno(aluno);
    }
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno){
        alunoService.adiciona(aluno);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public void update(@RequestBody final Aluno aluno){
        alunoService.alterar(aluno);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        alunoService.deletando(id);
    }
}


