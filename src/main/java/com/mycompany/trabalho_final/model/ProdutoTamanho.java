/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhenises
 */
@Entity
@Table(name = "produto_tamanho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoTamanho.findAll", query = "SELECT p FROM ProdutoTamanho p")
    , @NamedQuery(name = "ProdutoTamanho.findByIdProduto", query = "SELECT p FROM ProdutoTamanho p WHERE p.idProduto = :idProduto")
    , @NamedQuery(name = "ProdutoTamanho.findByTamannho", query = "SELECT p FROM ProdutoTamanho p WHERE p.tamannho = :tamannho")
    , @NamedQuery(name = "ProdutoTamanho.findByQuantidade", query = "SELECT p FROM ProdutoTamanho p WHERE p.quantidade = :quantidade")})
public class ProdutoTamanho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamannho")
    private Character tamannho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "id_produto", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produto produto;

    public ProdutoTamanho() {
    }

    public ProdutoTamanho(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public ProdutoTamanho(Integer idProduto, Character tamannho, int quantidade) {
        this.idProduto = idProduto;
        this.tamannho = tamannho;
        this.quantidade = quantidade;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Character getTamannho() {
        return tamannho;
    }

    public void setTamannho(Character tamannho) {
        this.tamannho = tamannho;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoTamanho)) {
            return false;
        }
        ProdutoTamanho other = (ProdutoTamanho) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.ProdutoTamanho[ idProduto=" + idProduto + " ]";
    }
    
}
