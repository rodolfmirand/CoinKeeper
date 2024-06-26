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

import CoinKeeper.dto.request.CategoriaRequestDTO;
import CoinKeeper.dto.request.CategoriaUpdateRequestDTO;
import CoinKeeper.dto.response.CategoriaResponseDTO;
import CoinKeeper.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coinkeeper/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    @Autowired
    private final CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<CategoriaResponseDTO> register(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return ResponseEntity.ok().body(service.register(categoriaRequestDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoriaResponseDTO> update(@RequestBody CategoriaUpdateRequestDTO categoriaUpdate) {
        return ResponseEntity.ok().body(service.update(categoriaUpdate, categoriaUpdate.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(service.deleteById(id));
    }
}
