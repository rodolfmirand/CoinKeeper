package CoinKeeper.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.UpdateLimiteRequestDTO;
import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.ContaResponseDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;
import CoinKeeper.service.conta.ContaService;
import CoinKeeper.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/coinkeeper/users")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private final UsuarioService service;

    @Autowired
    private final ContaService contaService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody UsuarioRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(service.register(userRequestDTO));
    }

    @PostMapping("/conta/limite")
    public ResponseEntity<ContaResponseDTO> updateLimiteConta(@RequestBody UpdateLimiteRequestDTO limiteRequest){
        return ResponseEntity.ok().body(contaService.uptadeLimite(limiteRequest.getId_conta(), limiteRequest.getValor()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO userDTO,
            @PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(service.update(userDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(service.deleteById(id));
    }
}
