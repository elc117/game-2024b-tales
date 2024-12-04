package com.badlogic.circledemo;

import com.badlogic.gdx.utils.Array;

public class Quiz {
    private int id;
    private String pergunta = new String();
    private Array<String> respostas = new Array<String>(); // Lista com todas as respostas (correta e erradas)
    private int respostaCorretaIndex; // Índice da resposta correta na lista

    public Quiz(Integer id) {
        String resposta = new String();
        int questao;
        switch (id) {
            case 1:
                this.pergunta = "Somos uma iniciativa da UFSM em parceria com o Consórcio Intermunicipal de Desenvolvimento Sustentável de uma cidade gaúcha, quem somos?";
                resposta = "Geoparque Quarta Colônia";
                respostas.add(resposta);
                resposta = "Sete Povos das Missões";
                respostas.add(resposta);
                resposta = "Praia de Torres";
                respostas.add(resposta);
                resposta = "Resposta Errada 3";
                respostas.add(resposta);
                this.respostaCorretaIndex = 0;
                break;
            case 2:
                this.pergunta = "Somos uma iniciativa da UFSM em parceria com o Consórcio Intermunicipal de Desenvolvimento Sustentável de uma cidade gaúcha, quem somos?";
                resposta = "Geoparque Quarta Colônia";
                respostas.add(resposta);
                resposta = "Sete Povos das Missões";
                respostas.add(resposta);
                resposta = "Praia de Torres";
                respostas.add(resposta);
                resposta = "Resposta Errada 3";
                respostas.add(resposta);
                this.respostaCorretaIndex = 0;
                break;
            case 3:
                this.pergunta = "Somos uma iniciativa da UFSM em parceria com o Consórcio Intermunicipal de Desenvolvimento Sustentável de uma cidade gaúcha, quem somos?";
                resposta = "Geoparque Quarta Colônia";
                respostas.add(resposta);
                resposta = "Sete Povos das Missões";
                respostas.add(resposta);
                resposta = "Praia de Torres";
                respostas.add(resposta);
                resposta = "Resposta Errada 3";
                respostas.add(resposta);
                this.respostaCorretaIndex = 0;
                break;
            default:
                break;
        }
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getPergunta() {
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