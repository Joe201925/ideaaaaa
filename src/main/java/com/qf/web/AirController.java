package com.qf.web;

import com.github.pagehelper.PageInfo;
import com.qf.bean.AirQualityIndex;
import com.qf.bean.District;
import com.qf.service.AirService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class AirController {

    @Resource
    private AirService airService;


    /**
     * 查询所有空气
     * @param map
     * @param index
     * @param size
     * @param districtId
     * @return
     */
    @RequestMapping("/findall")
    public String findallair(ModelMap map,@RequestParam(defaultValue = "1") Integer index,
                             @RequestParam(defaultValue = "1")Integer size, Integer districtId){

        //调用service方法
        System.out.println(districtId+"+++++");
        PageInfo<AirQualityIndex> pageInfo = airService.findall(index, 2, districtId);
        map.addAttribute("pageinfo",pageInfo);
        map.addAttribute("list",pageInfo.getList());
        List<District> districts = airService.findDistricts();
        map.addAttribute("district",districts);

        map.addAttribute("did",districtId);

//        System.out.println(districtId+++"这是模查");

        return "show";
    }

    /**
     * 增加空气条目
     * 跳转页面
     */
    @RequestMapping("/getdistricts")
    public String getdistricts(ModelMap map){

        List<District> districts = airService.findDistricts();
        map.addAttribute("districts",districts);

        return "add";
    }

    /**
     * 实现增加条目
     */
   @RequestMapping("/add")
    public  void addair(AirQualityIndex airQualityIndex, HttpServletResponse response){

       airQualityIndex.setLastModifyTime("20190711");
       airQualityIndex.setMonitoringStation("北科");

       //调用service方法
       int i = airService.addAir(airQualityIndex);
       response.setContentType("text/html;charset=utf-8");
       try {
           PrintWriter writer = response.getWriter();

           if (i>0){
               writer.print("<script>alert('增加成功');location.href='findall'</script>");
           }else {
               writer.print("<script>alert('增加失败');location.href='getdistricts'</script>");
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    /**
     * 主键查询
     */
     @RequestMapping("/findbyid")
    public String findbyid(ModelMap map,Integer id){

         List<District> districts = airService.findDistricts();
         map.addAttribute("districts",districts);

         AirQualityIndex findbyid = airService.findbyid(id);
         if (findbyid!=null){
             map.addAttribute("findbyid",findbyid);
         }
//         System.out.println(findbyid.getMonitoringStation()+findbyid.getLastModifyTime());

         return "update";
     }

    /**
     * 修改实现
     */
  @RequestMapping("/update")
    public void update(AirQualityIndex airQualityIndex,HttpServletResponse response){

      System.out.println(airQualityIndex.getMonitoringStation()+"监测站");
      int i = airService.updateair(airQualityIndex);

      response.setContentType("text/html;charset=utf-8");
      try {
          PrintWriter writer = response.getWriter();

          if (i>0){
              writer.print("<script>alert('修改成功');location.href='findall'</script>");
          }else {
              writer.print("<script>alert('修改失败');location.href='findbyid'</script>");
          }
      } catch (IOException e) {
          e.printStackTrace();
      }

  }

    /**
     * 删除条目
     */

    @RequestMapping("/deletebyid")
    public void deletebyid(Integer id,HttpServletResponse response){
        int i = airService.deletebyid(id);
        response.setContentType("text/html;charset=utf-8");

        try {
            PrintWriter writer = response.getWriter();

        if (i>0){
            writer.print("<script>alert('删除成功');location.href='findall'</script>");
        }else {
            writer.print("<script>alert('删除失败');location.href='findbyid'</script>");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    }

}
