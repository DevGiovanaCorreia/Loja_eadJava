/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.ItemVenda;
import data.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ItemVendaDAO {
    private static List<ItemVenda> listaItens = new ArrayList<>();

  
    public void adicionar(ItemVenda item) {
        listaItens.add(item);
    }

    
    public List<ItemVenda> listar() {
        return listaItens;
    }

  
    public ItemVenda buscarPorId(int idItem) {
        for (ItemVenda item : listaItens) {
            if (item.getIdItem() == idItem) {
                return item;
            }
        }
        return null;
    }

    
    public List<ItemVenda> buscarPorProduto(Produto produto) {
        List<ItemVenda> resultado = new ArrayList<>();

        for (ItemVenda item : listaItens) {
            if (item.getProduto().getIdProduto() == produto.getIdProduto()) {
                resultado.add(item);
            }
        }
        return resultado;
    }

 
    public boolean atualizar(ItemVenda itemAtualizado) {
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getIdItem()
                    == itemAtualizado.getIdItem()) {

                listaItens.set(i, itemAtualizado);
                return true;
            }
        }
        return false;
    }

    
    public boolean remover(int idItem) {
        return listaItens.removeIf(
            item -> item.getIdItem() == idItem
        );
    }

    
    public double calcularSubtotal(ItemVenda item) {
        return item.getQuantidade() * item.getPrecoUnitario();
    }
}
