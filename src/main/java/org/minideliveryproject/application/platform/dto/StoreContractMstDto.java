package org.minideliveryproject.application.platform.dto;

import java.math.BigInteger;
import java.util.Date;

public interface StoreContractMstDto {
    // 마스터
    BigInteger getStoreMstSeq();
    String getStoreType();
    String getStoreName();
    String getCity();
    Date getContDate();
    Date getContExpDate();
    Date getContRenewDate();
    String getStoreTel();

}
