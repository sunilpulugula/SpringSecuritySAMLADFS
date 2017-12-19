package com.geeksoverflow.security.saml.adfs.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 10/5/17
 */
public class LocalUser extends User {

    private String userId;

    private String phoneNo;

    public LocalUser(final String userId, final String username, final String password, final String phoneNo, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.phoneNo = phoneNo;
        this.userId = userId;
    }

    public LocalUser(final String userId, final String username, final String password, final String phoneNo, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.phoneNo = phoneNo;
        this.userId = userId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getUserId() {
        return userId;
    }
}
