package com.congfu.service;

import java.util.List;

import com.congfu.model.TagBlog;

public interface TagBlogService {
    /**
     * 
     * 新增
     * 
     * @param tagBlog
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public int insert(TagBlog tagBlog);
    /**
     * 
     * 更新
     * 
     * @param tagBlog
     * @return
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public int update(TagBlog tagBlog);
    /**
     * 
     * 根据id查询
     * 
     * @param id
     * @return
     * @return TagBlog
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public TagBlog findById(Integer id);
    /**
     * 
     * 条件查询
     * 
     * @param tagBlog
     * @return
     * @return List<TagBlog>
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public List<TagBlog> query(TagBlog tagBlog);
}
