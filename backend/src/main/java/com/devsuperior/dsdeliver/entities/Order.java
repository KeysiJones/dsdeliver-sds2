package com.devsuperior.dsdeliver.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
//Nome da tabela no banco
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //Botao autoincrementa pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    //Set é usado para que não seja repetido o mesmo produto em um pedido. Set cria no banco a tabela de relação muitos para muitos corretamente.
    //Coleção de produtos porque uma Order ou seja um pedido tem muitos produtos.
    @ManyToMany //relação muitos para muitos
    @JoinTable(name = "tb_order_product", 
        joinColumns = @JoinColumn(name = "order_id"),//Chave estrangeira que referencia a classe que eu estou
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Order() {

    }

    public Order(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        super();
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public String getAddress() {
        return this.address;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}