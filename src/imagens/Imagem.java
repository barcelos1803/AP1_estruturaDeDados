package imagens;

import java.util.Random;

public class Imagem {
    private static int[][] matriz; // matriz bidimensional para representar a imagem
    private int m; // numero de linhas da matriz
    private int n; // numero de colunas

    // construtor da classe imagem
    public Imagem(int m, int n) {
        this.m = m; // Atribuição do valor de m ao atributo m da classe
        this.n = n; // Atribuição do valor de n ao atributo n da classe
        matriz = new int[m][n];
        preencherAleatoriamente(); // chamando a função para preencher a matriz automaticamente
    }

    //função para preencher a matriz automaticamente
    public void preencherAleatoriamente() {
        Random random = new Random(); // Criação de um objeto da classe Random para gerar números aleatórios
        for (int i = 0; i < m; i++) { // loop para percorrer as linhas
            for (int j = 0; j < n; j++) { // loop para percorrer as colunas
                matriz[i][j] = random.nextInt(2); // aqui atribui um valor aleatório (0 ou 1) a posição [i][j] da matriz
            }
        }
    }

    // Função para obter o numero de linhas da matriz
    public int getM() {
        return m;
    }

    // Função para obter o numero de colunas da matriz
    public int getN() {
        return n;
    }

    // Função para obter o valor da posição [i][j] da matriz
    public static int getValor(int i, int j) {

        return matriz[i][j];
    }

    // Função para definir o valor da posição [i][j] da matriz
    public void setValor(int i, int j, int valor) {

        matriz[i][j] = valor;
    }

    // Função para imprimir a matriz
    public void imprimir() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Impressão de uma quebra de linha para separar as linhas da matriz
        }
    }
}
