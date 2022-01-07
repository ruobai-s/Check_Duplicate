package com.ruobai.util;

import org.springframework.stereotype.Component;

@Component
public class PageLimitUtil {
    public int index(int page) {
        return (page-1)*10;
    }
}
