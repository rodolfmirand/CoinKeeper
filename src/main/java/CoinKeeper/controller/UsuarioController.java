package CoinKeeper.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import CoinKeeper.service.UsuarioService;
import dto.request.UsuarioRequestDTO;
import dto.response.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody UsuarioRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(service.register(userRequestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO userDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.update(userDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }
}
