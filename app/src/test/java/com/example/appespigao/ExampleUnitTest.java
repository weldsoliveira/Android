package com.example.appespigao;

import com.example.appespigao.models.Jogo;

import org.junit.Test;
import org.junit.experimental.theories.Theory;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void dezenas_recebendo_lista_inteiros()
    {
        List<Integer> jogo = new ArrayList<Integer>();
        List<String> resultadoEsperado = new ArrayList<String>();
        jogo.add(1);
        jogo.add(10);
        jogo.add(5);
        jogo.add(50);
        Jogo jogoTeste = new Jogo();
        jogoTeste.setNumerosInteiros(jogo);
        List<String> valorTestar = jogoTeste.getNumeros();
        resultadoEsperado.add("01");
        resultadoEsperado.add("10");
        resultadoEsperado.add("05");
        resultadoEsperado.add("50");
        assertEquals(resultadoEsperado,valorTestar);
    }




}