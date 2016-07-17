package com.springapp2.mvc.repository;

import com.springapp2.mvc.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ssvh on 7/17/16.
 */
public interface ItemRepository extends JpaRepository<Item,Long> {
}
