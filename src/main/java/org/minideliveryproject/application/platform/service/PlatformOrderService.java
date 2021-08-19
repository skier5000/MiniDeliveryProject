package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;
import org.minideliveryproject.application.domain.repository.OrderDetailRepository;
import org.minideliveryproject.application.domain.repository.OrderMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.dto.OrderMstDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformOrderService {

    private final OrderMstRepository orderMstRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final StoreMstRepositoryImpl storeMstRepository;

    public List<OrderMst> selectOrderMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformOrderService::selectPersonalStoreList called");

        List<OrderMst> orderMstAllList = orderMstRepository.findAll();
        List<OrderMstDto> orderMstDtoList = new ArrayList<>();

        Iterable<OrderMst> orderMsts = orderMstRepository.testFindByOrderMstSearchDto();

        for (int i = 0; i < orderMstAllList.size(); i++) {
            orderMstAllList.get(i);
        }

        if (storeCode != null || storeNm != null) {   // 날짜 계산 로직 필요
            if (storeCode != null){
                StoreMst bySeq = storeMstRepository.findBySeq(storeCode);
            } else {
                List<StoreMst> byStoreNameLike = storeMstRepository.findByStoreNameLike(storeNm);
            }
        }

        return orderMstAllList;

    }
}
