package org.minideliveryproject.application.platform.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.embeded.StoreState;
import org.minideliveryproject.application.domain.entity.embeded.StoreType;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformStoreStatusService {

    private final StoreMstRepositoryImpl storeMstRepository;

    public List<StoreMstDto> selectStoreStatusMstList (String storeType, Long storeMstSeq, String storeName, String storeState) {
        log.info("PlatformStoreStatusService::selectStoreStatusMstList called");
        ArrayList<StoreMstDto> storeStatusMstList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        if (storeMstSeq != null) {
            modelMapper.map(storeMstRepository.findBySeq(storeMstSeq), StoreMstDto.class);
        } else {
            List<StoreMst> allList = storeMstRepository.findAll();

            if (storeType != null) {
                List<StoreMst> collect = allList.stream().filter(storeMst -> storeMst.getStoreType().equals(StoreType.valueOf(storeType))).collect(Collectors.toList());
                if (storeName != null && storeState == null) {
                    for (int i = 0; i < collect.size(); i++) {
                        if (collect.get(i).getStoreName().contains(storeName)) {
                            storeStatusMstList.add(modelMapper.map(collect.get(i), StoreMstDto.class));
                        }
                    }
                } else if (storeName == null && storeState != null) {
                    for (int i = 0; i < collect.size(); i++) {
                        if (collect.get(i).getStoreState().equals(StoreState.valueOf(storeState))) {
                            storeStatusMstList.add(modelMapper.map(collect.get(i), StoreMstDto.class));
                        }
                    }
                } else if (storeName != null & storeState != null) {
                    for (int i = 0; i < collect.size(); i++) {
                        if (collect.get(i).getStoreName().contains(storeName) && collect.get(i).getStoreState().equals(StoreState.valueOf(storeState))) {
                            storeStatusMstList.add(modelMapper.map(collect.get(i), StoreMstDto.class));
                        }
                    }
                } else {
                    for (int i = 0; i < collect.size(); i++) {
                        storeStatusMstList.add(modelMapper.map(collect, StoreMstDto.class));
                    }
                }
            } else {
                if (storeName == null && storeState != null) {
                    List<StoreMst> collect = allList.stream().filter(storeMst -> storeMst.getStoreState().equals(StoreState.valueOf(storeState))).collect(Collectors.toList());
                    for (int i = 0; i < collect.size(); i++) {
                        storeStatusMstList.add(modelMapper.map(collect.get(i), StoreMstDto.class));
                    }
                } else if (storeName != null && storeState != null) {
                    List<StoreMst> collect = allList.stream().filter(storeMst -> storeMst.getStoreState().equals(StoreState.valueOf(storeState))).collect(Collectors.toList());
                    for (int i = 0; i < collect.size(); i++) {
                        if (collect.get(i).getStoreName().contains(storeName)) {
                            storeStatusMstList.add(modelMapper.map(collect.get(i), StoreMstDto.class));
                        }
                    }
                } else {
                    for (int i = 0; i < allList.size(); i++) {
                        storeStatusMstList.add(modelMapper.map(allList.get(i), StoreMstDto.class));
                    }
                }
            }
        }

        return storeStatusMstList;
    }

    public List<StoreMstDto> selectStoreStatusDetailList (String storeMstSeq) {
        log.info("PlatformStoreStatusService::selectStoreStatusDetailList called");
        ArrayList<StoreMstDto> storeStatusDetailList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        try {
            StoreMst bySeq = storeMstRepository.findBySeq(Long.valueOf(storeMstSeq));
            storeStatusDetailList.add(modelMapper.map(bySeq, StoreMstDto.class));
        } catch (Exception e) {
            if (storeMstSeq == null)
                System.out.println("마스터 정보 수신 에러");
            else
                System.out.println("기타 에러");
        }

        return storeStatusDetailList;
    }


}
