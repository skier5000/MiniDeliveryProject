package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.ItemMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface ItemMstRepositoryImpl extends JpaRepository<ItemMst, Long>, ItemMstRepository {

//    @Override
//    Optional<ItemMst> findByItemName(String itemName);
//
//    @Override
//    Optional<ItemMst> findByItemCategory(String itemCategory);

}
