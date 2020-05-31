package com.example.appespigao.models;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Jogo
{
    private List<String> numeros;
    private String nomeBloco;

    public List<String> getNumeros() {
        return numeros;
    }
    public String getnomeBloco() {
        return nomeBloco;
    }


    public void setNumeros(List<String> numeros) {
        this.numeros = numeros;
    }
    public void setNumerosInteiros(List<Integer> numerosInteiros)
    {
        List<String> novoList = new ArrayList<String>();
        for (Integer num: numerosInteiros) {
            novoList.add(this.IncluirZeroEsquerda(num));
        }
        this.numeros = novoList;
    }
    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }

    private String IncluirZeroEsquerda(Integer numero) {
        return StringUtils.right("0" + numero,2);
    }
}



