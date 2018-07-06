package com.anyi.pojo;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data()
@Entity
@Getter
@Table(name = "core_order")
public class Order implements Serializable {
    @Column()
    @Id
    private String id;
    @Column()
    private String appid;
    @Column()
    private String product_id;
    @Column()
    private String request;
    @Column(name = "order_amount")
    private  Integer orderAmount;

}
