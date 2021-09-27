package com.Sprint.HealthCareSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sprint.HealthCareSystem.Entity.User;

@Repository
public interface IAdminRepository extends JpaRepository<User, Integer>{

	boolean existsByusername(String username);

}
