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
package org.redisson;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.redisson.misc.URIBuilder;

public class ClusterServersConfig extends BaseMasterSlaveServersConfig<ClusterServersConfig> {

    /**
     * Redis cluster node urls list
     */
    private List<URI> nodeAddresses = new ArrayList<URI>();

    /**
     * Redis cluster scan interval in milliseconds
     */
    private int scanInterval = 1000;

    /**
     * Use cluster slave nodes for read-operations
     */
    private boolean readFromSlaves = true;

    public ClusterServersConfig() {
    }

    ClusterServersConfig(ClusterServersConfig config) {
        super(config);
        setNodeAddresses(config.getNodeAddresses());
        setScanInterval(config.getScanInterval());
        setReadFromSlaves(config.isReadFromSlaves());
    }

    /**
     * Add Redis cluster node address. Use follow format -- <code>host:port</code>
     *
     * @param addresses in <code>host:port</code> format
     * @return
     */
    public ClusterServersConfig addNodeAddress(String ... addresses) {
        for (String address : addresses) {
            nodeAddresses.add(URIBuilder.create(address));
        }
        return this;
    }
    public List<URI> getNodeAddresses() {
        return nodeAddresses;
    }
    void setNodeAddresses(List<URI> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public int getScanInterval() {
        return scanInterval;
    }
    /**
     * Redis cluster scan interval in milliseconds
     *
     * @param scanInterval in milliseconds
     * @return
     */
    public ClusterServersConfig setScanInterval(int scanInterval) {
        this.scanInterval = scanInterval;
        return this;
    }

    public boolean isReadFromSlaves() {
        return readFromSlaves;
    }
    /**
     * Use cluster slave nodes for read-operations
     *
     * @param readFromSlaves
     * @return
     */
    public ClusterServersConfig setReadFromSlaves(boolean readFromSlaves) {
        this.readFromSlaves = readFromSlaves;
        return this;
    }

}
