package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.repository.UserMstRepositoryImpl;
import org.minideliveryproject.application.dto.UserMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformEmployeeService {

    private final UserMstRepositoryImpl userMstRepository;

    public List<UserMstDto> selectEmployeeList() {
        ModelMapper modelMapper = new ModelMapper();
        List<UserMst> findByAll = userMstRepository.findAll();
        List<UserMstDto> selectEmployeeList = new ArrayList<>();

        for (int i = 0; i < findByAll.size(); i++) {
            selectEmployeeList.add(modelMapper.map(findByAll, UserMstDto.class));
        }

        return selectEmployeeList;
    }



}
