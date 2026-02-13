/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Categoria;
import data.Produto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ProdutoDAO {
    private static List<Produto> listaProdutos = new ArrayList<>();
private final String ARQUIVO = "produtos.dat";


public ProdutoDAO(){
    carregarArquivo();
}
 
    public void adicionar(Produto produto) {
        listaProdutos.add(produto);
        salvarArquivo();
    }
    
    public void atualizar(Produto p) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getIdProduto() == p.getIdProduto()) {
                listaProdutos.set(i, p);
                break;
            }
        }
        salvarArquivo();
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

 
    

    
   public void remover(int id) {
        listaProdutos.removeIf(p -> p.getIdProduto() == id);
        salvarArquivo();
    }

    
    public boolean atualizarEstoque(int idProduto, int novaQuantidade) {
        Produto p = buscarPorId(idProduto);
        if (p != null) {
            p.setQuantidadeEstoque(novaQuantidade);
            return true;
        }
        return false;
    }
    
    
    private void salvarArquivo() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(
                     new FileOutputStream(ARQUIVO))) {

            oos.writeObject(listaProdutos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     private void carregarArquivo() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(
                     new FileInputStream(ARQUIVO))) {

            listaProdutos =
                (List<Produto>) ois.readObject();

        } catch (Exception e) {
            listaProdutos = new ArrayList<>();
        }
    }
}
