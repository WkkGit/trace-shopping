package com.wkk.constants;

/**
 * @author wkk
 * @date 2021/3/27 20:50
 */
public enum ProduceTypeEnum {
    NONE(-1, ""),
    VEGETABLE(1, "蔬菜"),
    FRUIT(2, "水果"),
    NUT(3, "坚果"),
    GRAIN(4, "谷物");
    ProduceTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
    public static ProduceTypeEnum getInstance(Integer code){
        for(ProduceTypeEnum typeEnum : ProduceTypeEnum.values()){
            if(typeEnum.getCode().equals(code)){
                return typeEnum;
            }
        }
        return ProduceTypeEnum.NONE;
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
