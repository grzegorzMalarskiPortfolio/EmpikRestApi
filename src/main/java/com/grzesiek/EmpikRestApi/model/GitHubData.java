package com.grzesiek.EmpikRestApi.model;

import javax.persistence.*;

@Entity
@Table(name = "git_data")
public class GitHubData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="LOGIN")
    private String login;
    @Column(name="REQUEST_COUNT")
    private int requestCount = 0;

    public GitHubData(String login, int requestCount) {
        this.login = login;
        this.requestCount += requestCount;
    }

    public GitHubData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }
}
