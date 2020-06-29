package com.aust.clanguagemanage.controller;


import com.aust.clanguagemanage.constant.Constants;
import com.aust.clanguagemanage.service.ProfitService;
import com.aust.clanguagemanage.vo.ReturnVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "成果管理")
@RestController
@RequestMapping("profit")
public class ProfitControllrt {
    @Autowired
    private ProfitService profitService;

    @ApiOperation(value = "获取成果list", notes = "传入page,pageSize ")
//    @ApiImplicitParam(value = "couId", name = "couId", paramType = "query", dataType = "String", required = true)
    @GetMapping("/getList")
    public ReturnVO getProfitList(@RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                  @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        return ReturnVO.getSuccess(profitService.findProfitList(page, pageSize));
    }
}
