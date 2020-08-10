package com.memsource.demotestproject.projects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectService {

    private final DataService dataService;

    /**
     * Method return projects for demanding page, no explicit order
     *
     * @param pageNumber number which page to show
     * @return ProjectResponseDTO -> list of projects and total elements
     * @throws HttpClientErrorException throws if is anything wrong with REST, network ...
     */
    public ProjectResponseDTO getProject(int pageNumber) throws HttpClientErrorException {
        TokenDTO token = dataService.getToken();
        return dataService.getProjects(token, pageNumber);
    }

}
