package com.board.boardserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private HttpStatus httpStatus;
    private String code;
    private String message;
    private T requestBody;

}
