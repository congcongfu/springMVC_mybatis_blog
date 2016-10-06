package com.congfu.dao;

import java.util.List;

import com.congfu.model.TagBlog;

public interface TagBlogDao {
    /**
     * 
     * 新增
     * 
     * @return
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public int insert();
    /**
     * 
     * 更新
     * 
     * @return
     * @return int
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public int update();
    /**
     * 
     * 根据id查找
     * 
     * @return
     * @return TagBlog
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public TagBlog findById();
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
     * Date 2016年9月13日
     * </PRE>
     */
    public List<TagBlog> query(TagBlog tagBlog);

}
