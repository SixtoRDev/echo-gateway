package com.sijareca.restgateway.echo.repos;

import com.sijareca.restgateway.echo.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByTokenIgnoreCase(String token);

}
