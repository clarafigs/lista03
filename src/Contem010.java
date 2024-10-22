import java.util.HashSet;
import java.util.Set;

public class Contem010 {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");

        estados.add(q0);
        estados.add(q1);
        estados.add(q2);
        estados.add(q3);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.add('0');
        alfabeto.add('1');

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q3);

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);


        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q0);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q2);
        afd.definirTransicoes(q2, '0', q3);
        afd.definirTransicoes(q2, '1', q0);
        afd.definirTransicoes(q3, '0', q3);
        afd.definirTransicoes(q3, '1', q3);

        afd.verificarCadeia("101010");
    }
}

