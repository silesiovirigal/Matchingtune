package com.example.MatchingTune.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String palavrapass;

    @Column(nullable = true)
    private String musicstreaming;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPalavrapass() {
        return palavrapass;
    }

    public void setPalavrapass(String palavrapass) {
        this.palavrapass = palavrapass;
    }

    public String getMusicstreaming() {
        return musicstreaming;
    }

    public void setMusicstreaming(String musicstreaming) {
        this.musicstreaming = musicstreaming;
    }
}
