package com.congfu.dao;

import java.util.List;

import com.congfu.model.Tag;

public interface TagDao {

    /**
     * 新增标签
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
    public int insert(Tag tag);

    /**
     * 更新标签
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
    public int update(Tag tag);

    /**
     * 根据id查找
     * 
     * @return Tag
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public Tag findById(Long id);

    /**
     * 条件查询
     * 
     * @param Tag 查询参数
     * @return
     * @return List<Blog>
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月13日
     * </PRE>
     */
    public List<Tag> query(Tag tag);
}
