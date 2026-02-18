/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexão.Conexao;
import data.Cliente;
import data.Funcionario;
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

        String sql = "INSERT INTO venda (formaDePagamento, idCliente, idFuncionario) " +
                     "VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1,venda.getFormaDePagamento());
            stmt.setInt(2, venda.getCliente().getIdCliente());
            stmt.setInt(3, venda.getFuncionario().getIdFuncionario());
            

            stmt.executeUpdate();

            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                venda.setIdVenda(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir venda: " + e.getMessage());
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
    
}
