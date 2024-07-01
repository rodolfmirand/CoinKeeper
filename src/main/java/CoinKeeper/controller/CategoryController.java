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

import CoinKeeper.dto.request.CategoryRequest;
import CoinKeeper.dto.request.CategoryUpdateRequest;
import CoinKeeper.dto.response.CategoryResponse;
import CoinKeeper.service.category.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coinkeeper/categorias")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<CategoryResponse> register(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok().body(service.register(categoryRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        return ResponseEntity.ok().body(service.update(categoryUpdateRequest, categoryUpdateRequest.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(service.deleteById(id));
    }
}
