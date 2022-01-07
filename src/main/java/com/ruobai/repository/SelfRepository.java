package com.ruobai.repository;

import com.ruobai.entity.PersonalInfoStatistic;
import com.ruobai.qo.PersonalInfoStatisticQO;
import com.ruobai.vo.PersonalInfoStatisticVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SelfRepository {
    List<PersonalInfoStatisticQO> findSelfInfo(int page, int limit);

    void deleteSelf(Integer id);

    void updateSelf(PersonalInfoStatistic personalInfoStatistic);
    Long checkTotal();
}
