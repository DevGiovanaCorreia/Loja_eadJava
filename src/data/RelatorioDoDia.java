/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author vitor
 */
public class RelatorioDoDia {
       private int idRelatorio;
      private Funcionario funcionario;
    

    public RelatorioDoDia(int idRelatorio, Funcionario funcionario) {
        this.idRelatorio = idRelatorio;
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
    
    

}
