package com.memsource.demotestproject.projects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectResponseDTO {
    private int totalElements;
    private List<ProjectDTO> content;

    private static final ProjectResponseDTO empty = new ProjectResponseDTO(0, Collections.emptyList());

    public static ProjectResponseDTO empty(){
        return empty;
    }
}
