/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Categoria;
import data.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ProdutoDAO {
    private static List<Produto> listaProdutos = new ArrayList<>();

 
    public void adicionar(Produto produto) {
        listaProdutos.add(produto);
    }

   
    public List<Produto> listar() {
        return listaProdutos;
    }

  
    public Produto buscarPorId(int idProduto) {
        for (Produto p : listaProdutos) {
            if (p.getIdProduto() == idProduto) {
                return p;
            }
        }
        return null;
    }

 
    public List<Produto> buscarPorCategoria(Categoria categoria) {
        List<Produto> resultado = new ArrayList<>();

        for (Produto p : listaProdutos) {
            if (p.getCategoria().equals(categoria)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

 
    public boolean atualizar(Produto produtoAtualizado) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getIdProduto()
                    == produtoAtualizado.getIdProduto()) {

                listaProdutos.set(i, produtoAtualizado);
                return true;
            }
        }
        return false;
    }

    
    public boolean remover(int idProduto) {
        return listaProdutos.removeIf(
            p -> p.getIdProduto() == idProduto
        );
    }

    
    public boolean atualizarEstoque(int idProduto, int novaQuantidade) {
        Produto p = buscarPorId(idProduto);
        if (p != null) {
            p.setQuantidadeEstoque(novaQuantidade);
            return true;
        }
        return false;
    }
}
