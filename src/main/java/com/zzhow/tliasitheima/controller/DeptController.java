package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.pojo.Dept;
import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Slf4j
@RestController
public class DeptController {
    //日志对象
    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门数据
     * @return JSON全部部门数据
     */
    //@RequestMapping(value = "depts", method = RequestMethod.GET)
    @GetMapping("depts")
    public Result list() {
        log.info("查询全部部门数据");

        //调用 service 查询部门数据
        List<Dept> deptList = deptService.findAll();

        return Result.success(deptList);
    }
}
