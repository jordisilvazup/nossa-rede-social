package br.com.zup.edu.nossaredesocial.perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Perfil> findByApelido(String apelido);
}
