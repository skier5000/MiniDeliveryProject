package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.minideliveryproject.application.platform.dto.StoreContractMstDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public StoreMstDto storeContractMstCreate(StoreMstDto storeMstDto) {
        log.info("PlatformStoreContractService::storeContractMstCreate called");
        StoreMstDto storeMstDtoReturnList = new StoreMstDto();

        // 공통 Save
        storeMstDtoReturnList.setStoreType(storeMstDto.getStoreType());
        storeMstDtoReturnList.setStoreName(storeMstDto.getStoreName());
        storeMstDtoReturnList.setCity(storeMstDto.getCity());

        // 해당 점포명이 존재하면 신규계약이 아닌 재계약
        StoreMst byStoreName = storeMstRepository.findByStoreName(storeMstDto.getStoreName());
        if (byStoreName != null) {
            LocalDate thisDate = LocalDate.now();
            LocalDate contExpDate = byStoreName.getContExpDate();

            // 점포명이 존재하는데 계약 만료되었으면 재계약으로 해결
            if (contExpDate.isBefore(thisDate)) {
                storeMstDto.setContRenewDate(thisDate);
                storeMstDto.setContCnt(byStoreName.getContCnt() + 1);
            } else {
                System.out.println("이미 존재하는 점포입니다.");
                StoreMstDto error = new StoreMstDto();
                error.setStoreName("ERROR");
                return error;
            }

        } else {
            storeMstDto.setContDate(LocalDate.now());
            storeMstDto.setContRenewDate(LocalDate.now());
            storeMstDto.setContExpDate(LocalDate.now().plusYears(3));
        }

        return storeMstDtoReturnList;
    }


    public StoreMstDto storeContractMstUpdate(StoreMstDto storeMstDto) {
        log.info("PlatformStoreContractService::storeContractMstUpdate called");
        StoreMstDto storeMstDtoReturnList = new StoreMstDto();

        // 바뀐 항목들만 update



        return storeMstDtoReturnList;
    }

    public StoreMstDto storeContractMstDelete(StoreMstDto storeMstDto) {
        log.info("PlatformStoreContractService::storeContractMstDelete called");

        StoreMst beforeSeq = storeMstRepository.findBySeq(storeMstDto.getSeq());
        beforeSeq.setDeleteType(DeleteType.YES);

        storeMstRepository.save(beforeSeq);
        StoreMst afterSeq = storeMstRepository.findBySeq(beforeSeq.getSeq());

        if (afterSeq.getSeq().equals(storeMstDto.getSeq()) && afterSeq.getDeleteType().equals(DeleteType.YES)) {
            return storeMstDto;
        } else {
            return storeMstDto;
        }
    }

}
