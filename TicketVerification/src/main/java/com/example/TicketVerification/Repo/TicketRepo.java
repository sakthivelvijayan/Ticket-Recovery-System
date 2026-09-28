package com.example.TicketVerification.Repo;

import com.example.TicketVerification.Module.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,String> {

}
