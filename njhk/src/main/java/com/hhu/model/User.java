package com.hhu.model;

public class User {
    private String id;
    private String username;
    private String userpasswd;
    private int authority;
    private String roleid;
    private String tag;
    private String companycode;
    private String isopenging;

    public String getUserpasswd() {
        return userpasswd;
    }

    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getIsopenging() {
        return isopenging;
    }

    public void setIsopenging(String isopenging) {
        this.isopenging = isopenging;
    }
}
