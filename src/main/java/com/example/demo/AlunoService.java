package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    List<Aluno> alunos = new ArrayList<>();


    public List<Aluno> getAll() {
        return alunos;
    }

    public List<Aluno> getIdAluno( Integer id) {
        try {
            List<Aluno> al = alunos.stream()
                    .filter(aluno -> aluno.getId().equals(id)).collect(Collectors.toList());
            return al;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Aluno> getNameAluno(String nome) {
        try {
            List<Aluno> al = alunos.stream()
                    .filter(aluno -> aluno.getNome().equals(nome)).collect(Collectors.toList());
            return al;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void adiciona(@RequestBody final Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(alunos.size() + 1);
        }
        alunos.add(aluno);
    }

    public void alterar(@RequestBody final Aluno aluno) {
        alunos.stream().filter(al -> al.getId().equals(aluno.getId()))
                .forEach(al -> {
                    al.setIdade(aluno.getIdade());
                    al.setNome(aluno.getNome());
                    al.setId(aluno.getId());
                });
    }

    public void deletando(@PathVariable("id") Integer id) {

        alunos.removeIf(al -> al.getId().equals(id));

    }
}
