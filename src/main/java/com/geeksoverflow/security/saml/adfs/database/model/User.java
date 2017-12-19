package com.geeksoverflow.security.saml.adfs.database.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author <a href="mailto:psunil1278@gmail.com">Sunil Kumar</a>
 * @since 25/12/15
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID", nullable = true, length = 128)
    private String userId;

    @Column(name = "NAME", nullable = true, length = 32)
    private String name;

    @Column(name = "PROVIDER", nullable = true, length = 32)
    private String provider;

    @Column(name = "PHONE_NO", nullable = true, length = 20)
    private String phoneno;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private Integer active;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(final String userId, final String name, final String phoneno, final Integer active, final String provider, final Set<Role> roles) {
        this.userId = userId;
        this.name = name;
        this.active = active;
        this.phoneno = phoneno;
        this.provider = provider;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(final String phoneno) {
        this.phoneno = phoneno;
    }
}
