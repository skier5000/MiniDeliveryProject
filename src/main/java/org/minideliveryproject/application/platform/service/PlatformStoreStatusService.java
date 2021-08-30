package org.minideliveryproject.application.platform.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

            StoreMstDto map = modelMapper.map(storeMstRepository.findAll(), StoreMstDto.class);
        }

        return storeStatusMstList;
    }
}
