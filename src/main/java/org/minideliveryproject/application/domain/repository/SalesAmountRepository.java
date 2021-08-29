package org.minideliveryproject.application.domain.repository;

import org.hibernate.annotations.Parameter;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.platform.dto.SalesAmountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesAmountRepository extends JpaRepository<StoreMst, Long> {

    @Query(nativeQuery = true, value = "" +
            "SELECT A.STORE_TYPE                                AS storeType          " + /* 점포구분 */
            "     , A.STORE_MST_SEQ                             AS storeMstSeq        " + /* 점포코드 */
            "     , A.STORE_NAME                                AS storeName          " + /* 점포명 */
            "     , A.CONT_DATE                                 AS contDate           " + /* 계약일 */
            "     , A.CONT_RENEW_DATE                           AS contRenewDate      " + /* 재계약일 */
            "     , A.STORE_TEL                                 AS storeTel           " + /* 점포 전화번호 */
            "     , SUM(B.TOTAL_PRICE)/COUNT(B.ORDER_MST_SEQ)   AS totalPriceByOrder  " + /*주문당평균매출 */
            "     , SUM(B.TOTAL_PRICE)                          AS totalPrice         " + /*전체매출*/
            "  FROM STORE_MST A  " +
            "    INNER JOIN ORDER_MST B" +
            "        ON A.STORE_MST_SEQ = B.STORE_MST_SEQ" +
            " WHERE 1=1" +
            "   AND A.CONT_EXP_DATE >= TO_DATE(SYSDATE, 'YYYY-MM-DD')" +
            "   AND TO_CHAR(B.ORDER_DATE, 'YYYYMMDD') BETWEEN ?1 AND ?2" +
            "   AND A.STORE_NAME LIKE %?3%" +
            " GROUP BY A.STORE_MST_SEQ")
    public List<SalesAmountDto> findBySalesAmountMst(String startContract, String endContract, String storeNm);


    @Query(nativeQuery = true, value = "" +
            "SELECT A.STORE_MST_SEQ      AS storeMstSeq   /*점포코드*/" +
            "     , A.STORE_NAME         AS storeName   /*점포명*/" +
            "     , B.ORDER_MST_SEQ      AS orderMstSeq   /*주문번호*/ " +
            "     , B.ORDER_DATE         AS orderDate   /*주문일자*/" +
            "     , D.USER_MST_SEQ       AS userMstSeq   /*주문자코드*/" +
            "     , D.USER_NAME          AS userName   /*주문자이름*/" +
            "     , C.ITEM_MST_SEQ       AS itemMstSeq   /*상품코드*/" +
            "     , E.ITEM_NAME          AS itemName   /*상품명*/" +
            "     , E.ITEM_PRICE         AS itemPrice   /*상품가격*/" +
            "  FROM STORE_MST A" +
            "    INNER JOIN ORDER_MST B" +
            "        ON A.STORE_MST_SEQ = B.STORE_MST_SEQ" +
            "    INNER JOIN ORDER_DETAIL C" +
            "        ON B.ORDER_MST_SEQ = C.ORDER_MST_SEQ" +
            "    INNER JOIN USER_MST D" +
            "        ON B.USER_MST_SEQ = D.USER_MST_SEQ" +
            "    INNER JOIN ITEM_MST E" +
            "        ON C.ITEM_MST_SEQ = E.ITEM_MST_SEQ " +
            " WHERE 1=1" +
            "   AND TO_CHAR(B.ORDER_DATE, 'YYYYMMDD') BETWEEN ?1 AND ?2" +
            "   AND A.STORE_MST_SEQ = ?3")
    public List<SalesAmountDto> findBySalesAmountDetail(String startContract, String endContract, String storeMstSeq);
}
