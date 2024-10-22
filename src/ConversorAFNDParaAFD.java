import java.util.*;

public class ConversorAFNParaAFD {

    public static AutomatoFinitoDeterministico converter(AutomatoFinitoNaoDeterministico afn) {
        Set<Set<Estado>> novosEstados = new HashSet<>();
        Map<Set<Estado>, Map<Character, Set<Estado>>> novaFuncaoDeTransicao = new HashMap<>();
        Set<Set<Estado>> estadosFinais = new HashSet<>();

        Set<Estado> estadoInicialAFD = new HashSet<>();
        estadoInicialAFD.add(afn.getEstadoInicial());
        novosEstados.add(estadoInicialAFD);

        Queue<Set<Estado>> fila = new LinkedList<>();
        fila.add(estadoInicialAFD);

        while (!fila.isEmpty()) {
            Set<Estado> conjuntoAtual = fila.poll();
            Map<Character, Set<Estado>> transicoes = new HashMap<>();

            for (Character simbolo : afn.getAlfabeto()) {
                Set<Estado> novosDestinos = new HashSet<>();
                for (Estado estado : conjuntoAtual) {
                    Set<Estado> destinos = afn.getFuncaoDeTransicao().get(estado).get(simbolo);
                    if (destinos != null) {
                        novosDestinos.addAll(destinos);
                    }
                }

                if (!novosDestinos.isEmpty()) {
                    transicoes.put(simbolo, novosDestinos);
                    if (!novosEstados.contains(novosDestinos)) {
                        novosEstados.add(novosDestinos);
                        fila.add(novosDestinos);
                    }
                }
            }

            novaFuncaoDeTransicao.put(conjuntoAtual, transicoes);

            for (Estado estado : conjuntoAtual) {
                if (afn.getEstadosFinais().contains(estado)) {
                    estadosFinais.add(conjuntoAtual);
                    break;
                }
            }
        }

        Map<Set<Estado>, Estado> mapaDeConjuntosParaEstados = new HashMap<>();
        for (Set<Estado> conjunto : novosEstados) {
            mapaDeConjuntosParaEstados.put(conjunto, new Estado(conjunto.toString()));
        }

        Set<Estado> estadosAFD = new HashSet<>(mapaDeConjuntosParaEstados.values());
        Set<Estado> estadosFinaisAFD = new HashSet<>();
        for (Set<Estado> conjunto : estadosFinais) {
            estadosFinaisAFD.add(mapaDeConjuntosParaEstados.get(conjunto));
        }

        Estado estadoInicial = mapaDeConjuntosParaEstados.get(estadoInicialAFD);

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estadosAFD, afn.getAlfabeto(), estadoInicial, estadosFinaisAFD);

        for (Map.Entry<Set<Estado>, Map<Character, Set<Estado>>> entry : novaFuncaoDeTransicao.entrySet()) {
            Estado origemAFD = mapaDeConjuntosParaEstados.get(entry.getKey());
            for (Map.Entry<Character, Set<Estado>> transicao : entry.getValue().entrySet()) {
                afd.definirTransicoes(origemAFD, transicao.getKey(), mapaDeConjuntosParaEstados.get(transicao.getValue()));
            }
        }

        return afd;
    }
}



