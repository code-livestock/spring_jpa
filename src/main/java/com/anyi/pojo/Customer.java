package com.anyi.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 50)
    private String id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 25)
    private String phone;
    @Column(length = 15)
    private String email;
    @Column(name = "card_type", length = 10)
    private String cardType;
    @Column(name = "card_id", length = 50)
    private String cardId;
    @Column()
    private int age;
    @Column(length = 2)
    private char sex;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(length = 100)
    private String address;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    private  String addressId;



}
