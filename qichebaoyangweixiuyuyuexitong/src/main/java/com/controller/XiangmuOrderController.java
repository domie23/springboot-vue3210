
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 项目预约订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmuOrder")
public class XiangmuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmuOrderController.class);

    @Autowired
    private XiangmuOrderService xiangmuOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private XiangmuCommentbackService xiangmuCommentbackService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiangmuOrderService.queryPage(params);

        //字典表数据转换
        List<XiangmuOrderView> list =(List<XiangmuOrderView>)page.getList();
        for(XiangmuOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmuOrderEntity xiangmuOrder = xiangmuOrderService.selectById(id);
        if(xiangmuOrder !=null){
            //entity转view
            XiangmuOrderView view = new XiangmuOrderView();
            BeanUtils.copyProperties( xiangmuOrder , view );//把实体数据重构到view中

                //级联表
                XiangmuEntity xiangmu = xiangmuService.selectById(xiangmuOrder.getXiangmuId());
                if(xiangmu != null){
                    BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiangmuId(xiangmu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xiangmuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmuOrderEntity xiangmuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmuOrder:{}",this.getClass().getName(),xiangmuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xiangmuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        xiangmuOrder.setInsertTime(new Date());
        xiangmuOrder.setCreateTime(new Date());
        xiangmuOrderService.insert(xiangmuOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmuOrderEntity xiangmuOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangmuOrder:{}",this.getClass().getName(),xiangmuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xiangmuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XiangmuOrderEntity> queryWrapper = new EntityWrapper<XiangmuOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuOrderEntity xiangmuOrderEntity = xiangmuOrderService.selectOne(queryWrapper);
        if(xiangmuOrderEntity==null){
            xiangmuOrderService.updateById(xiangmuOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiangmuOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XiangmuOrderEntity> xiangmuOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiangmuOrderEntity xiangmuOrderEntity = new XiangmuOrderEntity();
//                            xiangmuOrderEntity.setXiangmuOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            xiangmuOrderEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            xiangmuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xiangmuOrderEntity.setCheliangName(data.get(0));                    //车辆名称 要改的
//                            xiangmuOrderEntity.setCheliangTypes(Integer.valueOf(data.get(0)));   //车辆类型 要改的
//                            xiangmuOrderEntity.setChepaihao(data.get(0));                    //车牌号 要改的
//                            xiangmuOrderEntity.setYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            xiangmuOrderEntity.setXiangmuOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            xiangmuOrderEntity.setXiangmuOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            xiangmuOrderEntity.setXiangmuOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            xiangmuOrderEntity.setInsertTime(date);//时间
//                            xiangmuOrderEntity.setCreateTime(date);//时间
                            xiangmuOrderList.add(xiangmuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("xiangmuOrderUuidNumber")){
                                    List<String> xiangmuOrderUuidNumber = seachFields.get("xiangmuOrderUuidNumber");
                                    xiangmuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiangmuOrderUuidNumber = new ArrayList<>();
                                    xiangmuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiangmuOrderUuidNumber",xiangmuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<XiangmuOrderEntity> xiangmuOrderEntities_xiangmuOrderUuidNumber = xiangmuOrderService.selectList(new EntityWrapper<XiangmuOrderEntity>().in("xiangmu_order_uuid_number", seachFields.get("xiangmuOrderUuidNumber")));
                        if(xiangmuOrderEntities_xiangmuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiangmuOrderEntity s:xiangmuOrderEntities_xiangmuOrderUuidNumber){
                                repeatFields.add(s.getXiangmuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiangmuOrderService.insertBatch(xiangmuOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xiangmuOrderService.queryPage(params);

        //字典表数据转换
        List<XiangmuOrderView> list =(List<XiangmuOrderView>)page.getList();
        for(XiangmuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmuOrderEntity xiangmuOrder = xiangmuOrderService.selectById(id);
            if(xiangmuOrder !=null){


                //entity转view
                XiangmuOrderView view = new XiangmuOrderView();
                BeanUtils.copyProperties( xiangmuOrder , view );//把实体数据重构到view中

                //级联表
                    XiangmuEntity xiangmu = xiangmuService.selectById(xiangmuOrder.getXiangmuId());
                if(xiangmu != null){
                    BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiangmuId(xiangmu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xiangmuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmuOrderEntity xiangmuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xiangmuOrder:{}",this.getClass().getName(),xiangmuOrder.toString());
            XiangmuEntity xiangmuEntity = xiangmuService.selectById(xiangmuOrder.getXiangmuId());
            if(xiangmuEntity == null){
                return R.error(511,"查不到该项目");
            }
            // Double xiangmuNewMoney = xiangmuEntity.getXiangmuNewMoney();

            if(false){
            }
            else if(xiangmuEntity.getXiangmuNewMoney() == null){
                return R.error(511,"项目价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - xiangmuEntity.getXiangmuNewMoney();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            xiangmuOrder.setXiangmuOrderTypes(1); //设置订单状态为已支付
            xiangmuOrder.setXiangmuOrderTruePrice(xiangmuEntity.getXiangmuNewMoney()); //设置实付价格
            xiangmuOrder.setXiangmuOrderUuidNumber(String.valueOf(new Date().getTime()));
            xiangmuOrder.setXiangmuOrderPaymentTypes(1);
            xiangmuOrder.setInsertTime(new Date());
            xiangmuOrder.setCreateTime(new Date());
                xiangmuOrderService.insert(xiangmuOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            return R.ok();
    }

    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            XiangmuOrderEntity xiangmuOrder = xiangmuOrderService.selectById(id);
            Integer xiangmuOrderPaymentTypes = xiangmuOrder.getXiangmuOrderPaymentTypes();
            Integer xiangmuId = xiangmuOrder.getXiangmuId();
            if(xiangmuId == null)
                return R.error(511,"查不到该项目");
            XiangmuEntity xiangmuEntity = xiangmuService.selectById(xiangmuId);
            if(xiangmuEntity == null)
                return R.error(511,"查不到该项目");
            Double xiangmuNewMoney = xiangmuEntity.getXiangmuNewMoney();
            if(xiangmuNewMoney == null)
                return R.error(511,"项目价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");



            //判断是什么支付方式 1代表余额 2代表积分
            if(xiangmuOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = xiangmuEntity.getXiangmuNewMoney();
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
            }




            xiangmuOrder.setXiangmuOrderTypes(2);//设置订单状态为取消预约
            xiangmuOrderService.updateById(xiangmuOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            xiangmuService.updateById(xiangmuEntity);//更新订单中项目的信息
            return R.ok();
    }


    /**
     * 商家确认
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        XiangmuOrderEntity  xiangmuOrderEntity = new  XiangmuOrderEntity();;
        xiangmuOrderEntity.setId(id);
        xiangmuOrderEntity.setXiangmuOrderTypes(3);
        boolean b =  xiangmuOrderService.updateById( xiangmuOrderEntity);
        if(!b){
            return R.error("商家确认出错");
        }
        return R.ok();
    }














    /**
     * 使用
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        XiangmuOrderEntity  xiangmuOrderEntity = new  XiangmuOrderEntity();
        xiangmuOrderEntity.setId(id);
        xiangmuOrderEntity.setXiangmuOrderTypes(4);
        boolean b =  xiangmuOrderService.updateById( xiangmuOrderEntity);
        if(!b){
            return R.error("使用出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer xiangmuCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            XiangmuOrderEntity xiangmuOrder = xiangmuOrderService.selectById(id);
        if(xiangmuOrder == null)
            return R.error(511,"查不到该订单");
        if(xiangmuOrder.getXiangmuOrderTypes() != 4)
            return R.error(511,"您不能评价");
        Integer xiangmuId = xiangmuOrder.getXiangmuId();
        if(xiangmuId == null)
            return R.error(511,"查不到该项目");

        XiangmuCommentbackEntity xiangmuCommentbackEntity = new XiangmuCommentbackEntity();
            xiangmuCommentbackEntity.setId(id);
            xiangmuCommentbackEntity.setXiangmuId(xiangmuId);
            xiangmuCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            xiangmuCommentbackEntity.setXiangmuCommentbackText(commentbackText);
            xiangmuCommentbackEntity.setInsertTime(new Date());
            xiangmuCommentbackEntity.setReplyText(null);
            xiangmuCommentbackEntity.setUpdateTime(null);
            xiangmuCommentbackEntity.setCreateTime(new Date());
            xiangmuCommentbackService.insert(xiangmuCommentbackEntity);

            xiangmuOrder.setXiangmuOrderTypes(5);//设置订单状态为已评价
            xiangmuOrderService.updateById(xiangmuOrder);//根据id更新
            return R.ok();
    }












}
