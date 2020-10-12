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
 

package org.maxkey.authz.cas.endpoint.ticket.service;

import org.maxkey.authz.cas.endpoint.ticket.Ticket;
import org.maxkey.persistence.redis.RedisConnection;
import org.maxkey.persistence.redis.RedisConnectionFactory;


public class RedisTicketServices extends RandomServiceTicketServices {

	
	protected int serviceTicketValiditySeconds = 60 * 10; //default 10 minutes.
	
	RedisConnectionFactory connectionFactory;
	
	public static String PREFIX="REDIS_CAS_TICKET_ST_";
	/**
	 * @param connectionFactory
	 */
	public RedisTicketServices(RedisConnectionFactory connectionFactory) {
		super();
		this.connectionFactory = connectionFactory;
	}
	
	/**
	 * 
	 */
	public RedisTicketServices() {
		
	}

	public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public void store(String ticketId, Ticket ticket) {
		RedisConnection conn=connectionFactory.getConnection();
		conn.setexObject(PREFIX+ticketId, serviceTicketValiditySeconds, ticket);
		conn.close();
	}

	@Override
	public Ticket remove(String ticketId) {
		RedisConnection conn=connectionFactory.getConnection();
		Ticket ticket = conn.getObject(PREFIX+ticketId);
		conn.delete(PREFIX+ticketId);
		conn.close();
		return ticket;
	}

    @Override
    public Ticket get(String ticketId) {
        RedisConnection conn=connectionFactory.getConnection();
        Ticket ticket = conn.getObject(PREFIX+ticketId);
        conn.close();
        return ticket;
    }

	
}
