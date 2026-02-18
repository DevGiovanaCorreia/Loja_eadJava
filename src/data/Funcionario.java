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
public class Funcionario  implements Serializable
{
    private int idFuncionario;
    private String nomeFuncionario;
    private String cpf;
    
    
     public Funcionario(int idFuncionario,String nomeFuncionario,String cpf){
    this.idFuncionario=idFuncionario;
    this.nomeFuncionario=nomeFuncionario;
    this.cpf=cpf;
    
}
     
     public Funcionario(){
         
     }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
     
  @Override
public String toString() {
    return nomeFuncionario;
}
   
     
}
