/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ClienteDAO {
    private static List<Cliente> listaClientes = new ArrayList<>();

  
    public void adicionar(Cliente cliente) {
        listaClientes.add(cliente);
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

    
    public boolean atualizar(Cliente clienteAtualizado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdCliente() == clienteAtualizado.getIdCliente()) {
                listaClientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }

    
    public boolean remover(int idCliente) {
        return listaClientes.removeIf(c -> c.getIdCliente() == idCliente);
    }
}
