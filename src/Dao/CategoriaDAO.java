/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Categoria;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class CategoriaDAO {
    private static List<Categoria> listaCategorias = new ArrayList<>();
  private final String ARQUIVO = "categorias.dat";
  
  
  public CategoriaDAO(){
      carregarArquivo();
  }
    
   
 public void adicionar(Categoria c) {
        listaCategorias.add(c);
        salvarArquivo();
    }
 
    public List<Categoria> listar() {
        return listaCategorias;
    }

    
    public Categoria buscarPorId(int idCategoria) {
        for (Categoria c : listaCategorias) {
            if (c.getIdCategoria() == idCategoria) {
                return c;
            }
        }
        return null;
    }

   
    public Categoria buscarPorNome(String nome) {
        for (Categoria c : listaCategorias) {
            if (c.getNomeCategoria().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    
   public void atualizar(Categoria c) {
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).getIdCategoria() == c.getIdCategoria()) {
                listaCategorias.set(i, c);
                break;
            }
        }
        salvarArquivo();
    }

 
    public void remover(int id) {
        listaCategorias.removeIf(c -> c.getIdCategoria() == id);
        salvarArquivo();
    }
    
     private void salvarArquivo() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(
                     new FileOutputStream(ARQUIVO))) {

            oos.writeObject(listaCategorias);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private void carregarArquivo() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(
                     new FileInputStream(ARQUIVO))) {

            listaCategorias =
                (List<Categoria>) ois.readObject();

        } catch (Exception e) {
            listaCategorias = new ArrayList<>();
        }
    }
}
