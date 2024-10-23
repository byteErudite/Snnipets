package com.vaibhav.snippets.LLD.BookMyShow.entity;

import java.util.UUID;

public class Booking extends Audit {
    private UUID bookingId;
    private UUID userId;
    private UUID bookingUserId;
    private UUID eventId;

}
