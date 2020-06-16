package service_consumer.model.dto;

import service_consumer.model.HouseInfo;

/**
 * ______________________________
 *
 * @ClassName HouseInfoDto
 * @Author ctzeng
 * @Date 2020/6/15 17:47
 * @Version V1.0
 **/
public class HouseInfoDto extends HouseInfo {
    private HouseInfo Data;

    public HouseInfo getData() {
        return Data;
    }

    public void setData(HouseInfo data) {
        Data = data;
    }
}

