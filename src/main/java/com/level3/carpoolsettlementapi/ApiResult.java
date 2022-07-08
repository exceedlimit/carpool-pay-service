package com.level3.carpoolsettlementapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@NoArgsConstructor
@ToString
public class ApiResult<T> {
    public Integer code;
    public String message;
    public T data;

    public static <T> ApiResult<T> of(ApiStatusResponsible apiStatus, T data) {
        return new ApiResult<>(apiStatus, data);
    }

    public static ApiResult of(ApiStatusResponsible apiStatus, List<Pair> pairs) {
        Map<String, String> map = pairs.stream()
                .collect(Collectors.toMap(x -> x.getFirst().toString(), x -> x.getSecond().toString()));
        return new ApiResult<>(apiStatus, map);
    }

    public static <T> ApiResult<T> of(ApiStatusResponsible apiStatus) {
        return new ApiResult<>(apiStatus, null);
    }

    public static <T> ApiResult<T> ok(T data) {
        return new ApiResult<>(ApiStatus.SUCCESS, data);
    }

    public static <T> ApiResult<T> ok() {
        return new ApiResult<>(ApiStatus.SUCCESS, null);
    }

    private ApiResult(ApiStatusResponsible apiStatus, T data) {
        this.code = apiStatus.getCode();
        this.data = data;
        this.message = apiStatus.getMessage();
    }
}
