/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author vitor
 */
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private double preco;
    private int quantidadeEstoque;
    private Categoria categoria;
    
    
    public Produto(int idProduto,String nomeProduto,double preco,int quantidadeEstoque, Categoria categoria){
        this.idProduto=idProduto;
        this.nomeProduto=nomeProduto;
        this.preco=preco;
        this.quantidadeEstoque=quantidadeEstoque;
        this.categoria=categoria;
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
        return quantidadeEstoque;
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
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}
