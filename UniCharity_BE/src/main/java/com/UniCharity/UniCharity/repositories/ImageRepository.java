package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
