package com.ruobai.service.impl;

import com.ruobai.entity.ClassInfoStatistic;
import com.ruobai.repository.ClassRepository;
import com.ruobai.repository.UtilsRepository;
import com.ruobai.service.ClassService;
import com.ruobai.util.PageLimitUtil;
import com.ruobai.vo.ClassInfoStatisticVO;
import com.ruobai.vo.DataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private PageLimitUtil pageLimitUtil;
    @Autowired
    private UtilsRepository utilsRepository;
    @Override
    public DataVO<ClassInfoStatisticVO> findClassInfo(int page, int limit) {
        int index = pageLimitUtil.index(page);
        DataVO DataVO = new DataVO();
        DataVO.setCode(0);
        DataVO.setMsg("");
        List<ClassInfoStatistic> classes = classRepository.findClassInfo(index,limit);
        //json解析
        List<ClassInfoStatisticVO> classVOList = new ArrayList<>();
        for (ClassInfoStatistic aclass:classes) {
            ClassInfoStatisticVO classInfoStatisticVO = new ClassInfoStatisticVO();
            BeanUtils.copyProperties(aclass,classInfoStatisticVO);
            String class_Name = utilsRepository.checkName(aclass.getClass_id());
            classInfoStatisticVO.setClass_name(class_Name);
            classVOList.add(classInfoStatisticVO);
        }
        DataVO.setCount((long) classRepository.checkTotal());
        DataVO.setData(classVOList);
        return DataVO;
    }

    @Override
    public void deleteClass(Integer id) {
        classRepository.deleteClass(id);
    }

    @Override
    public void updateClass(ClassInfoStatisticVO classInfoStatisticVO) {
        ClassInfoStatistic classStatistic = new ClassInfoStatistic();
        String class_name = classInfoStatisticVO.getClass_name();
        Integer ids=utilsRepository.checkId(class_name);
        BeanUtils.copyProperties(classInfoStatisticVO,classStatistic);
        classStatistic.setClass_id( ids);
        classRepository.updateClass(classStatistic);
    }
}
