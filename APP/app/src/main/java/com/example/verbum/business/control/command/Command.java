package com.example.verbum.business.control.command;

import com.example.verbum.business.model.User;

public interface Command {
    User execute() throws Exception;
}
