/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;



/**
 *
 * @author vitor
 */
public class Cliente {
     private int idCliente;
    private String nomeCliente;
    private String cpf;
    private String endereco;
    private String telefone;
    
    
    public Cliente(int idCliente,String nomeCliente,String cpf,String endereco,String telefone){
        this.idCliente=idCliente;
        this.nomeCliente=nomeCliente;
        this.cpf=cpf;
        this.endereco=endereco;
        this.telefone=telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
  @Override
public String toString() {
    return nomeCliente;
}

}
