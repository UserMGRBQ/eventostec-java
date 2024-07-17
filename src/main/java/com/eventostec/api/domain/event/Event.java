package com.eventostec.api.domain.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "event")
@Getter // lombok ajuda a criar os getters
@Setter // lombok ajuda a criar os setters
@NoArgsConstructor // lombok ajuda a criar um construtor sem argumento
@AllArgsConstructor // lombok ajuda a criar um construtor com todos argumentos
public class Event {

    @Id
    @GeneratedValue // indica que o valor é gerado automatico pela tabela
    private UUID id;

    private String title;
    private String description;
    private String imgurl;
    private String eventurl;
    private Boolean remote;
    private Date date;
}
