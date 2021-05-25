package com.qingyuan.redtour;

import com.alibaba.fastjson.JSON;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiErrorCodeDictionary;
import com.power.doc.model.ApiReqHeader;
import com.qingyuan.redtour.utils.ResponseEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RedTourApplicationTests {

    @Test
    void contextLoads() {
        List<Object> list = new ArrayList<>();
        list.add("ok");
        list.add(1);
        list.add("name");
        String json = JSON.toJSONString(list);
        System.out.println(json);
    }

    @Test
    public static void main(String[] args) {
        SpringApplication.run(RedTourApplicationTests.class,args);
    }

    @Test
    void buildApiDoc() {
        ApiConfig config = new ApiConfig();
        config.setServerUrl("http://118.31.16.35:8080");

        // 设置为严格模式，Smart-doc将降至要求每个Controller暴露的接口写上标准文档注释
        config.setStrict(true);

        // 当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);

        // HTML5文档，建议直接放到src/main/resources/static/doc下，Smart-doc提供一个配置常量HTML_DOC_OUT_PATH
        config.setOutPath(DocGlobalConstants.HTML_DOC_OUT_PATH);

        // 设置接口包扫描路径过滤，如果不配置则Smart-doc默认扫描所有的接口类
        // 配置多个包名用英文逗号隔开
        config.setPackageFilters("com.qingyuan.redtour.controller");

        // 设置公共请求头.如果不需要请求头，则无需设置
        config.setRequestHeaders(
                ApiReqHeader.header().setName("token").setType("string")
                        .setDesc("Basic auth credentials").setRequired(true)
        );

        // 1.7.9 优化了错误码处理，用于下面替代遍历枚举设置错误码
        config.setErrorCodeDictionaries(
                ApiErrorCodeDictionary.dict().setEnumClass(ResponseEnum.class)
                        .setCodeField("code")  // 错误码值字段名
                        .setDescField("msg") // 错误码描述
        );

        // 生成html
        HtmlApiDocBuilder.buildApiDoc(config);
    }
}
