package org.nhnnext.security;

import lombok.extern.slf4j.Slf4j;
import org.nhnnext.domain.user.GitHubUser;
import org.nhnnext.domain.user.GitHubUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
public class GitHubResourceServerTokenServices implements ResourceServerTokenServices {
    @Autowired
    private GitHubUserRepository githubUserRepository;

    private final String userInfoEndpointUrl;
    private final String clientId;

    public GitHubResourceServerTokenServices(String userInfoEndpointUrl, String clientId) {
        this.userInfoEndpointUrl = userInfoEndpointUrl;
        this.clientId = clientId;
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) {
        GitHubUser user = githubUserRepository.findByAccessToken(accessToken);

        if (user == null) {
            user = createUser(accessToken);
        }

        return extractAuthentication(user);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }

    private GitHubUser createUser(String accessToken) {
        Map<String, Object> userInfo = getUserInfo(this.userInfoEndpointUrl, accessToken);

        if (userInfo.containsKey("error")) {
            throw new InvalidTokenException(accessToken);
        }

        GitHubUser user = new GitHubUser();
        user.setUsername(userInfo.get("login").toString());
        user.setName(userInfo.get("name").toString());
        user.setAccessToken(accessToken);
        githubUserRepository.save(user);

        return user;
    }

    private OAuth2Authentication extractAuthentication(GitHubUser user) {
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        OAuth2Request request = new OAuth2Request(null, this.clientId, null, true, null, null, null, null, null);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), "N/A", authorities);
        token.setDetails(user);
        return new OAuth2Authentication(request, token);
    }

    @SuppressWarnings({"unchecked"})
    private Map<String, Object> getUserInfo(String path, String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, HttpMethod.GET, entity, Map.class).getBody();
    }
}
