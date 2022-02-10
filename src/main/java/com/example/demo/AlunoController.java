package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trycatch")

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    List<Aluno> alunos = new ArrayList<>();


    @GetMapping
        public List<Aluno> findAll (@RequestParam (required = false) Integer id, String nome) {

        if(id!= null){
            return alunoService.getIdAluno(id);
        }
        if(nome!= null){
            return alunoService.getNameAluno(nome);
        }

        return alunoService.getAll();
    }


    /*@PostMapping
    public void add(@RequestBody final Aluno aluno){
        alunoService.adiciona(aluno);
    }*/

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


