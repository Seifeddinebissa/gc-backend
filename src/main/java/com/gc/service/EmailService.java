package com.gc.service;

import com.gc.entity.EmailDetails;

public interface EmailService {
    Boolean sendSimpleMail(EmailDetails emailDetails);
}
