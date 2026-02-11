/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Cliente;
import data.Funcionario;
import data.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class VendaDAO {
     private static List<Venda> listaVendas = new ArrayList<>();

  
    public void adicionar(Venda venda) {
        listaVendas.add(venda);
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

   
    public boolean atualizar(Venda vendaAtualizada) {
        for (int i = 0; i < listaVendas.size(); i++) {
            if (listaVendas.get(i).getIdVenda()
                    == vendaAtualizada.getIdVenda()) {

                listaVendas.set(i, vendaAtualizada);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int idVenda) {
        return listaVendas.removeIf(
            v -> v.getIdVenda() == idVenda
        );
    }
}
