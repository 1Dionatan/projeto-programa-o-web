package com.projeto.dionatan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "turmas")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String periodo;
    private String curso;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
