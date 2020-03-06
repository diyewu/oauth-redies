package com.aicc.bpf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@Api(tags = "demo测试controller")
@RequestMapping("/demo")
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @ApiOperation("GET示例")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "queryParam", value = "demo-query-param", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "pathParam", value = "demo-path-param", required = true),
    })
    @GetMapping("/demoGet/{pathParam}")
    public String demoGetRole(
            @NotBlank(message = "{required}") String queryParam,
            @NotBlank(message = "{required}") @PathVariable String pathParam
    ) {
        try {
            System.out.println(queryParam);
            System.out.println(pathParam);
//            return demoService.getRole().toString();
        } catch (Exception e) {
            logger.error("",e);
        }
        return null;
    }


    @ApiOperation("POST示例")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "queryParam", value = "demo-param", required = true),
    })
    @PostMapping("/demoPost")
    public String demoPost(
            @NotBlank(message = "{required}") String queryParam
    ) {
        try {
            System.out.println(queryParam);
        } catch (Exception e) {
            logger.error("",e);
        }
        return "demo test";
    }
}
