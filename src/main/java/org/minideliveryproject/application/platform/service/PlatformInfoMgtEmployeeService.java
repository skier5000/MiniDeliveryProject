package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.CommonColumn;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.repository.UserMstRepositoryImpl;
import org.minideliveryproject.application.dto.UserMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformInfoMgtEmployeeService {

    private final UserMstRepositoryImpl userMstRepository;

    public List<UserMstDto> selectEmployeeList() {
        ModelMapper modelMapper = new ModelMapper();
        List<UserMst> findByAll = userMstRepository.findAll();
        List<UserMstDto> selectEmployeeList = new ArrayList<>();

        for (int i = 0; i < findByAll.size(); i++) {
            selectEmployeeList.add(modelMapper.map(findByAll.get(i), UserMstDto.class));
        }

        return selectEmployeeList;
    }

    public UserMstDto createEmployeeList(UserMstDto userMstDto) {
        Optional<UserMst> byUserId = userMstRepository.findByUserId(userMstDto.getUserId());
        ModelMapper modelMapper = new ModelMapper();

        if (byUserId.isEmpty()) {
            UserMst mapUserMst = modelMapper.map(userMstDto, UserMst.class);

            mapUserMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
            mapUserMst.setJoinDate(LocalDate.now());

            userMstRepository.save(mapUserMst);

            return userMstDto;
        } else {
            userMstDto.setUserId("ERROR");
            return userMstDto;
        }

    }

    public UserMstDto updateEmployeeList(UserMstDto userMstDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<UserMst> byUserId = userMstRepository.findByUserId(userMstDto.getUserId());

        try {
            UserMst mapUserMst = modelMapper.map(userMstDto, UserMst.class);
            mapUserMst.setCommonColumn(new CommonColumn(byUserId.get().getCommonColumn().getInsDate(), byUserId.get().getCommonColumn().getInsUser(), LocalDateTime.now(), "Test"));
            userMstRepository.save(mapUserMst);
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        return userMstDto;
    }

    public UserMstDto deleteEmployeeList(UserMstDto userMstDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<UserMst> byUserId = userMstRepository.findByUserId(userMstDto.getUserId());
        UserMst mapUserMst = modelMapper.map(userMstDto, UserMst.class);

        mapUserMst.setCommonColumn(new CommonColumn(byUserId.get().getCommonColumn().getInsDate(), byUserId.get().getCommonColumn().getInsUser(), LocalDateTime.now(), "Test"));
        mapUserMst.setDeleteType(DeleteType.YES);

        userMstRepository.save(mapUserMst);

        return userMstDto;
    }



}
