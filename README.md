# A Aventura do Dragão: LeverStone (RPG de Texto — APS)

Este é um jogo de RPG baseado em texto desenvolvido em Java como parte das Atividades Práticas Supervisionadas (APS). O projeto explora conceitos de Programação Orientada a Objetos (POO) integrados a teorias acadêmicas de Game Design e narrativas com dilemas ecológicos.

## Sobre o Jogo (Sinopse)
O reino de LeverStone prospera através da expansão desenfreada de suas terras, destruindo florestas e desviando rios em nome do progresso. Como consequência, os recursos naturais começam a secar e o **Dragão Ancestral** — o último guardião da natureza — desperta para contra-atacar. 

O jogador assume o papel de um aventureiro contratado pelo Rei para eliminar a fera em troca de ouro. Ao longo da jornada pela vila destruída e pela caverna dos guardiões, o herói descobre a verdade por trás da crise ecológica e deve tomar a **Escolha Final**: cumprir o contrato e condenar o ecossistema ou aliar-se à criatura para restaurar o equilíbrio do mundo.

## Embasamento Teórico (Game Design)
O desenvolvimento das mecânicas, fichas de personagens e sistemas de escolhas foi fundamentado em grandes autores da literatura de jogos:

* **Salen & Zimmerman (2012):** Utilizado na definição de regras eficientes que criam relações significativas entre as ações do jogador e os resultados obtidos, além do equilíbrio matemático entre o desafio da alta dificuldade (50 HP iniciais) e a recompensa.
* **Adams (2014):** Aplicado na estruturação e diferenciação dos arquétipos clássicos de personagens através de atributos numéricos (Força, Constituição, Inteligência, etc.).
* **Schell (2019):** Base para o sistema de combate por turnos e rolagens de dados (D6), onde mecânicas que exigem precisão aumentam a sensação de domínio e habilidade do jogador.

---

## Estrutura de Pastas e Arquivos

O projeto é dividido de forma modular seguindo as boas práticas de POO:
* `src/Personagem.java`: Molde (Classe) que encapsula os atributos físicos, cognitivos e o estado de vida/poder do herói.
* `src/Jogo.java`: Centraliza as funções utilitárias do sistema (efeito de digitação gradual, pausas na história e a lógica matemática de rolagem de dados D6).
* `src/App.java`: Classe principal controladora que dita o fluxo dos capítulos e a máquina de estados da narrativa.
* `.gitignore`: Arquivo de configuração para impedir que arquivos compilados (`.class`) ou o ambiente JDK local sejam enviados ao repositório.

---

## Como Baixar e Executar o Trabalho

### Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:
1. O **Git** (opcional, para clonagem).
2. O **Java JDK** (versão 17 ou superior recomendada).
3. Uma IDE ou editor de código como o **Visual Studio Code** com a extensão *Extension Pack for Java* ativada.

### 1. Baixando o Projeto

Você pode clonar este repositório usando o terminal do Git:
bash
git clone [https://github.com/GabrielSCarvalho14/RPGTextoAPS.git]
(Ou clicando no botão verde Code no topo da página do GitHub e selecionando Download ZIP para extrair no seu computador).

### 2. Abrindo no VS Code
Abra o Visual Studio Code.

Vá em File > Open Folder... (Arquivo > Abrir Pasta).

Selecione a pasta raiz do projeto (prjRPG).

### 3. Como Jogar (Execução)
Certifique-se de que o arquivo principal App.java está aberto na sua tela.

Clique no botão de Play / Run Java localizado no canto superior direito do VS Code (ou pressione F5).

O jogo iniciará diretamente no terminal integrado da IDE.

Interação: Digite os números das opções desejadas no menu e pressione ENTER sempre que o console solicitar rolagens de dados ou pausas na leitura.
