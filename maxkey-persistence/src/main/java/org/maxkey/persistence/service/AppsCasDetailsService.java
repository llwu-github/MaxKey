/*
 * Copyright [2020] [MaxKey of copyright http://www.maxkey.top]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

package org.maxkey.persistence.service;

import org.apache.mybatis.jpa.persistence.JpaBaseService;
import org.maxkey.domain.apps.AppsCasDetails;
import org.maxkey.persistence.mapper.AppsCasDetailsMapper;
import org.springframework.stereotype.Service;

@Service
public class AppsCasDetailsService  extends JpaBaseService<AppsCasDetails>{

	public AppsCasDetailsService() {
		super(AppsCasDetailsMapper.class);
	}

	/* (non-Javadoc)
	 * @see com.connsec.db.service.BaseService#getMapper()
	 */
	@Override
	public AppsCasDetailsMapper getMapper() {
		// TODO Auto-generated method stub
		return (AppsCasDetailsMapper)super.getMapper();
	}
	
	public  AppsCasDetails  getAppDetails(String id) {
		return getMapper().getAppDetails(id);
	}
}
