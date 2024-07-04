package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {
    
    private UUID id;

    private String name;

    private String description;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
    }

}
