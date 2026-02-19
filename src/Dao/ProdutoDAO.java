/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexão.Conexao;
import data.Categoria;
import data.Fornecedor;
import data.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ProdutoDAO {
       public void adicionar(Produto produto) {

        String sql = "INSERT INTO produtos (nomeProduto, preco, quantidade, idCategoria, idFornecedor) VALUES (?, ?, ?, ?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getIdCategoria());
            stmt.setInt(5,produto.getFornecedor().getIdFornecedor());

            stmt.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT p.*, c.produtoCategoria, f.nomeFornecedor " +
             "FROM produtos p " +
             "JOIN categoria c ON p.idCategoria = c.idCategoria " +
             "JOIN fornecedor f ON p.idFornecedor = f.idFornecedor";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setProdutoCategoria(rs.getString("produtoCategoria"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nomeFornecedor"));
                
                
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProdutos"));
                p.setNomeProduto(rs.getString("nomeProduto"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoria(categoria);
                p.setFornecedor(fornecedor);

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }

    
    public Produto buscarPorId(int idProdutos) {

        String sql = "SELECT * FROM produtos WHERE idProdutos = ?";
        Produto produto = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProdutos);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idProdutos"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }

        return produto;
    }

    
    public void atualizar(Produto produto) {

        String sql = "UPDATE produtos SET nomeProduto = ?, preco = ?, quantidade = ?, idCategoria = ? , idFornecedor = ? WHERE idProdutos = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getIdCategoria());
            stmt.setInt(5,produto.getFornecedor().getIdFornecedor());
            stmt.setInt(6, produto.getIdProduto());

            stmt.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    
    public void remover(int idProdutos) {

        String sql = "DELETE FROM produtos WHERE idProdutos = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProdutos);
            stmt.executeUpdate();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    
    public void atualizarEstoque(int idProduto, int novaQuantidade) {

        String sql = "UPDATE produtos SET quantidade = ? WHERE idProdutos = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, idProduto);

            stmt.executeUpdate();

            System.out.println("Estoque atualizado!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
        }
    }
}
