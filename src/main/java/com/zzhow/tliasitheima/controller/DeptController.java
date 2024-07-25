package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.pojo.Dept;
import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
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

    /**
     * 删除指定 ID 的部门
     *
     * @param id
     * @return null
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除 id = {} 的部门", id);

        //调用 service 删除部门
        deptService.delete(id);

        return Result.success();
    }

    /**
     * 添加部门
     *
     * @param dept
     * @return null
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门：{}", dept);

        //调用 service 添加部门
        deptService.add(dept);

        return Result.success();
    }
}
