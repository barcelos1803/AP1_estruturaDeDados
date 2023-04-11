import imagens.Imagem;
import imagens.Padrao;
public class BuscarPadroes {
    public static void main(String[] args) {
        int m = 100;
        int n = 100;

        Imagem imagem = new Imagem(m, n);
        Padrao[] padroes = new Padrao[2];
        int[][] padraoMatriz1 = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        int[][] padraoMatriz2 = {{1, 1, 1}, {1, 0, 1}, {0,1, 1}};
        padroes[0] = new Padrao(padraoMatriz1);
        padroes[1] = new Padrao(padraoMatriz2);

        long tempoInicial = System.currentTimeMillis();
        int[] qtdOcorrencias = buscarPadroes(imagem, padroes);
        long tempoFinal = System.currentTimeMillis();

        for (int i = 0; i < padroes.length; i++) {
            System.out.println("Padrão " + i + " encontrado " + qtdOcorrencias[i] + " vezes.");
        }
        System.out.println("Tempo gasto: " + (tempoFinal - tempoInicial) + " ms.");
    }

    public static int[] buscarPadroes(Imagem imagem, Padrao[] padroes) {
        int[] qtdOcorrencias = new int[padroes.length];
        int m = imagem.getM();
        int n = imagem.getN();

        for (int pIndex = 0; pIndex < padroes.length; pIndex++) {
            Padrao padrao = padroes[pIndex];
            int p = padrao.getP();
            int q = padrao.getQ();

            for (int i = 0; i <= m - p; i++) {
                for (int j = 0; j <= n - q; j++) {
                    boolean encontrouPadrao = true;
                    for (int k = 0; k < p; k++) {
                        for (int l = 0; l < q; l++) {
                            if (imagem.getValor(i + k, j + l) != padrao.getValor(k, l)) {
                                encontrouPadrao = false;
                                break;
                            }
                        }
                        if (!encontrouPadrao) {
                            break;
                        }
                    }
                    if (encontrouPadrao) {
                        qtdOcorrencias[pIndex]++;
                    }
                }
            }
        }

        return qtdOcorrencias;
    }


}
