/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import data.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class CategoriaDAO {
    private static List<Categoria> listaCategorias = new ArrayList<>();

    
    public void adicionar(Categoria categoria) {
        listaCategorias.add(categoria);
    }

 
    public List<Categoria> listar() {
        return listaCategorias;
    }

    
    public Categoria buscarPorId(int idCategoria) {
        for (Categoria c : listaCategorias) {
            if (c.getIdCategoria() == idCategoria) {
                return c;
            }
        }
        return null;
    }

   
    public Categoria buscarPorNome(String nome) {
        for (Categoria c : listaCategorias) {
            if (c.getNomeCategoria().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    
    public boolean atualizar(Categoria categoriaAtualizada) {
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).getIdCategoria()
                    == categoriaAtualizada.getIdCategoria()) {

                listaCategorias.set(i, categoriaAtualizada);
                return true;
            }
        }
        return false;
    }

 
    public boolean remover(int idCategoria) {
        return listaCategorias.removeIf(
            c -> c.getIdCategoria() == idCategoria
        );
    }
}
