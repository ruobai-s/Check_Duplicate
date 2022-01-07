package com.ruobai.service;

import com.ruobai.entity.ClassInfoStatistic;
import com.ruobai.vo.ClassInfoStatisticVO;
import com.ruobai.vo.DataVO;

public interface ClassService {
    DataVO<ClassInfoStatisticVO> findClassInfo(int page, int limit);

    void deleteClass(Integer id);

    void updateClass(ClassInfoStatisticVO classInfoStatisticVO);
}
