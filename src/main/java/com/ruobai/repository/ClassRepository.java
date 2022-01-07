package com.ruobai.repository;

import com.ruobai.entity.ClassInfoStatistic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassRepository {
    List<ClassInfoStatistic> findClassInfo(int page, int limit);

    void deleteClass(Integer id);

    void updateClass(ClassInfoStatistic classStatistic);
    //检查id
    Long checkTotal();
}
