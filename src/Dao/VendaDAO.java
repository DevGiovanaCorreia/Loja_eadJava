/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexão.Conexao;
import data.Cliente;
import data.Funcionario;
import data.ItemVenda;
import data.Produto;
import java.sql.Statement;


import data.Venda;
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
public class VendaDAO {
    public void adicionar(Venda venda) {

    String sql = "INSERT INTO venda (formaDePagamento, idCliente, idFuncionario) VALUES (?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, venda.getFormaDePagamento());
        stmt.setInt(2, venda.getCliente().getIdCliente());
        stmt.setInt(3, venda.getFuncionario().getIdFuncionario());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            venda.setIdVenda(rs.getInt(1));
        }

        
        for (ItemVenda item : venda.getItens()) {

            String sqlItem = "INSERT INTO item_venda (idVenda, idProdutos, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";

            try (PreparedStatement stmtItem = conn.prepareStatement(sqlItem)) {

                stmtItem.setInt(1, venda.getIdVenda());
                stmtItem.setInt(2, item.getProduto().getIdProduto());
                stmtItem.setInt(3, item.getQuantidade());
                stmtItem.setDouble(4, item.getPrecoUnitario());

                stmtItem.executeUpdate();
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

   
    public List<Venda> listar() {

        List<Venda> lista = new ArrayList<>();

        String sql = "SELECT v.*, c.nomeCliente, f.nomeFuncionario " +
                     "FROM venda v " +
                     "JOIN cliente c ON v.idCliente = c.idCliente " +
                     "JOIN funcionario f ON v.idFuncionario = f.idFuncionario";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));

                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));

                Venda v = new Venda();
                v.setIdVenda(rs.getInt("idVenda"));
                v.setCliente(cliente);
                v.setFuncionario(funcionario);
                

                lista.add(v);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }

        return lista;
    }

    
    public Venda buscarPorId(int idVenda) {

        String sql = "SELECT * FROM venda WHERE idVenda = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("idVenda"));
               
                return v;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar venda: " + e.getMessage());
        }

        return null;
    }
    
    
    public List<Venda> buscarPorFuncionario(Funcionario funcionario) {

    List<Venda> lista = new ArrayList<>();

    String sql = "SELECT v.*, c.nomeCliente, f.nomeFuncionario " +
                 "FROM venda v " +
                 "JOIN cliente c ON v.idCliente = c.idCliente " +
                 "JOIN funcionario f ON v.idFuncionario = f.idFuncionario " +
                 "WHERE v.idFuncionario = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, funcionario.getIdFuncionario());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setNomeCliente(rs.getString("nomeCliente"));

            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNomeFuncionario(rs.getString("nomeFuncionario"));

           Venda v = new Venda();
           v.setIdVenda(rs.getInt("idVenda"));
           v.setFormaDePagamento(rs.getString("formaDePagamento"));
           v.setCliente(cliente);
           v.setFuncionario(f);
            
           
           v.setItens(buscarItensPorVenda(v.getIdVenda()));

         lista.add(v);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar vendas por funcionário: " + e.getMessage());
    }

    return lista;
}

    
    public void remover(int idVenda) {

        String sql = "DELETE FROM venda WHERE idVenda = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao remover venda: " + e.getMessage());
        }
    }
    
    private List<ItemVenda> buscarItensPorVenda(int idVenda) {

    List<ItemVenda> lista = new ArrayList<>();

    String sql = "SELECT iv.*, p.nomeProduto " +
                 "FROM item_venda iv " +
                 "JOIN produtos p ON iv.idProdutos = p.idProdutos " +
                 "WHERE iv.idVenda = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idVenda);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idProdutos"));
            produto.setNomeProduto(rs.getString("nomeProduto"));

            ItemVenda item = new ItemVenda(
                    rs.getInt("idItem"),
                    produto,
                    rs.getInt("quantidade"),
                    rs.getDouble("preco_unitario")
            );

            lista.add(item);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
    
}
