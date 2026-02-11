/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class FuncionarioDAO {
 
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    
    public void adicionar(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    
    public List<Funcionario> listar() {
        return listaFuncionarios;
    }

    
    public Funcionario buscarPorId(int idFuncionario) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getIdFuncionario() == idFuncionario) {
                return f;
            }
        }
        return null;
    }

    
    public boolean atualizar(Funcionario funcionarioAtualizado) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getIdFuncionario()
                    == funcionarioAtualizado.getIdFuncionario()) {

                listaFuncionarios.set(i, funcionarioAtualizado);
                return true;
            }
        }
        return false;
    }

  
    public boolean remover(int idFuncionario) {
        return listaFuncionarios.removeIf(
            f -> f.getIdFuncionario() == idFuncionario
        );
    }
}
