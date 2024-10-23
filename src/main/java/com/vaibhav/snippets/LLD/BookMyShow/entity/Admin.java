package com.vaibhav.snippets.LLD.BookMyShow.entity;

import java.util.List;
import java.util.UUID;

public class Admin extends Audit{
    private UUID adminId;
    private List<Role> roles;

}
