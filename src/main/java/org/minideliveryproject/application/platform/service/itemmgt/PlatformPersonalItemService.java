package org.minideliveryproject.application.platform.service.itemmgt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.repository.ItemMstRepository;
import org.minideliveryproject.application.dto.ItemMstDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PlatformPersonalItemService {

    private final ItemMstRepository itemMstRepository;

    public List<ItemMstDto> selectPersonalItemList(String storeCd, String storeNm, String itemType, String itemNm) {
        List<ItemMstDto> selectListStream = itemMstRepository.findByPersonalStoreAll();

        for (ItemMstDto itemMstDto : selectListStream) {
            System.out.println(itemMstDto.getSeq());
            System.out.println(itemMstDto.getItemName());
        }

        if (storeCd != null) {
            selectListStream = selectListStream.stream()
                    .filter(itemMstDto -> itemMstDto.getSeq().equals(Long.getLong(storeCd)))
                    .collect(Collectors.toList());
        } else {
            if (itemNm != null) {
                selectListStream = selectListStream.stream()
                        .filter(itemMstDto -> itemMstDto.getItemName().contains(itemNm))
                        .collect(Collectors.toList());
            }
            if (storeNm != null && itemType == null) {

            }
        }

        List<ItemMstDto> selectPersonalItemList = new ArrayList<>();
        selectPersonalItemList.addAll(selectListStream);

        return selectPersonalItemList;
    }



}
