package com.rengu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rengu.entity.CriterionModel;
import com.rengu.entity.PersonnelModel;
import com.rengu.entity.vo.RR;
import com.rengu.service.CriterionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CriterionController
 * @Description 控制器
 * @Author zj
 * @Date 2023/08/04 09:45
 **/
@RestController
@RequestMapping("/criterion-model")
@Api(value = "CriterionController", tags = {"评审准测控制器"})
	public class CriterionController {

@Autowired
public CriterionService criterionModelService;

//@RequestMapping(value = "list", method = RequestMethod.GET)
//@ApiOperation(value = "展示列表")
//@ApiImplicitParams({
//		@ApiImplicitParam(value = "页码", name = "pageNum", dataType = "Integer", required = false,example = "1",defaultValue = "1"),
//		@ApiImplicitParam(value = "每页条数", name = "pageSize", dataType = "Integer", required = false,example = "10",defaultValue = "10")
//})
//public IPage<CriterionModel> get(@RequestParam(value = "pageNum") Integer pageNum,@RequestParam(value = "pageSize") Integer pageSize){
//		return	criterionModelService.page(new Page<>(pageNum, pageSize));
//
//		}


@RequestMapping(value = "queryById", method = RequestMethod.GET)
@ApiOperation(value = "根据Id展示列表")
public RR get(String Id){
		return RR.success(criterionModelService.getById(Id));
		}
@RequestMapping(value = "remove", method = RequestMethod.GET)
@ApiOperation(value = "移除")
public RR remove(String Id){
		return RR.success(criterionModelService.removeById(Id));
		}
@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
@ApiOperation(value = "保存或更新")
public RR saveOrUpdate(@RequestBody CriterionModel criterionModel){
		return RR.success(criterionModelService.saveOrUpdate(criterionModel));
		}




	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ApiOperation(value = "分页，名字模糊查询")
	public RR page(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
				   @RequestParam(value = "pageSize", required = true, defaultValue = "2") Integer pageSize,
				   @RequestParam (value = "criterionName", required = false)String criterionName,
				   @RequestParam (value = "reviewPoints", required = false)String reviewPoints,
				   @RequestParam (value = "reviewCriteria", required = false)String reviewCriteria,
				   @RequestParam (value = "reviewProcess", required = false)String reviewProcess){



		Page<CriterionModel> page = criterionModelService.page(pageNum,pageSize,criterionName,reviewPoints,reviewCriteria,reviewProcess);


		return RR.success(page);
	}
}



