/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;

/**
 *
 * @author vitor
 */
public class Categoria implements Serializable {
      private int idCategoria;
    private String produtoCategoria;
   
    
    public Categoria(int idCategoria,String produtoCategoria){
        this.idCategoria=idCategoria;
        this.produtoCategoria=produtoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return produtoCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.produtoCategoria = nomeCategoria;
    }


     @Override
public String toString() {
    return produtoCategoria;
}
}
