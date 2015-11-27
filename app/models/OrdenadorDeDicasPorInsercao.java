package models;

import java.util.*;

public class OrdenadorDeDicasPorInsercao implements OrdenadorDeDicas {

    public OrdenadorDeDicasPorInsercao(){}

    @Override
    public List<Dica> ordenaDicas(List<Disciplina> listaDisciplina) {
        List<Dica> dicasOrdenadas = new ArrayList<>();
        for (Disciplina disciplina:listaDisciplina) {
            for (Tema tema:disciplina.getTemas()) {
                for (Dica dica:tema.getDicas()) {
                    dicasOrdenadas.add(dica);
                }
            }
        }
        Collections.sort(dicasOrdenadas);
        return dicasOrdenadas;
    }

}
