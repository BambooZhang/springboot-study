package org.spring.springboot.dubbo;

import org.spring.springboot.entity.Device;

/**
 * 客户端接口
 */
public interface BambooDubboService {

	/**
	 * 客户端接口
	 * @param uuid
	 */
	Device sayBamboo(String uuid);


	void saveDevice(Device device);
}
