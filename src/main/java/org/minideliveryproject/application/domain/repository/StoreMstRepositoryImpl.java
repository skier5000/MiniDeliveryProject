package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.platform.dto.StoreContractMstDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMstRepositoryImpl extends JpaRepository<StoreMst, Long> {

    public StoreMst findBySeq(Long seq);                         // 아이템 seq 조회
    public StoreMst findByStoreName(String storeName);

    @Query("SELECT sm FROM StoreMst sm WHERE sm.storeName LIKE %?1%")
    public List<StoreMst> findByStoreNameLike(String storeName);

    @Query(nativeQuery = true, value = "" +
            "SELECT A.STORE_MST_SEQ     AS storeMstSeq" +
            "     , A.STORE_TYPE        AS storeType" +
            "     , A.STORE_NAME        AS storeName" +
            "     , A.CITY              AS city" +
            "     , A.CONT_DATE         AS contDate" +
            "     , A.CONT_EXP_DATE     AS contExpDate" +
            "     , A.CONT_RENEW_DATE   AS contRenewDate" +
            "     , A.STORE_TEL         AS storeTel" +
            "  FROM STORE_MST A" +
            " WHERE 1=1" +
            "   AND TO_CHAR(CONT_DATE, 'YYYYMMDD') BETWEEN :startDate AND :endDate")
    public List<StoreContractMstDto> findByStoreMstContractDate(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);
}
