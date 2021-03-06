package br.com.zup.edu.nossaredesocial.perfil;

import javax.persistence.*;

import static br.com.zup.edu.nossaredesocial.perfil.Status.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String apelido;

    private String instituicaoDeEnsino;

    private String enderecoImagem;

    private long quantidadeFans;

    @Enumerated(EnumType.STRING)
    private Status status= PADRAO;

    public Perfil(String nome, String apelido, String instituicaoDeEnsino, String enderecoImagem) {
        this.nome = nome;
        this.apelido=apelido;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.enderecoImagem = enderecoImagem;
        this.quantidadeFans=0;
    }

    /**
     * @deprecated construtor para uso exclusivo do hibernate
     */
    @Deprecated
    public Perfil() {
    }

    public Long getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }


    public void atualizar(String nome, String apelido, String instituicaoDeEnsino, String enderecoImagem){
        this.nome = nome;
        this.apelido=apelido;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.enderecoImagem = enderecoImagem;
    }
}
