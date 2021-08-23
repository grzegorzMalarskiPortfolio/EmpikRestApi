package com.grzesiek.EmpikRestApi.repository;

import com.grzesiek.EmpikRestApi.model.GitHubData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubDataRepository extends CrudRepository<GitHubData, Integer> {
    GitHubData findByLogin(String login);
}
