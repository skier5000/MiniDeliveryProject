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

    public List<OrderMst> selectOrderMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformOrderService::selectPersonalStoreList called");

        List<OrderMst> orderMstAllList = orderMstRepository.findAll();

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


    public List<StoreMst> testOrderMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformOrderService::testOrderMstList called");
        ModelMapper modelMapper = new ModelMapper();
        List<StoreMstDto> storeMstDtoList = new ArrayList<>();
        // DTO 테스트
        List<StoreMst> bbqLikeList = storeMstRepository.findByStoreNameLike("BBQ");
        for (int i = 0; i < bbqLikeList.size(); i++) {
            storeMstDtoList.add(modelMapper.map(bbqLikeList.get(i), StoreMstDto.class));
        }
        System.out.println("storeMstDtoList = " + storeMstDtoList);

//        for (int i = 0; i < storeMstList.size(); i++) {
//            StoreMstDto storeMstDto = modelMapper.map(storeMstList.get(i), StoreMstDto.class);
//            storeMstDtoList.add(storeMstDto);
//        }

        return bbqLikeList;
    }
}
