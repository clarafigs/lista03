import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um autômato para testar:");
        System.out.println("1 - Contém pelo menos um 1");
        System.out.println("2 - Contém pelo menos um par de zeros");
        System.out.println("3 - Começa com 0");
        System.out.println("4 - Linguagem vazia");
        System.out.println("5 - Cadeia vazia (ε)");
        System.out.println("6 - Aceita qualquer cadeia");
        System.out.println("7 - Contém 010 como subcadeia");
        System.out.println("8 - Termina com número ímpar de 1's");
        System.out.println("9 - Contém mais 0's do que 1's");
        System.out.println("10 - Converter AFN para AFD");

        int escolha = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a cadeia de entrada:");
        String cadeia = scanner.nextLine();

        switch (escolha) {
            case 1:
                ContemPeloMenosUm1.main(new String[]{cadeia});
                break;
            case 2:
                ContemPeloMenosParDeZeros.main(new String[]{cadeia});
                break;
            case 3:
                ComecaComZero.main(new String[]{cadeia});
                break;
            case 4:
                AutomatoVazio.main(new String[]{cadeia});
                break;
            case 5:
                CadeiaVazia.main(new String[]{cadeia});
                break;
            case 6:
                QualquerCadeia.main(new String[]{cadeia});
                break;
            case 7:
                Contem010.main(new String[]{cadeia});
                break;
            case 8:
                TerminaComImparDe1s.main(new String[]{cadeia});
                break;
            case 9:
                MaisZerosDoQueUns.main(new String[]{cadeia});
                break;
            case 10:

                Set<Estado> estados = new HashSet<>();
                Estado q0 = new Estado("q0");
                Estado q1 = new Estado("q1");
                estados.add(q0);
                estados.add(q1);

                Set<Character> alfabeto = new HashSet<>();
                alfabeto.add('0');
                alfabeto.add('1');

                Set<Estado> estadosFinais = new HashSet<>();
                estadosFinais.add(q1);

                AutomatoFinitoNaoDeterministico afn = new AutomatoFinitoNaoDeterministico(estados, alfabeto, q0, estadosFinais);

                Set<Estado> destinos = new HashSet<>();
                destinos.add(q0);
                destinos.add(q1);
                afn.definirTransicoes(q0, '0', destinos);

                AutomatoFinitoDeterministico afdConvertido = ConversorAFNParaAFD.converter(afn);
                afdConvertido.verificarCadeia(cadeia);
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }
}

