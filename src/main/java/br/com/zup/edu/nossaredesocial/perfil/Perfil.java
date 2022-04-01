package br.com.zup.edu.nossaredesocial.perfil;

import javax.persistence.*;

import static br.com.zup.edu.nossaredesocial.perfil.Status.PADRAO;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String apelido;

    private String instituicaoDeEnsino;

    private String enderecoImagem;

    @OneToOne(mappedBy = "perfil", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private QuantidadeFanPerfil quantidadeFans;

    @Version
    private int versao;

    @Enumerated(EnumType.STRING)
    private Status status= PADRAO;

    public Perfil(String nome, String apelido, String instituicaoDeEnsino, String enderecoImagem) {
        this.nome = nome;
        this.apelido=apelido;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.enderecoImagem = enderecoImagem;
        this.quantidadeFans= new QuantidadeFanPerfil(this);
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

    public void atualiza(String nome, String apelido, String instituicaoDeEnsino, String enderecoImagem) {
        this.nome = nome;
        this.apelido=apelido;
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.enderecoImagem = enderecoImagem;
    }

    public void incrementaFan() {
        this.quantidadeFans.incrementa();
    }
}
