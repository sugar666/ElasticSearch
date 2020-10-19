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
        res.setStatus(ResultEnum.SUCCESS.getMessage());
        res.setData(obj);
        return res;
    }

    public static ResultVO<Object> success(){
        return success(null);
    }

    public static ResultVO successMsg(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(msg);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setStatus(msg);
        return resultVO;
    }

    public static ResultVO<Object> error(Integer code, String msg,Object data){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setStatus(msg);
        resultVO.setData(data);
        return resultVO;
    }


    public static ResultVO errorMsg(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(msg);
        resultVO.setCode(ResultEnum.UNAUTHORIZED.getCode());
        return resultVO;
    }
}
