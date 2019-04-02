package com.shq.validate.vo;

import com.shq.validate.annotation.ShqValidate;
import com.shq.validate.helper.ValidateHelper;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author sunhuaquan
 * @Title: UserVo
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3110:12
 */
public class UserVo2 {

    @NotNull(message = "用户名必须输入")
    private String username;

    @Length(min = 1,max = 20,message = "password必须长度为8-20")
    private String password;

    private String mobile;

    private Integer sex;

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
