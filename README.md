TableDesign:
Error:IllegalArgumentException: Result Maps collection does not contain value for cn.itedus.lottery.infrastructure.dao.IActivityDao.activityMap
原因：在mapper.xml文件中 将resultType 和resultMap 混淆

Strategy:
Error：Drawbase：if(1!=strategyMode) return;https://gitcode.net/KnowledgePlanet/Lottery/-/issues/177
原因：单项概率元组未初始化

Award:
数据库字段和infrastructure.po要对应
Error:org.springframework.dao.DataIntegrityViolationException: Error attempting to get column 'award_name' from result set. 
Cause: java.sql.SQLDataException: Cannot determine value type from string 'AirPods'
原因：用lombok自动生成的无参构造，要写全，尤其是 @NoArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
https://blog.csdn.net/m0_37822085/article/details/125894706