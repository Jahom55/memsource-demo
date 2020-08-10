package com.memsource.demotestproject.projects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private Status status;
    private String sourceLang;
    private List<String> targetLangs;
}
