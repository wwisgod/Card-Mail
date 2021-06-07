package com.qf.ww.service;

import com.qf.ww.entity.Message;

public interface ICategoryService {
    /**
     * 获取所有类目业务
     * @return 含有所有类目的list集合的Message对象
     */
    Message getCategoryList();

    /**
     * 删除所选分类业务
     * @param id 类目id
     * @return 含有success (删除成功)/error（删除失败）消息的Message对象
     */
    Message deleteCategory(int id);

    /**
     *  获取修改的的类目信息业务
     * @param id 类目id
     * @return 含有单个类目数据的list集合的Message对象
     */
    Message getCategoryInfo(int id);

    /**
     *  更新类目信息业务
     * @param id
     * @param name
     * @return 含有success (修改成功)/error（修改失败）消息的Message对象
     */
    Message updateCategoryInfo(int id,String name);

    /**
     *  添加分类业务
     * @param name 分类名称
     * @return 含有success (添加成功)/error（添加失败）消息的Message对象
     */
    Message addCategory(String name);
}
