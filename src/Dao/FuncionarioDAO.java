/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Funcionario;
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
public class FuncionarioDAO {
 
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();
private final String ARQUIVO = "funcionarios.dat"; 

 public FuncionarioDAO() {
        carregarArquivo();
    }
    
    public void adicionar(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
        salvarArquivo();
    }

    
    public List<Funcionario> listar() {
        return listaFuncionarios;
    }

    
    public Funcionario buscarPorId(int idFuncionario) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getIdFuncionario() == idFuncionario) {
                return f;
            }
        }
        return null;
    }

    
     public void atualizar(Funcionario f) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getIdFuncionario() == f.getIdFuncionario()) {
                listaFuncionarios.set(i, f);
                break;
            }
        }
        salvarArquivo();
    }

    
   public void remover(int id) {
        listaFuncionarios.removeIf(c -> c.getIdFuncionario() == id);
        salvarArquivo();
    }
    
    
    private void salvarArquivo() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {

            oos.writeObject(listaFuncionarios);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarArquivo() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(ARQUIVO))) {

            listaFuncionarios = (List<Funcionario>) ois.readObject();

        } catch (Exception e) {
            listaFuncionarios = new ArrayList<>();
        }
    }
}
