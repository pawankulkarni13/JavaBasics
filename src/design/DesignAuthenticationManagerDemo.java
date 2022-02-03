package design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * There is an authentication system that works with authentication tokens.
 * For each session, the user will receive a new authentication token that will expire timeToLive seconds after the currentTime.
 * If the token is renewed, the expiry time will be extended to expire timeToLive seconds after the (potentially different) currentTime.
 *
 * Implement the AuthenticationManager class:
 *
 * AuthenticationManager(int timeToLive) constructs the AuthenticationManager and sets the timeToLive.
 * generate(string tokenId, int currentTime) generates a new token with the given tokenId at the given currentTime in seconds.
 * renew(string tokenId, int currentTime) renews the unexpired token with the given tokenId at the given currentTime in seconds.
 * If there are no unexpired tokens with the given tokenId, the request is ignored, and nothing happens.
 * countUnexpiredTokens(int currentTime) returns the number of unexpired tokens at the given currentTime.
 * Note that if a token expires at time t, and another action happens on time t (renew or countUnexpiredTokens),
 * the expiration takes place before the other actions.
 *
 */
public class DesignAuthenticationManagerDemo {
    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
        authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
        System.out.println("UnExpiredTokens "+authenticationManager.countUnexpiredTokens(6)); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
        authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
        authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
        authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
        System.out.println("UnExpiredTokens "+ authenticationManager.countUnexpiredTokens(15)); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
    }
}

class AuthenticationManager {

    private int timeToLive;
    private Map<String, Integer> map = new LinkedHashMap<String, Integer>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        System.out.println("Generating Token " + tokenId +" at "+ currentTime);
        map.keySet().removeIf(key ->
            map.get(key) <= currentTime
        );

        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        map.keySet().removeIf(key ->
                map.get(key) <= currentTime
        );

        if(map.get(tokenId) != null) {
            map.remove(tokenId);
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        map.keySet().removeIf(key ->
                map.get(key) <= currentTime
        );

        return map.size();
    }
}