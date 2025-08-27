package com.sijareca.restgateway.echo.service;

import com.sijareca.restgateway.echo.domain.Consulta;
import com.sijareca.restgateway.echo.model.ConsultaDTO;
import com.sijareca.restgateway.echo.repos.ConsultaRepository;
import com.sijareca.restgateway.echo.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(final ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<ConsultaDTO> findAll() {
        final List<Consulta> consultas = consultaRepository.findAll(Sort.by("id"));
        return consultas.stream()
                .map(consulta -> mapToDTO(consulta, new ConsultaDTO()))
                .toList();
    }

    public ConsultaDTO get(final Long id) {
        return consultaRepository.findById(id)
                .map(consulta -> mapToDTO(consulta, new ConsultaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ConsultaDTO consultaDTO) {
        final Consulta consulta = new Consulta();
        mapToEntity(consultaDTO, consulta);
        return consultaRepository.save(consulta).getId();
    }

    public void update(final Long id, final ConsultaDTO consultaDTO) {
        final Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(consultaDTO, consulta);
        consultaRepository.save(consulta);
    }

    public void delete(final Long id) {
        final Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        consultaRepository.delete(consulta);
    }

    private ConsultaDTO mapToDTO(final Consulta consulta, final ConsultaDTO consultaDTO) {
        consultaDTO.setId(consulta.getId());
        consultaDTO.setTimestamp(consulta.getTimestamp());
        consultaDTO.setToken(consulta.getToken());
        consultaDTO.setOrigen(consulta.getOrigen());
        consultaDTO.setMensaje(consulta.getMensaje());
        consultaDTO.setRespuesta(consulta.getRespuesta());
        return consultaDTO;
    }

    private Consulta mapToEntity(final ConsultaDTO consultaDTO, final Consulta consulta) {
        consulta.setTimestamp(consultaDTO.getTimestamp());
        consulta.setToken(consultaDTO.getToken());
        consulta.setOrigen(consultaDTO.getOrigen());
        consulta.setMensaje(consultaDTO.getMensaje());
        consulta.setRespuesta(consultaDTO.getRespuesta());
        return consulta;
    }

    public boolean tokenExists(final String token) {
        return consultaRepository.existsByTokenIgnoreCase(token);
    }

}
