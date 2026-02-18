/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import data.RelatorioDoDia;
import Conexão.Conexao;
import data.Funcionario;
import java.sql.Statement;
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
public class RelatorioDoDIaDAO  {
       public void adicionar(RelatorioDoDia relatorio) {

        String sql = "INSERT INTO relatorioDoDia ( totalVendasDoDia, idFuncionario) " +
                     "VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            
            stmt.setDouble(1, relatorio.getTotalVendasDoDia());
            stmt.setInt(2, relatorio.getFuncionario().getIdFuncionario());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                relatorio.setIdRelatorio(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir relatório: " + e.getMessage());
        }
    }

  
    public List<RelatorioDoDia> listar() {

        List<RelatorioDoDia> lista = new ArrayList<>();

        String sql = "SELECT r.*, f.nomeFuncionario " +
                     "FROM relatorioDoDia r " +
                     "JOIN funcionario f ON r.idFuncionario = f.idFuncionario";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));

                RelatorioDoDia r = new RelatorioDoDia();
                r.setIdRelatorio(rs.getInt("idRelatorio"));
                r.setTotalVendasDoDia(rs.getDouble("totalVendasDoDia"));
                r.setFuncionario(funcionario);

                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar relatórios: " + e.getMessage());
        }

        return lista;
    }

   
    public RelatorioDoDia buscarPorId(int idRelatorio) {

        String sql = "SELECT * FROM relatorioDoDia WHERE idRelatorio = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRelatorio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                RelatorioDoDia r = new RelatorioDoDia();
                r.setIdRelatorio(rs.getInt("idRelatorio"));
                r.setTotalVendasDoDia(rs.getDouble("totalVendas"));
                return r;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar relatório: " + e.getMessage());
        }

        return null;
    }

   
    public void remover(int idRelatorio) {

        String sql = "DELETE FROM relatorioDoDia WHERE idRelatorio = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRelatorio);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao remover relatório: " + e.getMessage());
        }
    }
}
