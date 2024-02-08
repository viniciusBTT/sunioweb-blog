package br.com.blog.sunioweb.util;

public enum EnumRoleUser {
    ADMIN("admin"),
    USER("user");

    private String role;

    EnumRoleUser(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
