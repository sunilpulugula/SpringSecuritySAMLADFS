package com.geeksoverflow.security.saml.adfs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;

import com.geeksoverflow.security.saml.adfs.database.model.Role;
import com.geeksoverflow.security.saml.adfs.database.model.User;
import com.geeksoverflow.security.saml.adfs.model.LocalUser;


/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 17/12/17
 */
public class LocalSAMLUserDetailsService implements SAMLUserDetailsService {

    @Override
    public Object loadUserBySAML(final SAMLCredential credential) throws UsernameNotFoundException {
        /*User user = userDAO.get(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Given userId does not exist in repo");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = buildSimpleGrantedAuthorities(user);
        return new LocalUser(user.getUserId(), user.getName(), user.getName(), user.getPhoneno(),user.getActive() == 1 ? true : false, true
                , true, true, simpleGrantedAuthorities);*/

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        return new LocalUser(credential.getNameID().toString(),credential.getNameID().toString(),credential.getNameID().toString(),credential.getNameID().toString(),simpleGrantedAuthorities);
    }

    private List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final User user) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
            }
        }
        return simpleGrantedAuthorities;
    }

}
