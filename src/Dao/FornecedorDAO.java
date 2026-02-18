/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexão.Conexao;
import data.Fornecedor;
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
public class FornecedorDAO {
   public void adicionar(Fornecedor fornecedor) {

        String sql = "INSERT INTO fornecedor (nomeFornecedor, cnpj) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpj());
            

            stmt.executeUpdate();

            System.out.println("Fornecedor inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir fornecedor: " + e.getMessage());
        }
    }

    
    public List<Fornecedor> listar() {

        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("idFornecedor"));
                f.setNomeFornecedor(rs.getString("nomeFornecedor"));
                f.setCnpj(rs.getString("cnpj"));
               
                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar fornecedores: " + e.getMessage());
        }

        return lista;
    }

    
    public Fornecedor buscarPorId(int idFornecedor) {

        String sql = "SELECT * FROM fornecedor WHERE idFornecedor = ?";
        Fornecedor fornecedor = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nomeFornecedor"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecedor: " + e.getMessage());
        }

        return fornecedor;
    }

    
    public void atualizar(Fornecedor fornecedor) {

        String sql = "UPDATE fornecedor SET nomeFornecedor = ?, cnpj = ? WHERE idFornecedor = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setInt(3, fornecedor.getIdFornecedor());

            stmt.executeUpdate();

            System.out.println("Fornecedor atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar fornecedor: " + e.getMessage());
        }
    }

 
    public void remover(int idFornecedor) {

        String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);
            stmt.executeUpdate();

            System.out.println("Fornecedor removido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover fornecedor: " + e.getMessage());
        }
    }
}
