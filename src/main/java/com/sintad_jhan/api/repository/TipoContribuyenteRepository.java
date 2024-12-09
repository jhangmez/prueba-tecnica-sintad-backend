package com.sintad_jhan.api.repository;

import com.sintad_jhan.api.model.TipoContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {
}
