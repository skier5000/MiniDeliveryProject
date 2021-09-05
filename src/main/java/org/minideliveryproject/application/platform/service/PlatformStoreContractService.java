package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.minideliveryproject.application.platform.dto.StoreContractMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformStoreContractService {

    private final StoreMstRepositoryImpl storeMstRepository;

    public List<StoreContractMstDto> selectStoreContractMstList(String startDate, String endDate, String storeType, Long storeCode, String storeNm, String city) {
        log.info("PlatformStoreContractService::selectStoreContractMstList called");
        ArrayList<StoreContractMstDto> storeContractMstList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        if (startDate == null && endDate == null) {
            startDate = String.valueOf(LocalDate.now()).replace("-", "");
            endDate = String.valueOf(LocalDate.now().plusDays(30)).replace("-", "");
        }

        List<StoreContractMstDto> allStoreContractMstList = storeMstRepository.findByStoreMstContractDate(startDate, endDate);

        if (storeCode != null) {
            List<StoreContractMstDto> storeContractMstDtoStream =
                    allStoreContractMstList
                            .stream()
                            .filter(storeContractMstDto -> storeContractMstDto.getStoreMstSeq().equals(BigInteger.valueOf(storeCode)))
                            .collect(Collectors.toList());

            storeContractMstList.addAll(storeContractMstDtoStream);
        } else {
            if (storeType != null) {
                List<StoreContractMstDto> storeContractMstDtoStream = allStoreContractMstList
                        .stream()
                        .filter(storeContractMstDto -> storeContractMstDto.getStoreType().equals(storeType))
                        .collect(Collectors.toList());
                if (storeNm == null && city != null) {
                    storeContractMstDtoStream = storeContractMstDtoStream
                            .stream()
                            .filter(storeContractMstDto -> storeContractMstDto.getCity().equals(city))
                            .collect(Collectors.toList())
                    ;
                } else if (storeNm != null) {
                    storeContractMstDtoStream = storeContractMstDtoStream
                            .stream()
                            .filter(storeContractMstDto -> storeContractMstDto.getStoreName().contains(storeNm))
                            .collect(Collectors.toList());
                    if (city != null) {
                        storeContractMstDtoStream = storeContractMstDtoStream
                                .stream()
                                .filter(storeContractMstDto -> storeContractMstDto.getCity().equals(city))
                                .collect(Collectors.toList());
                    }
                }

                storeContractMstList.addAll(storeContractMstDtoStream);

            } else if (storeType == null) {
                if (storeNm != null) {
                    List<StoreContractMstDto> storeContractMstDtoStream =
                            allStoreContractMstList
                                    .stream()
                                    .filter(storeContractMstDto -> storeContractMstDto.getStoreMstSeq().equals(storeNm))
                                    .collect(Collectors.toList());

                    if (city == null) {
                        storeContractMstList.addAll(storeContractMstDtoStream);
                    } else if (city != null) {
                        storeContractMstDtoStream = storeContractMstDtoStream
                                .stream()
                                .filter(storeContractMstDto -> storeContractMstDto.getCity().equals(city))
                                .collect(Collectors.toList());
                        storeContractMstList.addAll(storeContractMstDtoStream);
                    }
                }
                else if (storeNm == null) {
                    List<StoreContractMstDto> storeContractMstDtoStream = allStoreContractMstList;
                    if (city == null) {
                        storeContractMstList.addAll(storeContractMstDtoStream);
                    } else if (city != null) {
                        storeContractMstDtoStream = storeContractMstDtoStream
                                .stream()
                                .filter(storeContractMstDto -> storeContractMstDto.getCity().equals(city))
                                .collect(Collectors.toList());
                        storeContractMstList.addAll(storeContractMstDtoStream);
                    }
                }

            }
        }

        return storeContractMstList;

    }

}
