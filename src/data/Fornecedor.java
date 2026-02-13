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
public class Fornecedor  implements Serializable{
     private int idFornecedor;
    private String nomeFornecedor;
    private String cnpj;
   
    
    public Fornecedor(int idFornecedor,String nomeFornecedor,String cnpj){
        this.idFornecedor=idFornecedor;
        this.nomeFornecedor=nomeFornecedor;
        this.cnpj=cnpj;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
   @Override
public String toString() {
    return nomeFornecedor;
}
 
    
}
