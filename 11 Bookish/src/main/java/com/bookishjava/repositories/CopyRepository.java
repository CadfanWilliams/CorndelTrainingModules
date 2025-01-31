package com.bookishjava.repositories;

import com.bookishjava.models.database.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface CopyRepository extends JpaRepository<Copy, Long> {
    Copy findById(int id);


}
