package CoinKeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.CategoryRequest;
import CoinKeeper.dto.request.CategoryUpdateRequest;
import CoinKeeper.dto.request.IdRequest;
import CoinKeeper.dto.response.CategoryResponse;
import CoinKeeper.service.category.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coinkeeper/categories")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService service;

    @GetMapping("/findall")
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

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody IdRequest IDCategory) {
        return ResponseEntity.ok().body(service.deleteById(IDCategory.getId()));
    }
}
