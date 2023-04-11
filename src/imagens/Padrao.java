package imagens;

public class Padrao{
    private static int[][] matriz; // matriz bidimencional para representar o padrao
    private int p; //numero de linhas do padrao
    private int q; // numero de colunas do padrao

    public Padrao(int[][] matriz) { //// Construtor que recebe a matriz do padrão como parâmetro
        this.matriz = matriz;
        p = matriz.length; // Atribui o número de linhas da matriz ao atributo p
        q = matriz[0].length; // Atribui o número de colunas da matriz ao atributo q
    }

    // função para obter o número de linhas do padrao
    public int getP() {
        return p;
    }
    // função para obter o número de colunas do padrao
    public int getQ() {
        return q;
    }

    // função para obter o valor do elemento na posição (i, j) do padrão
    public static int getValor(int i, int j) {
        return matriz[i][j];
    }

    // função para imprimir a matriz do padrão
    public void imprimirPadrao() {
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}