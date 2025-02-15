package com.aashish.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UserRequest {

        @NonNull
    private String name;
    @Email(message="invalid email address")
    private String email;
    @NonNull
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank

    private String nationality;

}
