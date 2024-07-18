package com.eventostec.api.domain.aws;

import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "awsparams")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Params {

    @Id
    @GeneratedValue
    private UUID id;

    private String accesskeyid;
    private String secretkey;
}


