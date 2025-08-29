package com.projeto.dionatan.service;

import com.projeto.dionatan.dto.TurmaDto;
import com.projeto.dionatan.entity.TurmaEntity;
import com.projeto.dionatan.exception.TurmaBadRequestException;
import com.projeto.dionatan.exception.TurmaNotFoundException;
import com.projeto.dionatan.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    private TurmaDto convertToDto(TurmaEntity e) {
        TurmaDto dto = new TurmaDto();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setPeriodo(e.getPeriodo());
        dto.setCurso(e.getCurso());
        return dto;
    }

    private TurmaEntity convertToEntity(TurmaDto d) {
        TurmaEntity e = new TurmaEntity();
        e.setNome(d.getNome());
        e.setPeriodo(d.getPeriodo());
        e.setCurso(d.getCurso());
        return e;
    }

    @Override
    public TurmaDto criar(TurmaDto dto) {
        if(dto.getNome() == null || dto.getNome().isBlank()){
            throw new TurmaBadRequestException("Nome é obrigatório");
        }
        TurmaEntity turmaSalva = turmaRepository.save(convertToEntity(dto));
        return convertToDto(turmaSalva);
    }

    @Override
    public TurmaDto buscarPorId(Long id) {
        TurmaEntity t = turmaRepository.findById(id)
                .orElseThrow(() -> new TurmaNotFoundException("Turma não encontrada"));
        return convertToDto(t);
    }

    @Override
    public List<TurmaDto> buscarTodas() {
        List<TurmaEntity> turmas = turmaRepository.findAll();
        if(turmas.isEmpty())
            throw new TurmaNotFoundException("Nenhuma turma cadastrada");
        return turmas.stream().map(this::convertToDto).toList();
    }

    @Override
    public TurmaDto buscarPorNome(String nome) {
        TurmaEntity t = turmaRepository.findByNome(nome)
                .orElseThrow(() -> new TurmaNotFoundException("Nenhuma turma com nome informado"));
        return convertToDto(t);
    }

    @Override
    public List<TurmaDto> buscarPorPeriodo(String periodo) {
        var lista = turmaRepository.findByPeriodo(periodo);
        if(lista.isEmpty())
            throw new TurmaNotFoundException("Nenhuma turma nesse período");
        return lista.stream().map(this::convertToDto).toList();
    }

    @Override
    public List<TurmaDto> buscarPorCurso(String curso) {
        var lista = turmaRepository.findByCurso(curso);
        if(lista.isEmpty())
            throw new TurmaNotFoundException("Nenhuma turma nesse curso");
        return lista.stream().map(this::convertToDto).toList();
    }

    @Override
    public void deletar(Long id) {
        if(!turmaRepository.existsById(id))
            throw new TurmaNotFoundException("Id não encontrado");
        turmaRepository.deleteById(id);
    }
}
