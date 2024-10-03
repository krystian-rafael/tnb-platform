package com.ksprogramming.tnb.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String authority;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public UserAuthority() {
    }

    public UserAuthority(Long id, User user, String authority, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
        this.id = id;
        this.user = user;
        this.authority = authority;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getAuthority() {
        return authority;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public static UserAuthorityBuilder builder(){
        return new UserAuthorityBuilder();
    }
    public static class UserAuthorityBuilder {
        private Long id;
        private User user;
        private String authority;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public UserAuthorityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserAuthorityBuilder user(User user) {
            this.user = user;
            return this;
        }

        public UserAuthorityBuilder authority(String authority) {
            this.authority = authority;
            return this;
        }

        public UserAuthorityBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public UserAuthorityBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public UserAuthorityBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }

        public UserAuthority build() {
            return new UserAuthority(id, user, authority, createDate, updateDate, deleteDate);
        }
    }
}
