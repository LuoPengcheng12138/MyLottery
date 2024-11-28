package cn.itedus.lottery.domain.award.model.res;

import lombok.*;

/**
 * @description:
 * @author：Luopc
 * @date: 2024/11/28
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class DistributionRes {
    /** 用户ID */
    @NonNull
    private String uId;
    /** 编码 */
    @NonNull
    private Integer code;
    /** 描述 */
    @NonNull
    private String info;

    /** 结算单ID，如：发券后有券码、发货后有单号等，用于存根查询 */
    private String statementId;
}


