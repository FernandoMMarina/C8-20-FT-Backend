package com.c820ftjavareact.ecommerce.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="roles")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    //@GeneratedValue(generator = "system-uuid")
    private Long id;
    @NotNull
    private String name;
    @Column(nullable = true)
    private String description;
    @Column(name = "timestamps")
    @Temporal(TemporalType.DATE)
    private Date timestamps;

    public Role(String name, String description) {
        this.name=name;
        this.description=description;
    }
    public Role get() {
        return this;
    }

}
