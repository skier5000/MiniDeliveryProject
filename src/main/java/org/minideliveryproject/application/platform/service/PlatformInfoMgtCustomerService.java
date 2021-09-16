package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public String updateCustomerList(HashMap<String, String> updateList) {

        try {
            Iterator<String> iteratorHm = updateList.keySet().iterator();
            while (iteratorHm.hasNext()) {
                UserMst userMst = new UserMst();
                String key = iteratorHm.next();
                String value = updateList.get(key);

                Optional<UserMst> byUserId = userMstRepository.findByUserId(key);
                userMst = byUserId.get();

                if (value.equals("YES")) {
                    userMst.setDeleteType(DeleteType.YES);
                } else if (value.equals("NO")) {
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
