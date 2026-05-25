import java.util.Scanner;
import java.util.Random;

/**
 * CLASSE JOGO
 * Centraliza funções globais e a mecânica de probabilidade matemática (RNG).
 */
public class Jogo {
    private static Scanner leitor = new Scanner(System.in);
    private static Random random = new Random();

    // Efeito visual de digitação gradual no console
    public static void imprimirGradual(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(15); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Gerenciador de pausas da história
    public static void aguardarEnter() {
        imprimirGradual("\n[Pressione ENTER para continuar o trajeto...]\n");
        leitor.nextLine();
    }

    // Centralização do encerramento por morte
    public static void gameOver() {
        imprimirGradual("\n💀 FIM DE JOGO! Seus pontos de vida chegaram a 0.\n");
        imprimirGradual("A ganância dos reis destruiu LeverStone e você tombou em combate.\n");
        System.out.println("========================================================");
    }

    /**
     * MÉTODO ROLAR DADO (D6)
     * "Um sistema de regras eficiente cria relações significativas entre as ações do jogador 
     * e os resultados obtidos" (SALEN; ZIMMERMAN, 2012, p. 34).
     */
    public static int rolarDado() {
        imprimirGradual("\n[Pressione ENTER para rolar o dado D6...]\n");
        leitor.nextLine();
        
        int resultado = random.nextInt(6) + 1;
        System.out.println("🎲 Dado lançado! Resultado: " + resultado);
        
        if (resultado == 1 || resultado == 2) {
            imprimirGradual("❌ STATUS: FALHA CRÍTICA!\n");
        } else if (resultado == 3 || resultado == 4) {
            imprimirGradual("⚔️ STATUS: AÇÃO BEM SUCEDIDA (Normal).\n");
        } else if (resultado == 5) {
            imprimirGradual("✨ STATUS: CONCLUSÃO MÁXIMA!\n");
        } else if (resultado == 6) {
            imprimirGradual("🌟 STATUS: CONCLUSÃO MÁXIMA LENDÁRIA! (CRÍTICO 6)\n");
            System.out.print("Mecânica Ativa de Roleplay! Descreva sua ação épica: ");
            String descricao = leitor.nextLine();
            System.out.println("Narrativa: '" + descricao + "' - Executado com perfeição divina!");
        }
        System.out.println();
        return resultado;
    }
}