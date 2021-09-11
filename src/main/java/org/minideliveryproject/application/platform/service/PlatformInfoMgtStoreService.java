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
public class PlatformInfoMgtStoreService {

    private final StoreMstRepositoryImpl storeMstRepository;

    public List<StoreMstDto> selectStoreList() {
        List<StoreMstDto> selectStoreList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        List<StoreMst> allSelectStoreList = storeMstRepository.findAll();

        for (StoreMst storeMst : allSelectStoreList) {
            selectStoreList.add(modelMapper.map(storeMst, StoreMstDto.class));
        }

        return selectStoreList;
    }

}
