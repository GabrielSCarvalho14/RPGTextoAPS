/**
 * CLASSE PERSONAGEM
 * Conforme Adams (2014), a caracterização e diferenciação de arquétipos através de 
 * atributos numéricos é fundamental para a identidade mecânica das classes em um RPG.
 */
public class Personagem {
    // Identificação do Personagem
    public String nome;
    public String raca;
    public String classe;
    
    // Status Vitais Dinâmicos
    public int vida;
    public int poder;

    // --- NOVOS ATRIBUTOS EXIGIDOS PELA APS (Salen & Zimmerman, 2012) ---
    // A inclusão destes atributos visa proporcionar equilíbrio entre desafio e recompensa,
    // permitindo diferentes estratégias baseadas na ficha do jogador.
    public int forca;        // FOR: Capacidade física e potência muscular
    public int destreza;     // DES: Coordenação motora, agilidade e precisão
    public int inteligencia; // INT: Capacidade cognitiva e processamento lógico
    public int magia;        // MAG: Afinidade com energias sobrenaturais
    public int constituicao; // CON: Resistência física e biológica
    public int percepcao;    // PER: Análise do ambiente e observação

    /**
     * CONSTRUTOR DA CLASSE
     * Inicializa o personagem e distribui os atributos de acordo com a especialização da classe.
     */
    public Personagem(String nome, String raca, String classe) {
        this.nome = nome;
        this.raca = raca;
        this.classe = classe;
        
        // Atributos base gerais (Dificuldade Elevada APS)
        this.vida = 50; 
        this.poder = 12;

        // Distribuição de Atributos baseada nas diretrizes acadêmicas do relatório:
        if (classe.equals("Guerreiro")) {
            // Especialista em Espada (Adams, 2014): Focado em Força e Constituição
            this.forca = 16;
            this.constituicao = 15;
            this.destreza = 10;
            this.percepcao = 10;
            this.inteligencia = 8;
            this.magia = 6;
            // Guerreiros ganham bônus de vida inicial pela alta Constituição (+10 HP)
            this.vida += 10; 
        } 
        else if (classe.equals("Arqueiro")) {
            // Especialista em Arco (Schell, 2019): Focado em Destreza e Percepção para precisão
            this.forca = 10;
            this.constituicao = 10;
            this.destreza = 16;
            this.percepcao = 15;
            this.inteligencia = 10;
            this.magia = 6;
            // Arqueiros ganham bônus de poder inicial pela Destreza/Precisão (+3 Poder)
            this.poder += 3;
        } 
        else {
            // Especialista em Magia (Salen & Zimmerman, 2012): Focado em Inteligência e Magia
            this.forca = 7;
            this.constituicao = 9;
            this.destreza = 11;
            this.percepcao = 11;
            this.inteligencia = 16;
            this.magia = 16;
            // Magos canalizam poder através da mente (+5 Poder)
            this.poder += 5;
        }
    }

    /**
     * MÉTODO STATUS
     * Exibe a ficha de personagem completa com a nova distribuição de atributos da APS.
     */
    public void status() {
        System.out.println("\n========================================");
        System.out.println("        STATUS DO AVENTUREIRO           ");
        System.out.println("========================================");
        System.out.println("Nome: " + this.nome + " | Raça: " + this.raca + " | Classe: " + this.classe);
        System.out.println("Vida Atual: " + this.vida + " HP | Poder Ofensivo: " + this.poder);
        System.out.println("----------------------------------------");
        System.out.println("        ATRIBUTOS DE DESIGN (APS)       ");
        System.out.println("----------------------------------------");
        System.out.println("💪 Força (FOR): " + this.forca + "       | 🎯 Destreza (DES): " + this.destreza);
        System.out.println("🧠 Inteligência (INT): " + this.inteligencia + " | 🔮 Magia (MAG): " + this.magia);
        System.out.println("🛡️ Constituição (CON): " + this.constituicao + " | 👁️ Percepção (PER): " + this.percepcao);
        System.out.println("========================================\n");
    }
}