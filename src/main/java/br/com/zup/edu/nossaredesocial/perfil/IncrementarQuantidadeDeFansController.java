package br.com.zup.edu.nossaredesocial.perfil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class IncrementarQuantidadeDeFansController {
    private final PerfilRepository repository;

    public IncrementarQuantidadeDeFansController(PerfilRepository repository) {
        this.repository = repository;
    }

    @PatchMapping("/perfils/{apelido}/serfan")
    public ResponseEntity<?> atualizar(@PathVariable String apelido){
        Perfil perfil = repository.findByApelido(apelido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao existe cadastro de perfil para este apelido"));

        perfil.incrementaFan();

        repository.save(perfil);

        return ResponseEntity.noContent().build();
    }
}
