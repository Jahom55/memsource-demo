package com.memsource.demotestproject.projects;

import org.springframework.web.client.HttpClientErrorException;

public interface DataService {
    ProjectResponseDTO getProjects(TokenDTO token, int pageNumber) throws HttpClientErrorException;

    TokenDTO getToken() throws HttpClientErrorException;
}
