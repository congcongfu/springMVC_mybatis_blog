package com.congfu.serviceImp;

import java.util.List;

import com.congfu.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congfu.model.Blog;
import com.congfu.query.BlogQuery;
import com.congfu.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    public int insert(Blog blog) {
        return blogDao.insert(blog);
    }

    public int update(Blog blog) {
        int result = 0;
        Blog oldBlog = blogDao.selectById( blog.getId());
        if (oldBlog != null) {
            try {
                result = blogDao.updateByPrimaryKeyWithBLOBs(blog);
            } catch (Exception e) {
                throw new RuntimeException("更新博客出错 ＝＝>id=" + blog.getId());
            }
        }
        return result;

    }

    public Blog findById(Integer id) {
        return blogDao.selectById(id);
    }

    public List<Blog> query(BlogQuery blog) {
        return blogDao.query(blog);
    }
}
