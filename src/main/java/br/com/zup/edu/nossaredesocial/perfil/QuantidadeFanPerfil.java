package br.com.zup.edu.nossaredesocial.perfil;

import javax.persistence.*;

@Entity
public class QuantidadeFanPerfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantidade;

    @Version
    private int version;

    @OneToOne
    private Perfil perfil;

    public QuantidadeFanPerfil(Perfil perfil) {
        this.perfil = perfil;
        this.quantidade=0;
    }

    /**
     * @deprecated construtor é de uso exclusivo do Hibernate
     */
    @Deprecated
    public QuantidadeFanPerfil() {
    }

    public void incrementa(){
        this.quantidade++;
    }
}
