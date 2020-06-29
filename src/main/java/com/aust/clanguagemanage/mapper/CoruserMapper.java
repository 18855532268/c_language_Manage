package com.aust.clanguagemanage.mapper;

import com.aust.clanguage.base.domain.CorUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoruserMapper extends JpaRepository<CorUser,Integer> {

    CorUser findCorUserByCouIdAndUserRole(Integer userId, Integer role);
}
