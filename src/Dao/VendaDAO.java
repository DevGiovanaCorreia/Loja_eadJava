/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Cliente;
import data.Funcionario;
import data.Venda;
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
public class VendaDAO {
     private static List<Venda> listaVendas = new ArrayList<>();
private final String ARQUIVO = "vendas.dat";



  public VendaDAO() {
        carregarArquivo();
    }
  
    public void adicionar(Venda venda) {
        listaVendas.add(venda);
        salvarArquivo();
    }

  
    public List<Venda> listar() {
        return listaVendas;
    }

 
    public Venda buscarPorId(int idVenda) {
        for (Venda v : listaVendas) {
            if (v.getIdVenda() == idVenda) {
                return v;
            }
        }
        return null;
    }


    public List<Venda> buscarPorCliente(Cliente cliente) {
        List<Venda> resultado = new ArrayList<>();

        for (Venda v : listaVendas) {
            if (v.getCliente().getIdCliente() == cliente.getIdCliente()) {
                resultado.add(v);
            }
        }
        return resultado;
    }

   
    public List<Venda> buscarPorFuncionario(Funcionario funcionario) {
        List<Venda> resultado = new ArrayList<>();

        for (Venda v : listaVendas) {
            if (v.getFuncionario().getIdFuncionario()
                    == funcionario.getIdFuncionario()) {

                resultado.add(v);
            }
        }
        return resultado;
    }

   
      public void atualizar(Venda v) {
        for (int i = 0; i < listaVendas.size(); i++) {
            if (listaVendas.get(i).getIdVenda() == v.getIdVenda()) {
                listaVendas.set(i, v);
                break;
            }
        }
        salvarArquivo();
    }

    
   public void remover(int id) {
        listaVendas.removeIf(c -> c.getIdVenda() == id);
        salvarArquivo();
    }
    
    
    
     private void salvarArquivo() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {

            oos.writeObject(listaVendas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarArquivo() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(ARQUIVO))) {

            listaVendas = (List<Venda>) ois.readObject();

        } catch (Exception e) {
            listaVendas = new ArrayList<>();
        }
    }
}
