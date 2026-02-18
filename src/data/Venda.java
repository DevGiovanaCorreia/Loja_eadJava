/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Venda implements Serializable {
       private int idVenda;
    private String formaDePagamento;
    private Funcionario funcionario;
    private Cliente cliente;
    private List<ItemVenda> itens;
    
    
     public Venda(int idVenda, String formaDePagamento, Funcionario funcionario, Cliente cliente,List<ItemVenda> itens) {
        this.idVenda = idVenda;
        this.formaDePagamento = formaDePagamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.itens=itens;
    }

     public Venda(){
         
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

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
     
     
    
    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }
    
 public double getTotal() {
    double total = 0;

    for (ItemVenda item : itens) {
        total += item.getSubtotal();
    }

    return total;
}
    
}
