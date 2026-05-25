import java.util.Scanner;

/**
 * CLASSE PRINCIPAL (APP)
 * Controla os capítulos da história e faz com que os novos atributos influenciem 
 * diretamente os caminhos e escolhas da narrativa (relação significativa de Salen & Zimmerman).
 */
public class App {
    private static Scanner leitor = new Scanner(System.in);
    private static int ataqueExtra = 0;
    private static int armaduraExtra = 0;

    public static void main(String[] args) {

        // --- APRESENTAÇÃO DO JOGO ---
        Jogo.imprimirGradual("========================================================\n");
        Jogo.imprimirGradual("         A AVENTURA DO DRAGÃO: LEVERSTONE V4            \n");
        Jogo.imprimirGradual("========================================================\n");
        Jogo.imprimirGradual("O reino de LeverStone prosperava expandindo suas terras.\n");
        Jogo.imprimirGradual("Florestas eram queimadas, rios desviados e montanhas escavadas.\n");
        Jogo.imprimirGradual("Mas o preço foi alto... Os rios secaram e as colheitas adoeceram.\n");
        Jogo.imprimirGradual("Sempre que um novo território era tomado, surgia o Dragão Ancestral.\n");
        Jogo.imprimirGradual("Para os humanos, um monstro destruidor. Para a natureza, o último guardião.\n\n");

        // --- CRIAÇÃO DE PERSONAGEM (INPUTS) ---
        Jogo.imprimirGradual("Digite o nome do seu aventureiro: ");
        String nome = leitor.nextLine();

        Jogo.imprimirGradual("\nEscolha sua RAÇA:\n1. Elfo (Agilidade/Magia)\n2. Humano (Versatilidade)\n3. Anão (Resistência)\nEscolha: ");
        int escRaca = leitor.nextInt();
        String raca = (escRaca == 1) ? "Elfo" : (escRaca == 2) ? "Humano" : "Anão";

        Jogo.imprimirGradual("\nEscolha sua CLASSE (Seus atributos mudarão conforme a escolha):\n1. Especialista em Espada (Guerreiro)\n2. Especialista em Magia (Mago)\n3. Especialista em Arco (Arqueiro)\nEscolha: ");
        int escClasse = leitor.nextInt();
        String classe;
        switch (escClasse) {
            case 1: classe = "Guerreiro"; break;
            case 2: classe = "Mago"; break;
            default: classe = "Arqueiro"; break;
        }

        // Instanciação orientada a objetos aplicando as regras de game design da APS
        Personagem heroi = new Personagem(nome, raca, classe);
        
        Jogo.imprimirGradual("\n⚠️ SISTEMA ADAPTADO: Ficha gerada com sucesso com base nos parâmetros da APS.\n");
        heroi.status();
        leitor.nextLine(); // Limpeza de buffer

        // --- CAPÍTULO 1: A QUEST DO REI ---
        Jogo.imprimirGradual("\n[CAPÍTULO 1 — A QUEST DO REI]\n");
        Jogo.imprimirGradual("No salão principal, o Rei de LeverStone diz: 'O dragão destruiu três vilas ao norte.'\n");
        Jogo.imprimirGradual("'Mate a criatura e será recompensado com ouro para viver como um lorde.'\n");
        Jogo.imprimirGradual("O conselheiro se aproxima e cochicha: 'Dizem que ninguém retorna da montanha...'\n");
        Jogo.imprimirGradual("Você ergue o medalhão antigo dado pelo Rei e marcha em direção ao norte.\n");
        Jogo.aguardarEnter();

        // --- CAPÍTULO 2: EXPLORAÇÃO DA VILA (RELAÇÃO ATRIBUTO X MUNDO) ---
        Jogo.imprimirGradual("\n[CAPÍTULO 2 — A VILA DESTRUÍDA]\n");
        Jogo.imprimirGradual("Ao chegar à vila, o cenário é desolador. Fumaça cinzenta e casas em cinzas.\n");
        
        boolean explorouTudo = false;
        while (!explorouTudo) {
            Jogo.imprimirGradual("\nO que deseja fazer no ambiente?\n");
            Jogo.imprimirGradual("1. Investigar as plantações queimadas ao redor\n");
            Jogo.imprimirGradual("2. Vasculhar os escombros da antiga ferraria destruída (Procurar Arma)\n");
            Jogo.imprimirGradual("3. Conversar com uma velha senhora perto da carroça\n");
            Jogo.imprimirGradual("4. Parar de explorar e avançar na jornada\n");
            Jogo.imprimirGradual("Escolha: ");
            int explorarVila = leitor.nextInt();
            leitor.nextLine();

            if (explorarVila == 1) {
                Jogo.imprimirGradual("\nVocê caminha pelas cinzas e nota troncos cortados com perfeição antes do incêndio.\n");
                // REQUISITO SCHELL (2019) / SALEN (2012): Atributos dando profundidade e respostas customizadas
                if (heroi.percepcao >= 15) {
                    System.out.println("🔎 [SUCESSO EM PERCEPÇÃO]: Seus olhos aguçados notam pegadas humanas de mercenários sabotando os suprimentos antes do ataque!");
                }
                Jogo.imprimirGradual("A ganância humana atacou primeiro. O fogo do dragão foi apenas uma resposta...\n");
            } else if (explorarVila == 2) {
                if (ataqueExtra == 0) {
                    Jogo.imprimirGradual("\nVocê remexe o metal retorcido da ferraria.\n");
                    // REQUISITO ADAMS (2014): Uso da força física para modificar o ambiente
                    if (heroi.forca >= 15) {
                        System.out.println("💪 [SUCESSO EM FORÇA]: Com seus músculos potentes, você joga a bigorna para o lado sem dificuldades!");
                        Jogo.imprimirGradual("Sob ela, você encontra uma Lâmina de Aço Temperado Lendária!\n");
                        Jogo.imprimirGradual("✨ EQUIPAMENTO EQUIPADO: +7 de Ataque Extra Permanente!\n");
                        ataqueExtra = 7;
                    } else {
                        Jogo.imprimirGradual("Sob uma bigorna pesada que você custa a mover, encontra uma Lâmina de Aço Temperado Comum.\n");
                        Jogo.imprimirGradual("✨ EQUIPAMENTO EQUIPADO: +5 de Ataque Extra Permanente!\n");
                        ataqueExtra = 5;
                    }
                } else {
                    Jogo.imprimirGradual("\nVocê já revirou os escombros da ferraria.\n");
                }
            } else if (explorarVila == 3) {
                Jogo.imprimirGradual("\nA velha senhora olha nos seus olhos:\n");
                if (heroi.inteligencia >= 15) {
                    System.out.println("🧠 [SUCESSO EM INTELIGÊNCIA]: Você decifra as runas antigas nas vestes dela antes mesmo de ela falar.");
                }
                Jogo.imprimirGradual("'Aventureiro, o dragão não nos atacou sem motivo. Nós cortamos a floresta sagrada para enriquecer o reino...'\n");
                Jogo.imprimirGradual("Ela lhe entrega um antigo 'Mapa da Montanha Esquecida'.\n");
            } else {
                explorouTudo = true;
            }
        }

        // QTE modificado pela CONSTITUIÇÃO do personagem
        Jogo.imprimirGradual("\nDe repente, uma menina chora: 'Por favor! Ajude meu pai preso nos destroços!'\n");
        int dadoVila = Jogo.rolarDado();
        
        // Aplicação das regras baseadas no atributo Constituição (CON) para mitigar falhas físicas
        if (dadoVila <= 2) {
            int danoQTE = Math.max(5, 15 - (heroi.constituicao / 3));
            System.out.printf("FALHA CRÍTICA! As vigas deslizam ferindo seus braços. Devido à sua Constituição, o dano real foi mitigado. (-%d HP)%n", danoQTE);
            heroi.vida -= danoQTE;
        } else if (dadoVila <= 4) {
            Jogo.imprimirGradual("AÇÃO NORMAL! Com esforço físico, você empurra as vigas e retira o aldeão em segurança.\n");
        } else {
            Jogo.imprimirGradual("CONCLUSÃO MÁXIMA! Você move os escombros com facilidade. Ganha um Bracelete de Couro Fervido.\n");
            Jogo.imprimirGradual("✨ EQUIPAMENTO EQUIPADO: +3 de Armadura Extra Permanente!\n");
            armaduraExtra = 3;
        }
        
        if (heroi.vida <= 0) { Jogo.gameOver(); return; }
        Jogo.aguardarEnter();

        // --- CAPÍTULO 3: O SEGUNDO GUARDIÃO (MECÂNICA E INTEGRAÇÃO DE MAGIA) ---
        Jogo.imprimirGradual("\n[CAPÍTULO 3 — O GUARDIÃO DA CAVERNA]\n");
        Jogo.imprimirGradual("O mapa te guia até a entrada de uma caverna. Um gigantesco guerreiro feito de rocha bloqueia o caminho.\n");
        
        // REQUISITO DE PROFUNDIDADE ESTRATÉGICA (SALEN & ZIMMERMAN)
        // Se o personagem for da classe Mago e possuir alta Magia, ele ganha uma opção exclusiva de interação
        if (heroi.magia >= 15) {
            System.out.println("🔮 [VANTAGEM DE MAGIA]: Seus canais sobrenaturais detectam o fluxo magnético da criatura de pedra!");
            System.out.println("Isso te dá a certeza absoluta de qual pilar escolher.");
        }

        Jogo.imprimirGradual("O puzzle exige que você ative duas forças que devem coexistir:\n");
        Jogo.imprimirGradual("1. Humanidade + Poder\n2. Humanidade + Natureza\n3. Natureza + Poder\nEscolha: ");
        int escolhaPuzzle = leitor.nextInt();
        leitor.nextLine();

        int vidaGuardiao = 40;
        boolean lutandoGuardiao = false;

        if (escolhaPuzzle == 2) {
            Jogo.imprimirGradual("\nOs pilares brilham verde. O Guardião de Pedra se ajoelha e abre passagem.\n");
        } else {
            Jogo.imprimirGradual("\nEnergia vermelha instável! O Guardião ergue os punhos de pedra. O combate começa!\n");
            lutandoGuardiao = true;
        }

        // Loop de Combate do Guardião
        while (lutandoGuardiao && vidaGuardiao > 0 && heroi.vida > 0) {
            System.out.println("\nSUA VIDA: " + heroi.vida + " HP | GUARDIÃO DE PEDRA: " + vidaGuardiao + " HP");
            Jogo.imprimirGradual("Ações:\n1. ATACAR\n2. DEFENDER\n3. DESVIAR\nEscolha: ");
            int acaoG = leitor.nextInt(); leitor.nextLine();

            int dadoG = Jogo.rolarDado();
            int ataqueTotal = heroi.poder + ataqueExtra;

            if (acaoG == 1) {
                if (dadoG <= 2) {
                    heroi.vida -= 18;
                    Jogo.imprimirGradual("FALHA CRÍTICA! Contra-ataque pesado sofrido! (-18 HP)\n");
                } else if (dadoG <= 4) {
                    vidaGuardiao -= ataqueTotal;
                    heroi.vida -= Math.max(2, 12 - armaduraExtra);
                    System.out.printf("AÇÃO NORMAL! Causou %d de dano e recebeu contra-ataque.%n", ataqueTotal);
                } else {
                    vidaGuardiao -= (ataqueTotal + 10);
                    System.out.printf("CONCLUSÃO MÁXIMA! Golpe preciso quebrando rochas! (-%d HP nele)%n", (ataqueTotal + 10));
                }
            } 
            else if (acaoG == 2) {
                if (dadoG <= 2) {
                    heroi.vida -= 15;
                    Jogo.imprimirGradual("FALHA CRÍTICA! Escudo quebrado. (-15 HP)\n");
                } else if (dadoG <= 4) {
                    int danoReduzido = Math.max(1, 6 - armaduraExtra);
                    heroi.vida -= danoReduzido;
                    System.out.printf("AÇÃO NORMAL! Impacto mitigado pelo equipamento. (-%d HP)%n", danoReduzido);
                } else {
                    Jogo.imprimirGradual("CONCLUSÃO MÁXIMA! Bloqueio limpo, dano zerado.\n");
                }
            } 
            else {
                if (dadoG <= 2) {
                    heroi.vida -= 20;
                    Jogo.imprimirGradual("FALHA CRÍTICA! Tropeçou e foi atingido! (-20 HP)\n");
                } else if (dadoG <= 4) {
                    heroi.vida -= 3;
                    Jogo.imprimirGradual("AÇÃO NORMAL! Raspão de estilhaços. (-3 HP)\n");
                } else {
                    vidaGuardiao -= 15;
                    Jogo.imprimirGradual("CONCLUSÃO MÁXIMA! Esquiva cirúrgica com contra-ataque imediato! (-15 HP nele)\n");
                }
            }
        }

        if (heroi.vida <= 0) { Jogo.gameOver(); return; }
        if (lutandoGuardiao) { Jogo.imprimirGradual("\n✨ O Guardião de Pedra se desfaz em poeira. Caminho livre!\n"); }
        Jogo.aguardarEnter();

        // --- CAPÍTULO 4: COMBATE FINAL CONTRA O DRAGÃO (REQUISITO SCHELL - DOMÍNIO) ---
        Jogo.imprimirGradual("\n[CAPÍTULO 4 — A PRIMEIRA BATALHA CONTRA O DRAGÃO]\n");
        Jogo.imprimirGradual("O Dragão Ancestral surge das sombras. 'Outro assassino... Os humanos falam demais e escutam pouco.'\n");

        int vidaDragao = 65;
        
        while (vidaDragao > 0 && heroi.vida > 0) {
            System.out.println("\nSUA VIDA: " + heroi.vida + " HP | VIDA DO DRAGÃO: " + vidaDragao + " HP");
            Jogo.imprimirGradual("Estratégias de Turno:\n1. ATACAR\n2. DEFENDER\n3. DESVIAR\nSua Ação: ");
            int estrategia = leitor.nextInt(); leitor.nextLine();

            int dadoTurno = Jogo.rolarDado();
            int danoDoHeroi = heroi.poder + ataqueExtra;

            // SCHELL (2019): Mecânicas de precisão aumentam a sensação de domínio e habilidade do jogador.
            // Arqueiros (Alta Destreza) ganham bônus de acerto crítico marginal nos dados automáticos!
            if (heroi.destreza >= 15 && dadoTurno == 4) {
                System.out.println("🎯 [MECÂNICA DE PRECISÃO - SCHELL]: Sua destreza elevada converteu um acerto Normal em um Crítico Máximo!");
                dadoTurno = 5; // Eleva o grau de sucesso
            }

            if (estrategia == 1) {
                if (dadoTurno <= 2) {
                    heroi.vida -= 22;
                    Jogo.imprimirGradual("FALHA CRÍTICA! Arremessado contra a parede! (-22 HP)\n");
                } else if (dadoTurno <= 4) {
                    vidaDragao -= danoDoHeroi;
                    heroi.vida -= Math.max(4, 14 - armaduraExtra);
                    System.out.printf("AÇÃO NORMAL! Perfurou as escamas (-%d HP) e sofreu retaliação de chamas.%n", danoDoHeroi);
                } else {
                    vidaDragao -= (danoDoHeroi + 12);
                    System.out.printf("CONCLUSÃO MÁXIMA! Golpe brutal rasgando carne! (-%d HP no Dragão)%n", (danoDoHeroi + 12));
                }
            } 
            else if (estrategia == 2) {
                if (dadoTurno <= 2) {
                    heroi.vida -= 18;
                    Jogo.imprimirGradual("FALHA CRÍTICA! Escudo superaquecido! (-18 HP)\n");
                } else if (dadoTurno <= 4) {
                    int danoFogo = Math.max(2, 8 - armaduraExtra);
                    heroi.vida -= danoFogo;
                    System.out.printf("AÇÃO NORMAL! Chamas absorvidas parcialmente pela armadura. (-%d HP)%n", danoFogo);
                } else {
                    Jogo.imprimirGradual("CONCLUSÃO MÁXIMA! Encontrou cobertura perfeita. Dano nulo!\n");
                }
            } 
            else {
                if (dadoTurno <= 2) {
                    heroi.vida -= 20;
                    Jogo.imprimirGradual("FALHA CRÍTICA! Atingido pela cauda pesada em pleno ar! (-20 HP)\n");
                } else if (dadoTurno <= 4) {
                    heroi.vida -= 4;
                    Jogo.imprimirGradual("AÇÃO NORMAL! Queda leve na evasão. (-4 HP)\n");
                } else {
                    Jogo.imprimirGradual("CONCLUSÃO MÁXIMA! Deslizou sob as asas do dragão saindo ileso!\n");
                }
            }
        }

        if (heroi.vida <= 0) { Jogo.gameOver(); return; }

        // --- CAPÍTULO 5: A VERDADE E ESCOLHA FINAL ---
        Jogo.imprimirGradual("\nO Dragão recua. Você o segue e encontra o santuário com a árvore colossal ligada à alma da terra.\n");
        Jogo.imprimirGradual("'Esta árvore mantém os rios vivos. Cada árvore cortada enfraquece suas raízes. Vocês estavam matando o reino...'\n");

        System.out.println("\n========================================================");
        System.out.println("                     A ESCOLHA FINAL                    ");
        System.out.println("========================================================");
        System.out.println("1. FINAL 1 — Matar o Dragão (Favorecer a ganância humana e o colapso do ecossistema)");
        System.out.println("2. FINAL 2 — Ajudar o Dragão (Rebelar-se e restaurar o equilíbrio ecológico)");
        System.out.print("Escolha o destino de LeverStone: ");
        int escolhaFinal = leitor.nextInt();

        if (escolhaFinal == 1) {
            Jogo.imprimirGradual("\nVocê derrota o guardião e ganha ouro. Mas anos depois, as águas somem e o império colapsa.\n");
            Jogo.imprimirGradual("Última cena: Uma pequena muda da árvore ancestral morrendo em solo totalmente seco...\n");
        } else {
            Jogo.imprimirGradual("\nVocê se nega a lutar pelo reino corrupto. Juntos, vocês marcham até a capital e restauram a ecologia.\n");
            Jogo.imprimirGradual("Última cena: O dragão ancestral sobrevoando vales e rios cristalinos que voltaram a correr puros.\n");
        }

        Jogo.imprimirGradual("\n========================================================\n");
        Jogo.imprimirGradual("      PROJETO APS FINALIZADO COM SUCESSO! (V4)         \n");
        Jogo.imprimirGradual("========================================================\n");
    }
}