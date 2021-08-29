package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.repository.SalesAmountRepository;
import org.minideliveryproject.application.dto.OrderDetailDto;
import org.minideliveryproject.application.dto.OrderMstDto;
import org.minideliveryproject.application.platform.dto.SalesAmountDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformSalesAmountService {

    private final SalesAmountRepository salesAmountRepository;

    /**
     * 점포별 매출 현황 Master 조회
     * @param startContract
     * @param endContract
     * @param storeCode
     * @param storeNm
     * @return
     */
    public List<SalesAmountDto> selectSalesAmountMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformSalesAmountService::selectSalesAmountMstList called");
        List<SalesAmountDto> salesAmountMstList = new ArrayList<>();

        if (storeCode == null) { // store code == null
            // 파라미터
            // 날짜는 테스트용도
            startContract = "20210801";
            endContract = "20210830";
            if (storeNm == null)
                storeNm = "";
        }

        List<SalesAmountDto> bySalesAmountMstAllList = salesAmountRepository.findBySalesAmountMst(startContract, endContract, storeNm);

        if (storeCode == null) {
            salesAmountMstList.addAll(bySalesAmountMstAllList);
        } else if (storeCode != null) { // storeCode 가 null 이 아니면
            for (int i = 0; i < bySalesAmountMstAllList.size(); i++) {
                if (bySalesAmountMstAllList.get(i).getStoreMstSeq().toString() == Long.toString(storeCode)) { // storeCode 가 같은걸 리턴 List 에 담기
                    salesAmountMstList.add(bySalesAmountMstAllList.get(i));
                }
            }
        }


        return salesAmountMstList;
    }


    /**
     * 점포별 매출 현황 Detail 조회
     * @param storeMstSeq
     * @return
     */
    public List<SalesAmountDto> selectSalesAmountDetailList(String startContract, String endContract, Long storeMstSeq) {
        log.info("PlatformSalesAmountService::selectSalesAmountDetailList called");

        // 파라미터
        // 날짜는 테스트용도
        startContract = "20210801";
        endContract = "20210830";

        List<SalesAmountDto> salesAmountDetailList = salesAmountRepository.findBySalesAmountDetail(startContract, endContract, Long.toString(storeMstSeq));


        return salesAmountDetailList;
    }
}
