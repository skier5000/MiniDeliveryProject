package com.minidelivery.application.login.repository;

import com.minidelivery.application.domain.UserMst;

import java.util.List;
import java.util.Optional;

public interface AccessMainRepository {
    public UserMst save(UserMst userMst);
    public Optional<UserMst> findById(String id);
    public Optional<UserMst> findByName(String name);
    public List<UserMst> findAll();
}
