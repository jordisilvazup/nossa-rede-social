package br.com.zup.edu.nossaredesocial.perfil;

import javax.validation.constraints.NotBlank;

public class AtualizaPerfilRequest {
    @NotBlank
    private String nome;

    @NotBlank
    private String apelido;

    @NotBlank
    private String instituicaoDeEnsino;

    @NotBlank
    private String enderecoImagem;

    public AtualizaPerfilRequest(String nome, String apelido, String instituicaoDeEnsino, String enderecoImagem) {
        this.nome = nome;
        this.apelido = apelido;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.enderecoImagem = enderecoImagem;
    }

    public AtualizaPerfilRequest() {
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
