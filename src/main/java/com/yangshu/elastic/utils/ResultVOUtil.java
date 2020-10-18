package com.yangshu.elastic.utils;

import com.yangshu.elastic.VO.ResultVO;
import com.yangshu.elastic.enums.ResultEnum;

/**
 * Created by yangshu on 2020/3/22 19:10
 * Description：工具类
 */
public class ResultVOUtil {
    public static ResultVO<Object> success(Object obj){
        ResultVO<Object> res = new ResultVO<>();
        res.setCode(ResultEnum.SUCCESS.getCode());
        res.setMsg(ResultEnum.SUCCESS.getMessage());
        res.setData(obj);
        return res;
    }

    public static ResultVO<Object> success(){
        return success(null);
    }

    public static ResultVO successMsg(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        return resultVO;
    }

//    public static ResultVO successCode(Integer code, String msg){
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(code);
//        resultVO.setMsg(msg);
//        return resultVO;
//    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO errorMsg(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(ResultEnum.UNAUTHORIZED.getCode());
        return resultVO;
    }
}
