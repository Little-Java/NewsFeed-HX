package com.example.hongxing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hongxing.dto.SubjectDto;
import com.example.hongxing.dto.TreeChidrenDto;
import com.example.hongxing.entity.SubjectEntity;
import com.example.hongxing.entity.TopicEntity;
import com.example.hongxing.mapper.SubjectMapper;
import com.example.hongxing.mapper.TopicMapper;
import com.example.hongxing.service.SubjectService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, SubjectEntity> implements SubjectService {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<SubjectDto> querySubjectListByTopicId(Integer topicId) {

        QueryWrapper<TopicEntity> qw = new QueryWrapper<>();
        qw.eq("TOPICID",topicId);
        TopicEntity topicEntity = topicMapper.selectOne(qw);
        if(topicEntity !=null) {
            if(topicEntity.getRootSubjectIndex() != null){
                QueryWrapper<SubjectEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("SBINDEX",topicEntity.getRootSubjectIndex().toString());
                subjectMapper.selectOne(queryWrapper);
            }
            String ids = "";
            if(topicEntity.getLp() != null && topicEntity.getLp()!=""){
                ids = topicEntity.getLp();
                if(topicEntity.getRp() != null && topicEntity.getRp() !=""){
                    ids = ids + "," + topicEntity.getRp();
                    if(topicEntity.getCp() != null && topicEntity.getCp() != ""){
                        ids = ids + "," + topicEntity.getCp();
                    }
                }
            }
            if(!ids.isEmpty()){
                List<String> idsStringList = Arrays.asList(ids.split(","));
                List<Integer> idsList = new ArrayList<>();
                CollectionUtils.collect(idsStringList, new Transformer() {
                    @Override
                    public Object transform(Object o) {
                        return Integer.valueOf(o.toString());
                    }

                }, idsList);

                List<SubjectDto> list = subjectMapper.selectSubjectByIndex(idsList);
                return list;
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public List<TreeChidrenDto> getSubjectListById(String sbId) {
        List<TreeChidrenDto> list = subjectMapper.getSubjectListById(sbId);
        return list;
    }

    @Override
    public List<TreeChidrenDto> querySubjectTree(String subjcetId) {
        List<TreeChidrenDto> list =  subjectMapper.querySubjectTree();
        for (TreeChidrenDto dto : list) {
            String id = dto.getSbId();
            List<TreeChidrenDto> list1 = subjectMapper.querySubjectTrees(id, id.length()+2);
            dto.setChildren(list1);
            if(list1.size()>0 || list !=null){
                for(TreeChidrenDto dto1 : dto.getChildren()){
                    String id1 = dto1.getSbId();
                    List<TreeChidrenDto> list2 = subjectMapper.querySubjectTrees(id1, id1.length()+2);
                    dto1.setChildren(list2);
                }
            }
        }
        return list;
    }
}
