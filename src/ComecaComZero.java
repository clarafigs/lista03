import java.util.HashSet;
import java.util.Set;

public class ComecaComZero {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");

        estados.add(q0);
        estados.add(q1);
        estados.add(q2);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.add('0');
        alfabeto.add('1');

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q1);

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);


        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q2);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);
        afd.definirTransicoes(q2, '0', q2);
        afd.definirTransicoes(q2, '1', q2);

        afd.verificarCadeia("011");
    }
}

