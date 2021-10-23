/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controle.Vendedor;
import DAO.VendedorDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author lino
 */
@ManagedBean
public class VendedorBeans {
    
    private Vendedor vendedor = new Vendedor();
    private VendedorDAO vendedorDAO = new VendedorDAO();
        
    public Vendedor getVendedor(){
        return vendedor;
    }
    
    public void CadastroVendedor(){
        
        try{
            this.vendedorDAO.SalvaVendedor(vendedor);
            vendedorDAO.TodosVendedor();
            this.vendedor = new Vendedor();
            FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Dados Gravador com Sucesso"));
        }cath (Exception e){
            FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Dados do Vendedor"));
        }
    }
    
    
}
