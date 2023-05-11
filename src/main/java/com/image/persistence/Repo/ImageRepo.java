package com.image.persistence.Repo;

import com.image.persistence.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image,Long> {
}
