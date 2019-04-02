package com.shq.validate.vo;

import com.shq.validate.annotation.ShqValidate;
import com.shq.validate.helper.ValidateHelper;

/**
 * @author sunhuaquan
 * @Title: UserVo
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3110:12
 */
public class UserVo {

    @ShqValidate(require = true)
    private String username;

    @ShqValidate(require = true, minLength = 8, maxLength = 20)
    private String password;

    @ShqValidate(require = true, regex = ValidateHelper.REGEX_MOBILE)
    private String mobile;

    private Integer sex;

    @ShqValidate(require = true, regex = ValidateHelper.REGEX_EMAIL)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
