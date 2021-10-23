/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controle.Cliente;
import DAO.ClienteDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lino
 */
@ManagedBean
public class ClienteBeans {
    
    private Cliente cliente = new Cliente();
    private ClienteDAO clienteDAO = new ClienteDAO();
        
    public Cliente getCliente(){
        return cliente;
    }
    
    public void CadastroCliente(){
        
        try{
            this.clienteDAO.SalvaCliente(cliente);
            clienteDAO.TodosCliente();
            this.cliente = new Cliente();
            FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Dados Gravador com Sucesso"));
        }cath (Exception e){
            FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Dados do Pacientes"));
        }
    }
    
    
}
