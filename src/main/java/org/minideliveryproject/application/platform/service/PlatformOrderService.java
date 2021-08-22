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
            // 파라미터
            // 날짜는 테스트용도
            startContract = "20210801";
            endContract = "20210830";
            if (storeNm == null)
                storeNm = "";

            List<Object[]> findByStartEndStoreNm = orderMstRepository.findByStartEndStoreNm(startContract, endContract, storeNm);
            for (int i = 0; i < findByStartEndStoreNm.size(); i++) {
                OrderMstDto orderMstDto = new OrderMstDto();
                orderMstDto.setStoreType((String) findByStartEndStoreNm.get(i)[0]);
                orderMstDto.setStoreMstSeq(Integer.parseInt((String) findByStartEndStoreNm.get(i)[1]));
                orderMstDto.setStoreName((String) findByStartEndStoreNm.get(i)[2]);
                orderMstDto.setStoreTel((String) findByStartEndStoreNm.get(i)[3]);
                orderMstDto.setContRenewDate((String) findByStartEndStoreNm.get(i)[4]);
                orderMstDto.setAllOrder(Integer.parseInt((String) findByStartEndStoreNm.get(i)[5]));
                orderMstDto.setAllOrderDeleteNo(Integer.parseInt((String) findByStartEndStoreNm.get(i)[6]));
                orderMstDto.setAllOrderDeleteYes(Integer.parseInt((String) findByStartEndStoreNm.get(i)[7]));
                orderMstDtoList.add(orderMstDto);
            }
            return orderMstDtoList;
        } else {  // store code != null
            List<Object[]> findByStoreCode = orderMstRepository.findByStoreCode(storeCode);
            for (int i = 0; i < findByStoreCode.size(); i++) {
                OrderMstDto orderMstDto = new OrderMstDto();
                orderMstDto.setStoreType((String) findByStoreCode.get(i)[0]);
                orderMstDto.setStoreMstSeq(Integer.parseInt((String) findByStoreCode.get(i)[1]));
                orderMstDto.setStoreName((String) findByStoreCode.get(i)[2]);
                orderMstDto.setStoreTel((String) findByStoreCode.get(i)[3]);
                orderMstDto.setContRenewDate((String) findByStoreCode.get(i)[4]);
                orderMstDto.setAllOrder(Integer.parseInt((String) findByStoreCode.get(i)[5]));
                orderMstDto.setAllOrderDeleteNo(Integer.parseInt((String) findByStoreCode.get(i)[6]));
                orderMstDto.setAllOrderDeleteYes(Integer.parseInt((String) findByStoreCode.get(i)[7]));
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
