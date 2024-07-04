package CoinKeeper.dto.request;

import java.util.UUID;

import lombok.Getter;

@Getter
public class CategoryUpdateRequest {

    private UUID id;

    private String name;

    private String description;
}
