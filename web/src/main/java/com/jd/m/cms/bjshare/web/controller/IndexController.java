package com.jd.m.cms.bjshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping(value = "/index.do")
	public String updateCheckFlow(HttpServletRequest request) {
		return "/DataStatistical";
	}

	@RequestMapping(value = "/getVarietiesData")
	@ResponseBody
	public Map<String, Object> getVarietiesData(HttpServletRequest request) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

//		String jsonData = ServletRequestUtils.getStringParameter(request,"param", "");
//		Map<String,Object> mapParam=new HashMap<String,Object>();
//
//		if (jsonData != null && !"".equals(jsonData)&&jsonData.length()!=0) {
//			ObjectMapper objectMapper=new ObjectMapper();
//			mapParam = objectMapper.readValue(jsonData, new TypeReference<HashMap<String,Object>>(){});
//		}
//
//		List<Varieties> varietiesLisNum = VarietiesService.findVarietiesList(mapParam);
//		mapParam.put("start", (page-1)*row+1);
//		mapParam.put("end",page*row);
//		List<Varieties> varietiesList = VarietiesService.findVarietiesList(mapParam);
//
////			datagridPage Page=new datagridPage();
////			List<Varieties> varietiesListResulta=(List<Varieties>)Page.page(start, end, varietiesList);
//
//		map.put("total", varietiesLisNum.size());
//		map.put("rows", varietiesList);
		return map;
	}





}
