import java.util.HashSet;
import java.util.Set;

public class QualquerCadeia {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");

        estados.add(q0);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.add('0');
        alfabeto.add('1');

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q0);

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);

        afd.verificarCadeia("101");
    }
}

