/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhenises
 */
@Entity
@Table(name = "vendas_itens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendasItens.findAll", query = "SELECT v FROM VendasItens v")
    , @NamedQuery(name = "VendasItens.findByIdVenda", query = "SELECT v FROM VendasItens v WHERE v.vendasItensPK.idVenda = :idVenda")
    , @NamedQuery(name = "VendasItens.findByIdProduto", query = "SELECT v FROM VendasItens v WHERE v.vendasItensPK.idProduto = :idProduto")
    , @NamedQuery(name = "VendasItens.findByQuantidade", query = "SELECT v FROM VendasItens v WHERE v.quantidade = :quantidade")})
public class VendasItens implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendasItensPK vendasItensPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "id_produto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "id_venda", referencedColumnName = "id_venda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendas_1 vendas;

    public VendasItens() {
    }

    public VendasItens(VendasItensPK vendasItensPK) {
        this.vendasItensPK = vendasItensPK;
    }

    public VendasItens(VendasItensPK vendasItensPK, int quantidade) {
        this.vendasItensPK = vendasItensPK;
        this.quantidade = quantidade;
    }

    public VendasItens(int idVenda, int idProduto) {
        this.vendasItensPK = new VendasItensPK(idVenda, idProduto);
    }

    public VendasItensPK getVendasItensPK() {
        return vendasItensPK;
    }

    public void setVendasItensPK(VendasItensPK vendasItensPK) {
        this.vendasItensPK = vendasItensPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vendas_1 getVendas() {
        return vendas;
    }

    public void setVendas(Vendas_1 vendas) {
        this.vendas = vendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendasItensPK != null ? vendasItensPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendasItens)) {
            return false;
        }
        VendasItens other = (VendasItens) object;
        if ((this.vendasItensPK == null && other.vendasItensPK != null) || (this.vendasItensPK != null && !this.vendasItensPK.equals(other.vendasItensPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.VendasItens[ vendasItensPK=" + vendasItensPK + " ]";
    }
    
}
