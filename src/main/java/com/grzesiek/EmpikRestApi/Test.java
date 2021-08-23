package com.grzesiek.EmpikRestApi;

public class Test {

    public static void main(String[] args) {
        String response = "{\"login\":\"grzesiek154\",\"id\":35150964,\"node_id\":\"MDQ6VXNlcjM1MTUwOTY0\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/35150964?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/grzesiek154\",\"html_url\":\"https://github.com/grzesiek154\",\"followers_url\":\"https://api.github.com/users/grzesiek154/followers\",\"following_url\":\"https://api.github.com/users/grzesiek154/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/grzesiek154/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/grzesiek154/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/grzesiek154/subscriptions\",\"organizations_url\":\"https://api.github.com/users/grzesiek154/orgs\",\"repos_url\":\"https://api.github.com/users/grzesiek154/repos\",\"events_url\":\"https://api.github.com/users/grzesiek154/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/grzesiek154/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":null,\"company\":null,\"blog\":\"\",\"location\":null,\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":17,\"public_gists\":0,\"followers\":0,\"following\":4,\"created_at\":\"2018-01-05T20:45:35Z\",\"updated_at\":\"2021-08-04T10:34:27Z\"}";
        System.out.println(response.replace("{", ""));
        System.out.println(response.split(":"));
    }
}
