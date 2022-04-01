package br.com.zup.edu.nossaredesocial.perfil;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {
    Optional<Perfil> findByApelido(String apelido);
}
