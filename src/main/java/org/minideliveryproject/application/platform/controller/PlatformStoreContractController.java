package org.minideliveryproject.application.platform.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.minideliveryproject.application.platform.dto.StoreContractMstDto;
import org.minideliveryproject.application.platform.service.PlatformStoreContractService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * 점포관리 계약관리 Controller
 * <pre>
 *
 * @author LJB
 * @since 2021.09.02
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.09.02.		LJB			최초작성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/storeMgt/contract")
public class PlatformStoreContractController {

    private final PlatformStoreContractService platformStoreContractService;

    @GetMapping("/")
    public String indexStoreMgtStoreContract() {
        log.info("PlatformStoreContractController::indexStoreMgtStoreContract called");
        return "platform/storeMgt/contract";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<StoreContractMstDto> storeContractMstSearch(
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "storeType", required = false) String storeType,
            @RequestParam(value = "storeCode", required = false) Long storeCode,
            @RequestParam(value = "storeNm", required = false) String storeNm,
            @RequestParam(value = "city", required = false) String city
    ) {
        log.info("PlatformStoreContractController::storeContractMstSearch called");

        List<StoreContractMstDto> storeContractMstList = platformStoreContractService.selectStoreContractMstList(startDate, endDate, storeType, storeCode, storeNm, city);

        return storeContractMstList;
    }

    @ResponseBody
    @GetMapping("/createOrUpdate")
    public StoreMstDto storeContractMstCreateOrUpdate(
            @RequestParam(value = "storeMstDto", required = true) StoreMstDto storeMstDto,
            @RequestParam(value = "createOrUpdate", required = true) String createOrUpdate
            ) {

        log.info("PlatformStoreContractController::storeContractMstCreateOrUpdate called");

        StoreMstDto storeMstDtoReturnList = new StoreMstDto();

        if (createOrUpdate.equals("create")) {
            storeMstDtoReturnList = platformStoreContractService.storeContractMstCreate(storeMstDto);
        } else if (createOrUpdate.equals("update")) {
            storeMstDtoReturnList = platformStoreContractService.storeContractMstUpdate(storeMstDto);
        } else {
            if (createOrUpdate.equals("") || createOrUpdate == null) {
                System.out.println("createOrUpdate Error = " + createOrUpdate);
            }
        }

        if (storeMstDtoReturnList.getStoreName().equals("ERROR")) {
            System.out.println("에러");
            return storeMstDtoReturnList;
        }

        return storeMstDtoReturnList;
    }

    @ResponseBody
    @GetMapping("/delete")
    public HashMap<StoreMstDto, String> storeContractMstDelete(
            @RequestParam(value = "storeMstDto", required = true) StoreMstDto storeMstDto
    ) {
        log.info("PlatformStoreContractController::storeContractMstDelete called");
        StoreMstDto storeMstDtoReturnList = platformStoreContractService.storeContractMstDelete(storeMstDto);
        HashMap<StoreMstDto, String> returnResult = new HashMap<>();

        if (storeMstDtoReturnList.getDeleteType().equals(DeleteType.YES)) {
            returnResult.put(storeMstDtoReturnList, "OK");
            return returnResult;
        } else {
            returnResult.put(storeMstDtoReturnList, "FAIL");
            return returnResult;
        }
    }


}
