package org.spring.springboot.dubbo.impl;

import org.spring.springboot.dubbo.BambooDubboService;
import org.spring.springboot.entity.Device;
import org.spring.springboot.mapping.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 *客户端接口服务层实现层
 */
@Service
public class BambooDubboServiceImpl implements BambooDubboService {


	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public Device sayBamboo(String uuid) {
		return deviceRepository.findByUuid(uuid);
	}


	// 如果不存在该uuid的数据则插入新值
	@Override
	public void saveDevice(Device device) {
		Device deviceTmp = deviceRepository.findByUuid(device.getUuid());
		if(Objects.nonNull(deviceTmp)){
			deviceRepository.updateByuuid(device);
		}else {
			deviceRepository.save(device);
		}
	}
}