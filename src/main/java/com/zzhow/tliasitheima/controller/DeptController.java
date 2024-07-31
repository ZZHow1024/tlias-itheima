package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.anno.Log;
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
@RequestMapping("/depts")
public class DeptController {
    //日志对象
    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门数据
     *
     * @return (JSON)全部部门数据
     */
    //@RequestMapping(value = "depts", method = RequestMethod.GET)
    @GetMapping
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
    @Log
    @DeleteMapping("/{id}")
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
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门：{}", dept);

        //调用 service 添加部门
        deptService.add(dept);

        return Result.success();
    }

    /**
     * 根据 ID 查询部门信息
     *
     * @param id
     * @return (JSON)指定 ID 的部门数据
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询 ID 为 {} 的部门信息", id);

        //调用 service 根据 ID 查询
        List<Dept> deptList = deptService.get(id);

        return Result.success(deptList);
    }

    /**
     * 修改部门
     *
     * @param dept
     * @return null
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改 ID 为 {} 的部门信息，部门名称修改为 {}", dept.getId(), dept.getName());

        //调用 service 修改部门
        deptService.update(dept);

        return Result.success();
    }
}
