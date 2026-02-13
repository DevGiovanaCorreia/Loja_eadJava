/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Fornecedor;
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
public class FornecedorDAO {
    private static List<Fornecedor> listaFornecedores = new ArrayList<>();
     private final String ARQUIVO = "fornecedores.dat";
     
     
public FornecedorDAO() {
        carregarArquivo();
    }


    
    public void adicionar(Fornecedor fornecedor) {
        listaFornecedores.add(fornecedor);
        salvarArquivo();
    }

   
    public List<Fornecedor> listar() {
        return listaFornecedores;
    }

    
    public Fornecedor buscarPorId(int idFornecedor) {
        for (Fornecedor f : listaFornecedores) {
            if (f.getIdFornecedor() == idFornecedor) {
                return f;
            }
        }
        return null;
    }

 
  public void atualizar(Fornecedor f) {
        for (int i = 0; i < listaFornecedores.size(); i++) {
            if (listaFornecedores.get(i).getIdFornecedor() == f.getIdFornecedor()) {
                listaFornecedores.set(i, f);
                break;
            }
        }
        salvarArquivo();
    }

    
   public void remover(int id) {
        listaFornecedores.removeIf(c -> c.getIdFornecedor() == id);
        salvarArquivo();
    }
    
    
  private void salvarArquivo() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {

            oos.writeObject(listaFornecedores);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarArquivo() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(ARQUIVO))) {

            listaFornecedores = (List<Fornecedor>) ois.readObject();

        } catch (Exception e) {
            listaFornecedores = new ArrayList<>();
        }
    }    
}
