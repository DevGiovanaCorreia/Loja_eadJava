/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Funcionario;
import data.RelatorioDoDia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class RelatorioDoDIa {
      private static List<RelatorioDoDia> listaRelatorios = new ArrayList<>();

  
    public void adicionar(RelatorioDoDia relatorio) {
        listaRelatorios.add(relatorio);
    }

    
    public List<RelatorioDoDia> listar() {
        return listaRelatorios;
    }

  
    public RelatorioDoDia buscarPorId(int idRelatorio) {
        for (RelatorioDoDia r : listaRelatorios) {
            if (r.getIdRelatorio() == idRelatorio) {
                return r;
            }
        }
        return null;
    }

   
    public List<RelatorioDoDia> buscarPorFuncionario(Funcionario funcionario) {
        List<RelatorioDoDia> resultado = new ArrayList<>();

        for (RelatorioDoDia r : listaRelatorios) {
            if (r.getFuncionario().getIdFuncionario()
                    == funcionario.getIdFuncionario()) {

                resultado.add(r);
            }
        }
        return resultado;
    }

    
    public boolean atualizar(RelatorioDoDia relatorioAtualizado) {
        for (int i = 0; i < listaRelatorios.size(); i++) {
            if (listaRelatorios.get(i).getIdRelatorio()
                    == relatorioAtualizado.getIdRelatorio()) {

                listaRelatorios.set(i, relatorioAtualizado);
                return true;
            }
        }
        return false;
    }

    
    public boolean remover(int idRelatorio) {
        return listaRelatorios.removeIf(
            r -> r.getIdRelatorio() == idRelatorio
        );
    }
}
