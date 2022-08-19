package com.trybe.acc.java.geradorsenhas;

import java.io.*;
import java.util.ArrayList;

public class GeradorSenhas {
  public static final Integer NUM_SENHAS = 10;

  // TROQUE O CAMINHO PARA O DIRETORIO DE DESTINO DOS SEUS ARQUIVOS
  public static final String pastaRaiz = "home/li0001/Projetos/Aceleração/";
  public static final String pastaProjeto = "acc-java-06-exercises-gerador-senhas/";
  public static final String pastaFinal = "src/main/java/com/trybe/acc/java/geradorsenhas/senhas/";
  public static final String DIRETORIO_DESTINO = "/" + pastaRaiz + pastaProjeto + pastaFinal;

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    GeradorSenhas gerador = new GeradorSenhas();

    for (int i = 0; i < NUM_SENHAS; i++) {

      File arquivo = new File(DIRETORIO_DESTINO + File.separator + "arquivo_" + i + ".txt");
      String senha = gerador.gerarSenhaCompleta(i);

      try {
        gerador.escreverSenhaNoArquivo(senha, arquivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /** Recebe uma senha e a escreve em arquivo. */
  public void escreverSenhaNoArquivo(String senha, File arquivo) throws IOException {
    FileWriter escreveArquivo = null;
    BufferedWriter bufferArquivo = null;
    
    try {
      escreveArquivo = new FileWriter(arquivo);
      bufferArquivo = new BufferedWriter(escreveArquivo);
      
      bufferArquivo.write(senha);
      bufferArquivo.flush();

    } finally {
      bufferArquivo.close();
      
    }   
  }

  /** Gera senha completa a partir do índice. */
  public String gerarSenhaCompleta(int indice) {
    String[] listaSenhas = {
        "A5$2", "B55S", "CFFG",
        "D&54", "EEDF", "FEGG",
        "G15E", "H123", "I81F",
        "JWEF", "####"
    };
    
    String senhaCriada = listaSenhas[indice] + listaSenhas[indice + 1];
    
    return senhaCriada;
  }
}
