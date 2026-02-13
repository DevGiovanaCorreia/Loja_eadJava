/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Cliente;
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
public class ClienteDAO {
    private static List<Cliente> listaClientes = new ArrayList<>();
  private final String ARQUIVO = "clientes.dat";
  
  
    public ClienteDAO() {
        carregarArquivo();
    }
  
    public void adicionar(Cliente cliente) {
        listaClientes.add(cliente);
        salvarArquivo();
    }

    
    public List<Cliente> listar() {
        return listaClientes;
    }

    
    public Cliente buscarPorId(int idCliente) {
        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                return c;
            }
        }
        return null;
    }

      public void atualizar(Cliente c) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdCliente() == c.getIdCliente()) {
                listaClientes.set(i, c);
                break;
            }
        }
        salvarArquivo();
    }

    
   public void remover(int id) {
        listaClientes.removeIf(c -> c.getIdCliente() == id);
        salvarArquivo();
    }
   

   private void salvarArquivo() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {

            oos.writeObject(listaClientes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    private void carregarArquivo() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(ARQUIVO))) {

            listaClientes = (List<Cliente>) ois.readObject();

        } catch (Exception e) {
            listaClientes = new ArrayList<>();
        }
    }
   
   
}
