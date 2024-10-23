package com.vaibhav.snippets.LLD.BookMyShow.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class Event {
    private UUID eventId;
    private String description;
    private Event eventType;
    private List<Show> shows;
    private Timestamp startDateTime;
    private Timestamp endDateTime;

}
