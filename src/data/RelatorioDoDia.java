/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;

/**
 *
 * @author vitor
 */
public class RelatorioDoDia implements Serializable{
       private int idRelatorio;
       private String totalVendasDoDia;
      private Funcionario funcionario;
      
    

    public RelatorioDoDia(int idRelatorio,String  totalVendasDoDia, Funcionario funcionario) {
        this.idRelatorio = idRelatorio;
        this.totalVendasDoDia=totalVendasDoDia;
        this.funcionario = funcionario;
    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getTotalVendasDoDia() {
        return totalVendasDoDia;
    }

    public void setTotalVendasDoDia(String totalVendasDoDia) {
        this.totalVendasDoDia = totalVendasDoDia;
    }
    
    
    
    

}
