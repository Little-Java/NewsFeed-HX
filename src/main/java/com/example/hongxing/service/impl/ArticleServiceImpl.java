package com.example.hongxing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hongxing.dto.ArticleDto;
import com.example.hongxing.entity.ArticleEntity;
import com.example.hongxing.entity.OrganEntity;
import com.example.hongxing.entity.UserEntity;
import com.example.hongxing.mapper.ArticleMapper;
import com.example.hongxing.mapper.OrganMapper;
import com.example.hongxing.mapper.UserMapper;
import com.example.hongxing.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrganMapper organMapper;

    @Override
    public ArticleDto getArticleById(Integer acId) {
        ArticleDto articleDto = articleMapper.getArticleById(acId);
        if(articleDto == null){
            return null;
        }
        if(articleDto.getAcUserId() != null) {
            UserEntity userEntity =userMapper.selectUserById(articleDto.getAcUserId());
            if(userEntity!=null){
                articleDto.setWriter((articleDto.getAcAuthor()==null?"":articleDto.getAcAuthor()+"-")+userEntity.getUsName());
                OrganEntity organEntity = organMapper.getOrganByOgIndex(userEntity.getOgindex());
                if(organEntity !=null){
                    int length = organEntity.getOgId().length();
                    int subStr = 2;
                    while (subStr <= length){
                        OrganEntity oe = organMapper.getOrganByOgId(organEntity.getOgId().substring(0,subStr));
                        articleDto.setCompanyName((articleDto.getCompanyName()==null?"":articleDto.getCompanyName())+oe.getOgName());
                        subStr = subStr + 2;
                    }
                }
            }
        }
        return articleDto;
    }

    @Override
    public List<ArticleDto> getArticleBySubjectId(Integer subjectId){
        return articleMapper.getArticleBySubjectId(subjectId);
    }

}
