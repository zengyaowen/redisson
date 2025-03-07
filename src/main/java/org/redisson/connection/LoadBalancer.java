/**
 * Copyright 2014 Nikita Koksharov, Nickolay Borbit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.connection;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;

import org.redisson.MasterSlaveServersConfig;
import org.redisson.client.RedisConnection;
import org.redisson.client.RedisPubSubConnection;
import org.redisson.connection.ConnectionEntry.FreezeReason;

import io.netty.util.concurrent.Future;

public interface LoadBalancer {

    SubscribesConnectionEntry getEntry(List<SubscribesConnectionEntry> clientsCopy);

    Future<RedisConnection> getConnection(InetSocketAddress addr);

    int getAvailableClients();

    void shutdownAsync();

    void shutdown();

    boolean unfreeze(String host, int port, FreezeReason freezeReason);

    Collection<RedisPubSubConnection> freeze(String host, int port, FreezeReason freezeReason);

    void init(MasterSlaveServersConfig config, ConnectionManager connectionManager, MasterSlaveEntry entry);

    void add(SubscribesConnectionEntry entry);

    Future<RedisConnection> nextConnection();

    Future<RedisPubSubConnection> nextPubSubConnection();

    void returnConnection(RedisConnection connection);

    void returnSubscribeConnection(RedisPubSubConnection connection);

}
