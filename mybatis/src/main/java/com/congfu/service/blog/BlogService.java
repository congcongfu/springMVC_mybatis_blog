package com.congfu.service.blog;

import java.util.List;

import com.congfu.model.blog.Blog;

public interface BlogService {
    /**
     * 新增blog
     * 
     * @param blog
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public int insert(Blog blog);
    /**
     * 更新blog
     * 
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public int update();
    /**
     * 根据id查询
     * 
     * @param id
     * @return Blog
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public Blog findById(Integer id);
    /**
     * 条件查询
     * 
     * @param blog
     * @return
     * @return List<Blog>
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public List<Blog> query(Blog blog);
}
