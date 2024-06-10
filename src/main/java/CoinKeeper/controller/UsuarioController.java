package CoinKeeper.controller;

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

import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;
import CoinKeeper.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    
    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody UsuarioRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(service.register(userRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO userDTO,
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.update(userDTO, id));
    }
}
