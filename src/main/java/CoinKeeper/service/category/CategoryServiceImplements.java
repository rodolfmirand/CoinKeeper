package CoinKeeper.service.category;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.CategoryRequest;
import CoinKeeper.dto.request.CategoryUpdateRequest;
import CoinKeeper.dto.response.CategoryResponse;
import CoinKeeper.model.Category;
import CoinKeeper.repository.CategoryRepository;
import CoinKeeper.util.CategoryMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplements implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse findById(UUID id) {
        return categoryMapper.toCategoryResponse(categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada do banco de dados.")));
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryMapper.toCategoryResponseList(categoryRepository.findAll());
    }

    @Override
    public CategoryResponse register(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategoryModel(categoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse update(CategoryUpdateRequest categoryUpdateRequest, UUID id) {
        Category category = findByIdAccount(id);

        if (categoryUpdateRequest.getName() != "")
            category.setName(categoryUpdateRequest.getName());

        if (categoryUpdateRequest.getDescription() != "")
            category.setDescription(categoryUpdateRequest.getDescription());

        categoryRepository.save(category);
        return new CategoryResponse(category);
    }

    @Override
    public String deleteById(UUID id) {
        categoryRepository.deleteById(id);
        return "Categoria de id (" + id + ") deletada.";
    }

    @Override
    public Category findByIdAccount(UUID id) {
        return categoryRepository.findById(id).get();
    }

}
