package com.example.tuneclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.tuneclub.entity.PlayList;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Integer>{


}
