package br.com.zup.edu.nossaredesocial.perfil;

public class AtualizaPerfilRequest {

    private String nome;

    private String apelido;

    private String instituicaoDeEnsino;

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
