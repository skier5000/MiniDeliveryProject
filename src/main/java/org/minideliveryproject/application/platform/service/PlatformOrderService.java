package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.repository.OrderDetailRepository;
import org.minideliveryproject.application.domain.repository.OrderMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.dto.OrderMstDto;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformOrderService {

    private final OrderMstRepository orderMstRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final StoreMstRepositoryImpl storeMstRepository;

    public List<OrderMstDto> selectOrderMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformOrderService::selectPersonalStoreList called");
        ModelMapper modelMapper = new ModelMapper();
        List<OrderMstDto> orderMstDtoList = new ArrayList<>();

        if (storeCode == null) { // store code == null
            List<OrderMstDto> findByStartEndStoreNm = orderMstRepository.findByStartEndStoreNm(startContract, endContract, storeNm);
            for (OrderMstDto orderMstDto : findByStartEndStoreNm) {
                orderMstDtoList.add(orderMstDto);
            }
            return orderMstDtoList;
        } else {  // store code != null
            List<OrderMstDto> findByStoreCode = orderMstRepository.findByStoreCode(storeCode);
            for (OrderMstDto orderMstDto : findByStoreCode) {
                orderMstDtoList.add(orderMstDto);
            }
            return orderMstDtoList;
        }

    }


    public List<StoreMst> testOrderMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformOrderService::testOrderMstList called");
        ModelMapper modelMapper = new ModelMapper();
        List<StoreMstDto> storeMstDtoList = new ArrayList<>();

        // DTO 테스트
        List<StoreMst> bbqLikeList = storeMstRepository.findByStoreNameLike("BBQ");
        for (int i = 0; i < bbqLikeList.size(); i++) {
            storeMstDtoList.add(modelMapper.map(bbqLikeList.get(i), StoreMstDto.class));
        }

        return bbqLikeList;
    }
}
