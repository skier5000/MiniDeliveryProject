package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.Address;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.entity.embeded.UserRoleType;
import org.minideliveryproject.application.domain.repository.UserMstRepositoryImpl;
import org.minideliveryproject.application.dto.UserMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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

    public String deleteCustomerList(String userId) {
        Optional<UserMst> byUserId = userMstRepository.findByUserId(userId);

        if (byUserId.get().getDeleteType() == DeleteType.YES) {
            return "DELETED";
        }

        try {
            UserMst userMst = byUserId.get();
            userMst.setDeleteType(DeleteType.YES);

            userMstRepository.save(userMst);

        } catch (Exception e) {
            log.info("ERROR");
            return "ERROR";
        }

        return "OK";
    }

    public String updateCustomerList(List<UserMstDto> updateList) {

        try {

            for (UserMstDto userMstDto : updateList) {
                Optional<UserMst> byUserId = userMstRepository.findByUserId(userMstDto.getUserId());
                UserMst userMst = new UserMst();
                userMst = byUserId.get();
                userMst.setUserName(userMstDto.getUserName());
                userMst.setPhoneNumber(userMstDto.getPhoneNumber());
                userMst.setEmail(userMstDto.getEmail());

                if (userMstDto.getDeleteType().equals("YES")) {
                    userMst.setDeleteType(DeleteType.YES);
                } else if (userMstDto.getDeleteType().equals("NO")) {
                    userMst.setDeleteType(DeleteType.NO);
                }

                userMstRepository.save(userMst);
            }

        } catch (Exception e) {
            log.info("ERROR");
            return "ERROR";
        }


        return "OK";
    }
}
