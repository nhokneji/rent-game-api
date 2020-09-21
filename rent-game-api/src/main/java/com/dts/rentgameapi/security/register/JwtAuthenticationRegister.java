package com.dts.rentgameapi.security.register;

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
public class JwtAuthenticationRegister extends AbstractAuthenticationToken {
    private JwtUserDetails jwtUserDetails;
    private String password;
    private String email;
    private String phone;
    private String display_name;

    public JwtAuthenticationRegister(String username, String password, String email, String phone, String display_name) {
        super(null);
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.display_name = display_name;
        JwtGenerator jwtGenerator = new JwtGenerator();
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername(username);
        jwtUser.setPassword(password);
        String token = jwtGenerator.generate(jwtUser);
        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRoles());
        jwtUserDetails = new JwtUserDetails(jwtUser.getUsername(),
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

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDisplay_name() {
        return display_name;
    }
}
