package cn.itedus.lottery.infrastructure.dao;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//@Mapper 在xml文件中实现crud
public interface IActivityDao {
    void insert(Activity activity);
    Activity queryActivityById(Long activityId);
}
