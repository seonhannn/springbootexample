package com.example.springbootexample.repository;

import com.example.springbootexample.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}

