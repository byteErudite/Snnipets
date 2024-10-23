package com.vaibhav.snippets.LLD.BookMyShow.entity;

import com.vaibhav.snippets.LLD.BookMyShow.entity.Audit;

import java.sql.Timestamp;
import java.util.UUID;

public class Show  extends Audit {
    private UUID showId;
    private UUID eventId;
    private UUID auditoriumId;
    private UUID venueId;
    private Timestamp start;
    private Timestamp end;
    private String status;
}
