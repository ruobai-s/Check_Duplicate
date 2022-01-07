package com.ruobai.service.impl;

import com.ruobai.entity.PersonalInfoStatistic;
import com.ruobai.qo.PersonalInfoStatisticQO;
import com.ruobai.repository.ClassRepository;
import com.ruobai.repository.SelfRepository;
import com.ruobai.service.SelfService;
import com.ruobai.util.PageLimitUtil;
import com.ruobai.vo.DataVO;
import com.ruobai.vo.PersonalInfoStatisticVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfRepository selfReposiotry;
    @Autowired
    private PageLimitUtil pageLimitUtil;
    @Override
    public DataVO<PersonalInfoStatisticVO> findSelfInfo(int page, int limit) {
        int index = pageLimitUtil.index(page);
        DataVO DataVO = new DataVO();
        DataVO.setCode(0);
        DataVO.setMsg("");
        //提高效率采用级联查询
        List<PersonalInfoStatisticQO> personalInfoStatistics = selfReposiotry.findSelfInfo(page,limit);
        List<PersonalInfoStatisticVO> personalInfoStatisticVOList = new ArrayList<>();
        for (PersonalInfoStatisticQO personalInfoStatisticQO: personalInfoStatistics) {
            PersonalInfoStatisticVO personalInfoStatisticVO = new PersonalInfoStatisticVO();
            BeanUtils.copyProperties(personalInfoStatisticQO,personalInfoStatisticVO);
            personalInfoStatisticVO.setClass_name(personalInfoStatisticQO.getAClass().getClass_name());
            personalInfoStatisticVO.setCourse_name(personalInfoStatisticQO.getCourse().getCourse_name());
            personalInfoStatisticVOList.add(personalInfoStatisticVO);
        }
        DataVO.setCount((long) personalInfoStatistics.size());
        DataVO.setData(personalInfoStatisticVOList);
        return DataVO;
    }

    @Override
    public void deleteSelf(Integer id) {

    }

    @Override
    public void updateSelf(PersonalInfoStatisticVO personalInfoStatisticVO) {

    }
}
