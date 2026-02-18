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
public class Produto implements Serializable {
     
    
    private int idProduto;
    private String nomeProduto;
    private double preco;
    private int quantidade;
    private Categoria categoria;
    private Fornecedor fornecedor;
    
    
    public Produto(int idProduto,String nomeProduto,double preco,int quantidadeEstoque, Categoria categoria, Fornecedor fornecedor){
        this.idProduto=idProduto;
        this.nomeProduto=nomeProduto;
        this.preco=preco;
        this.quantidade=quantidadeEstoque;
        this.categoria=categoria;
        this.fornecedor=fornecedor;
    } 

    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidade;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidade = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
  @Override
public String toString() {
    return nomeProduto;
}
  
    
}
