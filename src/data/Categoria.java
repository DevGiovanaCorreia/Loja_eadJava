/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author vitor
 */
public class Categoria {
      private int idCategoria;
    private String nomeCategoria;
   
    
    public Categoria(int idCategoria,String nomeCategoria){
        this.idCategoria=idCategoria;
        this.nomeCategoria=nomeCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


     @Override
public String toString() {
    return nomeCategoria;
}
}
