package com.example.TicketVerification.Module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    private String upitrasactionId;

    private String source;
    private String destination;
    private String price;

    private String paymentStatus;
    private String ticketStatus;
    private String busNumber;

    public Ticket(String source, String destination, String price) {
        this.upitrasactionId = UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 10);
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
}
