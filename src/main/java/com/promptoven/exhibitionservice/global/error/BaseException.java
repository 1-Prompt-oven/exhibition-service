package com.promptoven.exhibitionservice.global.error;

import com.promptoven.exhibitionservice.global.common.response.BaseResponseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final BaseResponseStatus status;

    public BaseException(BaseResponseStatus status) {
        super(status.getMessage()); //
        this.status = status;
    }
}
