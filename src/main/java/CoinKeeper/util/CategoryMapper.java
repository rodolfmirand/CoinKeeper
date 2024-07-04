package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import CoinKeeper.dto.request.CategoryRequest;
import CoinKeeper.dto.response.CategoryResponse;
import CoinKeeper.model.Category;

@Component
public class CategoryMapper {
    
    public Category toCategoryModel(CategoryRequest categoryRequest){
        return Category.builder()
                    .name(categoryRequest.getName())
                    .description(categoryRequest.getDescription())
                    .build();
    }

    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(category);
    }

    public List<CategoryResponse> toCategoryResponseList(List<Category> categoriesList) {
        return categoriesList.stream().map(CategoryResponse::new).collect(Collectors.toList());
    }
}
