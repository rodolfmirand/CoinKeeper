package CoinKeeper.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import CoinKeeper.service.CategoriaService;
import dto.request.CategoriaRequestDTO;
import dto.response.CategoriaResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/categorias")
@RequiredArgsConstructor
public class CategoriasController {
    
    private final CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> register(@RequestBody CategoriaRequestDTO categoriaRequestDTO, UriComponentsBuilder uriBuilder) {
        CategoriaResponseDTO categoriaResponseDTO = service.register(categoriaRequestDTO);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoriaResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(categoriaResponseDTO);
    }
}
