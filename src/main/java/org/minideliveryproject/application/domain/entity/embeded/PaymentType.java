package org.minideliveryproject.application.domain.entity.embeded;

public enum PaymentType {
    CARD,          // 신용/체크카드
    NAVERPAY,      // 네이버페이
    PREPARING,     // 카카오페이
    TOSS,          // 토스
    DIRECTLYCARD,  // 만나서카드결제
    DIRECTLYCASH   // 만나서현금결제
}
