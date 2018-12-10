package br.com.gabriel.projects.adventureworks.dao;

import br.com.gabriel.entities.Bicycle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil<T extends Bicycle> {

  private File arquivo;
  Class<? extends T> clazz;

  public FileUtil(Class<? extends T> clazz) {
    this.clazz = clazz;
    this.arquivo = new File(this.clazz.getSimpleName() + ".txt");
  }

  public void write(List<T> objs) {
    try {
      verificarIntegridade();

      FileOutputStream fos = new FileOutputStream(this.arquivo);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(objs);
      oos.flush();
      fos.flush();

      oos.close();
      fos.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<T> read() {
    List<T> objs = null;

    try {
      verificarIntegridade();

      if (isArquivoVazio()) {
        objs = new ArrayList<>();
      } else {
        FileInputStream fis = new FileInputStream(this.arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        objs = (List<T>) ois.readObject();
        ois.close();
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    return objs;
  }

  private void verificarIntegridade() throws IOException {
    if (!this.arquivo.exists()) {
      this.arquivo.createNewFile();
    }
  }

  private boolean isArquivoVazio() throws IOException {
    FileReader fr = new FileReader(this.arquivo);
    BufferedReader br = new BufferedReader(fr);

    String primeiraLina = br.readLine();

    br.close();
    fr.close();

    if (primeiraLina != null) {
      if (!primeiraLina.isEmpty()) {
        return false;
      }
    }
    return true;
  }
}
