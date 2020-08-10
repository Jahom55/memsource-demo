package com.memsource.demotestproject.projects;


import com.memsource.demotestproject.config.MemsourceConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemsourceDataService implements DataService {

    private final MemsourceConfig memsourceConfig;
    private final RestTemplate restTemplate;

    @Override
    public ProjectResponseDTO getProjects(TokenDTO token, int pageNumber) throws HttpClientErrorException {
        String restUrl = String.format(memsourceConfig.getBaseUrl() + memsourceConfig.getProjectsUrl(),
                token.getToken(), pageNumber);

        return restTemplate.getForObject(restUrl, ProjectResponseDTO.class);
    }

    @Override
    public TokenDTO getToken() throws HttpClientErrorException {
        HttpEntity<LoginDTO> request =
                new HttpEntity<>(
                        new LoginDTO(memsourceConfig.getLogin().getUsername(),
                                memsourceConfig.getLogin().getPassword()));

        return restTemplate
                .postForObject(memsourceConfig.getBaseUrl() + memsourceConfig.getLoginUrl(),
                        request,
                        TokenDTO.class);
    }
}
