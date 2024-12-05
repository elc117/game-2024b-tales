package com.badlogic.circledemo;

import com.badlogic.gdx.utils.Array;

public class Quiz {
    private int id;
    private Array<String> pergunta = new Array<String>();
    private Array<String> respostas = new Array<String>(); // Lista com todas as respostas (correta e erradas)
    private int respostaCorretaIndex; // Índice da resposta correta na lista

    public Quiz(Integer id) {
        String frase = new String();
        int questao;
        this.id = id;
        switch (id) {
            case 1:
                frase = "Somos uma iniciativa da UFSM em";
                pergunta.add(frase);
                frase = "parceria com o Consórcio";
                pergunta.add(frase);
                frase = "Intermunicipal de Desenvolvimento";
                pergunta.add(frase);
                frase = "Sustentável de uma cidade gaúcha,";
                pergunta.add(frase);
                frase = "quem somos?";
                pergunta.add(frase);
                frase = "Geoparque Quarta Colônia";
                respostas.add(frase);
                frase = "Sete Povos das Missões";
                respostas.add(frase);
                frase = "Praia de Torres";
                respostas.add(frase);
                frase = "Resposta Errada 3";
                respostas.add(frase);
                respostaCorretaIndex = 0;
                break;
            case 2:
                frase = "Somos uma iniciativa da UFSM em";
                pergunta.add(frase);
                frase = "parceria com o Consórcio";
                pergunta.add(frase);
                frase = "Intermunicipal de Desenvolvimento";
                pergunta.add(frase);
                frase = "Sustentável de uma cidade gaúcha,";
                pergunta.add(frase);
                frase = "quem somos?";
                pergunta.add(frase);
                frase = "Geoparque Quarta Colônia";
                respostas.add(frase);
                frase = "Sete Povos das Missões";
                respostas.add(frase);
                frase = "Praia de Torres";
                respostas.add(frase);
                frase = "Resposta Errada 3";
                respostas.add(frase);
                respostaCorretaIndex = 0;
                break;
            case 3:
                frase = "Somos uma iniciativa da UFSM em";
                pergunta.add(frase);
                frase = "parceria com o Consórcio";
                pergunta.add(frase);
                frase = "Intermunicipal de Desenvolvimento";
                pergunta.add(frase);
                frase = "Sustentável de uma cidade gaúcha,";
                pergunta.add(frase);
                frase = "quem somos?";
                pergunta.add(frase);
                frase = "Geoparque Quarta Colônia";
                respostas.add(frase);
                frase = "Sete Povos das Missões";
                respostas.add(frase);
                frase = "Praia de Torres";
                respostas.add(frase);
                frase = "Resposta Errada 3";
                respostas.add(frase);
                respostaCorretaIndex = 0;
                break;
            default:
                break;
        }
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public Array<String> getPergunta() {
        return pergunta;
    }

    public Array<String> getRespostas() {
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