package com.comrade.final_flow.block;

public class FinalBlockClient {
    public final Integer FINAL_BLANK;
    public static final Integer STATIC_FINAL_BLANK;

    static {
        STATIC_FINAL_BLANK = 508;
    }

    public FinalBlockClient() {
        this(408);
    }

    public FinalBlockClient(Integer fINAL_BLANK) {
        FINAL_BLANK = fINAL_BLANK;
    }
}
