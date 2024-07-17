package com.eventostec.api.domain.coupon;

import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id // indica que representa o campo PK
    @GeneratedValue // indica que vai ser gerado automaticamente pela tabela
    private UUID id;

    private Integer discount;
    private String codigo;
    private Date validade;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}