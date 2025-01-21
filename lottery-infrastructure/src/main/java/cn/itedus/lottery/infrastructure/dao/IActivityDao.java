package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**

 * @author Luopc
 */
@Mapper
public interface IActivityDao {

   void insert(Activity req);

   Activity queryActivityById(Long activityId);

   // 变更活动状态
   // @param alterStateVO  [activityId、beforeState、afterState]
   // @return 更新数量
   int alterState(AlterStateVO alterStateVO);

   /**
    * 扣减活动库存
    * @param activityId 活动ID
    * @return 更新数量
    */
   int subtractionActivityStock(Long activityId);
}
