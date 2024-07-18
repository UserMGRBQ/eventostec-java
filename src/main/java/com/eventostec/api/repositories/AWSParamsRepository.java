package com.eventostec.api.repositories;

import com.eventostec.api.domain.aws.Params;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AWSParamsRepository extends JpaRepository<Params, UUID> {
}
