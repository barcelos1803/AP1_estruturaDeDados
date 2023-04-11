import imagens.Imagem;
import imagens.Padrao;
public class BuscaPadrao {
    public static void main(String[] args) {
        int m = 100; // Dimensão m da imagem
        int n = 100; // Dimensão n da imagem


        Imagem imagem = new Imagem(m, n); // Gerar imagem 100x100 com valores 0 ou 1
        int[][] padraoMatriz = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}; // Padrão a ser buscado na imagem
        Padrao padrao = new Padrao(padraoMatriz);



        long tempoInicial = System.currentTimeMillis(); // Cronômetro - tempo inicial

        int qtdOcorrencias = buscarPadrao(imagem, padrao); // Buscar ocorrências do padrão na imagem

        long tempoFinal = System.currentTimeMillis(); // Cronômetro - tempo final

        /* System.out.println("Matriz:");
        imagem.imprimir();
        System.out.println("Padrão");
        padrao.imprimirPadrao(); */
        System.out.println("Padrão encontrado " + qtdOcorrencias + " vezes.");
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + " ms.");

    }
    public static int buscarPadrao(Imagem imagem, Padrao padrao) {
        int qtdOcorrencias = 0;
        int m = imagem.getM();
        int n = imagem.getN();
        int p = padrao.getP();
        int q = padrao.getQ();

        for (int i = 0; i <= m - p; i++) {  // loop externo - limita as linhas da imagem verificada
            for (int j = 0; j <= n - q; j++) {  // loop intermediario - limita as colunas da imagem verificada
                boolean encontrouPadrao = true;
                for (int k = 0; k < p; k++) {  // loop externo - verifica se o padrão é encontrado na imagem,
                    for (int l = 0; l < q; l++) {  // comparando seus elementos com a imagem a partir da posição atual.
                        if (Imagem.getValor(i + k,j + l) != Padrao.getValor(k, l)) {
                            encontrouPadrao = false;
                            break;
                        }
                    }
                    if (!encontrouPadrao) {
                        break;
                    }
                }
                if (encontrouPadrao) {
                    qtdOcorrencias++;
                }
            }
        }
        return qtdOcorrencias;
    }
}


   /* Este projeto é um exemplo de busca de padrões em uma imagem usando Java. O programa gera uma matriz bidimensional aleatória que representa uma imagem binária e busca por um padrão predefinido nessa imagem.

        A classe Imagem possui um construtor que inicializa uma matriz bidimensional de tamanho m x n, onde m é o número de linhas e n é o número de colunas da matriz. A matriz é preenchida aleatoriamente com valores 0 ou 1 usando a função preencherAleatoriamente(). A classe também fornece métodos para obter o número de linhas e colunas da matriz, obter o valor da posição [i][j] da matriz e definir o valor da posição [i][j] da matriz.

        A classe Padrao representa um padrão a ser procurado na imagem. Ela recebe uma matriz bidimensional como parâmetro e armazena seu tamanho e conteúdo. A classe também fornece métodos para obter o número de linhas e colunas do padrão e obter o valor do elemento na posição [i][j] do padrão.

        A classe BuscaPadrao é a classe principal que contém o método main(). Ela cria uma instância da classe Imagem com dimensões m x n e uma matriz de padrão de tamanho 3 x 3. O método buscarPadrao() é usado para procurar o padrão na imagem e contar o número de ocorrências. O tempo gasto na busca é registrado e impresso na saída. */