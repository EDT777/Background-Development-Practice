package com.edt.controller;


import com.edt.controller.vm.UserInfoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DemoController {

    @RequestMapping(value="test1",method = RequestMethod.GET)
    @ApiOperation("这是一个测试方法，返回一个消息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "一切安好")
    })
    public String demoTest1(@ApiParam("第一个测试参数") String param1){

        return "你好你好你好";
    }


    @RequestMapping(value="userInfo",method = RequestMethod.GET)
    @ApiOperation("返回用户当前登录的用户信息")
    public UserInfoResponse userInfo(@ApiParam(value = "用户id",type = "query") String userId){
        UserInfoResponse response = new UserInfoResponse();
        response.setAvatar("http://wwww.zyejy.com/pic/xxsssx.jpg");
        response.setNickname("大仙");
        response.setUsername("daxian");
        return  response;
    }
}
