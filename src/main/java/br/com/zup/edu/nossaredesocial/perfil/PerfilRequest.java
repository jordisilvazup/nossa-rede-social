package br.com.zup.edu.nossaredesocial.perfil;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class PerfilRequest {
    @NotBlank
    private String nome;

    @NotBlank
    @Length(max = 10)
    private String apelido;

    @NotBlank
    private String instituicaoDeEnsino;

    @NotBlank
    private String enderecoImagem;


    public PerfilRequest(String nome, String apelido, String instituicaoDeEnsino, String enderecoImagem) {
        this.nome = nome;
        this.apelido = apelido;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.enderecoImagem = enderecoImagem;
    }

    public PerfilRequest() {
    }

    public Perfil paraPerfil(){
        return new Perfil(nome,apelido,instituicaoDeEnsino,enderecoImagem);
    }
    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }

    public String getEnderecoImagem() {
        return enderecoImagem;
    }
}
