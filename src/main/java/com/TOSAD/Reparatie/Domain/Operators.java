package com.TOSAD.Reparatie.Domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "operators")
@EntityListeners(AuditingEntityListener.class)
public class Operators {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "inverted")
    private int inverted;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInverted() {
        return inverted;
    }

    public void setInverted(int inverted) {
        this.inverted = inverted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
