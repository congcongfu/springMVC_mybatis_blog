package com.congfu.service;

import java.util.List;

import com.congfu.model.Tag;

public interface TagService {

    /**
     * 新增标签
     * 
     * @param tag
     * @return int
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public int insert(Tag tag);

    /**
     * 更新标签
     * 
     * 
     * @param tag
     * @return
     * @return int
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public int update(Tag tag);

    /**
     * 根据id查询
     * 
     * @param id
     * @return tag
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年10月5日
     * </PRE>
     */
    public Tag findById(Long id);

    /**
     * 条件查询
     * 
     * @param blog
     * @return
     * @return List<Blog>
     * @since v0.0.1
     * 
     * <PRE>
     * author congfu
     * Date 2016年9月14日
     * </PRE>
     */
    public List<Tag> query(Tag Tag);

}
