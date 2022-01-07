package com.ruobai.service;

import com.ruobai.entity.ClassInfoStatistic;
import com.ruobai.vo.ClassInfoStatisticVO;
import com.ruobai.vo.DataVO;
import com.ruobai.vo.PersonalInfoStatisticVO;

public interface SelfService {
    DataVO<PersonalInfoStatisticVO> findSelfInfo(int page, int limit);

    void deleteSelf(Integer id);

    void updateSelf(PersonalInfoStatisticVO personalInfoStatisticVO);
}
