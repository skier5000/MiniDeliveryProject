package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.repository.OrderDetailRepository;
import org.minideliveryproject.application.domain.repository.OrderMstRepository;
import org.minideliveryproject.application.dto.OrderDetailDto;
import org.minideliveryproject.application.dto.OrderMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformSalesAmountService {

    private final OrderMstRepository orderMstRepository;
    private final OrderDetailRepository orderDetailRepository;

    /**
     * Order Master 조회
     * @param startContract
     * @param endContract
     * @param storeCode
     * @param storeNm
     * @return
     */
    public List<OrderMstDto> selectOrderMstList(String startContract, String endContract, Long storeCode, String storeNm) {
        log.info("PlatformOrderService::selectPersonalStoreList called");
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
            List<Object[]> findByStoreCode = orderMstRepository.findByStoreCodeJoin(storeCode);
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


    /**
     * Order Detail 조회
     * @param storeMstSeq
     * @return
     */
    public List<OrderDetailDto> selectOrderDetailList(Long storeMstSeq) {
        log.info("PlatformOrderService::selectPersonalStoreList called");
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        List<Object[]> orderDetailListByStoreMstSeq = orderDetailRepository.findOrderDetailListByStoreMstSeq(storeMstSeq);
        for (int i = 0; i < orderDetailListByStoreMstSeq.size(); i++) {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setOrderMstSeq((BigInteger) orderDetailListByStoreMstSeq.get(i)[0]);
            orderDetailDto.setStoreName((String) orderDetailListByStoreMstSeq.get(i)[1]);
            orderDetailDto.setStoreMstSeq((BigInteger) orderDetailListByStoreMstSeq.get(i)[2]);
            orderDetailDto.setOrderDate((Timestamp) orderDetailListByStoreMstSeq.get(i)[3]);
            orderDetailDto.setItemName((String) orderDetailListByStoreMstSeq.get(i)[4]);
            orderDetailDto.setItemMstSeq((BigInteger) orderDetailListByStoreMstSeq.get(i)[5]);
            orderDetailDto.setItemQuantity((Integer) orderDetailListByStoreMstSeq.get(i)[6]);
            orderDetailDto.setItemPrice((Integer) orderDetailListByStoreMstSeq.get(i)[7]);
            orderDetailDto.setRequests((String) orderDetailListByStoreMstSeq.get(i)[8]);
            orderDetailDto.setPayment((String) orderDetailListByStoreMstSeq.get(i)[9]);
            orderDetailDto.setUserMstSeq((BigInteger) orderDetailListByStoreMstSeq.get(i)[10]);
            orderDetailDtoList.add(orderDetailDto);
        }

        return orderDetailDtoList;
    }
}
