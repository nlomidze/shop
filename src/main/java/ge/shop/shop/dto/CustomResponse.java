package ge.shop.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomResponse {

    private String message;

    public CustomResponse(String message) {
        this.message = message;
    }
}
