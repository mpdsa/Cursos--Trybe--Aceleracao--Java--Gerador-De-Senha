package com.trybe.acc.java.geradorsenhas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** Classe que cria senha e escreve no arquivo cada senha gerada, na pasta /tmp/ . */
public class GeradorSenhas {
  public static final Integer NUM_SENHAS = 10;

  // TROQUE O CAMINHO PARA O DIRETORIO DE DESTINO DOS SEUS ARQUIVOS
  public static final String DIRETORIO_DESTINO = "/tmp/";

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
