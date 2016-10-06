package com.congfu.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congfu.dao.TagDao;
import com.congfu.model.Tag;
import com.congfu.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    public int insert(Tag tag) {
        return tagDao.insert(tag);
    }

    public int update(Tag tag) {
        int result = 0;
        Tag oldTag = tagDao.findById((long) tag.getId());
        if (oldTag != null) {
            try {
                result = tagDao.update(tag);
                int a = 1 / 0;
            } catch (Exception e) {
                throw new RuntimeException("更新标签出错 ==>id=" + tag.getId());
            }
        }
        return result;
    }

    public Tag findById(Long id) {
        // TODO Auto-generated method stub
        return tagDao.findById(id);
    }

    public List<Tag> query(Tag tag) {
        // TODO Auto-generated method stub
        return tagDao.query(tag);
    }

}
