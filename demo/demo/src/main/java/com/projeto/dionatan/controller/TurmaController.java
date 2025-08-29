package com.projeto.dionatan.controller;

import com.projeto.dionatan.dto.TurmaDto;
import com.projeto.dionatan.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaDto criar(@RequestBody TurmaDto dto){
        return turmaService.criar(dto);
    }

    @GetMapping("/{id}")
    public TurmaDto buscarPorId(@PathVariable Long id){
        return turmaService.buscarPorId(id);
    }

    @GetMapping
    public List<TurmaDto> buscarTodas(){
        return turmaService.buscarTodas();
    }

    @GetMapping("/nome/{nome}")
    public TurmaDto buscarPorNome(@PathVariable String nome){
        return turmaService.buscarPorNome(nome);
    }

    @GetMapping("/periodo/{periodo}")
    public List<TurmaDto> buscarPorPeriodo(@PathVariable String periodo){
        return turmaService.buscarPorPeriodo(periodo);
    }

    @GetMapping("/curso/{curso}")
    public List<TurmaDto> buscarPorCurso(@PathVariable String curso){
        return turmaService.buscarPorCurso(curso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        turmaService.deletar(id);
    }
}
