package br.com.zup.edu.nossaredesocial.perfil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AtualizaPerfilController {
    private final PerfilRepository repository;

    public AtualizaPerfilController(PerfilRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/perfils/{apelido}")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizaPerfilRequest request, @PathVariable String apelido){

        Perfil perfil = repository.findByApelido(apelido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao existe cadastro de perfil para este apelido"));

        perfil.atualiza(request.getNome(), request.getApelido(), request.getInstituicaoDeEnsino(), request.getEnderecoImagem());

        repository.save(perfil);

        return ResponseEntity.noContent().build();

    }
}
