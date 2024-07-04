package CoinKeeper.service.category;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.CategoryRequest;
import CoinKeeper.dto.request.CategoryUpdateRequest;
import CoinKeeper.dto.response.CategoryResponse;
import CoinKeeper.model.Category;

public interface CategoryService {

    CategoryResponse findById(UUID id);

    Category findByIdAccount(UUID id);

    List<CategoryResponse> findAll();

    CategoryResponse register(CategoryRequest category);

    CategoryResponse update(CategoryUpdateRequest category, UUID id);

    String deleteById(UUID id);
    
}
