package com.mycompany.trabalho_final.DAO;
import java.util.List;
import javax.persistence.Query;
import com.mycompany.trabalho_final.model.Cliente;


/**
 *
 * @author Jhenises
 */
public class ClienteDao {

/**
 *
 * @author Jhenises
 */
public class ModeloDAO extends Dao {
    
    
    public List<Cliente> listar(){        
        Query q = em.createQuery("SELECT m FROM Cliente m ORDER BY m.Nome");
        return q.getResultList();
    }
    
    public List<Cliente> getModelo(String id) {
        Query q = em.createQuery("SELECT m FROM Cliente m where id = "+id);
        return  q.getResultList();
    }

}
}
