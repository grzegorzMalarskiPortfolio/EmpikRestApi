package com.grzesiek.EmpikRestApi.service;

import com.grzesiek.EmpikRestApi.model.GitHubData;
import com.grzesiek.EmpikRestApi.model.RestGitHubData;
import com.grzesiek.EmpikRestApi.repository.GitHubDataRepository;
import org.springframework.stereotype.Service;

@Service
public class GitHubDataService {

    private final GitHubDataRepository gitHubDataRepository;

    public GitHubDataService(GitHubDataRepository gitHubDataRepository) {
        this.gitHubDataRepository = gitHubDataRepository;
    }

    public void save(GitHubData gitHubData) {
        GitHubData existingData = gitHubDataRepository.findByLogin(gitHubData.getLogin());
        if(existingData != null) {
            existingData.setRequestCount(existingData.getRequestCount() + 1);
            gitHubDataRepository.save(existingData);
        } else {
            gitHubDataRepository.save(gitHubData);
        }

    }
}
