package com.mycompany.trabalho_final.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhenises
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id")
    , @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco")
    , @NamedQuery(name = "Produto.findByFoto", query = "SELECT p FROM Produto p WHERE p.foto = :foto")
    , @NamedQuery(name = "Produto.findByTamanho", query = "SELECT p FROM Produto p WHERE p.tamanho = :tamanho")})
public class Produto implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
    private com.mycompany.trabalho_final.DAO.ProdutoTamanho produtoTamanho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<com.mycompany.trabalho_final.DAO.VendasItens> vendasItensCollection;

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<VendasItens> vendasItensCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
    private ProdutoTamanho produtoTamanho;
*/
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    @Size(max = 2147483647)
    @Column(name = "foto")
    private String foto;
    @Column(name = "tamanho")
    private Character tamanho;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Character getTamanho() {
        return tamanho;
    }

    public void setTamanho(Character tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabalho_final.model.Produto[ id=" + id + " ]";
    }

  /*  public ProdutoTamanho getProdutoTamanho() {
        return produtoTamanho;
    }

    public void setProdutoTamanho(ProdutoTamanho produtoTamanho) {
        this.produtoTamanho = produtoTamanho;
    }

    @XmlTransient
    public Collection<VendasItens> getVendasItensCollection() {
        return vendasItensCollection;
    }

    public void setVendasItensCollection(Collection<VendasItens> vendasItensCollection) {
        this.vendasItensCollection = vendasItensCollection;
    }

    public com.mycompany.trabalho_final.DAO.ProdutoTamanho getProdutoTamanho() {
        return produtoTamanho;
    }

    public void setProdutoTamanho(com.mycompany.trabalho_final.DAO.ProdutoTamanho produtoTamanho) {
        this.produtoTamanho = produtoTamanho;
    }

    @XmlTransient
    public Collection<com.mycompany.trabalho_final.DAO.VendasItens> getVendasItensCollection() {
        return vendasItensCollection;
    }

    public void setVendasItensCollection(Collection<com.mycompany.trabalho_final.DAO.VendasItens> vendasItensCollection) {
        this.vendasItensCollection = vendasItensCollection;
    }
   */ 
}
