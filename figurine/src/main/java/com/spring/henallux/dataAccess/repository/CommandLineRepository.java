package com.spring.henallux.dataAccess.repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.spring.henallux.dataAccess.entity.*;

import antlr.collections.List;

@Repository
@Transactional
public interface CommandLineRepository extends JpaRepository<CommandLineEntity, Integer>
{
}
