package com.petroff.testtask.dto;

import com.petroff.testtask.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserStatusDto {

    private Long id;
    private Boolean oldStatus;
    private Boolean newStatus;

    public UserStatusDto(User user, Boolean oldStatus) {
        this.id = user.getId();
        this.oldStatus = oldStatus;
        this.newStatus = user.getStatus();
    }

}
