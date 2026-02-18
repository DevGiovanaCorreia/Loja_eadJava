/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexão.Conexao;
import data.Categoria;
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
public class CategoriaDAO {
  public void adicionar(Categoria categoria) {

        String sql = "INSERT INTO categoria (nomeCategoria) VALUES (?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());

            stmt.executeUpdate();

            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    
    public List<Categoria> listar() {

        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNomeCategoria(rs.getString("nomeCategoria"));

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
        }

        return lista;
    }

    
    public Categoria buscarPorId(int idCategoria) {

        String sql = "SELECT * FROM categoria WHERE idCategoria = ?";
        Categoria categoria = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNomeCategoria(rs.getString("nomeCategoria"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar categoria: " + e.getMessage());
        }

        return categoria;
    }

    
    public Categoria buscarPorNome(String nome) {

        String sql = "SELECT * FROM categoria WHERE nomeCategoria = ?";
        Categoria categoria = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNomeCategoria(rs.getString("nomeCategoria"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar categoria por nome: " + e.getMessage());
        }

        return categoria;
    }

  
    public void atualizar(Categoria categoria) {

        String sql = "UPDATE categoria SET nomeCategoria = ? WHERE idCategoria = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getIdCategoria());

            stmt.executeUpdate();

            System.out.println("Categoria atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar categoria: " + e.getMessage());
        }
    }

   
    public void remover(int idCategoria) {

        String sql = "DELETE FROM categoria WHERE idCategoria = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCategoria);
            stmt.executeUpdate();

            System.out.println("Categoria removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover categoria: " + e.getMessage());
        }
    }
}
