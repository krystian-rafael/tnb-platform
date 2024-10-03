package com.ksprogramming.tnb.Data;

import java.time.LocalDateTime;

public class UserAuthorityData {
    private Long id;
    private UserData user;
    private String authority;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public UserAuthorityData() {
    }

    public UserAuthorityData(Long id, UserData user, String authority, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
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

    public UserData getUser() {
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

    public void setUser(UserData user) {
        this.user = user;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public static UserAuthorityDataBuilder builder(){
      return new UserAuthorityDataBuilder();
    }

    public static class UserAuthorityDataBuilder {
        private Long id;
        private UserData user;
        private String authority;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private LocalDateTime deleteDate;

        public UserAuthorityDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserAuthorityDataBuilder user(UserData user) {
            this.user = user;
            return this;
        }

        public UserAuthorityDataBuilder authority(String authority) {
            this.authority = authority;
            return this;
        }

        public UserAuthorityDataBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public UserAuthorityDataBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public UserAuthorityDataBuilder deleteDate(LocalDateTime deleteDate) {
            this.deleteDate = deleteDate;
            return this;
        }

        public UserAuthorityData build() {
            return new UserAuthorityData(id, user, authority, createDate, updateDate, deleteDate);
        }
    }
}
