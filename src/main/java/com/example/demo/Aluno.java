package com.example.demo;

public class Aluno {


    private int idade;
    private String nome;
    private Integer id;

    public Aluno(){}

    public Aluno(int idade, String nome, Integer id) {
        this.idade = idade;
        this.nome = nome;
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "idade=" + idade +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}