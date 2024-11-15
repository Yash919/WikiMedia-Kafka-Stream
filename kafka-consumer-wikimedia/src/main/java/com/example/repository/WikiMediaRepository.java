package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.WikiMedia;

public interface WikiMediaRepository extends JpaRepository<WikiMedia,Long> {
}