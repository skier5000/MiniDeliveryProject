package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.entity.embeded.UserRoleType;
import org.minideliveryproject.application.domain.repository.UserMstRepositoryImpl;
import org.minideliveryproject.application.dto.UserMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformInfoMgtCustomerService {

    private final UserMstRepositoryImpl userMstRepository;

    public List<UserMstDto> selectCustomerList() {
        ModelMapper modelMapper = new ModelMapper();
        List<UserMstDto> selectCustomerList = new ArrayList<>();

        List<UserMst> collectAllList = userMstRepository.findAll().stream()
                .filter(userMst -> userMst.getUserRoleType().equals(UserRoleType.CUSTOMER))
                .collect(Collectors.toList());

        for (int i = 0; i < collectAllList.size(); i++) {
            selectCustomerList.add(modelMapper.map(collectAllList.get(i), UserMstDto.class));
        }

        return selectCustomerList;
    }
}
