package ge.shop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private HttpStatus status;

    private String message;

    public ResponseDto(HttpStatus status) {
        this.status = status;
    }


}
