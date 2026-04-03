package co.practice.roth.springjwtpractice01.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @Schema(defaultValue = "roth@gmail.com")
    private String email;

    @Schema(defaultValue = "root")
    private String password;
}
