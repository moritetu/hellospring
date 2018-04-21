package net.debug_life.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.debug_life.hellospring.model.Users;

@Repository
public interface UsersRepository extends JpaRepository <Users, String> {

}
