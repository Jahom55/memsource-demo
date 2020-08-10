package com.memsource.demotestproject.setup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserSetupDTO {
    private Long id;
    private String username;
    private String password;
}
