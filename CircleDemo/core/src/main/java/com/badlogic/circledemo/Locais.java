package com.badlogic.circledemo;

import java.io.File;
import java.util.List;

public class Locais {
    private String nome;
    private int id;
    private List<String> imagens;
    private Integer personagem;
    private List<Integer> questoes;

    public Locais() {
        // Construtor vazio necessário para Jackson
    }

    // Construtor
    public Locais(int id) {
        
        this.nome = "Quarta Colônia";
        this.id = 1;
        this.imagens.add("img/QuartaColonia.jpg");
        this.imagens.add("img/QuartaColonia.jpg");
        this.personagem = 1;
        this.questoes.add(1);

        
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public Integer getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Integer personagem) {
        this.personagem = personagem;
    }

    public List<Integer> getQuestoes() {
        return questoes;
    }

}
