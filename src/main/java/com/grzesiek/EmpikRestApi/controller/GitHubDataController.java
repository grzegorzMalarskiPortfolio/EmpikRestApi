package com.grzesiek.EmpikRestApi.controller;

import com.grzesiek.EmpikRestApi.model.GitHubData;
import com.grzesiek.EmpikRestApi.model.RestGitHubData;
import com.grzesiek.EmpikRestApi.repository.GitHubDataRepository;

import com.grzesiek.EmpikRestApi.service.GitHubDataService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping(GitHubDataController.BASE_URL)
public class GitHubDataController {

    public static final String BASE_URL = "/api/gitData/";
    private final GitHubDataService gitHubDataService;
    private final WebClient.Builder webClientBuilder;

    public GitHubDataController(GitHubDataService gitHubDataService, WebClient.Builder webClientBuilder) {
        this.gitHubDataService = gitHubDataService;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping({"/{userName}"})
    public ResponseEntity<RestGitHubData> getGitHubData(@PathVariable("userName") String userName) {

        String response = webClientBuilder
                .baseUrl("https://api.github.com/users/" + userName).build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class).block();

        RestGitHubData restGitHubData = adjustResponseData(response);
        gitHubDataService.save(new GitHubData(restGitHubData.getLogin(),1));

        return new ResponseEntity<>(restGitHubData, HttpStatus.OK);
    }

    private RestGitHubData adjustResponseData(String response) {

        JSONObject jsonObject;
        RestGitHubData restGitHubData = new RestGitHubData();
        Integer followers;
        Integer publicRepos;

        try {
            jsonObject = new JSONObject(response);
            if(jsonObject != null) {
                restGitHubData.setId(Long.valueOf(jsonObject.getString("id")));
                restGitHubData.setLogin(jsonObject.getString("login"));
                restGitHubData.setName(jsonObject.getString("name"));
                restGitHubData.setType(jsonObject.getString("type"));
                restGitHubData.setAvatarUrl(jsonObject.getString("avatar_url"));
                restGitHubData.setCreatedAt(jsonObject.getString("created_at"));
                followers = (Integer.valueOf(jsonObject.getString("followers")) > 0 ? Integer.valueOf(jsonObject.getString("followers")) : 1);
                publicRepos = Integer.valueOf(jsonObject.getString("public_repos"));
                restGitHubData.setCalculations(6 / followers * (2 + publicRepos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restGitHubData;
    }
}
