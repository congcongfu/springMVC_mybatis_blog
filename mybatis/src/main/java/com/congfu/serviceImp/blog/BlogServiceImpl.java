package com.congfu.serviceImp.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congfu.dao.blog.BlogDao;
import com.congfu.model.blog.Blog;

@Service("blogService")
public class BlogServiceImpl implements BlogDao {
    @Autowired
    private BlogDao blogDao;
    
    public int insert(Blog blog) {
        return blogDao.insert(blog);
    }

    public int update(Blog blog) {
        return blogDao.update(blog);
    }

    public Blog findById(int id) {
        return blogDao.findById(id);
    }

    public List<Blog> query(Blog blog) {
        return blogDao.query(blog);
    }

}
