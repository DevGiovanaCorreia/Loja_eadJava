/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author vitor
 */
public class Venda {
       private int idVenda;
    private String formaDePagamento;
    private Funcionario funcionario;
    private Cliente cliente;
    
    
     public Venda(int idVenda, String formaDePagamento, Funcionario funcionario, Cliente cliente) {
        this.idVenda = idVenda;
        this.formaDePagamento = formaDePagamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
     
     
     
}
