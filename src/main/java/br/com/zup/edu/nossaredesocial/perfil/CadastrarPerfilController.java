package br.com.zup.edu.nossaredesocial.perfil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarPerfilController {
    private final PerfilRepository repository;

    public CadastrarPerfilController(PerfilRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/perfils")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PerfilRequest request, UriComponentsBuilder uriComponentsBuilder){

        Perfil perfil = request.paraPerfil();

        repository.save(perfil);

        URI location = uriComponentsBuilder.path("/perfils/{apelido}")
                .buildAndExpand(perfil.getApelido())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
