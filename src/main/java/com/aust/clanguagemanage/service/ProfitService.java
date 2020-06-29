package com.aust.clanguagemanage.service;

import com.alibaba.fastjson.JSONObject;
import com.aust.clanguage.base.domain.Profit;
import com.aust.clanguage.base.mapper.ProfitMapper;
import com.aust.clanguage.base.vo.profit.ProfitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProfitService {
    @Autowired
    private ProfitMapper profitMapper;

    public List<ProfitVo> findProfitList(Integer page, Integer pageSize){
        List<Profit> list = profitMapper.findProfitsByPage(page, pageSize);
        List<ProfitVo> vos = new ArrayList<>();
        for (Profit profit: list){
            vos.add(ProfitVo.of(profit));
        }
        log.info("成果返回:{}", JSONObject.toJSONString(vos));
        return vos;
    }
}
