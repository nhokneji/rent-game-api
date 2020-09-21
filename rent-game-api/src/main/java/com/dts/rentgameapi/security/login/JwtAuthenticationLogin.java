package com.dts.rentgameapi.security.login;

import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.security.jwt.JwtUserDetails;
import com.dts.rentgameapi.security.JwtGenerator;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

/**
 * @author Rin-DTS
 */
public class JwtAuthenticationLogin extends AbstractAuthenticationToken {
    private JwtUserDetails jwtUserDetails;
    private String password;

    public JwtAuthenticationLogin(String username, String password) {
        super(null);
        this.password = password;
        JwtGenerator jwtGenerator = new JwtGenerator();
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername(username);
        jwtUser.setPassword(password);
        String token = jwtGenerator.generate(jwtUser);
        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRoles());

        jwtUserDetails = new JwtUserDetails(
                jwtUser.getUsername(),
                jwtUser.getPassword(),
                token,
                authorities
        );
    }


    @Override
    public String getCredentials() {
        return password;
    }

    @Override
    public JwtUserDetails getPrincipal() {
        return jwtUserDetails;
    }
}
