package com.wkk.constants;

/**
 * @author wkk
 * @date 2021/3/27 22:31
 */
public enum SeedQualityEnum {
    NONE(-1, ""),
    VEGETABLE(0, "优秀"),
    FRUIT(1, "一般"),
    NUT(2, "合格");
    SeedQualityEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
    public static SeedQualityEnum getInstance(Integer code){
        for(SeedQualityEnum qualityEnum : SeedQualityEnum.values()){
            if(qualityEnum.getCode().equals(code)){
                return qualityEnum;
            }
        }
        return SeedQualityEnum.NONE;
    }
    private Integer code;
    private String name;

    public Integer getCode(){
        return code;
    }

    public String getName(){
        return name;
    }
}
