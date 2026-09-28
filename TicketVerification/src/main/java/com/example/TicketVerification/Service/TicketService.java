package com.example.TicketVerification.Service;

import com.example.TicketVerification.Module.Ticket;
import com.example.TicketVerification.Repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;


    public Ticket getTicketbyUpi(String upiId) {
       Ticket ticket=ticketRepo.findById(upiId).orElse(null);
       if(ticket==null)
           return null;
        if (!ticket.getPaymentStatus().equals("SUCCESS")) {
            return null;
        }

        if (!ticket.getTicketStatus().equals("NOT_GENERATED")) {
            return null;
        }

        return ticket;
    }


//    public void addTicket(String source, String desti, String price) {
//        Ticket ticket=new Ticket(source,desti,price);
//        ticketRepo.save(ticket);
//
//
//    }

    public Ticket generateTicket(String upiId) {
        Ticket ticket=ticketRepo.findById(upiId).orElse(null);
        if(ticket==null)
            return null;
        if (ticket.getTicketStatus().equals("GENERATED"))
            return null;


        ticket.setTicketStatus("GENERATED");

        ticketRepo.save(ticket);

        return ticket;

    }
}
