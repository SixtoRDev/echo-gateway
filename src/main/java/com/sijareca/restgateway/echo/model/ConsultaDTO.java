package com.sijareca.restgateway.echo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ConsultaDTO {

    private Long id;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    @Size(max = 1024)
    @ConsultaTokenUnique
    private String token;

    @NotNull
    @Size(max = 255)
    private String origen;

    private String mensaje;

    private String respuesta;

}
