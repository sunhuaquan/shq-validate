package com.shq.validate.controller;

import com.shq.validate.vo.ResultJson;
import com.shq.validate.vo.UserVo;
import com.shq.validate.vo.UserVo2;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author sunhuaquan
 * @Title: UserController
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3110:05
 */
@RestController
@RequestMapping("/")
public class UserController {

    @RequestMapping("/user/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/user/register1")
    public ResultJson<UserVo> register1(@RequestBody UserVo userVo) {
        if (StringUtils.isEmpty(userVo.getUsername())) {
            return ResultJson.error("用户名为空");
        }
        if (StringUtils.isEmpty(userVo.getPassword())) {
            return ResultJson.error("密码为空");
        }
        return ResultJson.success(userVo);
    }

    @RequestMapping("/user/register2")
    public ResultJson<UserVo2> register2(@RequestBody @Valid UserVo2 userVo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            return ResultJson.error(errorList.get(0).getDefaultMessage());
        }
        return ResultJson.success(userVo);
    }

    @RequestMapping("/user/register3")
    public ResultJson<UserVo> register3(@RequestBody UserVo userVo) {
        return ResultJson.success(userVo);
    }

}
