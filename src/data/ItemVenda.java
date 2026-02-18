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
public class ItemVenda  implements Serializable {
    private static final long serialVersionUID = 1L;
    
      private int idItem;
      private Produto produto;
      private int quantidade;
      private double preco_unitario;

    public ItemVenda(int idItem, Produto produto, int quantidade, double precoUnitario){
        this.idItem = idItem;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco_unitario = precoUnitario;
    }

    public int getIdItem() {
        return idItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return preco_unitario;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.preco_unitario = precoUnitario;
    }
  
 public double getSubtotal() {
    return quantidade * preco_unitario;
}
    
}
