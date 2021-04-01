package com.wkk.constants;


/**
 * @author wkk
 * @date 2021/3/27 20:31
 */
public enum AccountStatusEnum {
    NONE(-1, ""),
    NORMALITY(0, "正常"),
    FREEZE(1, "冻结"),
    DELETED(2, "删除");
    AccountStatusEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
    public static AccountStatusEnum getInstance(Integer code){
        for(AccountStatusEnum statusEnum : AccountStatusEnum.values()){
            if(statusEnum.getCode().equals(code)){
                return statusEnum;
            }
        }
        return AccountStatusEnum.NONE;
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
