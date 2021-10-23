/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controle.Produto;
import DAO.ProdutoDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author lino
 */
@ManagedBean
public class ProdutoBeans {
    
    private Produto produto = new Produto();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
        
    public Produto getProduto(){
        return produto;
    }
    
    public void CadastroProduto(){
        
        try{
            this.produtoDAO.SalvaProduto(produto);
            produtoDAO.TodosProduto();
            this.produto = new Produto();
            FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Dados Gravador com Sucesso"));
        }cath (Exception e){
            FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Dados do Vendedor"));
        }
    }
    
    
}
