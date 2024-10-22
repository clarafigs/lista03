import java.util.*;

public class AutomatoFinitoNaoDeterministico {
    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Set<Estado>>> funcaoDeTransicao;

    public AutomatoFinitoNaoDeterministico(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.funcaoDeTransicao = new HashMap<>();

        for (Estado estado : estados) {
            this.funcaoDeTransicao.put(estado, new HashMap<>());
        }
    }

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Set<Estado> estadosDestino) {
        if (!alfabeto.contains(simbolo)) {
            throw new IllegalArgumentException("Símbolo inválido: " + simbolo);
        }
        if (!estados.contains(estadoOrigem)) {
            throw new IllegalArgumentException("Estado de origem inválido: " + estadoOrigem.getNome());
        }
        this.funcaoDeTransicao.get(estadoOrigem).put(simbolo, estadosDestino);
    }

    public Map<Estado, Map<Character, Set<Estado>>> getFuncaoDeTransicao() {
        return funcaoDeTransicao;
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public Set<Estado> getEstadosFinais() {
        return estadosFinais;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public Set<Character> getAlfabeto() {
        return alfabeto;
    }
}


