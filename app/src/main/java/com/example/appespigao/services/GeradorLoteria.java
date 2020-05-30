package com.example.appespigao.services;
import com.example.appespigao.models.Bloco;
import com.example.appespigao.models.Jogo;
import java.util.ArrayList;
import java.util.List;

public class GeradorLoteria {
    public Jogo GerarJogo(Integer qtdNumeros, List<Integer> numerosParaAposta)
    {
        Jogo jogo = new Jogo();
        List<Integer> numerosParaJogo = new ArrayList<Integer>();
        for(Integer i = 0; i < qtdNumeros; i++){
            double tamanhoRestante = numerosParaAposta.size();
            int indiceSelecionado = getRandomNumber(1,(int)tamanhoRestante) -1;
            Integer numeroSelecionado = numerosParaAposta.get(indiceSelecionado );
            numerosParaJogo.add(numeroSelecionado);
            numerosParaAposta.remove(indiceSelecionado );
        }
        jogo.setNumerosInteiros(numerosParaJogo);
        return jogo;
    }
    public List<Integer> GerarNumerosMegaSena()
    {
        List<Integer> numerosMega = new ArrayList<Integer>();
        for(Integer i=1; i<=60; i++){
            numerosMega.add(i);
        }
        return numerosMega;
    }
    public Bloco GerarBloco(Integer qtdBlocos, List<Integer> numerosParaAposta)
    {
        List<Integer> numerosMega = this.GerarNumerosMegaSena();
        List<Jogo> listaJogos = new ArrayList<Jogo>();
        Bloco bloco = new Bloco();
        for(Integer i = 0 ; i<10 ; i++)
        {
            Jogo jogoGerado = this.GerarJogo(6,numerosMega);
            listaJogos.add(jogoGerado);
        }
        bloco.setJogos(listaJogos);
        return bloco;
    }

    public List<Bloco> Gerar(Integer qtdBlocos)
    {
        List<Bloco> blocos = new ArrayList<Bloco>();
        for(Integer i = 0; i< qtdBlocos; i++){
            List<Integer> numerosMega = this.GerarNumerosMegaSena();
            Bloco blocoGerado = this.GerarBloco(6,numerosMega);
            blocos.add(blocoGerado);
        }

        return blocos;
    }
    public int getRandomNumber(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
