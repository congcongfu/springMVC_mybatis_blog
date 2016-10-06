package com.congfu.dao;

import java.util.List;

import com.congfu.model.Blog;
import com.congfu.query.BlogQuery;

public interface BlogDao {

    /**
     * 新增博客
     * 
     * @return
     * @return int
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public int insert(Blog blog);

    /**
     * 更新博客
     * 
     * @param blog
     * @return int
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public int update(Blog blog);

    /**
     * 根据id查找
     * 
     * @return Blog
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public Blog findById(Long id);

    /**
     * 条件查询
     * 
     * @param blog 查询参数
     * @return
     * @return List<Blog>
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public List<Blog> query(BlogQuery blogQuery);
}
