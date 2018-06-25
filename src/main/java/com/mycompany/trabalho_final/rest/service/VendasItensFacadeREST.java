/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.DAO.service;

import com.mycompany.trabalho_final.DAO.VendasItens;
import com.mycompany.trabalho_final.DAO.VendasItensPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Jhenises
 */
@Stateless
@Path("com.mycompany.trabalho_final.dao.vendasitens")
public class VendasItensFacadeREST extends AbstractFacade<VendasItens> {

    @PersistenceContext(unitName = "com.mycompany_trabalho_final_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private VendasItensPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idVenda=idVendaValue;idProduto=idProdutoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.mycompany.trabalho_final.DAO.VendasItensPK key = new com.mycompany.trabalho_final.DAO.VendasItensPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idVenda = map.get("idVenda");
        if (idVenda != null && !idVenda.isEmpty()) {
            key.setIdVenda(new java.lang.Integer(idVenda.get(0)));
        }
        java.util.List<String> idProduto = map.get("idProduto");
        if (idProduto != null && !idProduto.isEmpty()) {
            key.setIdProduto(new java.lang.Integer(idProduto.get(0)));
        }
        return key;
    }

    public VendasItensFacadeREST() {
        super(VendasItens.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(VendasItens entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, VendasItens entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.mycompany.trabalho_final.DAO.VendasItensPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VendasItens find(@PathParam("id") PathSegment id) {
        com.mycompany.trabalho_final.DAO.VendasItensPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VendasItens> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VendasItens> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
