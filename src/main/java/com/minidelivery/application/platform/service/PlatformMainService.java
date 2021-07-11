package com.minidelivery.application.platform.service;

import com.minidelivery.application.domain.UserMst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PlatformMainService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

}
