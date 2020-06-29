package com.aust.clanguagemanage.controller;


import com.aust.clanguagemanage.constant.Constants;
import com.aust.clanguagemanage.service.UserService;
import com.aust.clanguagemanage.vo.ReturnVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Api(description = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${DingTalk.APP_ID}")
    private String APP_ID;
    @Value("${DingTalk.CALL_BACK_URL}")
    private String CALL_BACK_URL;

//    @ResponseBody
    @GetMapping("/dingdingLogin")
    public Object dingdingLogin() {
        String time = String.valueOf(System.currentTimeMillis());//产生一个当前的毫秒
        StringBuilder stringBuilder = new StringBuilder();
        String result="";
        stringBuilder
                .append("https://oapi.dingtalk.com/connect/qrconnect?appid=")
                .append(APP_ID)//APP_ID
                .append("&response_type=")
                .append("code")//code
                .append("&scope=")
                .append("snsapi_login")//snsapi_login
                .append("&state=")
                .append(time)
                .append("&redirect_uri=")
                .append(CALL_BACK_URL);//回调地址
        try {
            result = stringBuilder.toString();
        } catch (Exception e) {
            log.error(":{}",e);
        }
        return result;
    }
    @GetMapping(value="/callback", produces="text/html; charset=utf-8")
    public Object getUserInfo(HttpServletRequest request, HttpServletResponse response, Model model, String code, String state) {
//        Result result = userAuthsService.getDingLogin(code);
        return "https://pixar.fun/clanguage-ui-dev/index.html";
    }

    @ApiOperation(value = "获取用户list", notes = "传入page,pageSize ")
    @GetMapping("/getList")
    public ReturnVO getUserList(@RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        return ReturnVO.getSuccess(userService.findUsersByRoleAndList(page, pageSize));
    }

    public ReturnVO userLogin(@RequestBody User user){
        userService.userLogin(user.getName(), user.getPassword());
        return ReturnVO.getSuccess()
    }

}
