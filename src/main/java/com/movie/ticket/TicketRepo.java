package com.movie.ticket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long> {

}
