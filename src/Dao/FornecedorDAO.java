/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Fornecedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class FornecedorDAO {
    private static List<Fornecedor> listaFornecedores = new ArrayList<>();

    
    public void adicionar(Fornecedor fornecedor) {
        listaFornecedores.add(fornecedor);
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

 
    public boolean atualizar(Fornecedor fornecedorAtualizado) {
        for (int i = 0; i < listaFornecedores.size(); i++) {
            if (listaFornecedores.get(i).getIdFornecedor()
                    == fornecedorAtualizado.getIdFornecedor()) {

                listaFornecedores.set(i, fornecedorAtualizado);
                return true;
            }
        }
        return false;
    }

   
    public boolean remover(int idFornecedor) {
        return listaFornecedores.removeIf(
            f -> f.getIdFornecedor() == idFornecedor
        );
    } 
}
