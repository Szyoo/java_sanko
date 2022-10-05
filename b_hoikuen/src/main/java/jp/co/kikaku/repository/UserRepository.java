package jp.co.kikaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.kikaku.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
    
}
