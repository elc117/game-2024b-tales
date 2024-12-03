package com.badlogic.circledemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Quiz {
    private Integer id;
    private String pergunta;
    private ArrayList<String> respostas; // Lista com todas as respostas (correta e erradas)
    private Integer respostaCorretaIndex; // Índice da resposta correta na lista

    public Quiz(Integer id) {
        
        this.id = 1;
        this.pergunta = "Somos uma iniciativa da UFSM em parceria com o Consórcio Intermunicipal de Desenvolvimento Sustentável de uma cidade gaúcha, quem somos?";
        this.respostas.add("Geoparque Quarta Colônia");
        this.respostas.add("Sete Povos das Missões");
        this.respostas.add("Praia de Torres");
        this.respostas.add("Resposta Errada 3");
        this.respostaCorretaIndex = 0;

        
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public Integer getRespostaCorretaIndex() {
        return respostaCorretaIndex;
    }

    // Método para verificar se uma resposta está correta
    public boolean isRespostaCorreta(int index) {
        return index == respostaCorretaIndex;
    }
}