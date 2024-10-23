package com.vaibhav.snippets.LLD.BookMyShow.entity;

import java.sql.Timestamp;
import java.util.UUID;

public class Audit {
    private UUID creatorUserId;
    private UUID updateUserId;
    private Timestamp creationTime;
    private Timestamp updateTimestamp;
    private boolean isDeleted;
}
