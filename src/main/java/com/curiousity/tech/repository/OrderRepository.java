package com.curiousity.tech.repository;

import com.curiousity.tech.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
