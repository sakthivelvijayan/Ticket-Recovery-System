package com.example.TicketVerification.Controller;

import com.example.TicketVerification.Module.Ticket;
import com.example.TicketVerification.Module.TicketRequst;
import com.example.TicketVerification.Repo.TicketRepo;
import com.example.TicketVerification.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/api/tickets/verify")
    public Ticket getTicketbyUpi(@RequestParam ("utr")String UpiId){
        return ticketService.getTicketbyUpi(UpiId);

    }
    @PostMapping("/api/tickets/generate")
    public Ticket generateTicket(@RequestBody TicketRequst request) {

        return ticketService.generateTicket(request.getUtr());
    }
//    @PostMapping("/Ticket")
//    public String addTicket(@RequestParam ("source") String Source,
//                            @RequestParam("destination") String Desti,
//                            @RequestParam("price") String Price){
//        ticketService.addTicket(Source,Desti,Price);
//        return "Succes";
//    }


}
